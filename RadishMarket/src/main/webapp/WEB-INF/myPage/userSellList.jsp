<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>


<div class="dir-history">
	<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 > </a> <span>판매내역</span>
</div>

<div class="userSelllist-container">

	<div class="user-profile">
		<img alt="유저 이미지" src="/images/${user.user_img}">
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃${emoji}</p>
		<progress id="progress" value="${user.user_deg}" max="100"></progress>
		<p>매너온도</p>
	</div>
	
	<div class="btn-box">
		<input type="hidden" id="item_status" value="1">
		<button class="list-btn" id="sell-btn" onclick="openList()">판매 중 (${sellListSize})</button>
		<button class="list-btn" id="reserve-btn" onclick="openList()">예약 중 (${reserveListSize})</button>
		<button class="list-btn" id="sold-btn" onclick="openList()">거래 완료(${soldListSize})</button>
	</div>
	
	<p class="empty-info" id=""></p>
	<div id="list-box" style="width:100vw; flex-wrap:wrap; display:flex;">
		<!-- 여기 리스트 출력 -->
	</div>
	<button id="btn-more-list" value="myItem/0" onclick="getMoreList()">더보기</button>
	
</div>

<%@ include file="../main/footer.jsp"%>
<script src="../../js/mypageButtonToggle.js"></script>