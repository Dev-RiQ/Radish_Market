<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>
<link rel="stylesheet" href="../../css/userMypage.css">
<link rel="stylesheet" href="../../css/letterList.css">

<section>
	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 > </a> <span>쪽지함</span>
	</div>
	
	<div class="user-mypage-box">
    <div class="mypag">
      <div class="myprofil">
        <div class="user-profile-container">
			<div class="user-profile-inner-container">
				<section class="user-profile-section1">
					<img alt="대표이미지" src="/images/${user.user_img ne '' ? user.user_img : 'usersDefaultImg.png'}">
					<div class="user-profile-text-box">
						<a class="user-profile-nickname" href='/itemListUser.do?user_no=${user.user_no}'>${user.user_nickname}</a>
						<span class="user-profile-dong">
							<a href='/listItem.do?filter=true&gu=${user.user_gu}&dong=${user.user_dong}'>${user.user_dong}</a>
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
          <button class="tablinks clicked" onclick="location.href='/listLetter.do'">
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
          <button class="tablinks" onclick="location.href='/itemListUser.do'">
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
				<button class="list-btn" id="receive-btn" onclick="openList()">받은 쪽지 (${receiveLetterListSize})</button>
		<button class="list-btn" id="send-btn" onclick="openList()">보낸 쪽지 (${sendLetterListSize})</button>
          </div>
          <div class="cartegorymenue">
          		<p class="empty-info" id="boardList"></p>
          		<div class="letter-list-box">
          			<div class="mails">
				      <div class="state">
				        <table>
				          <tr>
				            <td style="width: 7%">상태</td>
				            <td id="for-user-th" style="width: 15%">보낸 사람</td>
				            <td style="width: 60%">내용</td>
				            <td style="width: 10%">날짜</td>
				            <td id="remove-letter-th">지우기</td>
				          </tr>
				        </table>
				      </div>
					<div id="list-box">
						<!-- 여기 리스트 출력 -->
					</div>
          		</div>
				<button class="addbtn" id="btn-more-list" value="receiveLetter/0" onclick="getMoreList()">더보기</button>
				</div>
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