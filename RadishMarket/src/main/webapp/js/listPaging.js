/*
	  더보기 버튼 양식
		<div id="list-box">
	<!-- 여기 리스트 출력 -->
	</div>
		<button id="btn-more-list" value="board/0" onclick="getMoreList()">더보기</button>
	<script src="../../js/listPaging.js"></script>
	   
	   (예시)
	   <button id="btn-more-list" value="board/0" onclick="getMoreList()">더보기</button>
  
	 리스트 종류
	 "item"  
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
 */

let isLoaded = false;
let isClicked = false;
let btnMoreList = document.querySelector("#btn-more-list")
let type = null;
if (btnMoreList) {
	getMoreList();
	setTimeout(() => {
		isLoaded = true;
	}, 50)
}

function getMoreList() {
	if (isLoaded && event) {
		btnMoreList = event.currentTarget;
	}
	if (!btnMoreList || !btnMoreList.value || (document.querySelector('.chang') && document.querySelector('.chang').classList.length == 1)) {
		btnMoreList = document.querySelector("#show-alarm-div");
	}

	const typeAndStart = btnMoreList.value.split("/");
	type = typeAndStart[0];
	let start = typeAndStart[1];

	if (type != 'alarm') {
		if (isClicked) return;
		isClicked = true;
		btnMoreList.innerHTML = '<img alt="로딩중" src="/images/loading.gif" style="width:50px; height: 50px; object-fit:cover;"/>';
	}

	btnMoreList.value = `${type}/${parseInt(start) + 30}`;
	let queryString = `start=${start}&type=${type}`;

	if (
		type == 'item' || type == 'board' || type == 'meetBoard' || type == 'meet' ||
		type == 'myItem' || type == 'adminUser' || type == 'adminBoard' ||
		type == 'adminItem' || type == 'adminMeet'
	) {
		queryString += getFilter();
	}

	const target_user_no = document.querySelector('#target_user_no');
	const user_no = target_user_no ? target_user_no.value : 0;
	queryString += `&user_no=${user_no}`;

	fetch("/listPagingAjax.do", {
		method: "POST",
		headers: { "Content-type": "application/x-www-form-urlencoded; charset=UTF-8" },
		body: queryString
	})
		.then(response => response.text())
		.then(printList)
		.catch(error => console.log(error));
}
function getFilter() {
	let queryString = '';

	let itemStatus = document.querySelector('input[id="item_status"]:checked');
	if (!itemStatus) itemStatus = document.querySelector('#item_status');
	queryString += `&item_status=${itemStatus ? itemStatus.value || 0 : 0}`;

	let categoryNo = document.querySelector('input[id="category_no"]:checked');
	if (!categoryNo) categoryNo = document.querySelector('#category_no');
	queryString += `&category_no=${categoryNo ? categoryNo.value || 0 : 0}`;

	let priceMin = document.querySelector('input[id="price_min"]:checked');
	if (!priceMin) priceMin = document.querySelector('#price_min');
	queryString += `&price_min=${priceMin ? priceMin.value || 0 : 0}`;

	let priceMax = document.querySelector('input[id="price_max"]:checked');
	if (!priceMax) priceMax = document.querySelector('#price_max');
	queryString += `&price_max=${priceMax ? priceMax.value || 0 : 0}`;

	let gu = document.querySelector('input[id="gu"]:checked');
	if (!gu) gu = document.querySelector('#gu');
	queryString += `&gu=${gu ? gu.value || "강남구" : "강남구"}`;

	let dong = document.querySelector('input[id="dong"]:checked');
	if (!dong) dong = document.querySelector('#dong');
	queryString += `&dong=${dong ? dong.value || "전체" : "전체"}`;

	let orderBy = document.querySelector('input[id="order_by"]:checked');
	if (!orderBy) orderBy = document.querySelector('#order_by');
	queryString += `&order_by=${orderBy ? orderBy.value || 0 : 0}`;

	let meetNo = document.querySelector('input[id="meet_no"]:checked');
	if (!meetNo) meetNo = document.querySelector('#meet_no');
	queryString += `&meet_no=${meetNo ? meetNo.value || 0 : 0}`;

	let searchValue = document.querySelector('#search_value');
	queryString += `&search_value=${searchValue ? searchValue.value : ''}`;

	return queryString;
}

