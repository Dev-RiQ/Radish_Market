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

	<div class="hostuser-boardlist">
		<h3>내가 호스트인 모임 (${empty hostMeetList ? 0 : hostMeetList.size()})</h3>
		<c:choose>
			<c:when test="${empty hostMeetList}">
				<p>회원님이 호스트인 모임이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<div id="list-box">
					<!-- 여기 리스트 출력 -->
				</div>
				<button id="btn-more-list" value="hostMeet/0"
					onclick="getMoreList()">더보기</button>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="user-boardlist">
		<h3>내 모임 (${empty meetList ? 0 : meetList.size()})</h3>
		<c:choose>
			<c:when test="${empty meetList}">
				<p>현재 참여 중인 모임이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<div id="list-box">
					<!-- 여기 리스트 출력 -->
				</div>
				<button id="btn-more-list" value="myMeet/0" onclick="getMoreList()">더보기</button>

			</c:otherwise>
		</c:choose>
	</div>

</div>

<script src="../../js/listPaging.js"></script>
<%@ include file="../main/footer.jsp"%>