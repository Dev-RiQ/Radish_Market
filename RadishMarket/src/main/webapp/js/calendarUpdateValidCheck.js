const title = document.querySelector("#calendar_title")
const titleCheck = document.querySelector("#title_check")
const datetime = document.querySelectorAll("#calendar_datetime")
const datetimeCheck = document.querySelector("#datetime_check")
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
	if(!datetime[0].value.trim()){
		datetimeCheck.innerText = '값을 입력해주세요.'
		datetime[0].style.border = "2px solid crimson"
	}
	datetime.forEach((i) => {
		i.addEventListener('change',() => {
			if(new Date(`${datetime[0].value} ${datetime[1].value < 10 ? '0' : ''}${datetime[1].value}:${datetime[2].value < 10 ? '0' : ''}${datetime[2].value}`) <= new Date()){
				datetimeCheck.innerText = '현재시간 이전으로 설정할 수 없습니다.'
			}else{
				if(datetimeCheck.innerText && datetime[0].value.trim()){
					datetimeCheck.innerText = '';
					datetime.style.border = "1px solid black"
				}
			}
		})
	})
	const spans = document.querySelectorAll("span");
		for(let i = 0 ; i < spans.length ; i++){
			if(spans[i].id && spans[i].innerText){
				let type = spans[i].id.split("_")[0];
				const input = document.querySelector(`#calendar_${type}`);
				if(input){
					input.focus();
				}
				return;		
			}
		}
	document.querySelector("form").submit();
}

title.addEventListener('input', ()=> {
	if(title.value && title.value.length > 20){
		title.value = title.value.substring(0, 20);
	}
})