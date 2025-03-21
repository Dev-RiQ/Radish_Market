<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="dir-history">
	<a href='/index.jsp'>홈 > </a>
	<c:choose>
		<c:when test="${log eq user.user_no}">
			<a href='/mypageUser.do'>마이페이지 > </a>
		</c:when>
		<c:otherwise>
			<a href='/mypageUser.do'>${user.user_nickname} > </a>
		</c:otherwise>
	</c:choose>
	<span>${user.user_nickname}</span>
</div>

<div class="useritemlist-container">

	<div class="user-profile">
		<img alt="유저 이미지" src="/images/${user.user_img}">
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃${emoji}</p>
		<progress id="progress" value="${user.user_deg}" max="100"></progress>
		<p>매너온도</p>
	</div>
	
	<input type="hidden" id="item_status" value="1">
	<div class="btn-box">
		<button class="list-btn" id="sell-btn" onclick="openList()">판매 물품(${sellListSize})</button>
		<button class="list-btn" id="review-btn" onclick="openList()">거래 후기(${reviewListSize}))</button>
	</div>

	<p class="empty-info" id=""></p>
	<div id="list-box">
		<!-- 여기 리스트 출력 -->
	</div>
	<button id="btn-more-list" value="" onclick="getMoreList()">더보기</button>

</div>

<script src="../../js/mypageButtonToggle.js"></script>
<script src="../../js/listPaging.js"></script>
<%@ include file="../main/footer.jsp"%> 