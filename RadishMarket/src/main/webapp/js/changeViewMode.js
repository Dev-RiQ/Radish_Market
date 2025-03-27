const mode = document.querySelector("#change-view-mode");
const head = document.querySelector('head');
mode.addEventListener('click',(e) => {
	let isChecked = e.target.checked;
	if(isChecked){
		isChecked = 'dark';
		head.innerHTML += `<link rel="stylesheet" href="../../css/darkMode.css">`
	}else {
		isChecked = 'light';
		head.innerHTML = head.innerHTML.replace(`<link rel="stylesheet" href="../../css/darkMode.css">`,'')
	}
	fetch(`/viewModeAjax.do?mode=${isChecked}`)
	.then(response => response.text())
	.catch(error => console.log(error))
})