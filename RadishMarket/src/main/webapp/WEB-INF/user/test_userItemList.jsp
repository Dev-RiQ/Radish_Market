<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="useritemlist-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}</p>
		<p>매너온도</p>
	</div>

	<div class="user-itemlist">
		<h3>판매 물품</h3>
		<c:forEach var="i" begin="0" end="${itemList.size()-1}">
			<div class="item-box" style="cursor: pointer;"
				onclick="location.href='/infoItem.do?item_no=${itemList.get(i).item_no}'">
				<div class="item-img">
					<img alt="" src="">이미지가 들어가요
				</div>
				<div class="item-body">
					<p>${itemList.get(i).item_name}</p>
					<p>${itemList.get(i).item_price}원</p>
					<p>${userDongList.get(i)}</p>
					<hr>
				</div>
			</div>
		</c:forEach>
	</div>
</div>


<script src="../../js/user.js"></script>

<%@ include file="../main/footer.jsp"%>