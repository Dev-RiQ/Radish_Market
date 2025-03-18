<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="mypage-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃</p>
		<p>매너온도</p>
	</div>

	<div class="user-calendar">
		<!-- 달력 들어갈 곳 -->
	</div>
	
	<div class="link-group">
		<a href='/updateUser.do'>프로필 수정</a> 
		<a href='/listLetter.do'>쪽지함</a> 
		<a href='/zzimListUser.do'>찜목록</a>
		<a href='/itemListUser.do'>내 상품</a>
		<a href='/cartListUser.do'>구매내역(!)</a>
		<a href='/sellListUser.do'>판매내역</a>
		<a href='/boardListUser.do'>내 게시글</a>
		<a href='/meetListUser.do'>내 모임</a>
		<a style="cursor: pointer;" onclick="deleteUserDoubleCheck()">회원탈퇴</a>
	</div>
</div>

<script src="../../js/user.js"></script>

<%@ include file="../main/footer.jsp"%>