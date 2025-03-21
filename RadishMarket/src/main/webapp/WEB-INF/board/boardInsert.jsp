<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/insertBoard.do" method="post">
	<select name="board_category_no" id="board_category_no">
		<c:forEach var="category" items="${ boardCategoryList }">
			<option value="${ category.board_category_no }">${ category.board_category_name }</option>
		</c:forEach>
	</select>
	<c:choose>
		<c:when test="${ meet_no ne null }">
			<input type="text" name="meet_no" id="meet_no" value="${ meet_no }" readonly><br>
		</c:when>
		<c:otherwise>
			<input type="hidden" name="meet_no" id="meet_no" value=0>
		</c:otherwise>
	</c:choose>
	<label for="board_title">제목</label>
	<input type="text" name="board_title" id="board_title" placeholder="제목">
	<span id="title_check"></span>
	<br>
	<label for="board_content">내용</label>
	<textarea name="board_content" id="board_content" placeholder="내용"></textarea>
	<span id="content_check"></span>
	<br>
	<label for="board_img">이미지</label>
	<div id="post-list"></div><br>
	<input type="text" name="board_img" id="board_img" placeholder="이미지" readonly>
	<button type="button" onclick="openPop()">이미지 등록</button>
	<br>
	<input type="hidden" name="board_gu" id="board_gu" value="${ user.user_gu }">
	<input type="hidden" name="board_dong" id="board_dong" value="${ user.user_dong }">
	<button type="button" onclick="validCheck()">게시하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/boardInsertValidCheck.js"></script>
<script src="../../js/singleFileUpload.js"></script>
<script src="../../js/board.js"></script>