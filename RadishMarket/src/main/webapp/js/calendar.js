let map;
let marker;

function domLoadEvent(data) {
	if (data == 'no_data') {
		return;
	}

	data.split('/separation/').forEach((e) => {
		const dateInfo = e.split('/divide/');

		let title = dateInfo[2];
		let date = dateInfo[1].split(' ')[0];
		let time = dateInfo[1].split(' ')[1];
		let start = date + 'T' + time;
		let id = dateInfo[0];

		$('#calendar').fullCalendar('renderEvent', { id: id, title: title, start: start,
			 		color: "#5FCC29"}, true);


	})
}


function calendarInfoView(calendar_no) {
	fetch(`/infoCalendarAjax.do?calendar_no=${calendar_no}`)
		.then(response => response.json())
		.then(data => {
			if (data.error === 'no_data') {
				alert('캘린더 정보 불러오기 오류');
				return;
			}

			document.querySelector('#calendar_title').value = data.calendar_title;
			document.querySelector('#calendar_content').value = data.calendar_content;
			document.querySelector('#calendar_datetime').value = data.calendar_datetime;
			$('#calendar-info-modal').modal('show');

			if (data.calendar_dir_x && data.calendar_dir_y) {
				document.querySelector('#calendar_address').value = data.address;
				document.querySelector('#calendar_dir_x').value = data.calendar_dir_x;
				document.querySelector('#calendar_dir_y').value = data.calendar_dir_y;
				const calender_dir_y = data.calendar_dir_y;
				const calender_dir_x = data.calendar_dir_x;
				const center = new kakao.maps.LatLng(calender_dir_y, calender_dir_x);

				var container = document.getElementById('map');

				var options = {
					center: center,
					level: 3
				};

				if (!map) {
					map = new kakao.maps.Map(container, options);
					var mapTypeControl = new kakao.maps.MapTypeControl();
					map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPLEFT);

					var zoomControl = new kakao.maps.ZoomControl();
					map.addControl(zoomControl, kakao.maps.ControlPosition.BOTTOMRIGHT);
				}

				if (marker) {
					marker.setMap(null);
				}

				var imageSrc = '/images/marker.png', // 마커이미지의 주소입니다    
					imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
					imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

				// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
				var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
				marker = new kakao.maps.Marker({
					position: center,
					image: markerImage // 마커이미지 설정 
				});

				marker.setMap(map);

				setTimeout(() => {
					map.relayout();
					map.setCenter(center);
				}, 200)
				document.getElementById('updateEventBtn').addEventListener('click', () => {
					window.location.href = `/updateCalendar.do?calendar_no=${data.calendar_no}`;
				})

				document.getElementById('deleteEventBtn').addEventListener('click', () => {
					const check = confirm('이 일정을 삭제하시겠습니까?');
					if (check) {
						window.location.href = `/deleteCalendar.do?calendar_no=${data.calendar_no}`;
					}
				})

				document.querySelector(".guid-box").style.display = 'block';
			} else {
				document.querySelector(".guid-box").style.display = 'none';
			}
		})
		.catch(error => console.log(error))
}


$(document).ready(function() {
	let savedEvents =
		JSON.parse(localStorage.getItem('calendarEvents')) || [];

	$('#calendar').fullCalendar({
		selectable: true,
		selectHelper: true,
		select: function(start) {
			let formattedDate = moment(start).format('YYYY-MM-DD');
			$('#eventDate').val(formattedDate);
		},
		header: {
			right: 'prev,today,next',
		},
		buttonText: {
			today: 'Today',
			month: 'Month',
		},
		eventClick: function(info) {
			calendarInfoView(info.id);
		},
	});

	const dateArr = document.querySelector('.fc-left h2').innerHTML;
	const year = dateArr.split(' ')[1];
	let month = dateArr.split(' ')[0];
	let dateNum = year + '-';

	switch (month) {
		case 'January': dateNum += '01'; break;
		case 'February': dateNum += '02'; break;
		case 'March': dateNum += '03'; break;
		case 'April': dateNum += '04'; break;
		case 'May': dateNum += '05'; break;
		case 'June': dateNum += '06'; break;
		case 'July': dateNum += '07'; break;
		case 'August': dateNum += '08'; break;
		case 'September': dateNum += '09'; break;
		case 'October': dateNum += '10'; break;
		case 'November': dateNum += '11'; break;
		case 'December': dateNum += '12'; break;
	}

	fetch("/listCalendarAjax.do?dateNum=" + dateNum)
		.then(response => response.text())
		.then(domLoadEvent)
		.catch(error => console.log(error))
})
