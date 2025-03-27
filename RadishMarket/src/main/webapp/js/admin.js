adminBtns = document.querySelectorAll('.admin-btn');

adminBtns.forEach((btn) => {
	btn.addEventListener('click', (e) => {
		console.log(e.target)
	})
})
