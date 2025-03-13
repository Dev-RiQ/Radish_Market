<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateBoard.do?board_no=${ board.board_no }" method="post">
	${ board.board_no }<br>
	${ board.user_no }<br>
	<select name="board_category_no" id="board_category_no">
		<c:forEach var="category" items="${ boardCategoryList }">
			<option value="${ board_category_no }" ${ board_category_no == board.board_category_no ? 'selected' : '' }>${ board_category_name }</option>
		</c:forEach>
	</select>
	${ board.meet_no }<br>
	<input type="text" name="board_title" id="board_title" value="${ board.board_title }" ><br>
	<textarea name="board_content" id="board_content" >${ board.board_content }</textarea><br>
	${ board.board_reg_datetime }<br>
	${ board.board_update_datetime }<br>
	<input type="text" name="board_img" id="board_img" value="${ board.board_img}"><br>
	${ board.board_hits }<br>
	<button>수정하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/board.js"></script>