<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="../../css/reviewInsert.css">
<section>
<div class="review-insert-box">
    <div class="lettergoings">
      <div class="lettertxt">
        <h2>Review 작성</h2>

      </div>
      <div class="propilreview">
      	<div class="user-profile-container">
			<div class="user-profile-inner-container">
				<section class="user-profile-section1">
					<img alt="대표이미지" src="/images/${user.user_img ne '' ? user.user_img : 'usersDefaultImg.png'}">
					<div class="user-profile-text-box">
						<a class="user-profile-nickname" href='/itemListUser.do?user_no=${user.user_no}'>${user.user_nickname}</a>
						<span class="user-profile-dong">
							<a style="margin-left:0;" href='/listItem.do?filter=true&gu=${user.user_gu}&dong=${user.user_dong}'>${user.user_dong}</a>
						</span>
					</div>
				</section>
				<section class="user-profile-section2">
					<div class="user-profile-inner-section">
						<div class="user-profile-inner-box1">
							<span class="user-profile-deg">${user.user_deg}℃</span> <span class="user-profile-emoji">${emoji}</span>
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
      </div>
      <div class="productletter">
      	<form action="/insertReview.do" method="post">
			<div class="productReview">
		        <div class="reviewimg">
					<img alt="대표이미지" src="/images/${item_img}">
		        </div>
		          <p style="margin-left: 10px; font-size: 15px; margin-bottom: 0px;">${item.item_name}<br>${infoItemPrice}원</p>
		      </div>
			<input type="hidden" name="item_no" id="item_no" value="${ item.item_no }">
			<input type="hidden" name="sell_user_no" id="sell_user_no" value="${ item.user_no }">
			<input type="hidden" name="buy_user_no" id="buy_user_no" value="${ log }">
			
	        <div class="text">
	
	          <div class="title">
	            <h3>내용<span> *</span></h3><!--내용-->
	          </div>
	            <textarea name="review_content" id="review_content"></textarea>
				<span id="content_check"></span>
	        </div>
	        <div class="stars">
	          <h3>${user.user_nickname}님과의 거래는 어떠셨나요?</h3>
	
	          <div class="star"><!--별 만족도-->
	            <label class="star-label">&#9733;
	              <input type="radio" id="review_deg" name="review_deg" class="star-radio" value="-2">
	            </label>
	
	            <label class="star-label">&#9733;
	              <input type="radio" id="review_deg" name="review_deg" class="star-radio" value="-1">
	            </label>
	
	            <label class="star-label">&#9733;
	              <input type="radio" id="review_deg" name="review_deg" class="star-radio" value="0">
	            </label>
	
	            <label class="star-label">&#9733;
	              <input type="radio" id="review_deg" name="review_deg" class="star-radio" value="1">
	            </label>
	
	            <label class="star-label">
	              <input type="radio" id="review_deg" name="review_deg" class="star-radio" value="2" checked>
	              &#9733;</label>
	
	          </div>
	        </div>
	        <div class="going">
	          <button type="button" onclick="validCheck()">보내기</button><!--리뷰 버튼-->
	          <button type="button" onclick="history.back()" class="delect">취소</button><!--취소 버튼-->
	        </div>
			
			<input type="hidden" name="user_no" id="user_no" value="${ item.user_no }">
			<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="4">
			<input type="hidden" name="link_no" id="link_no" value="">
		</form>
      
        
        
      </div>
  </div>
  </div>

</section>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/reviewInsertValidCheck.js"></script>