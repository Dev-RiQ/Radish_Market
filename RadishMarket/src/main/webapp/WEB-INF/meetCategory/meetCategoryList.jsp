<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
<link rel="stylesheet" href="../../css/admin.css">

<section>
	<c:forEach var="category" items="${ meetCategoryList }">
		${ category.meet_category_no }
		${ category.meet_category_name }
		<button
			onclick="location.href='/updateMeetCategory.do?meet_category_no=${ category.meet_category_no }'">수정하기</button>
		<button
			onclick="location.href='/deleteMeetCategory.do?meet_category_no=${ category.meet_category_no }'">삭제하기</button>
		<hr>
	</c:forEach>

	<button onclick="location.href='/insertMeetCategory.do'">카테고리
		추가하기</button>
</section>

<%@ include file="../main/footer.jsp"%>