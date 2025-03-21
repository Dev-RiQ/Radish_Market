<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/insertMeetJoin.do?meet_no=${ meet.meet_no }" method="post">
	<label for="meet_join_content">${ meet.meet_title }에 가입신청하기</label>
	<textarea name="meet_join_content" id="meet_join_content" placeholder="가입 인사"></textarea><br>
	<span id="content_check"></span>
	
	<input type="hidden" name="user_no" id="user_no" value="${ meet.host_user_no }">
	<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="8">
	<input type="hidden" name="link_no" id="link_no" value="${ meet.meet_no }">
	<button type="button" onclick="validCheck()">모임 가입 신청하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/meetJoinInsertValidCheck.js"></script>
<script src="../../js/board.js"></script>