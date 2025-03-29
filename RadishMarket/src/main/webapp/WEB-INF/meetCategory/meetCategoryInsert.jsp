<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<section>
<form action="/insertMeetCategory.do" method="post">
	<label for="meet_category_name">알람 분류</label>
	<input type="text" name="meet_category_name" id="meet_category_name" placeholder="카테고리 명">
	<span id="title_check"></span>
	<button type="button" onclick="validCheck()">추가하기</button>
</form>
</section>
<%@ include file="../main/footer.jsp" %>
<script src="../../js/categoryInsertValidCheck.js"></script>
