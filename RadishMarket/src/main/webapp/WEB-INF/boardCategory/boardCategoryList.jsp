<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
<link rel="stylesheet" href="../../css/admin.css">

<section>
	<c:forEach var="category" items="${ boardCategoryList }">
		${ category.board_category_no }
		${ category.board_category_name }
		<button
			onclick="location.href='/updateBoardCategory.do?board_category_no=${ category.board_category_no }'">수정하기</button>
		<button
			onclick="location.href='/deleteBoardCategory.do?board_category_no=${ category.board_category_no }'">삭제하기</button>
		<hr>
	</c:forEach>

	<button onclick="location.href='/insertBoardCategory.do'">카테고리
		추가하기</button>
</section>

<%@ include file="../main/footer.jsp"%>