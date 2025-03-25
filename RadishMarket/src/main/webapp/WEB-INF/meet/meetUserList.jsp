<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="../../css/meetUserList.css">
<section>
		<button onclick="location.href='/infoMeet.do?meet_no=${ meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }'">모임 홈</button>
	<div class="meet-user-list-box">
      <div class="memberlist">
        <div class="mtlogo">
        <img alt="대표이미지" src="/images/${ meet.meet_img ne '' ? meet.meet_img : 'meetsDefaultImg.png' }">
          <h3>관악/홍대 서브컬처 오타쿠 모임</h3><!--모임 이름-->
        </div>
        <div class="members">
<c:forEach var="user" items="${meet_user_list}">
          <div class="mbprofile">
            <div class="m">
	            <div class="img-box">
	              <img alt="대표이미지" src="/images/${ user.user_img ne '' ?  user.user_img : 'usersDefaultImg.png' }">
              </div>
              <div class="mname">
                <p>${ user.user_nickname } <br /><span>${ user.user_dong }</span></p><!--멤버 이름 상태 메세지-->
              </div>
              <div class="ondo">
                   <div class="ondos">
                     <p style="font-size: 17px;">${ user.user_deg }℃ <br> <progress id="file" value="${ user.user_deg }" max="100"></progress></p><!--온도-->
                   
                   </div>
                   <div class="empticon">
                     <p style="font-size: 35px;">😆</p><!--이모티콘 상태-->
                   </div>
            </div>
            </div>
          </div>
</c:forEach>
        </div>
      </div>
    </div>
</section>

<%@ include file="../main/footer.jsp" %>