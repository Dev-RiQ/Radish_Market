let swiper;
document.addEventListener("DOMContentLoaded", () => {
	if (typeof Swiper !== "undefined") {
		swiper = new Swiper(".mySwiper", {
			slidesPerView: 'auto',
			spaceBetween: 16,
			freeMode: true,
			grabCursor: true,
		});
	}

	const delBtns = document.querySelectorAll('.load-delete-btn');
	const loadImgs = document.querySelectorAll('.loadImage');
	delBtns.forEach((btn, idx) => {
		btn.addEventListener('click', () => {
			deleteArr.push(loadImgs[idx].value);
			btn.closest('.swiper-slide').remove();
			updateHiddenInput();
			if (swiper) swiper.update();
		});
	});
});

let saveList = [];
let deleteArr = [];
const imageUploadInput = document.getElementById('ofile');

imageUploadInput.addEventListener('change', () => {
	const files = Array.from(imageUploadInput.files);

	const maxFileSize = 5 * 1024 * 1024;
	const maxTotalSize = 40 * 1024 * 1024;

	for (let file of files) {
		if (file.size > maxFileSize) {
			alert(`사진 파일은 5MB 이하의 파일만 등록할 수 있습니다.`);
			imageUploadInput.value = '';
			return;
		}
	}

	let currentTotalSize = saveList.reduce((acc, f) => acc + f.size, 0);
	let filesTotalSize = files.reduce((acc, f) => acc + f.size, 0);

	if (currentTotalSize + filesTotalSize > maxTotalSize) {
		alert("전체 업로드 용량은 40MB를 초과할 수 없습니다.");
		imageUploadInput.value = '';
		return;
	}

	const existingImgs = document.querySelectorAll('.swiper-slide img').length;
	const totalCount = existingImgs + files.length;

	if (totalCount > 8) {
		alert('물품 사진은 최대 8장까지 등록할 수 있습니다.');
		imageUploadInput.value = '';
		return;
	}

	files.forEach(file => {
		saveList.push(file);
		const reader = new FileReader();
		reader.onload = (e) => {
			appendNewSlide(e.target.result);
		};
		reader.readAsDataURL(file);
	});
});

function appendNewSlide(image) {
	const wrapper = document.querySelector('.swiper-wrapper');
	const slide = document.createElement('div');
	slide.classList.add('swiper-slide');

	const img = document.createElement('img');
	img.src = image;
	img.alt = "업로드 이미지";

	const delBtn = document.createElement('button');
	delBtn.textContent = 'X';
	delBtn.classList.add('delete-btn');
	delBtn.addEventListener('click', () => {
		const index = Array.from(wrapper.children).indexOf(slide);
		deleteImage(index);
	});

	slide.appendChild(img);
	slide.appendChild(delBtn);
	wrapper.appendChild(slide);

	if (swiper) swiper.update();
}

function deleteImage(idx) {
	saveList.splice(idx, 1);
	const wrapper = document.querySelector('.swiper-wrapper');
	wrapper.children[idx]?.remove();

	const dataTransfer = new DataTransfer();
	saveList.forEach(file => dataTransfer.items.add(file));
	imageUploadInput.files = dataTransfer.files;

	updateHiddenInput();
	if (swiper) swiper.update();
}

function updateHiddenInput() {
	const user_item_img = document.querySelector("#user_item_img");
	const loadImgs = document.querySelectorAll('.loadImage');
	const filenames = Array.from(loadImgs).map(input => input.value);
	user_item_img.value = filenames.join(',');
}

async function saveImg() {
	if (saveList.length > 0) {
		const inData = new FormData();
		saveList.forEach(file => inData.append('img', file));

		const response = await fetch('/multiFileUploadAjax.do', {
			method: 'POST',
			body: inData
		});

		if (!response.ok) throw new Error("업로드 실패");

		const uploadedFileNames = await response.json();
		const loadImgs = document.querySelectorAll('.loadImage');
		const existingNames = Array.from(loadImgs).map(input => input.value);
		const allFileNames = [...existingNames, ...uploadedFileNames];
		document.getElementById('user_item_img').value = allFileNames.join(',');
	}
}

if (document.getElementById('itemUpdateForm')) {
	document.getElementById('itemUpdateForm').addEventListener('submit', async function(e) {
		e.preventDefault();
		try {
			await saveImg();
			document.getElementById('deleteArr').value = deleteArr.join(',');
			this.submit();
		} catch (err) {
			alert('이미지 업로드 중 오류 발생');
			console.error(err);
		}
	});
}