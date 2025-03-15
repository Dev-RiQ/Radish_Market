<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<c:forEach var="category" items="${ itemCategoryList }">
		${ category.item_category_no }
		${ category.item_category_name }
		<button onclick="location.href='/updateItemCategory.do?item_category_no=${ category.item_category_no }'">수정하기</button>
		<button onclick="location.href='/deleteItemCategory.do?item_category_no=${ category.item_category_no }'">삭제하기</button>
		<hr>
</c:forEach>

<button onclick="location.href='/insertItemCategory.do'">카테고리 추가하기</button>

<%@ include file="../main/footer.jsp" %>