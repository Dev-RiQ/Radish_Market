<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/insertAlarmCategory.do" method="post">
	<input type="text" name="alarm_category_name" id="alarm_category_name" placeholder="카테고리 명"><br>
	<button>추가하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
