const title = document.querySelector("#board_title")
const titleCheck = document.querySelector("#title_check")
const content = document.querySelector("#board_content")
const contentCheck = document.querySelector("#content_check")
function validCheck(){
	if(!title.value.trim()){
		titleCheck.innerText = '값을 입력해주세요.'
		title.style.border = "2px solid crimson"
	}
	title.addEventListener('keyup',() => {
		if(titleCheck.innerText && title.value.trim()){
			titleCheck.innerText = '';
			title.style.border = "1px solid black"
		}
	})
	if(!content.value.trim()){
		contentCheck.innerText = '값을 입력해주세요.'
		content.style.border = "2px solid crimson"
	}
	content.addEventListener('keyup',() => {
		if(contentCheck.innerText && content.value.trim()){
			contentCheck.innerText = '';
			content.style.border = "1px solid black"
		}
	})
	const spans = document.querySelectorAll("span");
	for(let i = 0 ; i < spans.length ; i++){
		if(spans[i].id && spans[i].innerText){
			let type = spans[i].id.split("_")[0];
			const input = document.querySelector(`#board_${type}`);
			if(input){
				input.focus();
			}
			return;		
		}
	}
	document.querySelector("form").submit()
}

title.addEventListener('input', ()=> {
	if(title.value && title.value.length > 50){
		title.value = title.value.substring(0, 50);
	}
})
content.addEventListener('input', ()=> {
	if(content.value && content.value.length > 1000){
		content.value = content.value.substring(0, 1000);
	}
})