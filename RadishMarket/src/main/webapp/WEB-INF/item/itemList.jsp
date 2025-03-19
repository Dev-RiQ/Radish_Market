
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>
<div class="item-list-container">
	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/listItem.do'>중고거래</a>
	</div>
	<c:choose>
		<c:when test="${log ne null}">
			<h1>${user.user_city}${user.user_gu}${user.user_dong}중고거래</h1>
		</c:when>
		<c:otherwise>
			<h1>${address}중고거래</h1>
		</c:otherwise>
	</c:choose>

	<div class="btn-box">
		<a href='/insertItem.do'>글 쓰기</a>
	</div>
	<c:choose>
		<c:when test="${itemList eq null or itemList.size() == 0}">
			<p>무우마켓에 등록된 상품이 없습니다.</p>
		</c:when>
		<c:otherwise>
			<div id="list-box">
				<!-- 여기 리스트 출력 -->
			</div>
			<button id="btn-more-list" value="item/0" onclick="getMoreList()">더보기</button>
		</c:otherwise>
	</c:choose>
</div>

<%@ include file="../main/footer.jsp"%>

<script src="../../js/listPaging.js"></script>