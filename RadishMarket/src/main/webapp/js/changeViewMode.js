const mode = document.querySelector("#change-view-mode");
const head = document.querySelector('head');
let browserSetMode = 'light';
let selectModeName = setSelectModeName();
const isDarkMode = window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches;
if(isDarkMode){
	browserSetMode = 'dark';
}
setDarkMode()
if(mode){
	mode.addEventListener('click',() => {
		selectModeName = setSelectModeName();
		setTimeout(()=>{
			setDarkMode();
		},100)
		
	})
}
function setSelectModeName(){
	if(mode){
		if(mode.checked){
			return 'dark';
		}else {
			return 'light';
		}
	}
}
function setDarkMode(){
	fetch(`/viewModeAjax.do?mode=${selectModeName}&browserSetMode=${browserSetMode}`)
	.then(response => response.text())
	.then(addMode)
	.catch(error => console.log(error))
}
function addMode(type){
	let headCss = head.innerHTML;
	if(type == 'dark'){
		headCss += `<link rel="stylesheet" href="../../css/darkMode.css">`;
	}else if(type == 'light'){
		while(true){
			let temp = headCss.replace(`<link rel="stylesheet" href="../../css/darkMode.css">`,'')
			if(headCss == temp) break;
			headCss = temp;
		}
	}
	head.innerHTML = headCss;
}