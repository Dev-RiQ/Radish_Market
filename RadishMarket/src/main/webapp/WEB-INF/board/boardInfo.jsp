<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<div>
	${ board.board_no }<br>
	${ board.user_no }<br>
	${ board.board_category_no }<br>
	${ board.meet_no }<br>
	${ board.board_title }<br>
	${ board.board_content }<br>
	${ board.board_reg_datetime }<br>
	${ board.board_update_datetime }<br>
	${ board.board_img }<br>
	${ board.board_hits }<br>
</div>
<button onclick="history.back()">뒤로가기</button>
<c:if test="${ board.user_no == log }">
	<button onclick="location.href='/deleteBoard.do?board_no=${ board.board_no }'">삭제하기</button>
	<button onclick="location.href='/updateBoard.do?board_no=${ board.board_no }'">수정하기</button>
</c:if>

<%@ include file="../main/footer.jsp" %>