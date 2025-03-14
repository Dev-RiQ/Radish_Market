<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<div>
	${ board.board_no }<br>
	${ user.user_img }<br>
	${ user.user_nickname }<br>
	${ user.user_dong }<br>
	${ user.user_deg }<br>
	${ board.board_category_no }<br>
	${ board.meet_no }<br>
	${ board.board_title }<br>
	${ board.board_content }<br>
	${ board.board_reg_datetime }<br>
	${ board.board_update_datetime }<br>
	${ board.board_img }<br>
	${ board.board_hits }<br>
	<a href="/${ isLike == 0 ? 'insert' : 'delete' }Like.do?board_no=${ board.board_no }">좋아요 ${ likeCount }<br></a>
	댓글<br>
	<c:forEach var="i" begin="1" end="${commentList.size() - 1}">
		${ commentNickname.get(i) }<br>
		${ commentList.get(i).comment_content }<br>
		${ commentList.get(i).comment_reg_datetime }<br>
		<c:if test="${ log == commentList.get(i).user_no }">
			<button onclick="location.href">수정</button>
		</c:if>
		<c:if test="${ log == commentList.get(i).user_no || log == board.user_no }">
			<button onclick="location.href='/deleteComment.do?user_no?${commentList.get(i).user_no}'">삭제</button>
		</c:if>
		<br>
	</c:forEach>
	댓글달기<br>
	<form action="/insertComment.do?board_no=${ board.board_no }" method="post">
		<textarea name="comment_content" id="comment_content" placeholder="내용을 입력하세요."></textarea>
		<button onclick="location.href">댓글등록</button>
	</form>
</div>
<button onclick="location.href='/listBoard.do'">목록</button>
<c:if test="${ board.user_no == log }">
	<button onclick="location.href='/deleteBoard.do?board_no=${ board.board_no }'">삭제하기</button>
	<button onclick="location.href='/updateBoard.do?board_no=${ board.board_no }'">수정하기</button>
</c:if>

<%@ include file="../main/footer.jsp" %>