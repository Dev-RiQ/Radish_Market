<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<link rel="stylesheet" type="text/css" href="../../css/swiper.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<link rel="stylesheet" type="text/css" href="../../css/itemInsert.css">

<section>

	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/listItem.do'>중고거래 > </a> <span>내
			물건 팔기</span>
	</div>

	<div class="item-insert-box ">
		<div class="productsts">
			<form action="/insertItem.do" method="post">
				<input type="hidden" id="user_item_img" name="user_item_img" /> <input
					type="hidden" name="item_gu" id="item_gu" value="${ user.user_gu }">
				<input type="hidden" name="item_dong" id="item_dong"
					value="${ user.user_dong }">
				<div class="txt" style="border-bottom: 1px solid #ddd">
					<h1>상품 등록</h1>
				</div>

				<div class="txt img-header">
					<h3>상품 이미지</h3>
					<div class="imgbtn-small">
						<button type="button" onclick="fileUpload()">
							<i class="fa-solid fa-image"></i> 이미지
						</button>
					</div>
				</div>
				<div class="priducts" style="margin-bottom: 20px">
					<div class="priductsimg">
						<div class="swiper mySwiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<!-- 사진 들어오는 공간 -->
								</div>
							</div>
						</div>
					</div>

					<input class="hide" type="file" id="ofile" name="ofile" multiple />
					<div class="save-filename" id="save-filename"></div>
				</div>


				<div class="txt">
					<h3>
						카테고리<span>*</span>
					</h3>
				</div>
				<select class="category" id="item_category_no"
					name="item_category_no">
					<c:forEach var="category" items="${itemCategoryList}">
						<option value="${category.item_category_no}">${category.item_category_name}</option>
					</c:forEach>
				</select>

				<div class="txt">
					<h3>
						제목<span> *</span>
					</h3>
				</div>
				<input type="text" id="item_name" name="item_name" placeholder="제목">
				<span id="title_check"></span>

				<div class="txt">
					<h3>
						자세한 설명<span> *</span>
					</h3>
				</div>
				<textarea id="item_content" name="item_content"
					style="height: 200px; width: 800"
					placeholder="${user.user_dong}에 올릴 게시글 내용을 작성해 주세요. (판매 금지 물품은 게시가 제한될 수 있어요.) 신뢰할 수 있는 거래를 위해 자세히 적어주세요. 과학기술정보통신부, 한국 인터넷진흥원과 함께 해요."></textarea>
				<span id="content_check"></span>

				<div class="txt">
					<h3>
						거래방식<span> *</span>
					</h3>
				</div>
				<button class="rsbtn" type="button" id="sell-btn">판매하기</button>
				<button class="rsbtn" type="button" id="free-btn">나눔하기</button>
				<br> <input type="number" id="item_price" name="item_price"
					placeholder="₩ 가격을 입력해주세요."> <span id="price_check"></span>


				<div class="registrationbtn">
					<button type="button" onclick="history.back()">취소</button>
					<!--취소-->
					<button class="rbtn">등록하기</button>
					<!--등록-->₩
				</div>
			</form>
		</div>
	</div>


</section>
<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="../../js/multiFile.js"></script>
<script src="../../js/itemInsertValidCheck.js"></script>
<script src="../../js/itemInsert_UpdateSwiper.js"></script>

<%@ include file="../main/footer.jsp"%>