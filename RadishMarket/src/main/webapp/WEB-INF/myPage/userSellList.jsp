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
		<p>${user.user_deg}℃ ${emoji}</p>
		<progress id="progress" value="${user.user_deg}" max="100"></progress>
		<p>매너온도</p>
	</div>

	<div class="sell-list">
		<h3>판매 중(${empty itemList ? 0 : itemList.size()})</h3>
		<c:choose>
			<c:when test="${empty itemList}">
				<p>판매중인 물품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<div id="list-box">
					<!-- 여기 리스트 출력 -->
				</div>
				<button id="btn-more-list" value="myItem/0" onclick="getMoreList()">더보기</button>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="reserve-list">
		<h3>예약 중(${reserveItemList.size() == 0 or reserveItemList eq null ? 0 : reserveItemList.size()})</h3>
		<c:choose>
			<c:when
				test="${reserveItemList eq null or reserveItemList.size() == 0}">
				<p>예약중인 물품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<!-- 예약 중 리스트 -->
			</c:otherwise>
		</c:choose>
	</div>

	<div class="sold-list">
		<h3>거래 완료(${soldItemList.size() == 0 or soldItemList eq null ? 0 : soldItemList.size()})</h3>
		<c:choose>
			<c:when test="${soldItemList eq null or soldItemList.size() == 0}">
				<p>거래 완료된 물품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<!-- 거래 완료 리스트 -->
			</c:otherwise>
		</c:choose>
	</div>
</div>

<script src="../../js/listPaging.js"></script>
<%@ include file="../main/footer.jsp"%>