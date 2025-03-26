let joinId = null;
let checkId = null;
function idValidCheck () {
	joinId = document.querySelector("#user_id")
	checkId = joinId.value;
	if(!checkId.trim()){
		
		return
	}
	fetch('/insertUserAjax.do',{
		method: "post",
		headers:{
			"Content-type" : "application/x-www-form-urlencoded; charset=UFT-8"
		},
		body: "user_id="+checkId
	}).then(response => response.text())
	.then(hasId)
	.catch(error => console.log(error))
}

function hasId(check){
	const idCheck = document.querySelector("#id_check");
	if(!check){
		idCheck.innerText = '사용 불가능한 아이디입니다.'
		joinId.style.border = "2px solid crimson"
		joinId.value = ""
		joinId.focus()
		checkId = null;
	}else{
		idCheck.innerText = ''
		joinId.style.border = "2px solid royalblue"
	}
}

function validCheck(){
	const inputs = document.querySelectorAll("input")
	const userImg = document.querySelector("#user_img");
	const hiddenEmail = document.querySelectorAll("#user_email")[2];
	const selectEmail = document.querySelectorAll("#user_email")[1];
	for(let i = 0 ; i < inputs.length ; i++){
		let value = inputs[i].value.trim();
		if(selectEmail.value != "@" && inputs[i] === hiddenEmail || inputs[i] === userImg) continue;
		let type = inputs[i].id.split("_")[1];
		const span = document.querySelector(`#${type}_check`);
		if(value && span){
			span.innerText = '';
			inputs[i].style.border = "1px solid black"
		}
		if(!value && span){
			span.innerText = '값을 입력해주세요.';
			inputs[i].style.border = "2px solid crimson"
		}
		if(span && i < 10 && value.includes(" ")){
			span.innerText = '공백을 제거해주세요.';
			inputs[i].style.border = "2px solid crimson"
		}
	}
	const spans = document.querySelectorAll("span");
	for(let i = 0 ; i < spans.length ; i++){
		if(spans[i].id && spans[i].innerText){
			let type = spans[i].id.split("_")[0];
			const input = document.querySelector(`#user_${type}`);
			if(input){
				input.focus();
			}
			return;		
		}
	}
	document.querySelector("form").submit()
}

function inputLength(value, min, max) {
  return value.length >= min && value.length <= max
}

function onlyNumberAndEnglish(str) {
  return /^[A-Za-z0-9][A-Za-z0-9]*$/.test(str);
}

const user_id = document.querySelector('#user_id');
user_id.focus();
const idCheck = document.querySelector(`#id_check`);
user_id.addEventListener('keyup', () => {
	if(inputLength(user_id.value, 4, 12)){
		if(onlyNumberAndEnglish(user_id.value)){
			idCheck.innerText = '';
		}else{
			idCheck.innerText = '숫자, 영어만 입력';
		}
	}else{
		idCheck.innerText = '4~12자 입력';
	}
})

function strongPassword (str) {
  return /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/.test(str);
}

const user_pw = document.querySelector('#user_pw');
const pwCheck = document.querySelector('#pw_check');
user_pw.addEventListener('keyup', () => {
	if(inputLength(user_pw.value, 8, 16)){
		if(strongPassword(user_pw.value)){
			pwCheck.innerText = '';
		}else{
			pwCheck.innerText = '숫자, 영어, 특수문자 포함 입력';
		}
	}else{
			pwCheck.innerText = '8~16자 입력';
	}
})

function validName (str) {
  return /^[가-힣]+$/.test(str);
}

const user_name = document.querySelector('#user_name');
const nameCheck = document.querySelector('#name_check');
user_name.addEventListener('keyup', () => {
	if(inputLength(user_name.value, 2, 10)){
		if(validName(user_name.value)){
			nameCheck.innerText = '';
		}else{
			nameCheck.innerText = '한글만 입력';
		}
	}else{
		nameCheck.innerText = '2~10자 입력';
	}
})

function validAge (str) {
  return parseInt(str) >= 14 && parseInt(str) <= 130;
}

const user_age = document.querySelector('#user_age');
const ageCheck = document.querySelector('#age_check');
user_age.addEventListener('keyup', () => {
	if(validAge(user_age.value)){
		ageCheck.innerText = '';
	}else{
		ageCheck.innerText = '14~130사이 숫자만 입력';
	}
	if(user_age.value.length > 3)
		user_age.value = user_age.value.substring(0,3)
})

function validEmail (str) {
  return /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-za-z0-9\-]+$/.test(str);
}

const user_email = document.querySelectorAll('#user_email');
const emailCheck = document.querySelector('#email_check');
user_email[1].addEventListener('input', () => {
	if(user_email[1].value =='@'){
		emailCheck.innerText = '';
		user_email[2].classList.remove('hide');
	}else{
		user_email[2].classList.add('hide');
		emailCheck.innerText = '';
		user_email[2].value="";
	}
})
user_email[0].addEventListener('keyup', () => {
	if(validEmail(user_email[0].value + user_email[1].value + user_email[2].value)){
		emailCheck.innerText = '';
	}else{
		emailCheck.innerText = 'test@example.com 형식으로 입력해주세요.';
	}
})
user_email[2].addEventListener('keyup', () => {
	if(validEmail(user_email[0].value + user_email[1].value + user_email[2].value)){
		emailCheck.innerText = '';
	}else{
		emailCheck.innerText = 'test@example.com 형식으로 입력해주세요.';
	}
})

function validNickname (str) {
  return /^[A-Z|a-z|0-9|가-힣]+$/.test(str);
}

const user_nickname = document.querySelector('#user_nickname');
const nicknameCheck = document.querySelector('#nickname_check');
user_nickname.addEventListener('keyup', () => {
	if(inputLength(user_nickname.value, 2, 6)){
		if(validNickname(user_nickname.value)){
			nicknameCheck.innerText = '';
		}else{
			nicknameCheck.innerText = '사용할 수 없는 닉네임';
		}
	}else{
		nicknameCheck.innerText = '2~6자 입력';
	}
})

function validPhoneNumber (str) {
  return /^(01[01679]{1})-?[0-9]{3,4}-?[0-9]{4}$/.test(str);
}

const user_phone = document.querySelectorAll('#user_phone');
const phoneCheck = document.querySelector('#phone_check');
user_phone[1].addEventListener('keyup', () => {
	if(validPhoneNumber(user_phone[0].value + "-" +user_phone[1].value + "-" +user_phone[2].value)){
		phoneCheck.innerText = '';
	}else{
		phoneCheck.innerText = '유효하지 않은 전화번호입니다.';
	}
	if(user_phone[1].value.length > 4)
		user_phone[1].value = user_phone[1].value.substring(0,4)
})
user_phone[2].addEventListener('keyup', () => {
	if(validPhoneNumber(user_phone[0].value + "-" +user_phone[1].value + "-" +user_phone[2].value)){
		phoneCheck.innerText = '';
	}else{
		phoneCheck.innerText = '유효하지 않은 전화번호입니다.';
	}
	if(user_phone[2].value.length > 4)
		user_phone[2].value = user_phone[2].value.substring(0,4)
})

const btn_user_address = document.querySelector('#btn_user_address');
const addressCheck = document.querySelector('#address_check');
btn_user_address.addEventListener('click', () => {
	addressCheck.innerText = '';
})