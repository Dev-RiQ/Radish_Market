<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="userboardlist-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}</p>
		<p>매너온도</p>
	</div>

	<div class="user-zzimlist">
		<h3>내 찜목록</h3>
		<c:choose>
			<c:when test="${zzimList eq null or zzimList.size() == 0}">
				<p>아직 찜한 상품이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${zzimList.size()-1}">
					<div class="zzimlist-box" style="cursor: pointer;"
						onclick="location.href='/infoItem.do?Item_no=${zzimList.get(i).item_no}'">
						<div class="board-body">
							<p>${zzimList.get(i).item_name}</p>
							<p>${zzimList.get(i).item_price}원</p>
							<p>${userDongList.get(i)}</p>
							<hr>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</div>

</div>

<%@ include file="../main/footer.jsp"%>