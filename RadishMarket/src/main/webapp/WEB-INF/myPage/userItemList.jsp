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

	<div class="btn-group">
		<c:if test="${log ne user.user_no}">
			<form action="/insertLetter.do" method="post">
				<input type="hidden" id="receive_user_no" name="receive_no"
					value="${user.user_no}"> <input type="hidden"
					id="alarm_category_no" name="alarm_category_no" value="6">
				<button type="button" onclick="openPop('send')">쪽지 보내기</button>
			</form>
		</c:if>
	</div>

	<div class="user-itemlist">
		<h3>구매한 물품(${itemList.size() == 0 or itemList eq null ? 0 : itemList.size()})</h3>
		<c:choose>
			<c:when test="${itemList eq null or itemList.size() == 0}">
				<p>아직 구매한 물품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${itemList.size()-1}">
					<div class="item-box">
						<div class="item-body">
							<img alt="대표 이미지" src="/images/${mainImgList.get(i)}">
							<p>${itemList.get(i).item_name}</p>
							<c:if test="${ cartList.get(i).check_reviewed == 0 }">
								<button onclick="location.href='insertReview.do?item_no=${itemList.get(i).item_no}'">리뷰작성</button>
							</c:if>
							<c:if test="${ cartList.get(i).check_reviewed == 1 }">
								<p>리뷰작성완료</p>
							</c:if>
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
</div>
<%@ include file="../main/footer.jsp"%>