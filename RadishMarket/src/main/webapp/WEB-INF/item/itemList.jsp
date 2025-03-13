<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <%@ include file="../main/header.jsp"%>
<div class="item-list-container">
	<c:forEach var="item" items="${itemList}" varStatus="loop">
		<div class="item-box">
			<div class="item-img">
				<img alt="" src="">이미지가 들어가요
			</div>
			<div class="item-body" onclick="">
				<p>${item.item_name}</p>
				<p>${item.item_price}원</p>
				<p>${userDongList.get(loop.index)}</p>
			</div>
		</div>
	</c:forEach>
</div>

<div class="btn-box">
	<c:if test="${itemList.size() == 30 && itemTotalCnt > offset + 30}">
		<form action="/item/listItem.do" method="get">
			<input type="hidden" name="offset" value="${offset + 30}">
			<button type="submit" class="btn btn-submit">더 보기</button>
		</form>
	</c:if>
</div>

 <%@ include file="../main/footer.jsp"%>

