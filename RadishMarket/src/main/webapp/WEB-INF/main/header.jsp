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
<c:if test="${ mode ne null && mode eq 'dark' }">
	<link rel="stylesheet" href="../../css/darkMode.css">
</c:if>

<link rel="stylesheet" href="../../css/media.css">
<link rel="stylesheet" href="../../css/main.css">
<link rel="stylesheet" href="../../css/user.css">
<link rel="stylesheet" href="../../css/alarm.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<!--             -->

</head>
<body>
			<c:set var="url" value="${ pageContext.request.requestURL }" />
	<div id="loading-page" class="loading-page hide">
		<%@ include file="../../pageLoading.jsp" %>
	</div>
	<c:if test="${ log ne null }">
		<input type="hidden" id="log" value="${log}">
	</c:if>

	<header>
		<div class="gnb">
		<div>
			<c:if test="${ url ne 'http://localhost:8080/index.jsp' }">
				<div class="navigationbtns" onclick="toggleNav(this)">
			         <div class="bar1"></div>
			         <div class="bar2"></div>
			         <div class="bar3"></div>
			       </div>
	        </c:if>
			<div class="header-logo" style="cursor:pointer;" onclick="location.href='/index.jsp'">
		          <img src="/images/logo.png" style="width: 100px; height: 50px;"></img>
	    	</div>
		</div>
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
					<c:if test="${ url ne 'http://localhost:8080/index.jsp' }">
						<button id="show-search-box" onclick="showSearchBox()"><i class="fa-solid fa-search"></i></button>
					</c:if>
						<button id="show-alarm-div" value="alarm/0" onclick="showAlarmDiv()"><i class="fa-solid fa-bell"></i></button>
						<button id="show-chang" onclick="showMyInfo()"><img alt="user" src="/images/${ my_img ne '' ? my_img : 'usersDefaultImg.png' }" /></button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<c:if test="${ url ne 'http://localhost:8080/index.jsp' }">
		<div class="search-box">
			<div class="search">
	        <button id="btn-search-close" onclick="closeSearchBox()"><i class="fa-solid fa-close"></i></button>
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
	          <input type="checkbox" id="change-view-mode" ${ mode ne null && mode eq 'dark' ? 'checked' : '' }/>
	          <span class="slider round"></span>
	        </label>
	      </div>
	    </div>
	</c:if>
	
	
	<nav>
    <div id="mySidenav" class="navigationbar" >
      <button onclick="location.href='/listItem.do'"><i class="fa fa-shopping-bag"
	            style="font-size: 20px; margin: 5px; color: pink"></i><span>중고거래</span></button>
      <button onclick="location.href='/listBoard.do'"><i class="fa-solid fa-chalkboard"
	            style="font-size: 20px; margin: 5px; color: skyblue"></i><span>동네생활</span></button>
      <button onclick="location.href='/listMeet.do'"><i class="fa fa-users" 
      			style="font-size: 20px; margin: 5px; color: #5fcc29"></i><span>모임</span></button>
      <c:if test="${ isMyPage ne null && isMyPage ne ''}">
      <hr>	
          <button class="tablinks clicked" id="defaultOpen" onclick="location.href='/mypageUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-home" style="font-size: 20px; color: #000"></i>
              </div><span>마이페이지</span>
            </div>
          </button><!-- 프로필 수정-->
          <button class="tablinks" onclick="location.href='/updateUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-user" style="font-size: 20px; color: #000"></i>
              </div><span>프로필 수정</span>
            </div>
          </button><!-- 프로필 수정-->
          <button class="tablinks" onclick="location.href='/boardListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-folder" style="font-size: 20px; color:  #F7D358 "></i>
              </div><span>내 게시글</span>
            </div>
            <!--  내 게시글-->
          </button>
          <button class="tablinks" onclick="location.href='/listLetter.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-envelope" style="font-size: 20px;  color: #FF0080"></i>
              </div><span>쪽지함</span>
            </div>
            <!--  쪽지함-->
          </button>
          <button class="tablinks" onclick="location.href='/zzimListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-bookmark" style="font-size: 20px;  color: gray"></i>
              </div><span>찜목록</span>
            </div>
            <!--  찜목록-->
          </button>
          <button class="tablinks" onclick="location.href='/itemListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-gift" style="font-size: 20px;  color: skyblue"></i>
              </div><span>내 상품</span>
            </div>
            <!--  내 상품-->
          </button>
          <button class="tablinks" onclick="location.href='/cartListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-bag-shopping" style="font-size: 20px; color: pink"></i>
              </div><span>구매 내역</span>
            </div>
            <!--   구매 내역 -->
          </button>
          <button class="tablinks" onclick="location.href='/sellListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-piggy-bank" style="font-size: 20px; color: #5fcc29"></i>
              </div><span>판매 내역</span>
            </div>
            <!--    판매 내역-->
          </button>

          <button class="tablinks" onclick="location.href='/meetListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa fa-users" style="font-size: 20px;color: yellowgreen"></i>
              </div><span>내 모임</span>
            </div>
            <!--   내 모임<-->
          </button>
		</c:if>
    </div>
    
   </nav>
