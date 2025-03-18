<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="userCartList-container">

	<div class="user-profile">
		<p>유저 이미지</p>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃</p>
		<p>매너온도</p>
	</div>

	<div class="user-itemlist">
		<h3>구매 내역(${itemList.size() == 0 or itemList eq null ? 0 : itemList.size()})</h3>
		<c:choose>
			<c:when test="${itemList eq null or itemList.size() == 0}">
				<p>구매한 물품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${itemList.size()-1}">
					<div class="item-box" style="cursor: pointer;"
						onclick="location.href='/infoItem.do?item_no=${itemList.get(i).item_no}'">
						<div class="item-body">
							<img alt="대표 이미지" src="/images/${mainImgList.get(i)}">
							<p>${itemList.get(i).item_name}</p>
							<p>판매자동</p>
							<p>거래확정일자</p>
							<p>${itemList.get(i).item_price}원</p>
							<p>해당아이템찜개수</p>
							<hr>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	
</div>

	<%@ include file="../main/footer.jsp"%>