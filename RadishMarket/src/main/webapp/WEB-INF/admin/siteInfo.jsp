<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
<link rel="stylesheet" href="../../css/admin.css">

<section>

	<div class="admin-box">
		<hr>
		<h4>회원</h4>
		<p>
			<a class="admin-btn" onclick="open-list()" href="userManage.do">회원 관리</a>
		</p>

		<h4>알람</h4>
		<p>
			<a class="admin-btn" href="listAlarmCategory.do">알람 카테고리 관리</a>
		</p>

		<h4>게시판</h4>
		<p>
			<a  class="admin-btn" href="listBoardCategory.do">게시판 카테고리 관리</a><br> 
			<span><a class="admin-btn" href="boardManage.do">게시글 관리</a></span>
		</p>

		<h4>아이템</h4>
		<p>
			<a  class="admin-btn" href="listItemCategory.do">아이템 카테고리 관리</a><br> 
			<span><a class="admin-btn" href="itemManage.do">아이템 관리</a></span>
		</p>

		<h4>모임</h4>
		<p>
			<a class="admin-btn" href="listMeetCategory.do">모임 카테고리 관리</a><br> 
			<span><a class="admin-btn" href="meetManage.do">모임 관리</a></span>
		</p>
		<hr>
	</div>
	
</section>


<script src="../../js/listPaging.js"></script>

<%@ include file="../main/footer.jsp"%>