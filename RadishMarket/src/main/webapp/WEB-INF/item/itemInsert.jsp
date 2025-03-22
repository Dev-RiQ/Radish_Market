<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<link rel="stylesheet" type="text/css" href="../../css/swiper.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

<div class="dir-history">
	<a href='/index.jsp'>홈 > </a> <a href='/listItem.do'>중고거래 > </a> <span>내
		물건 팔기</span>
</div>

<div class="item-insert-container">

	<form action="/insertItem.do" method="post">
		<input type="hidden" id="user_item_img" name="user_item_img" />
		<input type="hidden" name="item_gu" id="item_gu" value="${ user.user_gu }"> 
		<input type="hidden" name="item_dong" id="item_dong" value="${ user.user_dong }">

		<div class="swiper mySwiper">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<!-- 사진 들어오는 공간 -->
				</div>
			</div>
			<div class="swiper-pagination"></div>
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</div>

		<input type="file" id="ofile" name="ofile" multiple />
		<div class="save-filename" id="save-filename"></div>
		<hr>
	
		<label for="item_title">제목</label>
		<input type="text" id="item_name" name="item_name"placeholder="제목" required>
		<span id="title_check"></span>
		<br> 
		
		<label>카테고리</label>
		<select id="item_category_no" name="item_category_no">
				<c:forEach var="category" items="${itemCategoryList}">
					<option value="${category.item_category_no}">${category.item_category_name}</option>
				</c:forEach>
		</select>
		<br> 
		
		<label for="item_price">거래 가격</label>
		<input type="number" id="item_price" name="item_price" placeholder="₩ 가격을 입력해주세요." required>
		<label for="free_item">나눔하기</label>
		<input type="checkbox" id="free_item" name="free_item">
		<span id="price_check"></span>
		<br> 
		
		<label for="item_content">자세한 설명</label>
		<textarea id="item_content" name="item_content" style="height: 200px; width: 800"
				placeholder="${user.user_dong}에 올릴 게시글 내용을 작성해 주세요. (판매 금지 물품은 게시가 제한될 수 있어요.) 신뢰할 수 있는 거래를 위해 자세히 적어주세요. 과학기술정보통신부, 한국 인터넷진흥원과 함께 해요."
				required></textarea>
		<span id="content_check"></span>
		<br> 
		
		<button class="btn submit-btn" type="button" onclick="validCheck()">작성 완료</button>
	</form>
</div>

<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="../../js/multiFile.js"></script>
<script src="../../js/itemInsertValidCheck.js"></script>

<%@ include file="../main/footer.jsp"%>