const searchBox = document.querySelector('#search_value');
if (searchBox)
	searchBox.addEventListener('keypress', () => {
		if (event.key == 'Enter') {
			searchInItemList();
		}
	})

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
window.addEventListener('scroll',function() {
	if (
		document.documentElement.scrollTop > 50
	) {
		if (headerBtn && headerBtn.style.opacity == 0){
			headerBtn.style.display = 'block'; // 스크롤 시 Top 버튼 보이기
			setTimeout(()=>{
				headerBtn.style.opacity = 1; // 스크롤 시 Top 버튼 보이기
			},100)
			setTimeout(()=>{
				headerBtn.style.display = 'block'; // 스크롤 시 Top 버튼 보이기
			},300)
		}
	} else {
		if (headerBtn && headerBtn.style.opacity == 1){
			headerBtn.style.opacity = 0; // 최상단에 있을 때 숨기기
			setTimeout(()=>{
				headerBtn.style.display = 'none'; // 최상단에 있을 때 숨기기
			},300)
			setTimeout(()=>{
				headerBtn.style.opacity = 0; // 스크롤 시 Top 버튼 보이기
			},100)
		}
	}
});

// Top 버튼 클릭 시 맨 위로 이동
function topFunction() {
	window.scrollTo({top: 0, behavior: 'smooth'});
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
	flow_word.innerHTML = words[idx++];
	setInterval(() => {
		flow_word.classList.add('trans');
		setTimeout(() => {
			flow_word.classList.remove('trans');
			flow_word.innerHTML = words[idx++];
		}, 300)
		idx = idx % words.length;
	}, 2500);
}
if (flow_word) {
	runFlowWord();
}

const progress = document.querySelectorAll("progress");
if (progress)
	progress.forEach((i) => {
		i.classList.add('basic-progress')
		if (parseInt(i.value) <= 20) {
			i.classList.add('basic-progress1')
		} else if (parseInt(i.value) <= 35) {
			i.classList.add('basic-progress2')
		} else if (parseInt(i.value) <= 48) {
			i.classList.add('basic-progress3')
		} else if (parseInt(i.value) <= 63) {
			i.classList.add('basic-progress4')
		} else if (parseInt(i.value) <= 80) {
			i.classList.add('basic-progress5')
		} else if (parseInt(i.value) <= 100) {
			i.classList.add('basic-progress6')
		}
	})

const user_profile_deg = document.querySelectorAll('span.user-profile-deg');
if (user_profile_deg) {
	user_profile_deg.forEach((i)=>{
		if (parseInt(i.innerHTML) <= 20) {
			i.classList.add('deg-color1')
		} else if (parseInt(i.innerHTML) <= 35) {
			i.classList.add('deg-color2')
		} else if (parseInt(i.innerHTML) <= 48) {
			i.classList.add('deg-color3')
		} else if (parseInt(i.innerHTML) <= 63) {
			i.classList.add('deg-color4')
		} else if (parseInt(i.innerHTML) <= 80) {
			i.classList.add('deg-color5')
		} else if (parseInt(i.innerHTML) <= 100) {
			i.classList.add('deg-color6')
		}
	})
}

setTimeout(() => {
	const item_status = document.querySelectorAll("span.item-status");
	if (item_status)
		item_status.forEach((e) => {
			if (e.innerHTML === '예약중') {
				e.style.color = '#4CAF50';
			} else if (e.innerHTML === '판매완료') {
				e.style.color = '#EF6C00';
			}
		})
}, 100);

setTimeout(() => {
	const item_price = document.querySelectorAll(".item-price");
	if (item_price)
		item_price.forEach((e) => {
			const text = e.innerText.trim();
			if (text === '0원' || text === '0' || text === 0) {
				e.innerHTML = '나눔'
			}
		})
}, 100);
