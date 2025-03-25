function commentUpdate(e) {
	const comment_no = e.id.replace("btn-comment-update", "");
	const comment_content_box = document.querySelector(`#comment_content_box${comment_no}`);
	comment_content_box.innerHTML = `<form action="/updateComment.do" method="post">
										<textarea name="comment_content" id="comment_content">${document.querySelector(`#comment_content${comment_no}`).innerText}</textarea>
										<input type="hidden" name="comment_no" id="comment_no" value="${comment_no}" />
										<input type="hidden" name="board_no" id="board_no" value="${document.querySelector("#link_no").value}" />
										<button>수정완료</button>
									</form>`
}