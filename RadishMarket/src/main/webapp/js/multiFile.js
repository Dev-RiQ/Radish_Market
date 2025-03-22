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
	} else {
		console.error("Swiper 라이브러리가 정상적으로 로드되지 않았습니다.");
	}
});

const imageUploadInput = document.getElementById('ofile');
let postKey = null;
let imgArr = [];
let saveList = [];
let inData = new FormData();

document.addEventListener("DOMContentLoaded", () => {
    const loadImage = document.querySelectorAll('input#loadImage');
    loadImage.forEach(image => {
        const fileName = image.value;
        const imagePath = `/images/${fileName}`;
        fetch(imagePath)
            .then(response => {
                if (!response.ok) {
                    throw new Error('이미지 로드 실패: ' + response.statusText);
                }
                return response.blob();
            })
            .then(blob => {
                const file = new File([blob], fileName, { type: blob.type });
                saveList.push(file);
                inData.append('img', file);
                const post = { image: imagePath, existing: true, fileName };
                imgArr.push(JSON.stringify(post));
                displayImage();
            })
            .catch(error => {
                console.error("기존 이미지 로드 중 오류:", error);
            });
    });
});

function saveImg() {
	if (saveList.length > 0) {
		inData = new FormData();
		saveList.forEach(file => {
			inData.append('img', file);
		});

		fetch('/fileUploadAjax.do', {
			method: "post",
			body: inData
		})
			.then(response => response.text())
			.then((sFileName) => {
				showImageName(sFileName);
				document.querySelector("form").submit();
			})
			.catch(error => {
				console.error(error);
				alert("이미지 업로드 중 문제가 발생했습니다.");
			});
	} else {
		document.querySelector("form").submit();
	}
}

imageUploadInput.addEventListener('change', () => {
    const files = Array.from(imageUploadInput.files);

    if ((saveList.length + files.length) > 8) {
        alert('최대 8장까지 등록할 수 있습니다.');
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


function displayImage() {
    const sliderWrapper = document.querySelector('.swiper-wrapper');
    if (!sliderWrapper) {
        console.error("'.swiper-wrapper' 요소를 찾을 수 없습니다.");
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
            const post = JSON.parse(imgArr[idx]);
            if (post.existing) {
                const inputs = document.querySelectorAll('input[name="existingImg"]');
                inputs.forEach(input => {
                    if (input.value === post.fileName) input.remove();
                });
            }
            imgArr.splice(idx, 1);
            saveList.splice(idx, 1);

            inData = new FormData();
            saveList.forEach(file => {
                inData.append('img', file);
            });

            displayImage();
        });

        slide.appendChild(imageElement);
        slide.appendChild(deleteBtn);
        sliderWrapper.appendChild(slide);
    });

    if (swiper) {
        swiper.update();
    } else {
        console.error("Swiper가 초기화되지 않았습니다.");
    }
}

function showImageName(sFileName) {
	const user_itme_img = document.querySelector("#user_itme_img")
	let fileName = sFileName.substring(1, sFileName.length - 1);
	user_itme_img.value = fileName;
}