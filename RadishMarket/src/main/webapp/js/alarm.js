function sendAlarm (user_no, alarm_category_no, link_no) {
	fetch(`/insertAlarm.do?user_no=${user_no}&alarm_category_no=${alarm_category_no}&link_no=${link_no}`)
	.then(response => response.text())
	.catch(error => console.log(error))
}

function deleteAlarm(e){
	const alarm_no = e.id.replace("btn-deleteAlarm","");
	fetch(`/deleteAlarm.do?alarm_no=${alarm_no}`)
	.then(response => response.text())
	.catch(error => console.log(error))
	showAlarmDiv()
	showAlarmDiv()
}

const alarmList = document.querySelector("#alarm-list");
function loadAlarm () {
	fetch(`/alarmListAjax.do`)
	.then(response => response.text())
	.then(showAlarm)
	.catch(error => console.log(error))
}
function showAlarm(alarms){
	if(!alarms){
		return;
	}
	let alarm = alarms.split("/");
	alarmList.innerHTML = '';
	for(let i = 0 ; i < alarm.length ; i++){
		const datas = alarm[i].split(",");
		let href = '';
		switch(datas[4]){
			case '1', '2' : href = `infoBoard.do?board_no=${datas[5]}`; break; // 게시판 이동
			case '3' : href = `infoItem.do?item_no=${datas[5]}`; break; // 아이템 이동
			case '4' : href = `listReview.do`; break; // 리뷰 리스트 이동
			case '5' : href = `insertReview.do?item_no=${datas[5]}`; break; // 리뷰 작성 페이지 이동
			case '6' : href = `listLetter.do?`; break; // 쪽지함 이동
			case '7' : href = `마이페이지.do`; break; // 일정 보기 이동
			case '8' : href = `listMeetJoin.do`; break; // 모임 가입 리스트 이동
			case '9' : href = `infoMeet.do?meet_no=${datas[5]}`; break; // 신청 모임으로 이동
		}
		
		let printAlarm =`<a href=${href}>
							[${datas[0]}] ${datas[1]} ${datas[2]}
						</a>
						<button id="btn-deleteAlarm${datas[3]}" onclick="deleteAlarm(this)">X</button>`
						
		let addClass = '';
		if(datas[6] == '0'){
			addClass = 'class="alarm-bold"';
		}
		
		if(addClass){
			alarmList.innerHTML += `<div ${addClass}>${printAlarm}</div>`
		}else{
			alarmList.innerHTML += `<div>${printAlarm}</div>`
		}
								
		
		
	}
}

let isOpenAlarm = false;
function showAlarmDiv(){
	loadAlarm()
	if(isOpenAlarm){
		alarmList.classList.add('hide');
		isOpenAlarm = false;
	}else{
		alarmList.classList.remove('hide');
		isOpenAlarm = true;
	}
}
document.addEventListener('click', (e)=>{
	if(isOpenAlarm && !alarmList.contains(e.target) && !document.querySelector('#show-alarm-div').contains(e.target)){
		alarmList.classList.add('hide');
		isOpenAlarm = false;
	}
})