<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./header.jsp" %>
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
<a href='/listItem.do'>중고거래</a>
<a href='/listBoard.do'>자유게시판</a>
<a href='/listMeet.do'>모임</a>

<jsp:include page="${ section }"></jsp:include>
	
<%@ include file="./footer.jsp" %>
<script src="../../js/main.js"></script>