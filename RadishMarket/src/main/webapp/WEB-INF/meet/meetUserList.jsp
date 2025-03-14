<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<button onclick="location.href='/infoMeet.do?meet_no=${ meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }'">모임 홈</button>
<c:forEach var="user" items="${meet_user_list}">
	<hr>
	${ user.user_img }
	${ user.user_nickname }
	${ user.user_dong }
</c:forEach>

<%@ include file="../main/footer.jsp" %>