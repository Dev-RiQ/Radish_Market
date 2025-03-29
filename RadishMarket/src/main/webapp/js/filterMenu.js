
/* 필터 */
function openNav() {
	setTimeout(()=>{
	document.getElementById('myNav').style.height = 'calc(100vh - 80px)';
	document.querySelector('.category-header').classList.add('show');
	},10)
	setTimeout(()=>{
		document.querySelector('.categorymain').style.marginTop = '70px';
		document.querySelector('.category-header').classList.add('fix');
	},300)
	setTimeout(()=>{
		document.querySelector('.categoryfooter').classList.add('fix');
	},200)
}

function closeNavbar() {
	document.getElementById('myNav').style.height = '0px';
	document.querySelector('.category-header').classList.remove('show');
		document.querySelector('.category-header').classList.remove('fix');
		document.querySelector('.categoryfooter').classList.remove('fix');
		document.querySelector('.categorymain').style.marginTop = '0px';
}
function showSearchBox() {
	document.querySelector('section').classList.add('search-box-show');
	document.querySelector('header').classList.add('search-box-show');
	document.querySelector('.search-box').classList.add('show');
	document.querySelector('#show-search-box').classList.add('hide');
	document.querySelector('#btn-search-close').classList.add('show');
}
function closeSearchBox() {
	document.querySelector('section').classList.remove('search-box-show');
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
	let searchInput = document.querySelector('#search_value')
	if (e.target != searchInput && document.querySelector('header').scrollHeight == 130){
		closeSearchBox()
	}
	let filterDiv = document.querySelector('#myNav');
	let filterAction = document.querySelector('.btn-action-filter');
	if(e.target != filterAction && filterDiv && !filterDiv.contains(e.target) && filterDiv.style.heigth != '0px'){
		closeNavbar()
	}
	if(e.target == document.querySelector('.navigationbtns')
	|| e.target == document.querySelectorAll('.navigationbtns>div')[0]
	|| e.target == document.querySelectorAll('.navigationbtns>div')[1]
	|| e.target == document.querySelectorAll('.navigationbtns>div')[2]) return;
	
	let nav = document.querySelector('#mySidenav');
	if (e.target != nav && nav.style.width == '200px'){
		document.querySelector('.navigationbtns').click()
	}
})
function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
	document.querySelector(".navigationbtns").classList.remove("change");
}