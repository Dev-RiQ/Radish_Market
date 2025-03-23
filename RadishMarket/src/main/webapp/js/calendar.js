function domLoadEvent(data) {
	if (data == 'no_data') {
		return;
	}

	let event_nums = [];

	data.split('/separation/').forEach((e) => {
		const dateInfo = e.split('/divide/');

		let title = dateInfo[2];
		let date = dateInfo[1].split(' ')[0];
		let time = dateInfo[1].split(' ')[1];
		let start = date + 'T' + time;

		event_nums.push(dateInfo[0]);

		$('#calendar').fullCalendar('renderEvent', { title: title, start: start }, true);
	})

	document.querySelectorAll('.fc-event-container').forEach((e, idx) => {
		e.id = event_nums[idx];
	})

	document.querySelectorAll('.fc-event-container').forEach((e) => {
		e.addEventListener('click', (event) => {
			console.log(event.currentTarget);

			const calendar_no = event.currentTarget.id;
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

					if (data.calendar_dir_x && data.calendar_dir_y) {
						document.querySelector('#calendar_dir_x').value = data.calendar_dir_x;
						document.querySelector('#calendar_dir_y').value = data.calendar_dir_y;

						const calender_dir_y = document.querySelector('#calendar_dir_y').value;
						const calender_dir_x = document.querySelector('#calendar_dir_x').value;

						var container = document.getElementById('map');
						var options = {
							center: new kakao.maps.LatLng(calender_dir_y, calender_dir_x),
							level: 3
						};

						var map = new kakao.maps.Map(container, options);

						var markerPosition = new kakao.maps.LatLng(calender_dir_y, calender_dir_x);

						var marker = new kakao.maps.Marker({
							position: markerPosition
						});

						marker.setMap(map);

						var mapTypeControl = new kakao.maps.MapTypeControl();

						map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

						var zoomControl = new kakao.maps.ZoomControl();
						map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
					} else {
						document.querySelector(".guid-box").style.display = 'none';
					}
					$('#calendar-info-modal').modal('show');
				})
				.catch(error => console.log(error))
		})
	})
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