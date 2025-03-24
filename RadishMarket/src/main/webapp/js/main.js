function searchInItemList(){
	const searchValue = document.querySelector("#search_value").value;
	if(!searchValue){
		alert('검색어를 입력해주세요.')
		return;
	}
	location.href=`listItem.do?search_value=${searchValue}`
}