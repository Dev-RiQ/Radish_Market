const mySwiper = new Swiper('.mySwiper', {
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
})