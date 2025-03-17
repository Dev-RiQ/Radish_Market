let fileName = null;
function openPop() {

	const popupWindow = window.open('', '', 'width=400,height=400');
	const popupDocument = popupWindow.document;
	setPopupWrite(popupDocument)

	const imageUploadInput = popupDocument.getElementById('image-upload');
	const imagePreview = popupDocument.getElementById('image-preview');
	const inData = new FormData();
	
	imageUploadInput.addEventListener('change', () => {
		const selectedImage = imageUploadInput.files[0];
		if (selectedImage) {
			inData.append('img', selectedImage);
			const reader = new FileReader();
			reader.onload = (e) => {
				imagePreview.src = e.target.result;
			};
			reader.readAsDataURL(selectedImage);
		}
	});
	popupDocument.getElementById('save-post').addEventListener('click', () => {
		const savedImage = imagePreview.src;
		if (savedImage) {
			fetchFileUpload(inData)
			saveImgInLocalStorage(savedImage)
			displayImage();
			popupWindow.close();
		}
	});
}

function setPopupWrite(popupDocument){
	popupDocument.write('<h2>이미지 업로드</h2>');
	popupDocument.write('<img id="image-preview" style="max-width: 100%; max-height: 200px;"><br>');
	popupDocument.write('<input type="file" id="image-upload" accept="image/*"><br>');
	popupDocument.write('<button id="save-post">저장</button>');
}

function fetchFileUpload(inData){
	if(fileName != null){
		fetch('/fileUploadAjax.do',{
			method: "post",
			headers:{"Content-type" : "application/x-www-form-urlencoded; charset=UFT-8"},
			body: "beforeFileName="+fileName
		}).then(response => response.text())
		.catch(error => console.log(error))
	}				
	fetch('/fileUploadAjax.do',{
		method: "post",
		headers:{},
		body: inData
	}).then(response => response.text())
	.then(showImageName)
	.catch(error => console.log(error))
}

function saveImgInLocalStorage(savedImage){
	const postKey = `post-${Date.now()}`;
	const post = { image: savedImage };
	localStorage.clear();
	localStorage.setItem(postKey, JSON.stringify(post));
}

function displayImage() {
    const postList = document.getElementById('post-list');
    postList.innerHTML = '';

    const key = localStorage.key(0);
    if (key.startsWith('post-')) {
        const post = JSON.parse(localStorage.getItem(key));
        const image = post.image;
        const imageElement = document.createElement('img');
        imageElement.src = image;
        imageElement.alt = '이미지';
        postList.appendChild(imageElement);
    }
}

function showImageName(sFileName){
	const user_img = document.querySelector("#user_img")
	fileName = sFileName.substring(1,sFileName.length - 1);
	user_img.value = fileName;
}