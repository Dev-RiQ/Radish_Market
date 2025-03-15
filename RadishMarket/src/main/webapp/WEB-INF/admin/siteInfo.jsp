<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<ul>
	<li>회원</li>
	<ul>
		<li><a href="userManage.do">회원 관리</a></li>
	</ul>
	<li>알람</li>
	<ul>
		<li><a href="listAlarmCategory.do">알람 카테고리 관리</a></li>
	</ul>
	<li>게시판</li>
	<ul>
		<li><a href="listBoardCategory.do">게시판 카테고리 관리</a></li>
		<li><a href="boardManage.do">게시글 관리</a></li>
	</ul>
	<li>아이템</li>
	<ul>
		<li><a href="listItemCategory.do">아이템 카테고리 관리</a></li>
		<li><a href="itemManage.do">아이템 관리</a></li>
	</ul>
	<li>모임</li>
	<ul>
		<li><a href="listMeetCategory.do">모임 카테고리 관리</a></li>
		<li><a href="meetManage.do">모임 관리</a></li>
	</ul>
</ul>

<%@ include file="../main/footer.jsp" %>