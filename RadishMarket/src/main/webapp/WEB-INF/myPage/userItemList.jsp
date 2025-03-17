<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="useritemlist-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃</p>
		<p>매너온도</p>
	</div>

	<div class="user-itemlist">
		<h3>판매 물품(${itemList.size() == 0 or itemList eq null ? 0 : itemList.size()})</h3>
		<c:choose>
			<c:when test="${itemList eq null or itemList.size() == 0}">
				<p>아직 판매중인 물품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${itemList.size()-1}">
					<div class="item-box" style="cursor: pointer;"
						onclick="location.href='/infoItem.do?item_no=${itemList.get(i).item_no}'">
						<div class="item-body">
							<img alt="대표 이미지" src="/images/${mainImgList.get(i)}">
							<p>${itemList.get(i).item_name}</p>
							<p>${itemList.get(i).item_price}원</p>
							<p>${userDongList.get(i)}</p>
							<hr>
						</div>
					</div>
				</c:forEach>
				<div class="btn-box">
					<c:if test="${itemList.size() == 30 && itemTotalCnt > offset + 30}">
						<form action="/item/listItem.do" method="get">
							<input type="hidden" name="offset" value="${offset + 30}">
							<button type="submit" class="btn btn-submit">더 보기</button>
						</form>
					</c:if>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="review-list">
		<h3>거래 후기(${reviewList.size() == 0 or reviewList eq null  ? 0 : reviewList.size()})</h3>
		<c:choose>
			<c:when
				test="${reviewList eq null or reviewList.size() == 0 or buyUserInfo eq null or buyUserInfo.size() == 0}">
				<p>아직 거래 후기가 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${reviewList.size()-1}">
					<div>
						${buyUserInfo.get(i).user_nickname} 구매자 <span>${buyUserInfo.get(i).user_dong}</span>
					</div>
					<div>${reviewList.get(i).review_content}</div>
					<div>${reviewList.get(i).review_content}</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<%@ include file="../main/footer.jsp"%>