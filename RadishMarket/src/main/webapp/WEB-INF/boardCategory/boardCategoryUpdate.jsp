<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateBoardCategory.do" method="post">
	<input type="hidden" name="board_category_no" id="board_category_no" value="${ board_category_no }">
	<input type="text" name="board_category_name" id="board_category_name" value="${ board_category_name }"><br>
	<button>수정하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/board.js"></script>