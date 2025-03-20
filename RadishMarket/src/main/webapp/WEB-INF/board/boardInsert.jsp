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
	<input type="text" name="board_title" id="board_title" placeholder="제목"><br>
	<textarea name="board_content" id="board_content" placeholder="내용"></textarea><br>
	<input type="text" name="board_img" id="board_img" placeholder="이미지"><br>
	<input type="hidden" name="board_gu" id="board_gu" value="${ user.user_gu }">
	<input type="hidden" name="board_dong" id="board_dong" value="${ user.user_dong }">
	<button>게시하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/board.js"></script>