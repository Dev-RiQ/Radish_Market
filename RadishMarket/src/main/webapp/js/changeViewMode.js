const mode = document.querySelector("#change-view-mode");
const head = document.querySelectorAll('head');
mode.addEventListener('click',(e) => {
	let isChecked = e.target.checked;
	if(isChecked){
		isChecked = 'dark';
		head.forEach((i) => {
			i.innerHTML += `<link rel="stylesheet" href="../../css/darkMode.css">`
		})
	}else {
		isChecked = 'light';
		head.forEach((i) => {
			i.innerHTML = i.innerHTML.replace(`<link rel="stylesheet" href="../../css/darkMode.css">`,'')
		})
	}
	fetch(`/viewModeAjax.do?mode=${isChecked}`)
	.then(response => response.text())
	.catch(error => console.log(error))
})