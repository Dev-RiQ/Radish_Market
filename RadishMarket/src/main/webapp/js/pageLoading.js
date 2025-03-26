const loading = document.querySelector("#loading-page");

window.onbeforeunload = function () {
	setTimeout(() => {
		loading.classList.remove('hide');
	}, 300)
}  //현재 페이지에서 다른 페이지로 넘어갈 때 표시해주는 기능
window.addEventListener('focus', () => {      //돌아오면 로딩 종료
	loading.classList.add('hide');
});
