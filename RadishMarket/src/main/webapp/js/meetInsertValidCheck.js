const title = document.querySelector("#meet_title")
const titleCheck = document.querySelector("#title_check")
const content = document.querySelector("#meet_content")
const contentCheck = document.querySelector("#content_check")
function validCheck(){
	const age_min = document.querySelector("#age_min")
	const age_minCheck = document.querySelector("#age_min_check")
	const age_max = document.querySelector("#age_max")
	const age_maxCheck = document.querySelector("#age_max_check")
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
	if(!age_min.value.trim()){
		age_minCheck.innerText = '값을 입력해주세요.'
		age_min.style.border = "2px solid crimson"
	}
	age_min.addEventListener('keyup',() => {
		if(age_minCheck.innerText && age_min.value.trim()){
			age_minCheck.innerText = '';
			age_min.style.border = "1px solid black"
		}
	})
	if(!age_max.value.trim()){
		age_maxCheck.innerText = '값을 입력해주세요.'
		age_max.style.border = "2px solid crimson"
	}
	age_max.addEventListener('keyup',() => {
		if(age_maxCheck.innerText && age_max.value.trim()){
			age_maxCheck.innerText = '';
			age_max.style.border = "1px solid black"
		}
	})
	if(age_min.value && age_max.value && parseInt(age_min.value) >= parseInt(age_max.value)){
		age_minCheck.innerText = '유효하지 않은 범위';
		age_min.style.border = "2px solid crimson"
		age_maxCheck.innerText = '유효하지 않은 범위';
		age_max.style.border = "2px solid crimson"
	}
	if(age_min.value && parseInt(age_min.value) < 14){
		age_minCheck.innerText = '14 이상 입력';
		age_min.style.border = "2px solid crimson"
	}
	if(age_max.value && parseInt(age_max.value) > 130){
		age_maxCheck.innerText = '130 이하 입력';
		age_max.style.border = "2px solid crimson"
	}
	const spans = document.querySelectorAll("span");
	for(let i = 0 ; i < spans.length ; i++){
		if(spans[i].id && spans[i].innerText){
			let type = spans[i].id.split("_")[0];
			const input = document.querySelector(`#meet_${type}`);
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