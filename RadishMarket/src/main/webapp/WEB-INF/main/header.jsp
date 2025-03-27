<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="../../images/fav.ico" type="image/x-icon">
<link rel="icon" href="../../images/fav.ico" type="image/x-icon">
<title>무엇이든 우리동네 무우</title>
<!-- CSS 추가 위치 -->
<c:if test="${ mode ne null && mode ne '' }">
	<link rel="stylesheet" href="../../css/darkMode.css">
</c:if>
<link rel="stylesheet" href="../../css/main.css">
<link rel="stylesheet" href="../../css/user.css">
<link rel="stylesheet" href="../../css/alarm.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<!--             -->

</head>
<body>
	<div id="loading-page" class="loading-page hide">
		<jsp:include page="/pageLoading.jsp"></jsp:include>
	</div>
	<c:if test="${ log ne null }">
		<input type="hidden" id="log" value="${log}">
	</c:if>

	<header>
		<div class="gnb">
			<div class="header-logo" style="cursor:pointer;" onclick="location.href='/index.jsp'">
		          <img src="/images/logo.png" style="width: 100px; height: 50px;"></img>
	    	</div>
			<c:set var="url" value="${ pageContext.request.requestURL }" />
			<c:if test="${ url ne 'http://localhost:8080/index.jsp' }">
		    	<div class="gnb-category">
					<a href='/listItem.do'>중고거래</a> 
					<a href='/listBoard.do'>자유게시판</a> 
					<a href='/listMeet.do'>모임</a>
						<c:if test='${ log == -1 }'>
							<a href='/siteInfo.do'>관리자테스트</a>
						</c:if>
		    	</div>
			</c:if>
			<div class="header-box">	
				<c:choose>
					<c:when test='${ log eq null }'>
						<a href='/login.do'>로그인</a>
					</c:when>
					<c:otherwise>
						<button id="show-alarm-div" value="alarm/0" onclick="showAlarmDiv()"><i class="fa-solid fa-bell"></i></button>
						<button id="show-chang" onclick="showMyInfo()"><img alt="user" src="/images/${ my_img ne '' ? my_img : 'usersDefaultImg.png' }" /></button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<c:if test="${ url ne 'http://localhost:8080/index.jsp' }">
		<div class="search-box">
			<div class="search">
	        <button id="local-btn">
	          <i class="fa-solid fa-location-dot" style="font-size: 17px; margin: 5px"></i>${ dong }
	        </button>
	        <input type="search" class="search-input" id="search_value" name="search_value" value="${ search_value }"/>
	        <button id="search-btn" onclick="searchInItemList()"><i class="fa fa-search"></i></button>
	      </div>
		</div>
		</c:if>
	</header>
	<c:if test='${ log ne null }'>
		<div class="bells hide" id="alarm-list-box">
		</div>
		<div class="chang hide">
	      <a href="/mypageUser.do"><button style="cursor:pointer;">내 정보</button></a>
	      <a href="/logout.do"><button style="cursor:pointer;">로그아웃</button></a>
	
	      <div class="mode">
	        <p>화면 모드</p>
	        <label class="switch">
	          <input type="checkbox" id="change-view-mode" ${ mode ne null && mode ne '' ? 'checked' : '' }/>
	          <span class="slider round"></span>
	        </label>
	      </div>
	    </div>
	</c:if>
