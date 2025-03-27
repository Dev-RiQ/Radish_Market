<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<link rel="stylesheet" type="text/css" href="../../css/swiper.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<link rel="stylesheet" type="text/css" href="../../css/itemInsert.css">

<section>

	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/listItem.do'>중고거래</a> <span>중고거래
			글 수정하기</span>
	</div>

	<div class="item-insert-box ">
		<div class="productsts">
			<form action="/updateItem.do" method="post"
				enctype="multipart/form-data">
				<div class="txt" style="border-bottom: 1px solid #ddd">
					<h1>상품 등록</h1>
				</div>

				<div class="txt img-header" style="margin-bottom: 10px">
					<h3>상품 이미지</h3>
					<div class="imgbtn-small">
						<button type="button" onclick="fileUpload()">
							<i class="fa-solid fa-image"></i> 이미지
						</button>
					</div>
				</div>
				<div class="priducts" style="margin-bottom: 20px">
					<div class="priductsimg">
						<input type="hidden" class="item_no" name="item_no"
							value="${item.item_no}"> <input type="hidden"
							id="user_item_img" name="user_item_img" />

						<div class="post-list" id="post-list">
							<c:choose>
								<c:when test="${empty itemImgList}">
									<p>서버 오류로 이미지를 불러오지 못 했습니다.</p>
								</c:when>
								<c:otherwise>
									<div class="swiper mySwiper">
										<div class="swiper-wrapper">
											<c:forEach var="i" begin="0" end="${itemImgList.size()-1}">
												<div class="swiper-slide">
													<img alt="item-images" src="/images/${itemImgList.get(i)}">
													<button type="button" class="load-delete-btn load${i}"
														id="load-delete-btn load${i}">X</button>
													<input type="hidden" class="loadImage" id="loadImage"
														value="${itemImgList.get(i)}">
													<!-- 사진 들어오는 공간 -->
												</div>
											</c:forEach>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
							<input class="hide" type="file" id="ofile" name="ofile" multiple />
							<div class="save-filename" id="save-filename"></div>
						</div>
					</div>
				</div>

				<div class="txt">
					<h3>
						카테고리<span>*</span>
					</h3>
				</div>
				<select class="category" id="item_category_no"
					name="item_category_no">
					<c:forEach var="category" items="${itemCategoryList}">
						<option value="${category.item_category_no}"
							${category.item_category_no == item.item_category_no ? 'selected' : '' }>${category.item_category_name}</option>
					</c:forEach>
				</select>

				<div class="txt">
					<h3>
						제목<span> *</span>
					</h3>
				</div>
				<input type="text" id="item_name" name="item_name" placeholder="제목"
					value="${item.item_name}"> <span id="title_check"></span>

				<div class="txt">
					<h3>
						자세한 설명<span> *</span>
					</h3>
				</div>
				<textarea id="item_content" name="item_content"
					style="height: 200px; width: 800"
					placeholder="${user_dong}에 올릴 게시글 내용을 작성해 주세요. (판매 금지 물품은 게시가 제한될 수 있어요.) 신뢰할 수 있는 거래를 위해 자세히 적어주세요. 과학기술정보통신부, 한국 인터넷진흥원과 함께 해요.">${item.item_content}</textarea>
				<span id="content_check"></span>

				<div class="txt">
					<h3>
						거래방식<span> *</span>
					</h3>
				</div>
				<button class="rsbtn" type="button" id="sell-btn">판매하기</button>
				<button class="rsbtn" type="button" id="free-btn">나눔하기</button>
				<br> <input type="number" id="item_price" name="item_price"
					value="${item.item_price}" placeholder="₩ 가격을 입력해주세요."> <span
					id="price_check"></span>

				<div class="txt">
					<h3>
						판매 상태<span> *</span>
					</h3>
				</div>
				<select class="category" id="item_status" name="item_status">
					<option value="1" ${ item.item_status == 1 ? 'selected' : '' }>판매
						중</option>
					<option value="2" ${ item.item_status == 2 ? 'selected' : '' }>예약
						중</option>
					<option value="3" ${ item.item_status == 3 ? 'selected' : '' }>판매
						완료</option>
				</select>

				<div class="registrationbtn">
					<button onclick="history.back()">취소</button>
					<!--취소-->
					<button
						onclick="location.href='deleteItem.do?item_no=${item.item_no}'">삭제하기</button>
					<!--등록-->
					<button class="rbtn">수정하기</button>
					<!--등록-->
				</div>
			</form>
		</div>
	</div>


</section>


<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="../../js/multiFile.js"></script>
<script src="../../js/itemInsert_UpdateSwiper.js"></script>
<script src="../../js/itemInsertValidCheck.js"></script>

<%@ include file="../main/footer.jsp"%>