<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/listBoard.do'>동네생활 > </a> <span>${board.board_title}</span>
	</div>

<div>
	${ board.board_no }<br>
	${ user.user_img }<br>
	${ user.user_nickname }<br>
	${ user.user_dong }<br>
	${ user.user_deg }℃ ${emoji}<br>
	<progress id="progress" value="${user.user_deg}" max="100"></progress><br>
	${ board.board_category_no }<br>
	${ board.meet_no }<br>
	${ board.board_title }<br>
	${ board.board_content }<br>
	${ board.board_reg_datetime }<br>
	${ board.board_update_datetime }<br>
	${ board.board_img }<br>
	${ board.board_hits }<br>
	<input type="hidden" name="user_no" id="user_no" value="${ board.user_no }">
	<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="1">
	<input type="hidden" name="link_no" id="link_no" value="${ board.board_no }">
	<input type="hidden" name="isLike" id="isLike" value="${ isLike ne null ? isLike : 0 }">
	<button id="btn-like-submit" type="button" onclick="sendAlarm()">좋아요 <span id="like-count">${ likeCount }</span></button>
	댓글<br>
	<div id="comment-list">
		<c:if test="${commentList.size() != 0}">
		<c:forEach var="i" begin="0" end="${commentList.size() - 1}">
			${ commentNickname.get(i) }<br>
			<div id="comment_content_box${ commentList.get(i).comment_no }">
				<div id="comment_content${ commentList.get(i).comment_no }">${ commentList.get(i).comment_content }</div>
				${ commentList.get(i).comment_reg_datetime } ${ commentList.get(i).check_update == 1 ? '수정됨' : '' }
				<br>
			</div>
			<c:if test="${ log == commentList.get(i).user_no }">
				<button id="btn-comment-update${ commentList.get(i).comment_no }" onclick="commentUpdate(this)">수정</button>
			</c:if>
			<c:if test="${ log == commentList.get(i).user_no || log == board.user_no }">
				<button onclick="location.href='/deleteComment.do?user_no=${ board.user_no }&board_no=${ board.board_no }&comment_no=${commentList.get(i).comment_no}'">삭제</button>
			</c:if>
			<br>
		</c:forEach>
		</c:if>
	</div>
	댓글달기<br>
	<div>
		<textarea name="comment_content" id="comment_content" placeholder="내용을 입력하세요."></textarea>
		<button id="btn-comment-submit" onclick="sendAlarm()">댓글등록</button>
	</div>
</div>
<button onclick="location.href='/listBoard.do'">목록</button>
<c:if test="${ board.user_no == log }">
	<button onclick="location.href='/deleteBoard.do?board_no=${ board.board_no }'">삭제하기</button>
	<button onclick="location.href='/updateBoard.do?board_no=${ board.board_no }'">수정하기</button>
</c:if>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/board.js"></script>