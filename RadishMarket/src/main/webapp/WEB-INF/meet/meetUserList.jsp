<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="../../css/meetUserList.css">
<section>
		<button onclick="location.href='/infoMeet.do?meet_no=${ meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }'">모임 홈</button>
	<div class="meet-user-list-box">
      <div class="memberlist">
        <div class="mtlogo">
        <div class="meet-img-box">
        <img alt="대표이미지" src="/images/${ meet.meet_img ne '' ? meet.meet_img : 'meetsDefaultImg.png' }">
        </div>
          <h3>관악/홍대 서브컬처 오타쿠 모임</h3><!--모임 이름-->
        </div>
        <div class="members">
<c:forEach var="i" begin="0" end="${ meet_user_list.size() - 1 }">
          <div class="mbprofile">
            <div class="m">
	            <div class="img-box">
	              <img alt="대표이미지" src="/images/${ meet_user_list.get(i).user_img ne '' ?  meet_user_list.get(i).user_img : 'usersDefaultImg.png' }">
              </div>
              <div class="mname">
                <p><a href="/itemListUser.do?user_no=${meet_user_list.get(i).user_no}">${ meet_user_list.get(i).user_nickname }</a> <br /><span>${ meet_user_list.get(i).user_dong }</span></p><!--멤버 이름 상태 메세지-->
              </div>
              <div class="ondo">
                   <div class="ondos">
                     <p style="font-size: 17px;">${ meet_user_list.get(i).user_deg }℃ ${ emojiList.get(i) }<br> <progress id="file" value="${ meet_user_list.get(i).user_deg }" max="100"></progress></p><!--온도-->
                   
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