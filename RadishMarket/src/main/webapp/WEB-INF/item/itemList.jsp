
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>
<div class="item-list-container">
	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a>
		<a href='/listItem.do'>중고거래</a>
	</div>
	<c:choose>
		<c:when test="${log ne null}">
			<h1>${user.user_city} ${user.user_gu} ${user.user_dong} 중고거래</h1>
		</c:when>
		<c:otherwise>
			<h1><span id="user_city"></span> <span id="user_gu"></span> <span id="user_dong"></span><span> 중고거래</span></h1>
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
				<c:if test="${itemList.size() == 30 && itemTotalCnt > offset + 30}">
					<form action="/item/listItem.do" method="get">
						<input type="hidden" name="offset" value="${offset + 30}">
						<button type="submit" class="btn btn-submit">더 구경하기</button>
					</form>
				</c:if>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services"></script>
<%@ include file="../main/footer.jsp"%>
<script src="../../js/getUserJuso.js"></script>