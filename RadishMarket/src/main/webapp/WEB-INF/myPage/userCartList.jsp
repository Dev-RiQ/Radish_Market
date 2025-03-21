<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="dir-history">
	<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 > </a> <span>구매내역</span>
</div>

<div class="userCartList-container">

	<div class="user-profile">
		<img alt="유저 이미지" src="/images/${user.user_img}">
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃${emoji}</p>
		<progress id="progress" value="${user.user_deg}" max="100"></progress>
		<p>매너온도</p>
	</div>

	<div class="user-itemlist">
		<h3>구매 내역 (${buyListSize})</h3>
		<p class="empty-info" id="buyList"></p>
		<div id="list-box" style="width:100vw; flex-wrap:wrap; display:flex;">
			<!-- 여기 리스트 출력 -->
		</div>
		<button id="btn-more-list" value="cart/0" onclick="getMoreList()">더보기</button>
	</div>
</div>

<%@ include file="../main/footer.jsp"%>