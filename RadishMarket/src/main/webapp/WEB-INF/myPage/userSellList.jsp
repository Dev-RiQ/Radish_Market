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

	<div class="sell-list">
		<h3>판매 중(${sellListSize})</h3>
		<p class="empty-info" id="sellList"></p>
		<div id="list-box">
			<!-- 여기 리스트 출력 -->
		</div>
		<button id="btn-more-list" value="myItem/0" onclick="getMoreList()">더보기</button>
		<input type="hidden" id="item_status" value="1">
	</div>

	<div class="reserve-list">
		<h3>예약 중(${reserveListSize})</h3>
		<p class="empty-info" id="reserveList"></p>
		<div id="list-box">
			<!-- 여기 리스트 출력 -->
		</div>
		<button id="btn-more-list" value="myItem/0" onclick="getMoreList()">더보기</button>
		<input type="hidden" id="item_status" value="2">
	</div>

	<div class="sold-list">
		<h3>거래 완료(${soldListSize})</h3>
		<p class="empty-info" id="soldList"></p>
		<div id="list-box">
			<!-- 여기 리스트 출력 -->
		</div>
		<button id="btn-more-list" value="myItem/0" onclick="getMoreList()">더보기</button>
		<input type="hidden" id="item_status" value="3">
	</div>
</div>

<script src="../../js/listPaging.js"></script>
<%@ include file="../main/footer.jsp"%>