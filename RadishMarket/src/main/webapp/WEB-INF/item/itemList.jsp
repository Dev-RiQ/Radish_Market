
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>
<div class="item-list-container">
	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/listItem.do'>중고거래</a>
	</div>
	<c:choose>
		<c:when test="${log ne null}">
			<h1>${user.user_city}${user.user_gu}${user.user_dong} 중고거래</h1>
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
			<c:forEach var="i" begin="0" end="${itemList.size()-1}">
				<div class="item-box" style="cursor: pointer;"
					onclick="location.href='/infoItem.do?item_no=${itemList.get(i).item_no}'">
					<div class="item-img">
						<img alt="대표 이미지" src="/images/${mainImgList.get(i)}">
					</div>
					<div class="item-body">
						<p>${itemList.get(i).item_name}</p>
						<p>
							<span> <c:choose>
									<c:when test="${itemList.get(i).item_status == 2}">
										예약중
									</c:when>
									<c:when test="${itemList.get(i).item_status == 3}">
										판매 완료
									</c:when>
								</c:choose>
							</span> ${itemList.get(i).item_price}원
						</p>
						<p>${userDongList.get(i)}</p>
						<hr>
					</div>
				</div>
			</c:forEach>
			<div class="btn-box">
				<c:if test="${itemList.size() < itemTotalCnt}">
					<form action="/listItem.do" method="get">
						<input type="hidden" name="limit" value="${limit + 30}"> <input
							type="hidden" name="offset" value="0">
						<button type="submit" class="btn btn-submit">더 구경하기</button>
					</form>
				</c:if>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<%@ include file="../main/footer.jsp"%>