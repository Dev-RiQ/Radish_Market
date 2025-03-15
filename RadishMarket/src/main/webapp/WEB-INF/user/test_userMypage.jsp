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
	

</div>

<%@ include file="../main/footer.jsp"%>