<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<c:forEach var="board" items="${ boardList }">
	${ board.board_no }
	${ board.board_title }
	${ board.board_content }
	${ board.board_reg_datetime }
	${ board.board_hits }
	<button onclick="location.href='deleteBoard.do?board_no=${board.board_no}'">삭제</button>
	<hr>
</c:forEach>

<%@ include file="../main/footer.jsp" %>