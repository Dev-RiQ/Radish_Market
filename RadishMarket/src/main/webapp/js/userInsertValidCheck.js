let joinId = null;
let checkId = null;
function idValidCheck () {
	joinId = document.querySelector("#user_id")
	checkId = joinId.value;
	if(!checkId.trim()){
		alert('값을 입력하세요.')
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
	if(!check){
		alert('이미 존재하는 아이디입니다.')
		joinId.style.border = "2px solid crimson"
		joinId.value = ""
		joinId.focus()
		checkId = null;
	}else{
		alert('사용할 수 있는 아이디입니다.')
		joinId.style.border = "2px solid royalblue"
	}
}

function validCheck(){
	const inputs = document.querySelectorAll("input")
	const labels = document.querySelectorAll("label");
	const spans = document.querySelectorAll("span");
	const userImg = document.querySelector("#user_img");
	const hiddenEmail = document.querySelectorAll("#user_email")[2];
	for(let i = 0 ; i < inputs.length ; i++){
		let value = inputs[i].value.trim();
		if(inputs[i] === hiddenEmail || inputs[i] === userImg) continue;
		if(!value){
			alert(labels[i].innerText+' 입력이 필요합니다.')
			return			
		}
		if(i < inputs.length - 7 && value.includes(" ")){
			alert(labels[i].innerText+'에 공백을 제거해주세요.')
			return			
		}
	}
	for(let i = 0 ; i < spans.length ; i++){
		let countClass = spans[i].classList.length;
		if(countClass == 1){
			alert('유효하지 않은 값이 있습니다.')
			return			
		}
	}
	if(checkId == null || joinId == null || joinId.value != checkId){
		alert('아이디 중복체크가 필요합니다.')
		return;
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
const id_length_check = document.querySelector('.id_length_check');
const id_value_check = document.querySelector('.id_value_check');
user_id.addEventListener('keyup', () => {
	if(onlyNumberAndEnglish(user_id.value)){
		id_value_check.classList.add('hide');
	}else{
		id_value_check.classList.remove('hide');
	}
	if(inputLength(user_id.value, 4, 12)){
		id_length_check.classList.add('hide');
	}else{
		id_length_check.classList.remove('hide');
	}
})

function strongPassword (str) {
  return /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/.test(str);
}

const user_pw = document.querySelector('#user_pw');
const pw_length_check = document.querySelector('.pw_length_check');
const pw_value_check = document.querySelector('.pw_value_check');
user_pw.addEventListener('keyup', () => {
	if(strongPassword(user_pw.value)){
		pw_value_check.classList.add('hide');
	}else{
		pw_value_check.classList.remove('hide');
	}
	if(inputLength(user_pw.value, 8, 16)){
		pw_length_check.classList.add('hide');
	}else{
		pw_length_check.classList.remove('hide');
	}
})

function validName (str) {
  return /^[ㄱ-ㅎ|가-힣]+$/.test(str);
}

const user_name = document.querySelector('#user_name');
const name_length_check = document.querySelector('.name_length_check');
const name_value_check = document.querySelector('.name_value_check');
user_name.addEventListener('keyup', () => {
	if(validName(user_name.value)){
		name_value_check.classList.add('hide');
	}else{
		name_value_check.classList.remove('hide');
	}
	if(inputLength(user_name.value, 2, 10)){
		name_length_check.classList.add('hide');
	}else{
		name_length_check.classList.remove('hide');
	}
})

function validAge (str) {
  return parseInt(str) >= 14 && parseInt(str) <= 130;
}

const user_age = document.querySelector('#user_age');
const number_value_check = document.querySelector('.number_value_check');
user_age.addEventListener('keyup', () => {
	if(validAge(user_age.value)){
		number_value_check.classList.add('hide');
	}else{
		number_value_check.classList.remove('hide');
	}
	if(user_age.value.length > 3)
		user_age.value = user_age.value.substring(0,3)
})

function validEmail (str) {
  return /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-za-z0-9\-]+$/.test(str);
}

const user_email = document.querySelectorAll('#user_email');
const email_value_check = document.querySelector('.email_value_check');
user_email[1].addEventListener('input', () => {
	if(user_email[1].value =='@'){
		user_email[2].classList.remove('hide');
		email_value_check.classList.remove('hide');
	}else{
		user_email[2].classList.add('hide');
		user_email[2].value="";
		email_value_check.classList.add('hide');
	}
})
user_email[0].addEventListener('keyup', () => {
	if(validEmail(user_email[0].value + user_email[1].value + user_email[2].value)){
		email_value_check.classList.add('hide');
	}else{
		email_value_check.classList.remove('hide');
	}
})
user_email[2].addEventListener('keyup', () => {
	if(validEmail(user_email[0].value + user_email[1].value + user_email[2].value)){
		email_value_check.classList.add('hide');
	}else{
		email_value_check.classList.remove('hide');
	}
})

function validNickname (str) {
  return /^[A-Z|a-z|0-9|가-힣]+$/.test(str);
}

const user_nickname = document.querySelector('#user_nickname');
const nickname_length_check = document.querySelector('.nickname_length_check');
const nickname_value_check = document.querySelector('.nickname_value_check');
user_nickname.addEventListener('keyup', () => {
	if(validNickname(user_nickname.value)){
		nickname_value_check.classList.add('hide');
	}else{
		nickname_value_check.classList.remove('hide');
	}
	if(inputLength(user_nickname.value, 2, 6)){
		nickname_length_check.classList.add('hide');
	}else{
		nickname_length_check.classList.remove('hide');
	}
})

function validPhoneNumber (str) {
  return /^(01[01679]{1})-?[0-9]{3,4}-?[0-9]{4}$/.test(str);
}

const user_phone = document.querySelectorAll('#user_phone');
const phone_value_check = document.querySelector('.phone_value_check');
user_phone[1].addEventListener('keyup', () => {
	if(validPhoneNumber(user_phone[0].value + "-" +user_phone[1].value + "-" +user_phone[2].value)){
		phone_value_check.classList.add('hide');
	}else{
		phone_value_check.classList.remove('hide');
	}
	if(user_phone[1].value.length > 4)
		user_phone[1].value = user_phone[1].value.substring(0,4)
})
user_phone[2].addEventListener('keyup', () => {
	if(validPhoneNumber(user_phone[0].value + "-" +user_phone[1].value + "-" +user_phone[2].value)){
		phone_value_check.classList.add('hide');
	}else{
		phone_value_check.classList.remove('hide');
	}
	if(user_phone[2].value.length > 4)
		user_phone[2].value = user_phone[2].value.substring(0,4)
})