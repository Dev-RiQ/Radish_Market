<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<c:choose>
	<c:when test="${ section eq null }">
		<%@ include file="../main/header.jsp"%>
		<section>
		<div class="home-box">
	      <div class="txtbox">
	        <div class="home-text">
	        	<h2><i class="fa-solid fa-location-dot"></i> ${dong}에서 </h2>
	        	<h2 class="flow-word"></h2>
	        	<h2> 찾고 계신가요?</h2>
	        </div>
	      </div>
	
	      <div class="search">
	        <button id="local-btn">
	          <i class="fa-solid fa-location-dot"></i> ${dong}
	        </button>
	        <input type="search" id="search_value" class="search-input" />
	        <button id="search-btn" onclick="searchInItemList()"><i class="fa fa-search"></i></button>
	      </div>
	
	      <div class="linkbtn">
	        <a href="/listItem.do"><i class="fa fa-shopping-bag"
	            style="font-size: 60px; margin: 5px; color: pink"></i>중고거래</a>
	        <a href="/listBoard.do"><i class="fa-solid fa-chalkboard"
	            style="font-size: 60px; margin: 5px; color: skyblue"></i>자유게시판</a>
	        <a href="/listMeet.do"><i class="fa fa-users" style="font-size: 60px; margin: 5px; color: #5fcc29"></i>모임</a>
	        <c:if test="${ log == -1 }">
	          <a href="userManage.do">관리자 메뉴</a>
	        </c:if>
	      </div>
	    </div>
			</section>
		<%@ include file="../main/footer.jsp"%>
	</c:when>
	<c:otherwise>
		<jsp:include page="${ section }"></jsp:include>
	</c:otherwise>
</c:choose>