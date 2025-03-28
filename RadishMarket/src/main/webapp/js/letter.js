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
let log = document.querySelector("#log");
let send_user_img;
let send_user_dong;
let send_user_deg;
let send_user_emoji;
let item_img;
let item_name;
let item_price;
let send_user_gu;
const viewMode = document.querySelector('head');

function openPop(type) {
	if(document.getElementById('log') === null){
		alert('로그인 후 이용 가능합니다.');
		return;
	}
	if(popupWindow && !popupWindow.closed){
		popupWindow.close()
	}
	
	letter_no = event.currentTarget.id;
	if(letter_no)
		letter_no = letter_no.replace("show-letter","");
	popupWindow = null;
	if(type == 'send')
		popupWindow = window.open('', '쪽지 보내기', 'width=400,height=400,location=no, scrollbars=no, toolbar=no, resizable=no, left=0, top=0');
	else
		popupWindow = window.open('', '쪽지 보기', 'width=400,height=600,location=no, scrollbars=no, toolbar=no, resizable=no, left=0, top=0');
	popupDocument = popupWindow.document;
	switch(type){
		case 'send' :
			setSendLetterInfo();
			break;
		case 'read' : 
			fetchReadLetter();
			let check = document.querySelector(`#show-letter${letter_no}`);
			if(document.querySelector("#btn-more-list").value.split("/")[0] == 'receiveLetter' && check && check.className == '0'){
				check.className = '1'
				check.innerHTML = check.innerHTML.replace('<strong><i class="fa-solid fa-envelope" style="color: greenyellow">'
												,'<i class="fa-solid fa-envelope-open" style="color: rgb(148, 140, 140)">') + '<strong style="width:0; margin-right:-22.5px;">'
			}
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
	const btnTrade = popupDocument.getElementById('set-trade');
	if(btnTrade){
		btnTrade.addEventListener('click', () => {
			popupWindow.close();
			location.href=`/insertCalendar.do?sub_user_no=${send_user_no}&item_no=${item_no}`
		});
	}
	const btnWrite = popupDocument.getElementById('write-letter');
	if(btnWrite){
		btnWrite.addEventListener('click', () => {
			receive_user_no = send_user_no;
			popupDocument.getElementById('letter-info-box').innerText = '';
			setSendLetterInfo();
		});
	}
	popupDocument.getElementById('close-popup').addEventListener('click', () => {
		receive_user_no = null;
		item_no = null;
		popupWindow.close();
		resetValues()
	});
	const title = popupDocument.getElementById('letter_title'); 
	if(title){
		title.addEventListener('input', () => {
			if(title.value && title.value.length > 50){
				title.value = title.value.substring(0, 50);
			}
		});
	}
	const content = popupDocument.getElementById('letter_title'); 
	if(content){
		content.addEventListener('input', () => {
			if(content.value && content.value.length > 300){
				content.value = content.value.substring(0, 300);
			}
		});
	}
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
	send_user_img = datas[5];
	send_user_nickname = datas[6];
	send_user_gu = datas[7];
	send_user_dong = datas[8];
	send_user_deg = datas[9];
	send_user_emoji = datas[10];
	if(datas.length > 11){
		item_img = datas[11];
		item_name = datas[12];
		item_price = datas[13];
	}
	setPopupWriteForRead(popupDocument);
}

function setPopupWriteForSend(popupDocument){
	if(viewMode.innerHTML.includes('<link rel="stylesheet" href="../../css/darkMode.css">') == true){
		popupDocument.write(`<link rel="stylesheet" href="../../css/darkMode.css">`);
	}
	popupDocument.write(`<link rel="stylesheet" href="../../css/main.css">`);
	popupDocument.write(`<link rel="stylesheet" href="../../css/letterList.css">`);
	popupDocument.write('<div class="letter-info-box" id="letter-info-box" style="margin-top:-20px;">');
	popupDocument.write('<div class="lettergoings">');
	popupDocument.write('<div class="propile" style="height:50px; padding:0 10px; line-height: 50px;">');
	popupDocument.write('<h2> 쪽지 보내기</h2>');
	popupDocument.write(`<input type="hidden" id="receive_user_no" name="receive_user_no" value="${receive_user_no}" />`);
	popupDocument.write('</div>');
	if(item_no && item_no != '0'){
		popupDocument.write(`<input type="hidden" id="item_no" name="item_no" value="${item_no}" />`);
	}
	popupDocument.write('<div class="text">');
	popupDocument.write(`<div class="title"><h3> 제목 <br><input type="text" id="letter_title" name="letter_title" /></h3></div>`);
	popupDocument.write(`<div class="title"><h3> 내용</h3><textarea id="letter_content" name="letter_content"></textarea></div>`);
	popupDocument.write('<div class="going">');
	popupDocument.write('<button id="send-letter">전송</button>');
	popupDocument.write('<button class="delect" id="close-popup">취소</button>');
	popupDocument.write('</div>');
	popupDocument.write('</div>');
	popupDocument.write('</div>');
	popupDocument.write(`<script src="../../js/main.js"></script>`);
	setEvents()
}

function setPopupWriteForRead(popupDocument){
	if(viewMode.innerHTML.includes('<link rel="stylesheet" href="../../css/darkMode.css">') == true){
		popupDocument.write(`<link rel="stylesheet" href="../../css/darkMode.css">`);
	}
	popupDocument.write(`<link rel="stylesheet" href="../../css/main.css">`);
	popupDocument.write(`<link rel="stylesheet" href="../../css/letterList.css">`);
	popupDocument.write('<div class="letter-info-box" id="letter-info-box">');
	popupDocument.write('<div class="lettergoings">');
	popupDocument.write('<div class="propile">');
	popupDocument.write(`	<div class="user-profile-container">
								<div class="user-profile-inner-container">
									<section class="user-profile-section1">
										<img alt="대표이미지" src="/images/${send_user_img != '' ? send_user_img : 'usersDefaultImg.png'}">
										<div class="user-profile-text-box">
											<a>${send_user_nickname}</a>
											<span class="user-profile-dong">
												<a>${send_user_dong}</a>
											</span>
										</div>
									</section>
									<section class="user-profile-section2">
										<div class="user-profile-inner-section">
											<div class="user-profile-inner-box1">
												<span class="user-profile-deg">${send_user_deg}℃</span> <span class="user-profile-emoji">${send_user_emoji}</span>
											</div>
											<div class="user-profile-inner-box2">
												<progress value="${send_user_deg}" max="100"></progress>
											</div>
											<div class="user-profile-inner-box3">
												<p class="ondo-label">매너온도</p>
											</div>
										</div>
									</section>
								</div>
							</div>
							</div>`);
	if(item_no && item_no != '0'){
	popupDocument.write(`	<div class="productletter">
						        <div class="letterimg">
									<img alt="대표이미지" src="/images/${item_img}">
						          <p style="margin-left: 10px; font-size: 15px; margin-bottom: 0px;">${item_name}<br>${item_price}원</p>
						        </div>
						      </div>`);
	}
	popupDocument.write('<div class="text">');
	popupDocument.write(`<div class="title"><h3>제목</h3> <h5>${letter_title}</h5></div>`);
	popupDocument.write(`<div class="title"><h3>내용</h3><p>${letter_content}</p></div>`);
	popupDocument.write(`<div class="times"><p>${letter_reg_datetime}</p></div>`);
	popupDocument.write('<div class="going">');
	if(item_no && item_no != '0' && log && log.value != send_user_no){
		popupDocument.write('<button id="set-trade">약속잡기</button>');
	}
	if(log && log.value != send_user_no){
		popupDocument.write('<button id="write-letter">답장</button>');
	}
	popupDocument.write('<button class="delect" id="close-popup">취소</button>');
	popupDocument.write('</div>');
	popupDocument.write('</div>');
	popupDocument.write('</div>');
	popupDocument.write(`<script src="../../js/main.js"></script>`);
	
	setEvents()
}

function setSendData(popupDocument){
	receive_user_no = popupDocument.getElementById('receive_user_no').value;
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
	 send_user_img = null;
	 send_user_dong = null;
	 send_user_deg = null;
	 send_user_emoji = null;
	 item_img = null;
	 item_name = null;
	 item_price = null;
	 send_user_gu = null;
}