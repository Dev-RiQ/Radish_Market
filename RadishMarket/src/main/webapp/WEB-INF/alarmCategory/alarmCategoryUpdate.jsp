<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<section>
<form action="/updateAlarmCategory.do" method="post">
	<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="${ alarm_category_no }">
	<label for="alarm_category_name">알람 분류</label>
	<input type="text" name="alarm_category_name" id="alarm_category_name" value="${ alarm_category_name }"><br>
	<span id="title_check"></span>
	<br>
	<label for="alarm_category_content">알람 내용</label>
	<textarea name="alarm_category_content" id="alarm_category_content">${ alarm_category_content }</textarea><br>
	<span id="content_check"></span>
	<button type="button" onclick="validCheck()">수정</button>
</form>
</section>
<%@ include file="../main/footer.jsp" %>
<%@ include file="../main/footer.jsp" %>
<script src="../../js/categoryInsertValidCheck.js"></script>
<script src="../../js/alarm.js"></script>