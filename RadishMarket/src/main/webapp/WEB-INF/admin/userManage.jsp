<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>

<link rel="stylesheet" href="../../css/admin.css">

<section>

	<div class="admin-box">
		<hr>
		<h4>회원</h4>
		<p>
			<a href="userManage.do">회원 관리</a>
		</p>

		<h4>아이템</h4>
		<p>
			<a href="itemManage.do">아이템 관리</a><br> <span><a
				href="listItemCategory.do">아이템 카테고리 관리</a></span>
		</p>

		<h4>게시판</h4>
		<p>
			<a href="boardManage.do">게시판 관리</a><br> <span><a
				href="listBoardCategory.do">게시판 카테고리 관리</a></span>
		</p>

		<h4>모임</h4>
		<p>
			<a href="meetManage.do">모임 관리</a><br> <span><a
				href="listMeetCategory.do">모임 카테고리 관리</a></span>
		</p>

		<h4>알람</h4>
		<p>
			<a href="listAlarmCategory.do">알람 카테고리 관리</a>
		</p>
		<hr>
	</div>

	<div class="userlist">
		<div class="users">
			<h3>회원 관리</h3>
			<table>
				<tr>
					<th class="no">번호</th>
					<th class="name">이름</th>
					<th class="nickname">닉네임</th>
					<th class="age">나이</th>
					<th class="email">이메일</th>
					<th class="address">주소</th>
					<th class="phone">전화번호</th>
					<th class="temp">온도</th>
					<th class="delete">삭제</th>
			</table>
		</div>

		<div id="list-box">
			<!-- 여기 리스트 출력 -->
		</div>
	<button id="btn-more-list" value="adminUser/0" onclick="getMoreList()">더보기</button>
	</div>
</section>

<input type="hidden" id="gu" name="gu" value="강남구" />
<input type="hidden" id="dong" name="dong" value="전체" />
<input type="hidden" id="order_by" name="order_by" value="0" />
<script src="../../js/listPaging.js"></script>

<%@ include file="../main/footer.jsp"%>