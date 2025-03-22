const title = document.querySelector("#item_name")
const titleCheck = document.querySelector("#title_check")

const content = document.querySelector("#item_content")
const contentCheck = document.querySelector("#content_check")

const price = document.querySelector("#item_price")
const priceCheck = document.querySelector("#price_check")
const maxPrice = 2100000000;

let checkSellItem = true;
const sellBtn = document.querySelector('#sell-btn');
const freeBtn = document.querySelector('#free-btn');

document.addEventListener("DOMContentLoaded", () => {
	if(price.value === 0){
		freeBtn.click();
	}
	
	sellBtn.addEventListener("click", () => {
		checkSellItem = true;
		price.disabled = false;
		price.style.border = "1px solid black";
		price.value = '';
		priceCheck.innerText = '';
		sellBtn.classList.add("selected");
		freeBtn.classList.remove("selected");
	});

	freeBtn.addEventListener("click", () => {
		checkSellItem = false;
		price.value = 0;
		price.disabled = true;
		price.style.border = "1px solid green";
		priceCheck.innerText = '';
		freeBtn.classList.add("selected");
		sellBtn.classList.remove("selected");
	});

	sellBtn.classList.add("selected");
});

function validCheck() {
	// 제목
	if (!title.value.trim()) {
		titleCheck.innerText = '값을 입력해주세요.'
		title.style.border = "2px solid crimson"
	} else if (title.value.trim().length < 2) {
		titleCheck.innerText = '제목은 최소 2자 이상이어야 합니다.'
		title.style.border = "2px solid crimson"
	} else if (title.value.trim().length > 50) {
		titleCheck.innerText = '제목은 최대 50자까지 작성 가능합니다.'
		title.style.border = "2px solid crimson"
	}
	title.addEventListener('keyup', () => {
		if (titleCheck.innerText && title.value.trim()) {
			titleCheck.innerText = '';
			title.style.border = "1px solid black"
		}
	})

	// 물품 설명
	if (!content.value.trim()) {
		contentCheck.innerText = '값을 입력해주세요.'
		content.style.border = "2px solid crimson"
	} else if (content.value.trim().length < 2) {
		contentCheck.innerText = '물품 설명은 최소 2자 이상이어야 합니다.'
		content.style.border = "2px solid crimson"
	} else if (content.value.trim().length > 1000) {
		contentCheck.innerText = '물품 설명은 최대 1000자까지 작성 가능합니다.'
		content.style.border = "2px solid crimson"
	}
	content.addEventListener('keyup', () => {
		if (contentCheck.innerText && content.value.trim()) {
			contentCheck.innerText = '';
			content.style.border = "1px solid black"
		}
	})

	// 가격
	if (checkSellItem) {
		if (!price.value.trim()) {
			priceCheck.innerText = '값을 입력해주세요.'
			price.style.border = "2px solid crimson"
		} else if (isNaN(price.value) || Number(price.value) < 1) {
			priceCheck.innerText = '유효한 금액을 입력해 주세요.'
			price.style.border = "2px solid crimson"
		} else if (Number(price.value) > maxPrice) {
			priceCheck.innerText = '너무 많은 금액을 입력했습니다.'
			price.style.border = "2px solid crimson"
		}
	} else {
		if (!Number(price.value) === 0) {
			priceCheck.innerText = '나눔하기의 금액은 0원입니다.'
			price.style.border = "2px solid crimson"
		}
	}

	// 물품 사진
	const imageFile = document.querySelector("#ofile");
	if (imageFile.files.length === 0) {
		alert("사진을 한 장 이상 등록해주세요.");
		imageFile.focus();
		return;
	}

	const spans = document.querySelectorAll("span");
	for (let i = 0; i < spans.length; i++) {
		if (spans[i].id && spans[i].innerText) {
			let type = spans[i].id.split("_")[0];
			const input = document.querySelector(`#item_${type}`);
			if (input) {
				input.focus();
			}
			return;
		}
	}
	document.querySelector("form").submit()
}

title.addEventListener('input', () => {
	if (title.value && title.value.length > 50) {
		title.value = title.value.substring(0, 50);
	}
})

content.addEventListener('input', () => {
	if (content.value && content.value.length > 1000) {
		content.value = content.value.substring(0, 1000);
	}
})

price.addEventListener('input', () => {
	let value = price.value.replace(/[^0-9]/g, '');
	if (Number(value) > maxPrice) {
		value = maxPrice.toString();
	} else if (checkSellItem || Number(value) === 0) {
		checkSellItem = false;
		freeBtn.classList.add("selected");
		sellBtn.classList.remove("selected");
		freeBtn.click();
	}

	price.value = value;
});