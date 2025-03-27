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

	<div class="boardCategoryList">
		<div class="categorys">
			<h3>게시판 카테고리 관리</h3>
			<table>
				<tr>
					<th class="no">번호</th>
					<th class="category">카테고리</th>
					<th class="update">수정</th>
					<th class="delete">삭제</th>
				</tr>
			</table>
		</div>

		<div id="list-box">
			<c:forEach var="category" items="${ boardCategoryList }">
				<div class="board-category">
					<table>
						<tr>
							<th class="no">${ category.board_category_no }</th>
							<th class="category">${ category.board_category_name }</th>
							<th class="update"><button 
									onclick="location.href='/updateBoardCategory.do?board_category_no=${ category.board_category_no }'">수정하기</button></th>
							<th class="delete"><button 
									onclick="location.href='/deleteBoardCategory.do?board_category_no=${ category.board_category_no }'">삭제하기</button></th>
						</tr>
					</table>
				</div>
			</c:forEach>
		</div>
		<button class="add-btn"
			onclick="location.href='/insertBoardCategory.do'">카테고리 추가하기</button>
	</div>
</section>

<%@ include file="../main/footer.jsp"%>