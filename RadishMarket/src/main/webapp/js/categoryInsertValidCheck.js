const title = document.querySelectorAll("input")
if(title.length == 2){
	title = title[1]
}else if( title.length == 3){
	title = title[2]
}
const titleCheck = document.querySelector("#title_check")
const content = document.querySelector("textarea")
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
	if(content){
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
		if(!titleCheck.innerText && contentCheck.innerText){
			content.focus();
			return;
		}
	}
	if(titleCheck.innerText){
		title.focus();
		return;
	}
	document.querySelector("form").submit()
}
if(title){
	title.forEach((i)=>{
		i.addEventListener('input', ()=> {
			if(title.value && title.value.length > 10){
				title.value = title.value.substring(0, 10);
			}
		})
	})
}
if(content){
	content.addEventListener('input', ()=> {
		if(content.value && content.value.length > 300){
			content.value = content.value.substring(0, 300);
		}
	})
}