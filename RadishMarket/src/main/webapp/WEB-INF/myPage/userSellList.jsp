<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="userSelllist-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃</p>
		<p>매너온도</p>
	</div>

	<div class="sell-list">
		<h3>판매 중(${itemList.size() == 0 or itemList eq null ? 0 : itemList.size()})</h3>
		<c:choose>
			<c:when test="${itemList eq null or itemList.size() == 0}">
				<p>판매중인 물품이 없습니다.</p>
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
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="reserve-list">
		<h3>예약 중(${reserveItemList.size() == 0 or reserveItemList eq null ? 0 : reserveItemList.size()})</h3>
		<c:choose>
			<c:when test="${reserveItemList eq null or reserveItemList.size() == 0}">
				<p>예약중인 물품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${reserveItemList.size()-1}">
					<div class="item-box" style="cursor: pointer;"
						onclick="location.href='/infoItem.do?item_no=${reserveItemList.get(i).item_no}'">
						<div class="item-body">
							<img alt="대표 이미지" src="/images/${mainReserveImgList.get(i)}">
							<p>${reserveItemList.get(i).item_name}</p>
							<p><span>예약중</span> ${reserveItemList.get(i).item_price}원</p>
							<p>${userDongList.get(i)}</p>
							<hr>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="sold-list">
		<h3>거래 완료(${soldItemList.size() == 0 or soldItemList eq null ? 0 : soldItemList.size()})</h3>
		<c:choose>
			<c:when test="${soldItemList eq null or soldItemList.size() == 0}">
				<p>거래 완료된 물품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${soldItemList.size()-1}">
					<div class="item-box" style="cursor: pointer;"
						onclick="location.href='/infoItem.do?item_no=${soldItemList.get(i).item_no}'">
						<div class="item-body">
							<img alt="대표 이미지" src="/images/${mainImgList.get(i)}">
							<p>${soldItemList.get(i).item_name}</p>
							<p><span>판매완료</span> ${soldItemList.get(i).item_price}원</p>
							<p>${userDongList.get(i)}</p>
							<hr>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	
</div>

<%@ include file="../main/footer.jsp"%>