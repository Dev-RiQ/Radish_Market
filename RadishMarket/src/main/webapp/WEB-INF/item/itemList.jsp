
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>
<div class="item-list-container">
	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/listItem.do'>중고거래</a>
	</div>
	<c:choose>
		<c:when test="${log ne null}">
			<h1>${user.user_city} ${user.user_gu} ${user.user_dong} 중고거래</h1>
		</c:when>
		<c:otherwise>
			<h1>${address} 중고거래</h1>
		</c:otherwise>
	</c:choose>
	
	<a href='/insertItem.do'>글 쓰기</a>

	<c:choose>
		<c:when test="${itemList eq null or itemList.size() == 0}">
			<p>무우마켓에 등록된 상품이 없습니다.</p>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${log eq null}">
					<input type="hidden" id="user_dong" value="${dong}">
				</c:when>
				<c:otherwise>
					<input type="hidden" id="user_dong" value="${user.user_dong}">
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	
			<!-- <input type="hidden" id="user_dong" value="역삼동"> -->
			
			<div id="list-box">
				<!-- 여기 리스트 출력 -->
			</div>
			<button id="btn-more-list" value="item/0" onclick="getMoreList()">더보기</button>
</div>

<%@ include file="../main/footer.jsp"%>

<script src="../../js/listPaging.js"></script>