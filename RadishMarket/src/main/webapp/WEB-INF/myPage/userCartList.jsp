<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="userCartList-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지${user.user_img}</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃${emoji}</p>
		<progress id="progress" value="${user.user_deg}" max="100"></progress>
		<p>매너온도</p>
	</div>

	<div class="user-itemlist">
		<h3>구매 내역(${empty itemList ? 0 : itemList.size()})</h3>
		<c:choose>
			<c:when test="${empty itemList}">
				<p>구매한 물품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<div id="list-box">
					<!-- 여기 리스트 출력 -->
				</div>
				<button id="btn-more-list" value="cart/0" onclick="getMoreList()">더보기</button>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<script src="../../js/listPaging.js"></script>
<%@ include file="../main/footer.jsp"%>