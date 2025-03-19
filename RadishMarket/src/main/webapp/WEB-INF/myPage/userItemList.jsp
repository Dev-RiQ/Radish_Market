<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="useritemlist-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃</p>
		<p>매너온도</p>
	</div>

	<div class="user-itemlist">
		<h3>판매 물품(${empty itemList ? 0 : itemList.size()})</h3>
		<c:choose>
			<c:when test="${empty itemList}">
				<p>아직 판매중인 물품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<div id="list-box">
					<!-- 여기 리스트 출력 -->
				</div>
				<button id="btn-more-list" value="myItem/0" onclick="getMoreList()">더보기</button>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="review-list">
		<h3>거래 후기(${empty reviewList ? 0 : reviewList.size()})</h3>
		<c:choose>
			<c:when test="${empty reviewList or empty buyUserInfoList}">
				<p>아직 거래 후기가 없습니다.</p>
			</c:when>
			<c:otherwise>
				<div id="list-box">
					<!-- 여기 리스트 출력 -->
				</div>
				<button id="btn-more-list" value="review/0" onclick="getMoreList()">더보기</button>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<script src="../../js/listPaging.js"></script>
<%@ include file="../main/footer.jsp"%>