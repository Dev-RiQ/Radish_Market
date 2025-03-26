document.addEventListener("DOMContentLoaded", function () {
    if (typeof Swiper !== "undefined") {
        var swiper = new Swiper(".mySwiper", {
            loop: true,
			slidesPerView: "auto",
			watchOverflow : true,
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

document.addEventListener('DOMContentLoaded', () => {
  const swiperImages = document.querySelectorAll('.swiper-slide img');
  const modal = document.getElementById('imageModal');
  const modalImage = document.getElementById('modalImage');

  swiperImages.forEach(img => {
    img.addEventListener('click', () => {
      modalImage.src = img.src;
      modal.classList.remove('hidden');
    });
  });

  modal.addEventListener('click', () => {
    modal.classList.add('hidden');
    modalImage.src = ''; 
  });
});
