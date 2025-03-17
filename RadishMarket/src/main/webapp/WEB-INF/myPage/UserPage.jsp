<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="userpage-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user_nickname}</p>
		<p>${user_dong}</p>
		<p>${user_deg}</p>
		<p>매너온도</p>
	</div><hr>
	
	<div class="user-box">
		<c:choose>
			<c:when test="${itemList eq null or itemList.size() == 0}">
				<p> ${user.user_nickname}님은 아직 판매중인 상품이 없습니다. </p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${itemList.size()-1}">
					<div class="user-item-box" style="cursor: pointer;"
					onclick="location.href='/infoItem.do?item_no=${itemList.get(i).item_no}'">
						<div class="user-item-img">
							<img alt="" src="">이미지가 들어가요
						</div>
						<div class="user-item">
							<p>${itemList.get(i).item_name}</p>
							<p>${itemList.get(i).item_price}</p>
							<p>${user.user_dong}</p>
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

<script src="../../js/user.js"></script>

<%@ include file="../main/footer.jsp"%>