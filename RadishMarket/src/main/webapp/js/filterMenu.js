
/* 필터 */
function openNav() {
	document.getElementById('myNav').style.height = 'calc(100vh - 80px)';
}

function closeNav() {
	document.getElementById('myNav').style.height = '0px';
}
function showSearchBox() {
	document.querySelector('header').classList.add('search-box-show');
	document.querySelector('.search-box').classList.add('show');
	document.querySelector('#show-search-box').classList.add('hide');
	document.querySelector('#btn-search-close').classList.add('show');
}
function closeSearchBox() {
	document.querySelector('header').classList.remove('search-box-show');
	document.querySelector('.search-box').classList.remove('show');
	document.querySelector('#show-search-box').classList.remove('hide');
	document.querySelector('#btn-search-close').classList.remove('show');
}

function toggleNav(x) {
	const sidenav = document.getElementById("mySidenav");
	const isOpen = sidenav.style.width === "200px";
	
	if (isOpen) {
		sidenav.style.width = "0";
		sidenav.style.opacity = "0";
	} else {
		sidenav.style.width = "200px";
		sidenav.style.opacity = "1";
	}
	x.classList.toggle("change");
}
document.addEventListener('click', (e) => {
	let nav = document.querySelector('#mySidenav');
	if (e.currentTarget != nav && e.currentTarget != document.querySelector('.navigationbtns'))
		document.querySelector('.navigationbtns').click()
})
function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
	document.querySelector(".navigationbtns").classList.remove("change");
}