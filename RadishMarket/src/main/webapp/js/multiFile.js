const imageUploadInput = document.getElementById('ofile');
let postKey = null;
let imgArr = [];
let inData = new FormData();

imageUploadInput.addEventListener('change', () => {
	start = new Date().getTime();
	inData = new FormData();
	let idx = 0;
	if (imageUploadInput.files.length > 8) {
		alert('파일은 8개까지임 ㅇㅇ');
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
				end = new Date().getTime();
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
			headers: {},
			body: inData
		}).then(response => response.text())
			.then(showImageName)
			.catch(error => console.log(error))

		displayImage();
	}
}

function displayImage() {
	const postList = document.getElementById('post-list');
	postList.innerHTML = '';
	imgArr.forEach((img) => {
		const post = JSON.parse(img);
		const image = post.image;
		const imageElement = document.createElement('img');
		imageElement.src = image;
		imageElement.alt = '이미지';
		postList.appendChild(imageElement);
	})
}

function showImageName(sFileName) {
	const user_itme_img = document.querySelector("#user_itme_img")
	let fileName = sFileName.substring(1, sFileName.length - 1);
	user_itme_img.value = fileName;
}