function deleteUserDoubleCheck(){
	let check = confirm('진짜 지움?')
	if(check)
		location.href='/deleteUser.do'
}
