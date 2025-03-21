<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateItemCategory.do" method="post">
	<input type="hidden" name="item_category_no" id="item_category_no" value="${ item_category_no }">
	<label for="item_category_name">알람 분류</label>
	<input type="text" name="item_category_name" id="item_category_name" value="${ item_category_name }"><br>
	<span id="title_check"></span>
	<button type="button" onclick="validCheck()">수정</button>
</form>
<%@ include file="../main/footer.jsp" %>
<script src="../../js/categoryInsertValidCheck.js"></script>
<script src="../../js/item.js"></script>