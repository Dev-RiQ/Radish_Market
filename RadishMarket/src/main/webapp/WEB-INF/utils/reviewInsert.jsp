<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/insertReview.do" method="post">
	${ item_img }
	${ item.item_name }
	<input type="hidden" name="item_no" id="item_no" value="${ item.item_no }">
	<input type="hidden" name="sell_user_no" id="sell_user_no" value="${ item.user_no }">
	<input type="hidden" name="buy_user_no" id="buy_user_no" value="${ log }">
	<label for="review_deg">평점</label>
	<select name="review_deg" id="review_deg">
		<option value="2">최고에요</option>
		<option value="1">좋아요</option>
		<option value="0">괜찮아요</option>
		<option value="-1">별로에요</option>
		<option value="-2">다신안사요</option>
	</select>
	<label for="review_content">내용</label>
	<textarea name="review_content" id="review_content"></textarea>
	
	<input type="hidden" name="user_no" id="user_no" value="${ item.user_no }">
	<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="4">
	<input type="hidden" name="link_no" id="link_no" value="">
	<button type="button" onclick="sendAlarm()">등록</button>
</form>

<%@ include file="../main/footer.jsp" %>
