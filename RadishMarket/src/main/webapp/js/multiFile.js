let swiper;
document.addEventListener("DOMContentLoaded", function() {
	if (typeof Swiper !== "undefined") {
		swiper = new Swiper(".mySwiper", {
			slidesPerView: 4,
			slidesPerGroup: 4,
			spaceBetween: 20,
			navigation: {
				nextEl: ".swiper-button-next",
				prevEl: ".swiper-button-prev",
			},
			pagination: {
				el: ".swiper-pagination",
				clickable: true,
			},
		});
	}
});

// file
let imgArr = [];
let saveList = [];
let inData = new FormData();
let checkImgUpload = false;
const imageUploadInput = document.getElementById('ofile');

imageUploadInput.addEventListener('change', () => {
	imgArr = [];
	saveList = [];
	const files = Array.from(imageUploadInput.files);

	if ((saveList.length + files.length) > 8) {
		alert('물품 사진은 최대 8장까지 등록할 수 있습니다.');
		imageUploadInput.value = '';
		return;
	}

	files.forEach((file) => {
		saveList.push(file);
		const reader = new FileReader();
		reader.onload = (e) => {
			const post = { image: e.target.result };
			imgArr.push(JSON.stringify(post));
			inData = new FormData();
			saveList.forEach(file => {
				inData.append('img', file);
			});
			displayImage();
		};
		reader.readAsDataURL(file);
	});
});

function deleteImage(idx) {
	imgArr.splice(idx, 1);
	saveList.splice(idx, 1);

	const dataTransfer = new DataTransfer();
	saveList.forEach(file => {
		dataTransfer.items.add(file);
	});
	imageUploadInput.files = dataTransfer.files;

	inData = new FormData();
	saveList.forEach(file => {
		inData.append('img', file);
	});

	displayImage();
}

function displayImage() {
	const sliderWrapper = document.querySelector('.swiper-wrapper');
	if (!sliderWrapper) {
		return;
	}
	sliderWrapper.innerHTML = '';

	imgArr.forEach((img, idx) => {
		const post = JSON.parse(img);
		const image = post.image;
		const slide = document.createElement('div');
		slide.classList.add('swiper-slide');
		const imageElement = document.createElement('img');
		imageElement.src = image;
		imageElement.alt = '이미지';

		const deleteBtn = document.createElement('button');
		deleteBtn.textContent = '삭제';
		deleteBtn.classList.add('delete-btn');

		deleteBtn.addEventListener('click', () => {
			deleteImage(idx);
		});

		slide.appendChild(imageElement);
		slide.appendChild(deleteBtn);
		sliderWrapper.appendChild(slide);
	});

	if (swiper) {
		swiper.update();
	}
}

function saveImg() {
	if (saveList.length > 0) {
		inData = new FormData();
		saveList.forEach(file => {
			inData.append('img', file);
		});

		return fetch('/fileUploadAjax.do', {
			method: "post",
			body: inData
		})
			.then(response => {
				if (!response.ok) {
					throw new Error('파일 업로드 실패: ' + response.statusText);
				}
				checkImgUpload = true;
				return response.text();
			})
			.then((sFileName) => {
				showImageName(sFileName);
				return sFileName;
			})
			.catch(error => {
				console.error("파일 업로드 오류:", error);
				alert("이미지 업로드 중 문제가 발생했습니다.");
				throw error;
			});
	} else {
		return Promise.resolve('');
	}
}

function showImageName(sFileName) {
	const user_item_img = document.querySelector("#user_item_img");
	let fileName = sFileName.substring(1, sFileName.length - 1);
	user_item_img.value = fileName;
}


const itemImages = document.querySelectorAll('.loadImage');
if (itemImages.length > 0) {
	const item_no = document.querySelector('.item_no').value;
	itemImages.forEach((e) => {
		const formData = new FormData();
		formData.append("item_no", item_no);
		formData.append("files", new File([e.value], e.value)); 

		fetch('/multiFileUploadAjax.do', {
			method: 'POST',
			body: formData
		})
		.then(response => response.json())
	});
}
