const moreList = document.querySelector('#btn-more-list');
const btns = document.querySelectorAll('.list-btn');

const hiddenTag = document.querySelector('input#item_status');

btns.forEach((btn) => {
	btn.addEventListener('click', (e) => {
		console.log(e.target);
		document.querySelector('#list-box').innerHTML = '';
		switch (e.target.id) {
			case 'receive-btn': moreList.value = 'receiveLetter/0'; break;
			case 'send-btn': moreList.value = 'sendLetter/0'; break;
			case 'sell-btn': moreList.value = 'myItem/0'; break;
			case 'reserve-btn': moreList.value = 'myItem/0'; hiddenTag.value = "2"; break;
			case 'sold-btn': moreList.value = 'myItem/0'; hiddenTag.value = "3"; break;
			case 'review-btn': moreList.value = 'review/0'; break;
			case 'hostMeet-btn': moreList.value = 'hostMeet/0'; break;
			case 'meet-btn': moreList.value = 'myMeet/0'; break;
		}
		moreList.click();
	});
})

function openList() {
	moreList.addEventListener('click', (e) => {
		const more_value = e.target.value;
		const infoMsg = document.querySelector('.empty-info');
		switch (more_value) {
			case 'receiveLetter/0': infoMsg.id = 'receiveLetterList'; break;
			case 'sendLetter/0': infoMsg.id = 'sendLetterList'; break;
			case 'myItem/0': infoMsg.id = 'sellList'; break;
			case 'review/0': infoMsg.id = 'reviewList'; break;
			case 'hostMeet/0': infoMsg.id = 'hostMeetList'; break;
			case 'myMeet/0': infoMsg.id = 'meetList'; break;
		}
		if(hiddenTag){
			if (hiddenTag.value === "2") {
				infoMsg.id = "reserveList";
			} else if (hiddenTag.value === "3") {
				infoMsg.id = "soldList";
			}
		}
	})
}