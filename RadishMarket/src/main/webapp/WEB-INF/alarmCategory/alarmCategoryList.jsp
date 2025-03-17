<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<c:forEach var="category" items="${ alarmCategoryList }">
		${ category.alarm_category_no }
		${ category.alarm_category_name }
		${ category.alarm_category_content }
		<button onclick="location.href='/updateAlarmCategory.do?alarm_category_no=${ category.alarm_category_no }'">수정하기</button>
		<button onclick="location.href='/deleteAlarmCategory.do?alarm_category_no=${ category.alarm_category_no }'">삭제하기</button>
		<hr>
</c:forEach>

<button onclick="location.href='/insertAlarmCategory.do'">카테고리 추가하기</button>

<%@ include file="../main/footer.jsp" %>