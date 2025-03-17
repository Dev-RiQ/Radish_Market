<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/insertLetter.do" method="post">
	받는 사람 ${ user.user_nickname }
	<c:if test="${ item ne null }]">
		대상 아이템 ${ item.item_name }
		<input type="hidden" name="item_no" id="item_no" value="${ item.item_no }">
	</c:if>
	<input type="hidden" name="sell_user_no" id="sell_user_no" value="${ item.user_no }">
	<label for="letter_title">내용</label>
	<input type="text" name="letter_title" id="letter_title" value="${ log }">
	<label for="letter_content">내용</label>
	<textarea name="letter_content" id="letter_content"></textarea>
	
	<input type="hidden" name="user_no" id="user_no" value="${ item.user_no }">
	<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="6">
	<input type="hidden" name="link_no" id="link_no" value="${ item.item_no }">
	<button type="button" onclick="sendAlarm()">쪽지 보내기</button>
</form>

<%@ include file="../main/footer.jsp" %>
