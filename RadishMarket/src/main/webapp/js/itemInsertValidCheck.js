const title = document.querySelector("#item_name");
const titleCheck = document.querySelector("#title_check");

const content = document.querySelector("#item_content");
const contentCheck = document.querySelector("#content_check");

const price = document.querySelector("#item_price");
const priceCheck = document.querySelector("#price_check");
const maxPrice = 2100000000;

const sellBtn = document.querySelector('#sell-btn');
const freeBtn = document.querySelector('#free-btn');
const categorySelect = document.querySelector("#item_category_no");
const form = document.querySelector("form");

let checkSellItem = true;

document.addEventListener("DOMContentLoaded", () => {
	if (Number(price.value) === 0) {
		freeBtn.click();
	}

	sellBtn.addEventListener("click", () => {
		checkSellItem = true;
		price.disabled = false;
		price.style.border = "1px solid black";
		price.style.backgroundColor = "white";
		price.value = '';
		priceCheck.innerText = '';
		sellBtn.classList.add("selected");
		freeBtn.classList.remove("selected");
		document.querySelector("#is_free").value = "false";
	});

	freeBtn.addEventListener("click", () => {
		checkSellItem = false;
		price.value = 0;
		price.disabled = true;
		price.style.border = "1px solid green";
		price.style.backgroundColor = "#f0f0f0";
		priceCheck.innerText = '나눔하기';
		freeBtn.classList.add("selected");
		sellBtn.classList.remove("selected");
		document.querySelector("#is_free").value = "true";
	});

	price.addEventListener('input', () => {
		if (checkSellItem) {
			let value = price.value.replace(/[^0-9]/g, '');
			if (Number(value) > maxPrice) {
				value = maxPrice.toString();
			}
			price.value = value;

			if (Number(price.value) === 0) {
				freeBtn.click();
			}
		}
	});

	sellBtn.classList.add("selected");
});

form.addEventListener("submit", (e) => {
	e.preventDefault();
	validCheck();
});

function validCheck() {
	if (!title.value.trim()) {
		titleCheck.innerText = '값을 입력해주세요.';
		title.style.border = "2px solid crimson";
	} else if (title.value.trim().length < 2) {
		titleCheck.innerText = '제목은 최소 2자 이상이어야 합니다.';
		title.style.border = "2px solid crimson";
	} else if (title.value.trim().length > 50) {
		titleCheck.innerText = '제목은 최대 50자까지 작성 가능합니다.';
		title.style.border = "2px solid crimson";
	} else {
		titleCheck.innerText = '';
		title.style.border = "1px solid black";
	}

	title.addEventListener('keyup', () => {
		if (titleCheck.innerText && title.value.trim()) {
			titleCheck.innerText = '';
			title.style.border = "1px solid black";
		}
	});

	if (!content.value.trim()) {
		contentCheck.innerText = '값을 입력해주세요.';
		title.style.border = "2px solid crimson";
	} else if (content.value.trim().length < 2) {
		contentCheck.innerText = '물품 설명은 최소 2자 이상이어야 합니다.';
		title.style.border = "2px solid crimson";
	} else if (content.value.trim().length > 1000) {
		contentCheck.innerText = '물품 설명은 최대 1000자까지 작성 가능합니다.';
		title.style.border = "2px solid crimson";
	} else {
		contentCheck.innerText = '';
		title.style.border = "1px solid black";
	}

	content.addEventListener('keyup', () => {
		if (contentCheck.innerText && content.value.trim()) {
			contentCheck.innerText = '';
			content.style.border = "1px solid black";
		}
	});

	if (checkSellItem) {
		if (!price.value.trim()) {
			priceCheck.innerText = '값을 입력해주세요.';
			price.style.border = "2px solid crimson";
		} else if (isNaN(price.value) || Number(price.value) < 1) {
			priceCheck.innerText = '유효한 금액을 입력해 주세요.';
			price.style.border = "2px solid crimson";
		} else if (Number(price.value) > maxPrice) {
			priceCheck.innerText = '너무 많은 금액을 입력했습니다.';
			price.style.border = "2px solid crimson";
		} else {
			priceCheck.innerText = '';
			price.style.border = "1px solid black";
		}
	} else {
		if (Number(price.value) !== 0) {
			priceCheck.innerText = '나눔하기가 선택된 경우 가격은 0이어야 합니다.';
			price.style.border = "2px solid crimson";
		} else {
			priceCheck.innerText = '나눔하기';
			price.style.border = "1px solid green";
		}
	}

	price.addEventListener('keyup', () => {
		if (checkSellItem && priceCheck.innerText && price.value.trim()) {
			priceCheck.innerText = '';
			price.style.border = "1px solid black";
		}
	});

	if (typeof imgArr === 'undefined' || !Array.isArray(imgArr)) {
		alert("이미지 데이터를 불러오지 못했습니다. 다시 시도해주세요.");
		return;
	}
	if (imgArr.length === 0) {
		alert("사진을 한 장 이상 등록해주세요.");
		document.querySelector("#ofile").focus();
		return;
	}

	const spans = document.querySelectorAll("span");
	for (let i = 0; i < spans.length; i++) {
		if (spans[i].id && spans[i].innerText && spans[i].innerText !== '나눔하기') {
			let type = spans[i].id.split("_")[0];
			const input = document.querySelector(`#item_${type}`);
			if (input) {
				input.focus();
			}
			return;
		}
	}

	saveImg()
		.then(() => {
			console.log("이미지 업로드 완료, 폼 제출");
			form.submit();
		})
		.catch(error => {
			console.error("폼 제출 중 오류:", error);
		});
}

title.addEventListener('input', () => {
	if (title.value && title.value.length > 50) {
		title.value = title.value.substring(0, 50);
	}
});

content.addEventListener('input', () => {
	if (content.value && content.value.length > 1000) {
		content.value = content.value.substring(0, 1000);
	}
});