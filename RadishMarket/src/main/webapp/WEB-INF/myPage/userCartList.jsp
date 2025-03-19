<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="userCartList-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지${user.user_img}</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃ ${emoji}</p>
		<progress id="progress" value="${user.user_deg}" max="100"></progress>
		<p>매너온도</p>
	</div>

	<div class="user-itemlist">
		<h3>구매 내역(${empty itemList ? 0 : itemList.size()})</h3>
		<c:choose>
			<c:when test="${empty itemList}">
				<p>구매한 물품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${itemList.size()-1}">
					<div class="item-box" style="cursor: pointer;"
						onclick="location.href='/infoItem.do?item_no=${itemList.get(i).item_no}'">
						<div class="item-body">
							<img alt="대표 이미지" src="/images/${mainImgList.get(i)}">
							<p>${itemList.get(i).item_name}</p>
							<p>${sellerList.get(i).user_nickname}</p>
							<p>${sellerList.get(i).user_dong}</p>
							<p>${itemUpdateList.get(i)}</p>
							<p>${itemList.get(i).item_price}원</p>
							<p>찜 ${zzimCntList.get(i)}</p>
							<hr>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<%@ include file="../main/footer.jsp"%>