<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>
<input type="hidden" id="log" value="${ log }" />
<div class="useritemlist-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃${emoji}</p>
		<progress id="progress" value="${user.user_deg}" max="100"></progress>
		<p>매너온도</p>
	</div>

	<div class="user-sendletterlist">
		<h3>받은 쪽지 (${empty letterList ? 0 : letterList.size()})</h3>
		<c:choose>
			<c:when test="${empty letterList}">
				<p>아직 받은 쪽지가 없습니다.</p>
			</c:when>
			<c:otherwise>
				<div id="list-box">
					<!-- 여기 리스트 출력 -->
				</div>
				<button id="btn-more-list" value="receiveLetter/0"
					onclick="getMoreList()">더보기</button>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="user-receiveletterlist">
		<h3>보낸 쪽지</h3>
		<c:choose>
			<c:when test="${itemList eq null or itemList.size() == 0}">
				<p>아직 보낸 쪽지가 없습니다.</p>
			</c:when>
			<c:otherwise>
				<div id="list-box">
					<!-- 여기 리스트 출력 -->
				</div>
				<button id="btn-more-list" value="sendLetter/0"
					onclick="getMoreList()">더보기</button>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<script src="../../js/letter.js"></script>
<script src="../../js/listPaging.js"></script>
<%@ include file="../main/footer.jsp"%>