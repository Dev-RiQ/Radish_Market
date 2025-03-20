<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/insertMeet.do" method="post">
	<select name="meet_category_no" id="meet_category_no">
		<c:forEach var="category" items="${ meetCategoryList }">
			<option value="${ category.meet_category_no }">${ category.meet_category_name }</option>
		</c:forEach>
	</select>
	<input type="text" name="meet_title" id="meet_title" placeholder="제목"><br>
	<textarea name="meet_content" id="meet_content" placeholder="내용"></textarea><br>
	<input type="number" name="age_min" id="age_min" value=10><br>
	<input type="number" name="age_max" id="age_max" value=20><br>
	<input type="text" name="meet_img" id="meet_img" placeholder="이미지"><br>
	<input type="hidden" name="meet_gu" id="meet_gu" value="${ user.user_gu }">
	<input type="hidden" name="meet_dong" id="meet_dong" value="${ user.user_dong }">
	<button>모임 생성하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/board.js"></script>