function printList(data) {
	if (data == 'noMoreList') {
		if (type == 'alarm') return;
		btnMoreList.classList.add('hide');
		if (btnMoreList.value.split("/")[1] == '30') {
			printNoData();
		}else{
			printDataEnd();
		}
		return;
	}
	let listBox = document.querySelector("#list-box");
	if (type == 'alarm') listBox = document.querySelector("#alarm-list-box")
	listBox.innerHTML += data;
	if (type != 'alarm') {
		btnMoreList.innerHTML = '<i class="fa-solid fa-chevron-down"></i>'
		isClicked = false;
	}
	load_item_status_color();
}

function printNoData() {
	let word = document.querySelector('.empty-info')
	if (word) {
		switch (word.id) {
			case 'sellList': word.innerHTML = '판매중인 물품이 없습니다.'; break;
			case 'zzimList': word.innerHTML = '찜한 물품이 없습니다.'; break;
			case 'reviewList': word.innerHTML = '후기가 없습니다.'; break;
			case 'buyList': word.innerHTML = '구매한 물품이 없습니다.'; break;
			case 'reserveList': word.innerHTML = '예약중인 물품이 없습니다.'; break;
			case 'soldList': word.innerHTML = '거래 완료된 물품이 없습니다.'; break;
			case 'boardList': word.innerHTML = '게시글이 없습니다.'; break;
			case 'hostMeetList': word.innerHTML = '회원님이 호스트인 모임이 없습니다.'; break;
			case 'meetList': word.innerHTML = '불러올 모임이 없습니다.'; break;
			case 'receiveLetterList': word.innerHTML = '받은 쪽지가 없습니다.'; break;
			case 'sendLetterList': word.innerHTML = '보낸 쪽지가 없습니다.'; break;
			case 'itemList': word.innerHTML = '등록된 상품이 없습니다.'; break;
		}
	}
}
function printDataEnd() {
	let word = document.querySelector('.empty-info')
	if (word) {
		switch (word.id) {
			case 'sellList': word.innerHTML = '더 이상 불러올 물품이 없습니다.'; break;
			case 'zzimList': word.innerHTML = '더 이상 불러올 찜한 물품이 없습니다.'; break;
			case 'reviewList': word.innerHTML = '더 이상 불러올 후기가 없습니다.'; break;
			case 'buyList': word.innerHTML = '더 이상 불러올 구매한 물품이 없습니다.'; break;
			case 'reserveList': word.innerHTML = '더 이상 불러올 예약중인 물품이 없습니다.'; break;
			case 'soldList': word.innerHTML = '더 이상 불러올 거래 완료된 물품이 없습니다.'; break;
			case 'boardList': word.innerHTML = '더 이상 불러올 게시글이 없습니다.'; break;
			case 'hostMeetList': word.innerHTML = '더 이상 불러올 회원님이 호스트인 모임이 없습니다.'; break;
			case 'meetList': word.innerHTML = '더 이상 불러올 모임이 없습니다.'; break;
			case 'receiveLetterList': word.innerHTML = '더 이상 불러올 받은 쪽지가 없습니다.'; break;
			case 'sendLetterList': word.innerHTML = '더 이상 불러올 보낸 쪽지가 없습니다.'; break;
			case 'itemList': word.innerHTML = '더 이상 불러올 등록된 상품이 없습니다.'; break;
		}
	}
}

function load_item_status_color() {
	const item_status = document.querySelectorAll("span.item-status");
	if (item_status)
		item_status.forEach((e) => {
			if (e.innerHTML === '예약중') {
				e.style.color = '#4CAF50';
			} else if (e.innerHTML === '판매완료') {
				e.style.color = '#EF6C00';
			}
		})
}