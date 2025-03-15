<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<c:forEach var="item" items="${ itemList }">
	${ item.item_no }
	${ item.item_name }
	${ item.item_content }
	${ item.item_price }
	${ item.item_reg_datetime }
	${ item.item_status }
	${ item.item_hits }
	<button onclick="location.href='deleteItem.do?item_no=${item.item_no}'">삭제</button>
	<hr>
</c:forEach>

<%@ include file="../main/footer.jsp" %>