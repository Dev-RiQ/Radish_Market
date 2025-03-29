<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<section>
<form action="/insertAlarmCategory.do" method="post">
	<label for="alarm_category_name">알람 분류</label>
	<input type="text" name="alarm_category_name" id="alarm_category_name" placeholder="카테고리 명">
	<span id="title_check"></span>
	<br>
	<label for="alarm_category_content">알람 내용</label>
	<textarea name="alarm_category_content" id="alarm_category_content" placeholder="카테고리 내용"></textarea><br>
	<span id="content_check"></span>
	<button type="button" onclick="validCheck()">추가하기</button>
</form>
</section>
<%@ include file="../main/footer.jsp" %>
<script src="../../js/categoryInsertValidCheck.js"></script>
