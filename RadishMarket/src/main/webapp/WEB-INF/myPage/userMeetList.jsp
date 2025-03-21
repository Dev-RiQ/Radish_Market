<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="dir-history">
	<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 > </a> <span>내
		모임</span>
</div>

<div class="userboardlist-container">

	<div class="user-profile">
		<img alt="유저 이미지" src="/images/${user.user_img}">
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃${emoji}</p>
		<progress id="progress" value="${user.user_deg}" max="100"></progress>
		<p>매너온도</p>
	</div>
	
	<div class="btn-box">
		<button class="list-btn" id="hostMeet-btn" onclick="openList()">내가 호스트인 모임 (${hostMeetListSize})</button>
		<button class="list-btn" id="meet-btn" onclick="openList()">내 모임 (${meetListSize})</button>
	</div>

	<p class="empty-info" id=""></p>
	<div id="list-box">
		<!-- 여기 리스트 출력 -->
	</div>
	<button id="btn-more-list" id="" value="" onclick="getMoreList()">더보기</button>

</div>

<script src="../../js/mypageButtonToggle.js"></script>
<script src="../../js/listPaging.js"></script>
<%@ include file="../main/footer.jsp"%>