<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>

<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/listBoard.do'>동네생활</a>
	</div>

<form action="/listBoard.do?filter=true" method="post">
	<label for="user_dong">위치</label><br> <label><input
		type="radio" name="user_dong" id="user_dong" value="전체"
		${ userDong eq '전체' ? 'checked' : '' } />전체보기</label><br>
	<c:forEach var="dong" items="${ dongList }">
		<label><input type="radio" name="user_dong" id="user_dong"
			value="${ dong }"
			${ userDong eq dong ? 'checked' : userDong eq null and logUserDong eq dong? 'checked' : '' } />${ dong }</label>
		<br>
	</c:forEach>

	<hr>

	<label for="category_no">카테고리</label><br> <label><input
		type="radio" name="category_no" id="category_no" value="0"
		${ categoryNo eq null || categoryNo eq 0 ? 'checked' : '' } />전체보기</label><br>
	<c:forEach var="category" items="${ categoryList }">
		<label><input type="radio" name="category_no" id="category_no"
			value="${ category.board_category_no }"
			${ categoryNo eq category.board_category_no ? 'checked' : '' } />${ category.board_category_name }</label>
		<br>
	</c:forEach>

	<hr>

	<label for="order_by">정렬</label><br> <label><input
		type="radio" name="order_by" id="order_by" value=0
		${ order_by eq null || order_by == 0 ? 'checked' : '' } />최신순</label><br>
	<label><input type="radio" name="order_by" id="order_by"
		value=1 ${ order_by eq 1 ? 'checked' : '' } />인기순</label><br>
	<button>필터적용</button>
</form>

<button onclick="location.href='/insertBoard.do'">글쓰기</button>

<div id="list-box">
	<!-- 여기 리스트 출력 -->
</div>
<button id="btn-more-list" value="board/0" onclick="getMoreList()">더보기</button>

<%@ include file="../main/footer.jsp"%>

<script src="../../js/listPaging.js"></script>