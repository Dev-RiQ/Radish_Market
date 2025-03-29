<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ include file="../main/header.jsp" %>
		<link rel="stylesheet" href="../../css/itemInfo.css">
		<link rel="stylesheet" type="text/css" href="../../css/itemInfoSwiper.css">
		<section>
			<div class="item-info-box">
				<div class="thelook">
					<div class="dir-history">
						<a href='/index.jsp'>홈 > </a> <a href='/listItem.do'>중고거래 </a>
					</div>

					<div class="itemandtxt">
						<div class="itemimg">
							<div class="imgs">
								<div class="swiper mySwiper">
									<div class="swiper-wrapper">
										<c:choose>
											<c:when test="${empty itemImgList}">
												<p>서버 오류로 이미지를 불러오지 못 했습니다.</p>
											</c:when>
											<c:otherwise>
												<c:forEach var="i" begin="0" end="${itemImgList.size()-1}">
													<div class="swiper-slide">
														<img class="load-img" alt="item-images" src="/images/${itemImgList.get(i)}">
													</div>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="swiper-pagination"></div>
									<div class="swiper-button-prev"></div>
									<div class="swiper-button-next"></div>
								</div>
							</div>

							<div id="imageModal" class="image-modal hidden">
								<div class="modal-background"></div>
								<img id="modalImage" src="" alt="확대 이미지">
								<button type="button" class="modal-delete-btn">
									<i class="fa-solid fa-x"></i>
								</button>
							</div>

							<!-- 유저 프로필 시작 -->
							<div class="user-profile-container">
								<div class="user-profile-inner-container">
									<section class="user-profile-section1">
										<img alt="대표이미지" src="/images/${user.user_img ne '' ? user.user_img : 'usersDefaultImg.png'}">
										<div class="user-profile-text-box">
											<a class="user-profile-nickname"
												href='/itemListUser.do?user_no=${user.user_no}'>${user.user_nickname}</a>
											<span class="user-profile-dong"> <a
													href='/listItem.do?filter=true&gu=${user.user_gu}&dong=${user.user_dong}'>${user.user_dong}</a>
											</span>
										</div>
									</section>
									<section class="user-profile-section2">
										<div class="user-profile-inner-section">
											<div class="user-profile-inner-box1">
												<span class="user-profile-deg">${user.user_deg}℃</span> <span
													class="user-profile-emoji">${emoji}</span>
											</div>
											<div class="user-profile-inner-box2">
												<progress value="${user.user_deg}" max="100"></progress>
											</div>
											<div class="user-profile-inner-box3">
												<p class="ondo-label">매너온도</p>
											</div>
										</div>
									</section>
								</div>
							</div>
							<!-- 유저 프로필 끝 -->
						</div>

						<div class="itemtxt">
							<div class="text">
								<h2>${item.item_name}</h2>
								<span><a href='/listItem.do?filter=true&category_no=${item.item_category_no}'>${categoryName}</a> ∙ ${updateTime}</span>
								<input type="hidden" class="item-status-value" value="${item.item_status}">
								<c:choose>
									<c:when test="${item.item_status == 2}">
										<h3><span class="item-status">예약중</span>&nbsp;${infoItemPrice}원</h3>
									</c:when>
									<c:when test="${item.item_status == 3}">
										<h3><span class="item-status">판매완료</span>&nbsp;${infoItemPrice}원</h3>
									</c:when>
									<c:otherwise>
										<h3>${infoItemPrice}원</h3>	
									</c:otherwise>
								</c:choose>
								<p>${ item.item_content }</p>
								<span>찜 <span id="zzim-count">${zzimCount}</span></span> <span>
									· 조회수 ${item.item_hits}</span> <br />
								<div class="btn-box">
									<c:choose>
										<c:when test="${item.user_no ne log}">
											<input type="hidden" name="user_no" id="user_no" value="${ item.user_no }">
											<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="3">
											<input type="hidden" name="link_no" id="link_no" value="${ item.item_no }">
											<input type="hidden" name="isZzim" id="isZzim" value="${ isZzim ne null ? isZzim : 0}">
											<c:choose>
												<c:when test="${isZzim == 0 or log eq null}">
													<button type="button" class="add-zzim-btn" id="btn-zzim" onclick="sendAlarm()">찜하기</button>
												</c:when>
												<c:otherwise>
													<button type="button" class="remove-zzim-btn" id="btn-zzim" onclick="sendAlarm()">찜취소</button>
												</c:otherwise>
											</c:choose>
											<form action="/insertLetter.do" method="post">
												<input type="hidden" id="receive_user_no" name="receive_no" value="${item.user_no}"> <input
													type="hidden" id="item_no" name="send_user_no" value="${item.item_no}">
												<input type="hidden" id="alarm_category_no" name="alarm_category_no" value="6">
												<button type="button" class="send-letter-btn" onclick="openPop('send')">쪽지
													보내기</button>
											</form>
										</c:when>
										<c:when test="${item.user_no eq log and log ne null}">
											<form action="/updateItem.do" method="post">
												<input type="hidden" name="item_no" value="${item.item_no}">
												<button class="btn btn-submit">상품 수정하기</button>
											</form>
										</c:when>
									</c:choose>
								</div>
								<div class="guid-box">
									<h3>거래 희망 장소</h3>
									<div id="map" style="width: 472px; height: 200px;"></div>
									<input type="hidden" id="user_dir_y" value="${user.user_dir_y}">
									<input type="hidden" id="user_dir_x" value="${user.user_dir_x}">
								</div>
							</div>
						</div>
					</div>
					<hr>
					<div class="salelist">
						<div class="saletxt">
							<c:choose>
								<c:when test="${user.user_no eq log}">
									<h3>나의 판매물품</h3>
								</c:when>
								<c:otherwise>
									<h3>${user.user_nickname}님의판매물품</h3>
								</c:otherwise>
							</c:choose>
							<c:if test="${checkInfoItemSize > 6}">
								<a href='/itemListUser.do?user_no=${user.user_no}'>더 구경하기</a>
							</c:if>
						</div>
						<div class="saleitems">
							<c:choose>
								<c:when test="${empty itemList}">
									<p>${user.user_nickname}님은판매중인물품이없습니다.</p>
								</c:when>
								<c:otherwise>
									<c:forEach var="i" begin="0" end="${itemList.size()-1}">
										<div class="child" style="cursor: pointer;"
											onclick="location.href='/infoItem.do?item_no=${itemList.get(i).item_no}'">
											<div class="saleimg">
												<img alt="대표 이미지" src="/images/${mainImgList.get(i)}">
											</div>
											<div class="saleprice">
												<p class="item-name" style="font-size:16px;">${itemList.get(i).item_name}</p>
												<h4 class="item-price" style="font-size:16px;">${itemPriceList.get(i)}원</h4>
												<span>${user.user_dong}</span> <span>
													<c:choose>
														<c:when test="${itemList.get(i).item_status == 2}">
															<span class="item-status">예약중</span>
														</c:when>
														<c:when test="${itemList.get(i).item_status == 3}">
															<span class="item-status">판매 완료</span>
														</c:when>
													</c:choose>
												</span>
											</div>
										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
					</div>

					<div class="bestitems">
						<div class="besttxt">
							<h3>인기매물</h3>
							<c:if test="${checkInfoItemSize > 18}">
								<a href='/listItem.do'>더 구경하기</a>
							</c:if>
						</div>
						<div class="bestitem">
							<c:forEach var="i" begin="0" end="${hotItemList.size()-1}">
								<div class="child" style="cursor: pointer;"
									onclick="location.href='/infoItem.do?item_no=${hotItemList.get(i).item_no}'">
									<div class="saleimg">
										<img alt="대표 이미지" src="/images/${hotImgList.get(i)}">
									</div>
									<div class="saleprice">
										<p class="item-name" style="font-size:16px;">${hotItemList.get(i).item_name}</p>
										<h4 class="item-price" style="font-size:16px;">${hotItemPriceList.get(i)}원</h4>
										<span>${hotItemUserDongList.get(i)}</span>
										<c:choose>
											<c:when test="${hotItemList.get(i).item_status == 2}">
												<span class="item-status">예약중</span>
											</c:when>
											<c:when test="${hotItemList.get(i).item_status == 3}">
												<span class="item-status">판매완료</span>
											</c:when>
										</c:choose>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</section>
		<%@ include file="../main/footer.jsp" %>

			<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services,clusterer,drawing"></script>
			<script src="../../js/letter.js"></script>
			<script src="../../js/itemInfoSwiper.js"></script>
			<script src="../../js/item.js"></script>