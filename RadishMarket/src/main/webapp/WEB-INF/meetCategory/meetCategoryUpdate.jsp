<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateMeetCategory.do" method="post">
	<input type="hidden" name="meet_category_no" id="meet_category_no" value="${ meet_category_no }">
	<label for="meet_category_name">알람 분류</label>
	<input type="text" name="meet_category_name" id="meet_category_name" value="${ meet_category_name }">
	<span id="title_check"></span>
	<button type="button" onclick="validCheck()">수정</button>
</form>
<%@ include file="../main/footer.jsp" %>
<script src="../../js/categoryInsertValidCheck.js"></script>
