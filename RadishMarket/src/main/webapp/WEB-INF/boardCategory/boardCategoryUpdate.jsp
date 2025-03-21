<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateBoardCategory.do" method="post">
	<input type="hidden" name="board_category_no" id="board_category_no" value="${ board_category_no }">
	<label for="board_category_name">알람 분류</label>
	<input type="text" name="board_category_name" id="board_category_name" value="${ board_category_name }"><br>
	<span id="title_check"></span>
	<button type="button" onclick="validCheck()">수정</button>
</form>
<%@ include file="../main/footer.jsp" %>
<script src="../../js/categoryInsertValidCheck.js"></script>
<script src="../../js/board.js"></script>