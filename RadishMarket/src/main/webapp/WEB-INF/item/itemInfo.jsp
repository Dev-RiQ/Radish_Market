<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="item-info-container">
	<div class="dir-history">
	<a style="cursor: pointer;" onclick="location.href='/index.jsp'">홈 > </a>
	<a style="cursor: pointer;" onclick="location.href='/listItem.do'">중고거래 > </a>
	<p>${item.item_name}</p>
	</div>
	<div class="fir-box">
		<div class="img-box">
			<img alt="" src="">아이템 이미지
		</div>
		<div class="user-box">
			<img alt="" src="">유저 이미지 
			<a style="cursor: pointer;" onclick="추후에 만들 아이템 유저 인포">${user.user_nickname}</a>
			<a style="cursor: pointer;" onclick="location.href='/listItem.do?user_dong=${user.user_dong}'">${user.user_dong}</a>
			<p>${user.user_deg}도</p>
			<p>매너 온도</p>
		</div>
	</div>
	<div class="sec-box">
		<h3>${item.item_name}</h3>
		<a style="cursor: pointer;" onclick="location.href='/listItem.do?item_no=${item.item_no}'">${categoryName}</a>
		<p>${item.item_price}</p>
		<p>${item.item_content}</p>
		<span>찜 개수${zzimCount} </span><span>조회수 ${item.item_hits}</span>
	</div>
	<c:choose>
		<c:when test="${item.user_no ne log}">
	<div class="btn-box">
		<a href="/${isZzim == 0 ? 'insert' : 'delete' }
	Zzim.do?item_no=${item.item_no}">찜하기</a>
		<form action="/insertLetter.do" method="post">
			<input type="hidden" name="receive_no" value="${item.user_no}">
			<input type="hidden" name="send_user_no" value="${log}">
			<button class="btn btn-submit">쪽지 보내기</button>
		</form>
	</div>
	</c:when>
	<c:otherwise>
		<form action="/updateItem.do" method="post">
			<input type="hidden" name="item_no" value="${item.item_no}">
			<button class="btn btn-submit">상품 수정하기</button>
		</form>
	</c:otherwise>
	</c:choose>
	
	<div class="guid-box">
		<div id="map" style="width:500px;height:400px;"></div>
	</div>
</div>
<input type="hidden" id="user_dir_y" value="${user.user_dir_y}" >
<input type="hidden" id="user_dir_x" value="${user.user_dir_x}" >
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services,clusterer,drawing"></script>
<script src="../../js/item.js"></script>

<hr>

<div class="seller-container">
	<div class="seller-box">
		<div class="seller-info-box">
			<h3>${user.user_nickname}님의 판매물품</h3>
		<c:if test="${userAllItemListSize > 6}">
		<form action="추후 개발 타인이 보는 유저 페이지" method="get">
			<button type="submit" class="btn btn-submit">더 구경하기</button>
		</form>
		</c:if>
		</div>
		<c:forEach var="i" begin="0" end="${itemList.size()-1 > 7 ? 6 : itemList.size()-1}">
			<div class="seller-item-box" style="cursor: pointer;"
				onclick="location.href='/infoItem.do?item_no=${itemList.get(i).item_no}'">
				<div class="seller-item-img">
					<img alt="" src="">이미지가 들어가요
				</div>
				<div class="seller-item">
					<p>${itemList.get(i).item_name}</p>
					<p>${itemList.get(i).item_price}</p>
					<p>${user.user_dong}</p>
					<hr>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<div class="hot-item-container">
	<div class="hot-item-box">
		<div class="hot-item-info">
			<h3>인기매물</h3>
			<a style="cursor: pointer;" onclick="location.href='/listItem.do'">더 구경하기</a>
		</div>
		<c:forEach var="i" begin="0" end="${hotItemSortList.size()-1 > 18 ? 17 : hotItemSortList.size()-1}">
			<div class="hot-item-box" style="cursor: pointer;"
				onclick="location.href='/infoItem.do?item_no=${hotItemSortList.get(i).item_no}'">
				<div class="hot-item-img">
					<img alt="" src="">이미지가 들어가요
				</div>
				<div class="hot-item">
					<p>${hotItemSortList.get(i).item_name}</p>
					<p>${hotItemSortList.get(i).item_price}</p>
					<p>${hotUserNicknameList.get(i)}</p>
					<hr>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="../main/footer.jsp"%>

