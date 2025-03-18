<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="item-info-container">
	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/listItem.do'>중고거래 > </a> <span>${item.item_name}</span>
	</div>
	<div class="fir-box">
		<div class="img-box">
			<div class="swiper mySwiper">
				<div class="swiper-wrapper">
					<c:choose>
						<c:when test="${itemImgList eq null or itemImgList.size() == 0}">
							<p>서버 오류로 이미지를 불러오지 못 했습니다.</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="i" begin="0" end="${itemImgList.size()-1}">
								<div class="swiper-slide">
									<img alt="item-images" src="/images/${itemImgList.get(i)}">
								</div>
							</c:forEach>
							<div class="swiper-pagination"></div>
							<div class="swiper-button-next"></div>
							<div class="swiper-button-prev"></div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="user-box">
				<img alt="" src="">유저 이미지 <a
					href='/userpageUser.do?user_no=${user.user_no}'>${user.user_nickname}</a>
				<a href='/listItem.do?user_dong=${user.user_dong}'>${user.user_dong}</a>
				<p>${user.user_deg}℃${emoji}</p>
				<progress id="progress" value="${user.user_deg}" min="0" max="100"></progress>
				<p>매너 온도</p>
				<hr>
			</div>
		</div>
		<div class="sec-box">
			<h3>${item.item_name}</h3>
			<a href="카테고리 생기면...">${item_category_name}</a>
			<p>${updateTime}</p>
			<a href='/listItem.do?item_no=${item.item_no}'>${categoryName}</a>
			<p>${item.item_price}원</p>
			<p>${item.item_content}</p>
			<span>찜 개수<span id="zzim-count">${zzimCount}</span>
			</span><span>조회수 ${item.item_hits}</span>
		</div>
		<c:choose>
			<c:when test="${item.user_no ne log}">
				<div class="btn-box">
					<input type="hidden" name="user_no" id="user_no"
						value="${ item.user_no }"> <input type="hidden"
						name="alarm_category_no" id="alarm_category_no" value="3">
					<input type="hidden" name="link_no" id="link_no"
						value="${ item.item_no }"> <input type="hidden"
						name="isZzim" id="isZzim" value="${ isZzim }">
					<c:choose>
						<c:when test="${isZzim == 0}">
							<button type="button" onclick="sendAlarm()">찜하기</button>
						</c:when>
						<c:otherwise>
							<button type="button" onclick="sendAlarm()">찜취소</button>
						</c:otherwise>
					</c:choose>
					<form action="/insertLetter.do" method="post">
						<input type="hidden" id="receive_user_no" name="receive_no" value="${item.user_no}">
						<input type="hidden" id="item_no"  name="send_user_no" value="${item.item_no}">
						<input type="hidden" id="alarm_category_no"  name="alarm_category_no" value="6">
						<button type="button" onclick="openPop('send')" value="${user.user_no}">쪽지 보내기</button>
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
			<hr>
			<h3>거래 희망 장소</h3>
			<div id="map" style="width: 500px; height: 400px;"></div>
		</div>
	</div>
	<input type="hidden" id="user_dir_y" value="${user.user_dir_y}">
	<input type="hidden" id="user_dir_x" value="${user.user_dir_x}">
	<hr>

	<div class="seller-container">
		<div class="seller-box">
			<div class="seller-info-box">
				<c:choose>
					<c:when test="${user.user_no eq log}">
						<h3>나의 판매물품</h3>
					</c:when>
					<c:otherwise>
						<h3>${user.user_nickname}님의판매물품</h3>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${itemList eq null or itemList.size() == 0}">
						<p>${user.user_nickname}님은판매중인물품이 없습니다.</p>
					</c:when>
					<c:otherwise>
						<c:if test="${userAllItemListSize > 6}">
							<a href='/userpageUser.do?user_no=${user.user_no}'>더 구경하기</a>
						</c:if>
						<c:forEach var="i" begin="0"
							end="${itemList.size()-1 > 7 ? 6 : itemList.size()-1}">
							<div class="seller-item-box" style="cursor: pointer;"
								onclick="location.href='/infoItem.do?item_no=${itemList.get(i).item_no}'">
								<div class="seller-item-img">
									<img alt="대표 이미지" src="/images/${mainImgList.get(i)}">
								</div>
								<div class="seller-item">
									<p>${itemList.get(i).item_name}</p>
									<p>
										<span> <c:choose>
												<c:when test="${itemList.get(i).item_status == 2}">
										예약중
									</c:when>
												<c:when test="${itemList.get(i).item_status == 3}">
										판매 완료
									</c:when>
											</c:choose>
										</span> ${itemList.get(i).item_price}원
									</p>
									<p>${user.user_dong}</p>
									<hr>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

	<div class="hot-item-container">
		<div class="hot-item-box">
			<div class="hot-item-info">
				<h3>인기매물</h3>
				<a href='/listItem.do'>더 구경하기</a>
			</div>
			<c:forEach var="i" begin="0"
				end="${hotItemSortList.size()-1 > 18 ? 17 : hotItemSortList.size()-1}">
				<div class="hot-item-box" style="cursor: pointer;"
					onclick="location.href='/infoItem.do?item_no=${hotItemSortList.get(i).item_no}'">
					<div class="hot-item-img">
						<img alt="대표 이미지" src="/images/${hotImgList.get(i)}">
					</div>
					<div class="hot-item">
						<p>${hotItemSortList.get(i).item_name}</p>
						<p>
							<span> <c:choose>
									<c:when test="${hotItemSortList.get(i).item_status == 2}">
										예약중
									</c:when>
									<c:when test="${hotItemSortList.get(i).item_status == 3}">
										판매 완료
									</c:when>
								</c:choose>
							</span> ${hotItemSortList.get(i).item_price}원
						</p>
						<p>${hotUserNicknameList.get(i)}</p>
						<hr>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>

<%@ include file="../main/footer.jsp"%>

<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services,clusterer,drawing"></script>
<script src="../../js/letter.js"></script>
<script src="../../js/swiper.js"></script>
<script src="../../js/item.js"></script>