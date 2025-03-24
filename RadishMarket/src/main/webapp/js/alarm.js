function sendAlarm () {
	if(document.getElementById('log') === null){
		alert('로그인 후 이용가능합니다.')
		return;
	}
	
	const user_no = document.querySelector('#user_no').value;
	let alarm_category_no = document.querySelector('#alarm_category_no').value;
	const link_no = document.querySelector('#link_no').value;
	const isLike = document.querySelector('#isLike');
	const isZzim = document.querySelector('#isZzim');
	if(event.target.id && event.target.id == 'btn-comment-submit')
		alarm_category_no = '2'; 
	if(alarm_category_no == '1' && isLike.value != '0'){
		fetch(`/deleteLike.do?board_no=${ link_no }&user_no=${user_no}`)
		.then(response => response.text())
		.then(() => {
			const likeCount = document.querySelector('#like-count');
			likeCount.innerText = parseInt(likeCount.innerText) - parseInt(1);
			isLike.value = '0'
		})
		.catch(error => console.log(error))
		return
	}
	
	if(alarm_category_no == '3' && event.target.id == 'send-letter'){
		alarm_category_no = '6';
	}
	
	if(alarm_category_no == '3' && isZzim.value != '0'){
		fetch(`/deleteZzim.do?item_no=${ link_no }&user_no=${user_no}`)
		.then(response => response.text())
		.then(() => {
			const zzimBtn = document.querySelector('#btn-zzim');
			zzimBtn.innerText = '찜하기';
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
			const zzimBtn = document.querySelector('#btn-zzim');
			zzimBtn.innerText = '찜취소';
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

let alarmList = document.querySelector("#alarm-list-box");
const btn_alarm = document.querySelector("#show-alarm-div");
let isOpenAlarm = false;
let isLoad = false;
let scrollH = 0;
let isFirst = true;
function showAlarmDiv(){
	if(isOpenAlarm){
		resetAlarmList()
	}else{
		if(scrollH == 0){
			alarmList.innerHTML = `<div class="bellstxt">
								      <h3>알림</h3>
								    </div>`;
		}
		getMoreList();
		isLoad = true;
		alarmList.classList.remove('hide');
		isOpenAlarm = true;
		alarmList.addEventListener('scroll', infiniteScroll)
		
	}
}

function infiniteScroll(){
	if(isLoad && scrollH != alarmList.scrollHeight){
		scrollH = alarmList.scrollHeight;
		isLoad = false;				
	}
	const addListHeight = scrollH - alarmList.clientHeight - 90;
	if(!isLoad && alarmList.scrollTop > addListHeight){
		isLoad = true;
		if(!isFirst){
			getMoreList();
		}
	}
	isFirst = false;
}

document.addEventListener('click', (e)=>{
	if(isOpenAlarm && !alarmList.contains(e.target) && !document.querySelector('#show-alarm-div').contains(e.target)){
		resetAlarmList()
	}
})

function resetAlarmList(){
	alarmList.innerHTML = '';
	btn_alarm.value = 'alarm/0';
	alarmList.classList.add('hide');
	isOpenAlarm = false;
	alarmList.removeEventListener('scroll', infiniteScroll)
	scrollH = 0;
	isFirst = true;
}

function deleteAlarm(){
	const alarm_no = event.target.id.replace("btn-deleteAlarm","");
	btn_alarm.value = `alarm/${parseInt(btn_alarm.value.split("/")[1]) - 1}`;
	fetch(`/deleteAlarmAjax.do?alarm_no=${alarm_no}`)
	.then(response => response.text())
	.catch(error => console.log(error))
	event.target.parentElement.classList.add("hide");
	let leftAlarmCount = 0;
	alarmList.childNodes.forEach((i) => {
		if(!i.className){
			leftAlarmCount++;
		}
	})
	if(leftAlarmCount < 5) getMoreList();
}