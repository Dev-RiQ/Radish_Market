<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateMeet.do?meet_no=${ meetInfo.meet_no }" method="post">
	<select name="meet_category_no" id="meet_category_no">
		<c:forEach var="category" items="${ meetCategoryList }">
			<option value="${ category.meet_category_no }" ${ category.meet_category_no == meetInfo.meet_category ? 'selected' : '' }>${ category.meet_category_name }</option>
		</c:forEach>
	</select>
	<input type="text" name="meet_title" id="meet_title" value="${ meetInfo.meet_title }"><br>
	<textarea name="meet_content" id="meet_content" >${ meetInfo.meet_content }</textarea><br>
	<input type="number" name="age_min" id="age_min" value="${ meetInfo.age_min }"><br>
	<input type="number" name="age_max" id="age_max" value="${ meetInfo.age_max }"><br>
	<input type="text" name="meet_img" id="meet_img" value="${ meetInfo.meet_img }"><br>
	<button>수정하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/board.js"></script>