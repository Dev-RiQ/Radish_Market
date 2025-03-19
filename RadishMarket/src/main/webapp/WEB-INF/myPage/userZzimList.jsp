<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="userboardlist-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}</p>
		<p>매너온도</p>
	</div>

	<div class="user-zzimlist">
		<h3>내 찜목록 (${empty zzimList ? 0 : zzimList.size()})</h3>
		<c:choose>
			<c:when test="${empty zzimList or empty userDongList}">
				<p>아직 찜한 상품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<div id="list-box">
					<!-- 여기 리스트 출력 -->
				</div>
				<button id="btn-more-list" value="zzim/0" onclick="getMoreList()">더보기</button>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<script src="../../js/listPaging.js"></script>

<%@ include file="../main/footer.jsp"%>