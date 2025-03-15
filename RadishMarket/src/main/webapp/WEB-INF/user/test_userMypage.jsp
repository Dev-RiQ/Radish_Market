<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="mypage-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user_nickname}</p>
		<p>${user_dong}</p>
		<p>${user_deg}</p>
		<p>매너온도</p>
	</div>
	
	<div class="user-calendar">
		<!-- 달력 들어갈 곳 -->
	</div>
	
	<a style="cursor: pointer;" onclick="location.href='/infoUser.do'">프로필 수정</a>
	<a style="cursor: pointer;" onclick="location.href='/infoUser.do'">쪽지함</a>
	<a style="cursor: pointer;" onclick="location.href='/infoUser.do'">찜목록</a>
	<a style="cursor: pointer;" onclick="location.href='/test_boardListUser.do'">내 게시글</a>
	<a style="cursor: pointer;" onclick="location.href='/test_itemListUser.do'">내 상품</a>
	<a style="cursor: pointer;" onclick="deleteUserDoubleCheck()">회원 탈퇴</a>
	
</div>

<script src="../../js/user.js"></script>

<%@ include file="../main/footer.jsp"%>