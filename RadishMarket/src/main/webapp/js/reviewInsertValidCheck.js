const content = document.querySelector("#review_content")
const contentCheck = document.querySelector("#content_check")
function validCheck(){
	if(!content.value.trim()){
		contentCheck.innerText = '값을 입력해주세요.'
		content.style.border = "2px solid crimson"
		content.focus();
		return;		
	}
	content.addEventListener('keyup',() => {
		if(contentCheck.innerText && content.value.trim()){
			contentCheck.innerText = '';
			content.style.border = "1px solid black"
		}
	})
	sendAlarm()
}

content.addEventListener('input', ()=> {
	if(content.value && content.value.length > 100){
		content.value = content.value.substring(0, 100);
	}
})

const labels = document.querySelectorAll(".star-label");
const radios = document.querySelectorAll(".star-radio");
if(labels){
	labels.forEach((label) => {
	  label.addEventListener("click", () => {
	    radios.forEach((i, idx) => {
			if(document.querySelector('input[id="review_deg"]:checked')){
		      if (idx <= parseInt(document.querySelector('input[id="review_deg"]:checked').value) + 2)
		        labels[idx].classList.add("active");
		      else
		        labels[idx].classList.remove("active");
			}
	    })
	  });
	});
}