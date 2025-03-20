/**
 * 
 * 더보기 버튼 양식
  	<div id="list-box">
	<!-- 여기 리스트 출력 -->
	</div>
  	<button id="btn-more-list" value="board/0" onclick="getMoreList()">더보기</button>
	<script src="../../js/listPaging.js"></script>
 * 
 * (예시)
 * <button id="btn-more-list" value="board/0" onclick="getMoreList()">더보기</button>
 * 
 *   리스트 종류
 *   "item"  
	 "board"  
	 "meetBoard"  
	 "meet"
	 "receiveLetter"  
	 "sendLetter"
	 "zzim"  
	 "cart"  
	 "myItem"  
	 "review"  
	 "myBoard"  
	 "hostMeet"  
	 "myMeet"
	 "adminUser"
	 "adminBoard"
	 "adminItem"
	 "adminMeet"
 * 
 */
/*let isLoaded = false;
let btnMoreListLoad = document.querySelectorAll("#btn-more-list")*/
let btnMoreList = null;
/*btnMoreListLoad.forEach((i) => {
	btnMoreList = i;
	getMoreList();
})
setTimeout(() => {
	isLoaded = true;
},1000)*/

function getMoreList(){
	/*if(isLoaded){*/
		btnMoreList = event.target;
	/*}*/
	const typeAndStart = btnMoreList.value.split("/");
	const type = typeAndStart[0];
	const start = typeAndStart[1];
	btnMoreList.value = `${type}/${parseInt(start) + parseInt(30)}`;
	
	let queryString = `start=${start}&type=${type}`;
	if(type == 'item' || type == 'board' || type == 'meetBoard' || type == 'meet' 
		|| type == 'myItem' || type == 'adminUser' || type == 'adminBoard' 
		|| type == 'adminItem' || type == 'adminMeet'){
		queryString += getFilter();
	}
	console.log(queryString)
	let url = `/listPagingAjax.do`;
	fetch(url, {
		method: "post",
		headers:{"Content-type" : "application/x-www-form-urlencoded; charset=UFT-8"},
		body:queryString
	})
	.then(response => response.text())
	.then(printList)
	.catch(error => console.log(error))
}

function getFilter(){
	let queryString = '';
	let itemStatus = document.querySelector('input[id="item_status"]:checked');
	if(!itemStatus)
		itemStatus = document.querySelector('#item_status');
	queryString += `&item_status=${itemStatus ? itemStatus.value ? itemStatus.value : 0 : 0}`
	
	let categoryNo = document.querySelector('input[id="category_no"]:checked');
	if(!categoryNo)
		categoryNo = document.querySelector('#category_no');
	queryString += `&category_no=${categoryNo ? categoryNo.value ? categoryNo.value : 0 : 0}`
	
	let priceMin = document.querySelector('input[id="price_min"]:checked');
	if(!priceMin)
		priceMin = document.querySelector('#price_min');
	queryString += `&price_min=${priceMin ? priceMin.value ? priceMin.value : 0 : 0}`
	
	let priceMax = document.querySelector('input[id="price_max"]:checked');
	if(!priceMax)
		priceMax = document.querySelector('#price_max');
	queryString += `&price_max=${priceMax ? priceMax.value ? priceMax.value : 0 : 0}`
	
	let gu = document.querySelector('input[id="gu"]:checked');
	if(!gu)
		gu = document.querySelector('#gu');
	queryString += `&gu=${gu ? gu.value ? gu.value : "강남구" : "강남구"}`
	
	let dong = document.querySelector('input[id="dong"]:checked');
	if(!dong)
		dong = document.querySelector('#dong');
	queryString += `&dong=${dong ? dong.value ? dong.value : "전체" : "전체"}`
	
	let orderBy = document.querySelector('input[id="order_by"]:checked');
	if(!orderBy)
		orderBy = document.querySelector('#order_by');
	queryString += `&order_by=${orderBy ? orderBy.value ? orderBy.value : 0 : 0}`
	
	let meetNo = document.querySelector('input[id="meet_no"]:checked');
	if(!meetNo)
		meetNo = document.querySelector('#meet_no');
	queryString += `&meet_no=${meetNo ? meetNo.value ? meetNo.value : 0 : 0}`
	
	return queryString;
}

function printList(data){
	if(data == 'noMoreList'){
		btnMoreList.classList.add('hide');
		if(btnMoreList.value.split("/")[1] == '30'){
			printNoData(btnMoreList.value.split("/")[0]);
		}
		return;
	} 
	const listBox = document.querySelector("#list-box");
	listBox.innerHTML += data;
}

function printNoData(type){
	let word = document.querySelector('.empty-info')
	if(word){
		switch(word.id){
			case 'sellList' : word.innerHTML = '판매중인 물품이 없습니다.'; break;
			case 'reviewList' : word.innerHTML = '후기가 없습니다.'; break;
			case 'buyList' : word.innerHTML = '구매한 물품이 없습니다.'; break;
			case 'reserveList' : word.innerHTML = '예약중인 물품이 없습니다.'; break;
			case 'soldList' : word.innerHTML = '거래 완료된 물품이 없습니다.'; break;
			case 'boardList' : word.innerHTML = '게시한 글이 없습니다.'; break;
			case 'hostMeetList' : word.innerHTML = '회원님이 호스트인 모임이 없습니다.'; break;
			case 'meetList' : word.innerHTML = '참여중인 모임이 없습니다.'; break;
			case 'receiveLetterList' : word.innerHTML = '받은 쪽지가 없습니다.'; break;
			case 'sendLetterList' : word.innerHTML = '보낸 쪽지가 없습니다.'; break;
		}
	}
}