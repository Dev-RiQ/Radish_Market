<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>
<link rel="stylesheet" href="../../css/userMypage.css">
<link rel="stylesheet" href="../../css/itemList.css">

<section>
	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a>
		<c:choose>
			<c:when test="${log eq user.user_no}">
				<a href='/mypageUser.do'>마이페이지 > </a>
			</c:when>
			<c:otherwise>
				<a href='/mypageUser.do'>${user.user_nickname} > </a>
			</c:otherwise>
		</c:choose>
		<span>${user.user_nickname}</span>
	</div>
	
	<div class="user-mypage-box">
    <div class="mypag">
      <div class="myprofil">
        <table style="margin-left: 15px">
          <tr>
            <td rowspan="2">
            	<div class="user-img">
            		<img alt="대표이미지" src="/images/${ user.user_img ne '' ? user.user_img : 'usersDefaultImg.png' }">
            	</div>
            </td><!--프로필-->
          </tr>
          <tr>
            <td>
              <h3 style="font-size: 30px; margin-left: 5px">${user.user_nickname}</h3><!--이름-->
              <br />
              <span style="font-size: 13px; color: #5a5656; margin-left: 9px">${user.user_dong}</span><!--상태 메세지-->
            </td>
          </tr>
        </table>

        <div class="friend">
          <div class="temperature">
			<p>${user.user_deg}℃${emoji}</p>
            <progress id="file" value="${user.user_deg}" max="100"></progress>
            <p style="font-size: 40px; margin-left: 15px;">${emoji}</p><!--온도-->
            <p>매너온도</p>
          </div>

        </div>
      </div>

		<c:if test="${log ne user.user_no}">
			<input type="hidden" id="receive_user_no" name="receive_no" value="${user.user_no}">
			<button type="button" onclick="openPop('send')">쪽지 보내기</button>
		</c:if>



      <div class="menu">


        <div class="cartegory">
          <button class="tablinks" id="defaultOpen" onclick="location.href='/mypageUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-home" style="font-size: 20px; color: #000"></i>
              </div><span>마이페이지</span>
            </div>
          </button><!-- 프로필 수정-->
          <button class="tablinks" onclick="location.href='/updateUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-user" style="font-size: 20px; color: #000"></i>
              </div><span>프로필 수정</span>
            </div>
          </button><!-- 프로필 수정-->
          <button class="tablinks" onclick="location.href='/boardListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-folder" style="font-size: 20px; color:  #F7D358 "></i>
              </div><span>내 게시글</span>
            </div>
            <!--  내 게시글-->
          </button>
          <button class="tablinks" onclick="location.href='/listLetter.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-envelope" style="font-size: 20px;  color: #FF0080"></i>
              </div><span>쪽지함</span>
            </div>
            <!--  쪽지함-->
          </button>
          <button class="tablinks" onclick="location.href='/zzimListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-bookmark" style="font-size: 20px;  color: gray"></i>
              </div><span>찜목록</span>
            </div>
            <!--  찜목록-->
          </button>
          <button class="tablinks" style="background-color: #5FCC29 ; opacity:0.5; font-weight:bold;" onclick="location.href='/itemListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-gift" style="font-size: 20px;  color: skyblue"></i>
              </div><span>내 상품</span>
            </div>
            <!--  내 상품-->
          </button>
          <button class="tablinks" onclick="location.href='/cartListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-bag-shopping" style="font-size: 20px; color: pink"></i>
              </div><span>구매 내역</span>
            </div>
            <!--   구매 내역 -->
          </button>
          <button class="tablinks" onclick="location.href='/sellListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-piggy-bank" style="font-size: 20px; color: #5fcc29"></i>
              </div><span>판매 내역</span>
            </div>
            <!--    판매 내역-->
          </button>

          <button class="tablinks" onclick="location.href='/meetListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa fa-users" style="font-size: 20px;color: yellowgreen"></i>
              </div><span>내 모임</span>
            </div>
            <!--   내 모임<-->
          </button>
        </div>


        <div class="menulist">
          <div class="menulistbtn">
				<input type="hidden" id="item_status" value="1">
				<button class="list-btn" id="sell-btn" onclick="openList()">판매 물품(${sellListSize})</button>
				<button class="list-btn" id="review-btn" onclick="openList()">거래 후기(${reviewListSize}))</button>
          </div>
          <div class="cartegorymenue">
          		<p class="empty-info" id="boardList"></p>
          		<div class="item-list-box">
					<div class="product-child" id="list-box">
						<!-- 여기 리스트 출력 -->
					</div>
          		</div>
				<button class="addbtn" id="btn-more-list" value="${ alarm_no ne null ? 'review/0' : 'myItem/0' }" onclick="getMoreList()">더보기</button>
          </div><!-- 내용-->
        </div>
      </div>
  </div>
 	 <button onclick="topFunction()" id="headerBtn" title="Go to top">
       <i class="fa-solid fa-angle-up"></i>
     </button>
  </div>
</section>

<script src="../../js/mypageButtonToggle.js"></script>
<script src="../../js/letter.js"></script>
<%@ include file="../main/footer.jsp"%> 