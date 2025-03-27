const loading = document.querySelector("#loading-page");

window.onbeforeunload = function () {
	setTimeout(() => {
		loading.classList.remove('hide');
	}, 300)
}  //현재 페이지에서 다른 페이지로 넘어갈 때 표시해주는 기능
window.onpageshow = function (event){     //뒤로가기로 페이지 접근했는지 확인
    if(event.persisted || (window.performance && window.performance.navigation.type == 2) || (window.performance.getEntriesByType("navigation")[0].type == "back_forward")){
	setTimeout(() => {
		loading.classList.add('hide');
	}, 100)
    }
}
