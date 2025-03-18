function sendAlarm () {
	const user_no = document.querySelector('#user_no').value;
	let alarm_category_no = document.querySelector('#alarm_category_no').value;
	const link_no = document.querySelector('#link_no').value;
	const isLike = document.querySelector('#isLike');
	const isZzim = document.querySelector('#isZzim');
	if(event.target.id && event.target.id == 'btn-comment-submit')
		alarm_category_no = '2'; 
	if(alarm_category_no == '1' && isLike.value != '0'){
		fetch(`/deleteLike.do?board_no=${ link_no }`)
		.then(response => response.text())
		.then(() => {
			const likeCount = document.querySelector('#like-count');
			likeCount.innerText = parseInt(likeCount.innerText) - parseInt(1);
			isLike.value = '0'
		})
		.catch(error => console.log(error))
		return
	}
	
	if(alarm_category_no == '3' && event.target.value){
		alarm_category_no = '6';
	}
	
	if(alarm_category_no == '3' && isZzim.value != '0'){
		fetch(`/deleteZzim.do?item_no=${ link_no }`)
		.then(response => response.text())
		.then(() => {
			const zzimCount = document.querySelector('#zzim-count');
			zzimCount.innerText = parseInt(zzimCount.innerText) - parseInt(1);
			isZzim.value = '0'
		})
		.catch(error => console.log(error))
		return;
	}
	
	let url = `/insertAlarmAjax.do?user_no=${user_no}&alarm_category_no=${alarm_category_no}`;
	if(link_no){
		url += `&link_no=${link_no}`;
	}
	
	fetch(url)
	.then(response => response.text())
	.catch(error => console.log(error))
	
	if(alarm_category_no == '7'){
		url = `/insertAlarmAjax.do?user_no=${user_no}&alarm_category_no=5&link_no=${link_no}`
		fetch(url)
		.then(response => response.text())
		.catch(error => console.log(error))
	}
	
	if(alarm_category_no == '3'){
		fetch(`/insertZzim.do?item_no=${ link_no }`)
		.then(response => response.text())
		.then(() => {
			const zzimCount = document.querySelector('#zzim-count');
			zzimCount.innerText = parseInt(zzimCount.innerText) + parseInt(1);
			isZzim.value = '1'
		})
		.catch(error => console.log(error))
		return;
	}
	if(alarm_category_no != '6'){
		const form = document.querySelector('form');
		if(form){
			form.submit();
		}
	}
	if(alarm_category_no == '1'){
		fetch(`/insertLike.do?board_no=${ link_no }`)
		.then(response => response.text())
		.then(() => {
			const likeCount = document.querySelector('#like-count');
			likeCount.innerText = parseInt(likeCount.innerText) + parseInt(1);
			isLike.value = '1'
		})
		.catch(error => console.log(error))
	}
	if(alarm_category_no == '2'){
		const comment = document.querySelector('#comment_content');
		fetch(`/insertComment.do?board_no=${ link_no }&comment_content=${comment.value}`)
		.then(response => response.text())
		.then(() => {
			location.href=`infoBoard.do?board_no=${link_no}`
		})
		.catch(error => console.log(error))
	}
	if(alarm_category_no == '9'){
		location.href=`/insertMeetUser.do?meet_no=${link_no}&user_no=${user_no}`;
	}
}

function deleteAlarm(e){
	const alarm_no = e.id.replace("btn-deleteAlarm","");
	fetch(`/deleteAlarmAjax.do?alarm_no=${alarm_no}`)
	.then(response => response.text())
	.catch(error => console.log(error))
	showAlarmDiv()
	showAlarmDiv()
}

const alarmList = document.querySelector("#alarm-list");
function loadAlarm () {
	fetch(`/listAlarmAjax.do`)
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
			case '1': case '2' : href = `infoBoard.do?board_no=${datas[5]}&alarm_no=${datas[3]}`; break; // 게시판 이동
			case '3' : href = `infoItem.do?item_no=${datas[5]}&alarm_no=${datas[3]}`; break; // 아이템 이동
			case '4' : href = `listReview.do?alarm_no=${datas[3]}`; break; // 리뷰 리스트 이동
			case '5' : href = `insertReview.do?item_no=${datas[5]}&alarm_no=${datas[3]}`; break; // 리뷰 작성 페이지 이동
			case '6' : href = `listLetter.do?alarm_no=${datas[3]}`; break; // 쪽지함 이동
			case '7' : href = `mypageUser.do?alarm_no=${datas[3]}`; break; // 일정 보기 이동
			case '8' : href = `listMeetJoin.do?meet_no=${datas[5]}&alarm_no=${datas[3]}`; break; // 모임 가입 리스트 이동
			case '9' : href = `infoMeet.do?meet_no=${datas[5]}&alarm_no=${datas[3]}`; break; // 신청 모임으로 이동
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