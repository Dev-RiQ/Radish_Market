<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateAlarmCategory.do" method="post">
	<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="${ alarm_category_no }">
	<input type="text" name="alarm_category_name" id="alarm_category_name" value="${ alarm_category_name }">
	<textarea name="alarm_category_content" id="alarm_category_content">${ alarm_category_content }</textarea><br>
	<button>수정하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/alarm.js"></script>