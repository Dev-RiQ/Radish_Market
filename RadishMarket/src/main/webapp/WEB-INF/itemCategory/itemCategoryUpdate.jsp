<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateItemCategory.do" method="post">
	<input type="hidden" name="item_category_no" id="item_category_no" value="${ item_category_no }">
	<input type="text" name="item_category_name" id="item_category_name" value="${ item_category_name }"><br>
	<button>수정하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/item.js"></script>