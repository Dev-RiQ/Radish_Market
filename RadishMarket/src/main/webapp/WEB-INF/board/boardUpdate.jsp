<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateBoard.do?board_no=${ board.board_no }" method="post">
	<select name="board_category_no" id="board_category_no">
		<c:forEach var="category" items="${ boardCategoryList }">
			<option value="${ category.board_category_no }" ${ category.board_category_no == board.board_category_no ? 'selected' : '' }>${ category.board_category_name }</option>
		</c:forEach>
	</select>
	
	<label for="board_title">제목</label>
	<input type="text" name="board_title" id="board_title" value="${ board.board_title }">
	<span id="title_check"></span>
	<br>
	<label for="board_content">내용</label>
	<textarea name="board_content" id="board_content" >${ board.board_content }</textarea>
	<span id="content_check"></span>
	<br>
	<label for="board_img">이미지</label>
	<div id="post-list">
	<c:if test="${ meet_img ne null && !meet_img.isBlank() }">
		<img alt="프로필" src="/images/${ board.board_img }">
	</c:if>
	</div><br>
	<input type="text" name="board_img" id="board_img" ${ board.board_img eq null or board.board_img.isBlank() ? 'placeholder=' : 'value=' }"${ board.board_img eq null or board.board_img.isBlank() ? '이미지' : board.board_img }" readonly>
	<button type="button" onclick="openPop()">이미지 등록</button>
	<br>
	<input type="hidden" name="board_gu" id="board_gu" value="${ board.board_gu }">
	<input type="hidden" name="board_dong" id="board_dong" value="${ board.board_dong }">
	<button type="button" onclick="validCheck()">수정하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/boardInsertValidCheck.js"></script>
<script src="../../js/singleFileUpload.js"></script>
<script src="../../js/board.js"></script>