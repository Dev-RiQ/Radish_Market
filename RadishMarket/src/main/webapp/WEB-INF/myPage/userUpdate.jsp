<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="../../css/userInsert.css">
<link rel="stylesheet" href="../../css/userMypage.css">

<section>
	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 > </a> <span>프로필 수정</span>
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
          <button class="tablinks clicked" onclick="location.href='/updateUser.do'">
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
				<button>회원 정보 수정</button>
          </div>
          <div class="cartegorymenue">
          		<main>
      <div class="insert">
        <div class="insert-check">
        <form action="/updateUser.do" method="post">
          <label for="user_id">아이디 <b>*</b></label>
          <input type="text" name="user_id" id="user_id" value="${ user.user_id }"  readonly>
          <br />
          <span id="id_check"></span>
          <br />
          <label for="user_pw">비밀번호 <b>*</b></label>
          <input type="text" name="user_pw" id="user_pw" value="${ user.user_pw }" >
          <br />
          <span id="pw_check"></span>
          <br />
          <label for="user_name">이름 <b>*</b></label>
          <input type="text" name="user_name" id="user_name" value="${ user.user_name }" >
          <br />
          <span id="name_check"></span>
          <br />
          <label for="user_age">나이 <b>*</b></label>
          <input type="number" name="user_age" id="user_age" value="${ user.user_age }" readonly>
          <br />
          <span id="age_check"></span>
          <br />
          <label for="user_email">Email <b>*</b></label
          ><!--이메일-->
          <input type="text" name="user_email" id="user_email" value="${ user.user_email.split('@')[0] }" >@
			<select name="user_email" id="user_email">
				<option value="@naver.com" ${ user.user_email.split('@')[1] == 'naver.com' ? 'selected' : '' }>naver.com</option>
				<option value="@google.com" ${ user.user_email.split('@')[1] == 'google.com' ? 'selected' : '' }>google.com</option>
				<option value="@hanmail.net" ${ user.user_email.split('@')[1] == 'hanmail.net' ? 'selected' : '' }>hanmail.net</option>
				<option value="@">직접입력</option>
			</select>

          <input
            class="hide"
            type="text"
            name="user_email"
            id="user_email"
          /><!--이메일 직접 입력-->
          <br />
          <span id="email_check"></span>
          <br />
          <label for="user_nickname">닉네임 <b>*</b></label>
          <input type="text" name="user_nickname" id="user_nickname" value="${ user.user_nickname }" >
          <br />
          <span id="nickname_check"></span>
          <br />
		<div class="img-box">
          <label for="user_img">프로필<b>*</b></label
          ><!---->
          <div id="post-list">
          	<img alt="프로필" src="/images/${ user.user_img ne '' ? user.user_img : 'usersDefaultImg.png' }">
          </div>
          <br />
          <input type="hidden" name="user_img" id="user_img"  value="${ user.user_img }" readonly />
			
          <button type="button" onclick="openPop()" id="img-btn">
            <!--이미지 업로드-->
            프로필 변경
          </button>
		</div>
          <br />
          <label for="user_phone">전화번호 <b>*</b></label
          ><!--번호 앞자리 -->
          <select name="user_phone" id="user_phone">
				<option value="010" ${ user.user_phone.split('-')[0] == '010' ? 'selected' : '' }>010</option>
				<option value="011" ${ user.user_phone.split('-')[0] == '011' ? 'selected' : '' }>011</option>
				<option value="016" ${ user.user_phone.split('-')[0] == '016' ? 'selected' : '' }>016</option>
				<option value="017" ${ user.user_phone.split('-')[0] == '017' ? 'selected' : '' }>017</option>
				<option value="019" ${ user.user_phone.split('-')[0] == '019' ? 'selected' : '' }>019</option>
			</select>
			<input type="number" name="user_phone" id="user_phone" value="${ user.user_phone.split('-')[1] }">
			<input type="number" name="user_phone" id="user_phone" value="${ user.user_phone.split('-')[2] }"><br>
          <span id="phone_check"></span>
          <br />
          <label for="user_address">주소 <b>*</b></label>
          <input type="text" name="user_address" id="user_address" value="${ user.user_address }"  readonly>
          <input
            type="button"
            onclick="execDaumPostcode()"
            value="주소 찾기"
            id="btn_user_address"
          />
          <br />
			<span id="address_check"></span>
          <br />
          <input type="hidden" name="user_city" id="user_city" value="${ user.user_city }">
			<input type="hidden" name="user_gu" id="user_gu" value="${ user.user_gu }" >
			<input type="hidden" name="user_dong" id="user_dong" value="${ user.user_dong }" >
			<input type="hidden" name="user_dir_x" id="user_dir_x" value="${ user.user_dir_x }" >
			<input type="hidden" name="user_dir_y" id="user_dir_y" value="${ user.user_dir_y }" >
        </form>
        </div>
        <div class="insert-buttons">
          <p>정보 수정</p>
          <!--회원 가입-->
          <button type="button" id="insert-btn" onclick="validCheck()">
            <i class="fa-solid fa-arrow-right"></i>
          </button>
        </div>
      </div>
    </main>
          </div><!-- 내용-->
        </div>
      </div>
  </div>
 	 <button onclick="topFunction()" id="headerBtn" title="Go to top">
       <i class="fa-solid fa-angle-up"></i>
     </button>
  </div>
</section>


<section>


</section>
<%@ include file="../main/footer.jsp" %>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services,clusterer"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../../js/userJusoSearch.js"></script>
<script src="../../js/singleFileUpload.js"></script>
<script src="../../js/userUpdateValidCheck.js"></script>
