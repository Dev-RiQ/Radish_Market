<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="../../css/meetUserList.css">
<section>
	<div class="meet-user-list-box">
      <div class="memberlist">
        <div class="mtlogo">
		<button onclick="location.href='/infoMeet.do?meet_no=${ meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }'">
			<i class="fa-solid fa-chevron-left"></i>
		</button>
        <div class="meet-img-box">
        <img alt="대표이미지" src="/images/${ meet.meet_img ne '' ? meet.meet_img : 'meetsDefaultImg.png' }">
        </div>
          <h3>관악/홍대 서브컬처 오타쿠 모임</h3><!--모임 이름-->
        </div>
        <div class="members">
<c:forEach var="i" begin="0" end="${ meet_user_list.size() - 1 }">
          <div class="mbprofile">
            	<div class="user-profile-container">
					<div class="user-profile-inner-container">
						<section class="user-profile-section1">
							 <img alt="대표이미지" src="/images/${ meet_user_list.get(i).user_img ne '' ?  meet_user_list.get(i).user_img : 'usersDefaultImg.png' }">
							<div class="user-profile-text-box">
								<a href="/itemListUser.do?user_no=${meet_user_list.get(i).user_no}">${ meet_user_list.get(i).user_nickname }</a>
								<span class="user-profile-dong">
									<a href='/listItem.do?filter=true&gu=${ meet_user_list.get(i).user_gu}&dong=${ meet_user_list.get(i).user_dong }'>${ meet_user_list.get(i).user_dong }</a>
								</span>
							</div>
						</section>
						<section class="user-profile-section2">
							<div class="user-profile-inner-section">
								<div class="user-profile-inner-box1">
									<span class="user-profile-deg">${ meet_user_list.get(i).user_deg }℃</span> <span class="user-profile-emoji">${ emojiList.get(i) }</span>
								</div>
								<div class="user-profile-inner-box2">
									<progress value="${ meet_user_list.get(i).user_deg }" max="100"></progress>
								</div>
								<div class="user-profile-inner-box3">
									<p class="ondo-label">매너온도</p>
								</div>
							</div>
						</section>
					</div>
				</div>
          </div>
</c:forEach>
        </div>
      </div>
    </div>
</section>

<%@ include file="../main/footer.jsp" %>