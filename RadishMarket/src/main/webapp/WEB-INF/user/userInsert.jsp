<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="../../css/userInsert.css">

<section>
<div class="dir-history">
	<a href='/index.jsp'>홈 > </a><span>회원가입</span>
</div>

<main>
      <div class="insert">
        <div class="insert-check">
        <form action="/insertUser.do" method="post">
          <label for="user_id">아이디 <b>*</b></label>
          <input type="text" name="user_id" id="user_id" /><!--id-->
          <button type="button" onclick="idValidCheck()" id="id-btn">
            중복체크</button
          ><!--중복체크-->
          <br />
          <span id="id_check"></span>
          <br />
          <label for="user_pw">비밀번호 <b>*</b></label>
          <input type="text" name="user_pw" id="user_pw" /><!--pw-->
          <br />
          <span id="pw_check"></span>
          <br />
          <label for="user_name">이름 <b>*</b></label>
          <input type="text" name="user_name" id="user_name" /><!--이름-->
          <br />
          <span id="name_check"></span>
          <br />
          <label for="user_age">나이 <b>*</b></label>
          <input
            type="number"
            name="user_age"
            id="user_age"
            value="20"
          /><!--나이-->
          <br />
          <span id="age_check"></span>
          <br />
          <label for="user_email">Email <b>*</b></label
          ><!--이메일-->
          <input type="text" name="user_email" id="user_email" />@
          <select name="user_email" id="user_email">
            <!--이메일 유형-->
            <option value="@naver.com">naver.com</option>
            <option value="@google.com">google.com</option>
            <option value="@hanmail.net">hanmail.net</option>
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
          <input
            type="text"
            name="user_nickname"
            id="user_nickname"
          /><!--닉네임-->
          <br />
          <span id="nickname_check"></span>
          <br />
		<div class="img-box">
          <label for="user_img">프로필 <b>*</b></label
          ><!---->
          <div id="post-list"></div>
          <br />
          <input type="hidden" name="user_img" id="user_img" readonly />

          <button type="button" onclick="openPop()" id="img-btn">
            <!--이미지 업로드-->
            프로필 등록
          </button>
		</div>
          <br />
          <label for="user_phone">전화번호 <b>*</b></label
          ><!--번호 앞자리 -->
          <select name="user_phone" id="user_phone">
            <option value="010">010</option>
            <option value="011">011</option>
            <option value="016">016</option>
            <option value="017">017</option>
            <option value="019">019</option>
          </select>
          <abbr class="ab">-</abbr>
          <input
            type="number"
            name="user_phone"
            id="user_phone"
          /><!--중간 번호-->
          <abbr>-</abbr>
          <input
            type="number"
            name="user_phone"
            id="user_phone"
          /><!--끝 번호-->
          <br />
          <span id="phone_check"></span>
          <br />
          <label for="user_address">주소 <b>*</b></label>
          <input
            type="text"
            name="user_address"
            id="user_address"
            readonly
          /><!--주소 찾기-->
          <input
            type="button"
            onclick="execDaumPostcode()"
            value="주소 찾기"
            id="btn_user_address"
          />
          <br />
			<span id="address_check"></span>
          <br />
          <input type="hidden" name="user_city" id="user_city" />
          <input type="hidden" name="user_gu" id="user_gu" />
          <input type="hidden" name="user_dong" id="user_dong" />
          <input type="hidden" name="user_dir_x" id="user_dir_x" />
          <input type="hidden" name="user_dir_y" id="user_dir_y" />
        </form>
        </div>
        <div class="insert-buttons">
          <p>회원가입</p>
          <!--회원 가입-->
          <button type="button" id="insert-btn" onclick="validCheck()">
            <i class="fa-solid fa-arrow-right"></i>
          </button>
        </div>
      </div>
    </main>

</section>
<%@ include file="../main/footer.jsp" %>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services,clusterer"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../../js/singleFileUpload.js"></script>
<script src="../../js/userJusoSearch.js"></script>
<script src="../../js/userInsertValidCheck.js"></script>
