<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>무엇이든 우리동네 무우</title>

<!-- CSS 추가 위치 -->
<link rel="stylesheet" href="../../css/main.css">
<link rel="stylesheet" href="../../css/user.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<!--             -->

</head>
<body>
	<c:if test="${ log ne null }">
		<input type="hidden" id="log" value="${log}">
	</c:if>

	<header>
		<a href='/listItem.do'>중고거래</a> 
		<a href='/listBoard.do'>자유게시판</a> 
		<a href='/listMeet.do'>모임</a>
			<c:if test='${ log == -1 }'>
				<a href='/siteInfo.do'>관리자테스트</a>
			</c:if>
			
		<c:choose>
			<c:when test='${ log eq null }'>
				<a href='/login.do'>로그인</a>
				<a href='/insertUser.do'>회원가입</a>
			</c:when>
			<c:otherwise>
				<a href='/logout.do'>로그아웃</a>
				<a href='/mypageUser.do'>마이페이지</a>
				<button id="show-alarm-div" value="alarm/0" onclick="showAlarmDiv()">알람</button>
				<div class="hide" style="max-height:300px; overflow-y:auto;" id="alarm-list-box"></div>
			</c:otherwise>
		</c:choose>
			<input type="text" id="search_value" name="search_value" value="${ search_value }"/>
			<button onclick="searchInItemList()">검색</button>
	</header>