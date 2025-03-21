document.addEventListener("DOMContentLoaded", function () {
    if (typeof Swiper !== "undefined") {
        var swiper = new Swiper(".mySwiper", {
            loop: true,
			slidesPerView: "auto",
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
