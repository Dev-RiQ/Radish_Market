let swiper;
let imgArr = [];
let saveList = [];
let inData = new FormData();
let checkImgUpload = false;

document.addEventListener("DOMContentLoaded", function() {
    console.log("DOMContentLoaded 이벤트 발생");
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
        console.log("Swiper 초기화 완료");
    } else {
        console.error("Swiper 라이브러리가 정상적으로 로드되지 않았습니다.");
    }
});

const imageUploadInput = document.getElementById('ofile');

imageUploadInput.addEventListener('change', () => {
    imgArr = [];
    saveList = [];
    console.log("imageUploadInput change 이벤트 발생");
    const files = Array.from(imageUploadInput.files);
    console.log("선택된 파일:", files);

    if ((saveList.length + files.length) > 8) {
        alert('물품 사진은 최대 8장까지 등록할 수 있습니다.');
        imageUploadInput.value = '';
        console.log("파일 개수 초과, 초기화");
        return;
    }

    files.forEach((file) => {
        saveList.push(file);
        console.log("saveList 업데이트:", saveList);
        const reader = new FileReader();
        reader.onload = (e) => {
            const post = { image: e.target.result };
            imgArr.push(JSON.stringify(post));
            console.log("imgArr 업데이트:", imgArr);
            inData = new FormData();
            saveList.forEach(file => {
                inData.append('img', file); 
            });
            console.log("FormData 업데이트:", inData);
            displayImage();
        };
        reader.readAsDataURL(file);
    });
});

function deleteImage(idx) {
    console.log("삭제 버튼 클릭, idx:", idx);
    imgArr.splice(idx, 1);
    saveList.splice(idx, 1);
    console.log("imgArr 업데이트:", imgArr);
    console.log("saveList 업데이트:", saveList);

    const dataTransfer = new DataTransfer();
    saveList.forEach(file => {
        dataTransfer.items.add(file);
    });
    imageUploadInput.files = dataTransfer.files;

    inData = new FormData();
    saveList.forEach(file => {
        inData.append('img', file);
    });
    console.log("FormData 업데이트:", inData);

    displayImage();
}

function displayImage() {
    console.log("displayImage() 호출");
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
            deleteImage(idx);
        });

        slide.appendChild(imageElement);
        slide.appendChild(deleteBtn);
        sliderWrapper.appendChild(slide);
    });

    if (swiper) {
        swiper.update();
        console.log("Swiper 업데이트");
    } else {
        console.error("Swiper가 초기화되지 않았습니다.");
    }
}

function saveImg() {
    console.log("saveImg() 호출");
    if (saveList.length > 0) {
        inData = new FormData();
        saveList.forEach(file => {
            inData.append('img', file); 
        });
        console.log("FormData 업데이트:", inData);

        return fetch('/fileUploadAjax.do', {
            method: "post",
            body: inData
        })
            .then(response => {
                console.log("서버 응답:", response);
                if (!response.ok) {
                    throw new Error('파일 업로드 실패: ' + response.statusText);
                }
                checkImgUpload = true;
                return response.text();
            })
            .then((sFileName) => {
                console.log("서버에서 받은 파일 이름:", sFileName);
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
    console.log("showImageName() 호출, sFileName:", sFileName);
    const user_item_img = document.querySelector("#user_item_img");
    let fileName = sFileName.substring(1, sFileName.length - 1);
    user_item_img.value = fileName;
    console.log("user_item_img.value 업데이트:", fileName);
}