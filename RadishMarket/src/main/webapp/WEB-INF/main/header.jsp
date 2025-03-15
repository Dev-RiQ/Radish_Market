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

<!--             -->

</head>

<body>

	<header>
		<c:choose>
			<c:when test='${ log eq null }'>
				<a href='/login.do'>로그인</a>
				<a href='/insertUser.do'>회원가입</a>
			</c:when>
			<c:otherwise>
				<a href='/infoUser.do'>내정보</a>
				<a href='/logout.do'>로그아웃</a>
			</c:otherwise>
		</c:choose>
		<a href='/listItem.do'>중고거래</a> <a href='/listBoard.do'>자유게시판</a> <a
			href='/listMeet.do'>모임</a>
			
			<a href='/siteInfo.do'>관리자테스트</a>
	</header>
	<header> </header>