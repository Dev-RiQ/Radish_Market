<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<c:forEach var="meet" items="${ meetList }">
	${ meet.meet_no }
	${ meet.host_user_no }
	${ meet.meet_title }
	${ meet.meet_category }
	${ meet.age_min }
	${ meet.age_max }
	<button onclick="location.href='deleteMeet.do?meet_no=${meet.meet_no}'">삭제</button>
	<hr>
</c:forEach>

<%@ include file="../main/footer.jsp" %>