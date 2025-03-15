<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<c:forEach var="user" items="${ userList }">
	${ user.user_no }
	${ user.user_id }
	${ user.user_name }
	${ user.user_age }
	${ user.user_email }
	${ user.user_nickname }
	${ user.user_address }
	${ user.user_phone }
	${ user.user_reg_datetime }
	${ user.user_deg }
	<button onclick="location.href='deleteUser.do?user_no=${user.user_no}'">삭제</button>
	<hr>
</c:forEach>

<%@ include file="../main/footer.jsp" %>