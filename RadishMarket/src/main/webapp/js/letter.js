let letter_no;
let receive_user_no;
let send_user_no;
let letter_title;
let item_no;
let letter_reg_datetime;
let letter_content;
let send_user_nickname;
let popupWindow;
let popupDocument;

function openPop(type) {
	letter_no = event.currentTarget.id;
	if(letter_no)
		letter_no = letter_no.replace("show-letter","");
	popupWindow = null;
	popupWindow = window.open('', '', 'width=400,height=400');
	popupDocument = popupWindow.document;
	switch(type){
		case 'send' :
			setSendLetterInfo();
			break;
		case 'read' : 
			fetchReadLetter();
			let check = document.querySelector(`#check-letter${letter_no}`);
			if(check.innerText == '미확인 쪽지')
				check.innerText = '확인한 쪽지';
			break;
	}
}

function setEvents(){
	const btnSend = popupDocument.getElementById('send-letter');
	if(btnSend){
		btnSend.addEventListener('click', () => {
			setSendData(popupDocument)
			if(!letter_title || !letter_content){
				popupWindow.alert('입력되지 않은 내용이 있습니다.')
				return;
			}
			fetchSendLetter();
			popupWindow.close();
			resetValues()
			sendAlarm();
		});
	}
	const btnWrite = popupDocument.getElementById('write-letter');
	if(btnWrite){
		btnWrite.addEventListener('click', () => {
			receive_user_no = send_user_no;
			popupDocument.getElementById('letter-box').innerText = '';
			setSendLetterInfo();
		});
	}
	popupDocument.getElementById('close-popup').addEventListener('click', () => {
		receive_user_no = null;
		item_no = null;
		popupWindow.close();
		resetValues()
	});
}

function setSendLetterInfo(){
	if(!receive_user_no)
		receive_user_no = document.querySelector("#receive_user_no").value;
	if(!item_no){
		item_no = document.querySelector("#item_no");
		if(item_no)
			item_no = item_no.value;
		else
			item_no = '0';
	}
	setPopupWriteForSend(popupDocument);
}

function setPrintLetterInfo(data){
	const datas = data.split("/devide/");
	send_user_no = datas[0];
	letter_title = datas[1];
	item_no = datas[2];
	letter_reg_datetime = datas[3];
	letter_content = datas[4];
	send_user_nickname = datas[5];
	setPopupWriteForRead(popupDocument);
}

function setPopupWriteForSend(popupDocument){
	popupDocument.write('<h2>쪽지 보내기</h2>');
	popupDocument.write(`<input type="text" id="receive_user_no" name="receive_user_no" value="${receive_user_no}" readonly/>`);
	if(item_no){
		popupDocument.write(`<input type="hidden" id="item_no" name="item_no" value="${item_no}" readonly/>`);
	}
	popupDocument.write('<hr>');
	popupDocument.write(`<input type="text" id="letter_title" name="letter_title" />`);
	popupDocument.write('<hr>');
	popupDocument.write(`<textarea id="letter_content" name="letter_content"></textarea>`);
	popupDocument.write('<button id="send-letter">전송</button>');
	popupDocument.write('<button id="close-popup">취소</button>');
	setEvents()
}

function setPopupWriteForRead(popupDocument){
	popupDocument.write('<div id="letter-box">');
	popupDocument.write('<h2>쪽지</h2>');
	popupDocument.write(`<h3>${letter_title}</h3>`);
	if(item_no){
		popupDocument.write('<hr>');
		popupDocument.write(`<p>${item_no}</p>`);
	}
	popupDocument.write('<hr>');
	popupDocument.write(`<h3>${send_user_nickname}</h3>`);
	popupDocument.write('<hr>');
	popupDocument.write(`<p>${letter_reg_datetime}</p>`);
	popupDocument.write('<hr>');
	popupDocument.write(`<p>${letter_content}</p>`);
	popupDocument.write(`<button id="write-letter">답장</button>`);
	popupDocument.write('<button id="close-popup">닫기</button>');
	popupDocument.write('</div>');
	setEvents()
}

function setSendData(popupDocument){
	receive_user_no = popupDocument.getElementById('receive_user_no').value;
	console.log(receive_user_no)
	letter_title = popupDocument.getElementById('letter_title');
	if(letter_title)
		letter_title = letter_title.value;
	item_no = popupDocument.getElementById('item_no');
	if(!item_no)
		item_no = 0;
	else
		item_no = item_no.value;
	letter_content = popupDocument.getElementById('letter_content');
	if(letter_content)
		letter_content = letter_content.value;
}


function fetchSendLetter(){
	fetch('/insertLetter.do', {
		method: "post",
		headers:{"Content-type" : "application/x-www-form-urlencoded; charset=UFT-8"},
		body: `user_no=${receive_user_no}&letter_title=${letter_title}&item_no=${item_no}&letter_content=${letter_content}`
	})
	.then(response => response.text())
	.then(checkAction)
	.catch(error => console.log(error))
}

function fetchReadLetter(){
	fetch(`/infoLetterAjax.do?letter_no=${letter_no}`)
	.then(response => response.text())
	.then(setPrintLetterInfo)
	.catch(error => console.log(error))
}

function checkAction(check){
	if(check){
		alert('쪽지 발송 성공 !')
	}else{
		alert('쪽지 발송 실패 !')
	}
}

function resetValues(){
	 letter_no = null;
	 receive_user_no = null;
	 send_user_no = null;
	 letter_title = null;
	 item_no = null;
	 letter_reg_datetime = null;
	 letter_content = null;
	 send_user_nickname = null;
	 popupWindow = null;
	 popupDocument = null;
}