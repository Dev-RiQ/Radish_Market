<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/insertMeetJoin.do?meet_no=${ meet_no }" method="post">
	<textarea name="meet_join_content" id="meet_join_content" placeholder="가입 인사"></textarea><br>
	<button>모임 가입 신청하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/board.js"></script>