function searchInItemList() {
	const searchValue = document.querySelector("#search_value").value;
	if (!searchValue) {
		alert('검색어를 입력해주세요.')
		return;
	}
	location.href = `listItem.do?search_value=${searchValue}`
}
let headerBtn = document.getElementById('headerBtn');

// 스크롤 이벤트 리스너 추가
window.onscroll = function () {
	if (
		document.body.scrollTop > 20 ||
		document.documentElement.scrollTop > 20
	) {
		if (headerBtn)
			headerBtn.style.display = 'block'; // 스크롤 시 Top 버튼 보이기
	} else {
		if (headerBtn)
			headerBtn.style.display = 'block'; // 최상단에 있을 때 숨기기
	}
};

// Top 버튼 클릭 시 맨 위로 이동
function topFunction() {
	document.body.scrollTop = 0;
	document.documentElement.scrollTop = 0;
}

const chang = document.querySelector(".chang");
let isOpenChang = false;

function showMyInfo() {
	if (isOpenChang) {
		chang.classList.add('hide')
		isOpenChang = false;
	} else {
		chang.classList.remove('hide')
		isOpenChang = true;
	}
}
document.addEventListener('click', (e) => {
	if (isOpenChang && !chang.contains(e.target) && !document.querySelector('#show-chang').contains(e.target)) {
		chang.classList.add('hide')
		isOpenChang = false;
	}
})

const flow_word = document.querySelector('.flow-word');
function runFlowWord() {
	const words = ['아이폰', '동네친구', '러닝 모임', '카페', '맛집', '티켓', '독서 모임'];
	let idx = 0;
	setInterval(() => {
		flow_word.innerHTML = words[idx++];
		idx = (idx + 1) % words.length;
	}, 2500);
}
if(flow_word){
	runFlowWord();
}