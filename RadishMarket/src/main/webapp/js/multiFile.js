let swiper;

document.addEventListener("DOMContentLoaded", function() {
	if (typeof Swiper !== "undefined") {
		var swiper = new Swiper(".mySwiper", {
			loop: true,
			//slidesPerView: "auto",
			slidesPerView: 1,
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
	} else {
		console.error("Swiper 라이브러리가 정상적으로 로드되지 않았습니다.");
	}
});

const imageUploadInput = document.getElementById('ofile');
let postKey = null;
let imgArr = [];
let inData = new FormData();

imageUploadInput.addEventListener('change', () => {
	imgArr = [];
	inData = new FormData();
	document.getElementById('post-list').innerHTML = '';

	let idx = 0;
	if (imageUploadInput.files.length > 8) {
		alert('최대 8개까지의 판매 물품 사진을 등록할 수 있습니다.');
		imageUploadInput.value = '';
		return;
	}

	while (true) {
		const selectedImage = imageUploadInput.files[idx];
		if (!selectedImage) {
			break;
		}
		inData.append('img', selectedImage);
		console.log(selectedImage);
		if (selectedImage) {
			const reader = new FileReader();

			reader.onload = (e) => {
				postKey = `post-${new Date().getTime()}`;
				const post = { image: e.target.result };
				imgArr.push(JSON.stringify(post));
				displayImage();
			};

			reader.readAsDataURL(selectedImage);
		}
		idx++;
	}

	setTimeout(() => {
		saveImg();
	}, 10 * idx)
})

function saveImg() {
	if (imgArr.length > 0) {
		fetch('/fileUploadAjax.do', {
			method: "post",
			//headers: {},
			body: inData
		})
			.then(response => response.text())
			.then((sFileName) => {
				showImageName(sFileName);
				displayImage();
			})
			.catch(error => console.log(error))
	}
}

function displayImage() {
	const sliderWrapper = document.querySelector('.swiper-wrapper');
	sliderWrapper.innerHTML = '';
	imgArr.forEach((img) => {
		const post = JSON.parse(img);
		const image = post.image;
		const slide = document.createElement('div');
		slide.classList.add('swiper-slide');
		const imageElement = document.createElement('img');
		imageElement.src = image;
		imageElement.alt = '이미지';
		slide.appendChild(imageElement);
		sliderWrapper.appendChild(slide);
	})
	if (typeof swiper !== "undefined") {
		swiper.update();
	}
}

function showImageName(sFileName) {
	const user_itme_img = document.querySelector("#user_itme_img")
	let fileName = sFileName.substring(1, sFileName.length - 1);
	user_itme_img.value = fileName;
}

