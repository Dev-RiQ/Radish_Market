<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<div class="dir-history">
	<a href='/index.jsp'>홈 > </a>  <span>회원가입</span>
</div>

<form action="/insertUser.do" method="post">
	<label for="user_id">아이디</label>
	<input type="text" name="user_id" id="user_id" placeholder="아이디">
	<button type="button" onclick="idValidCheck()">중복체크</button>
	<span id="id_check"></span>
	<br>
	<label for="user_pw">비밀번호</label>
	<input type="text" name="user_pw" id="user_pw" placeholder="비밀번호">
	<span id="pw_check"></span>
	<br>
	<label for="user_name">이름</label>
	<input type="text" name="user_name" id="user_name" placeholder="이름">
	<span id="name_check"></span>
	<br>
	<label for="user_age">나이</label>
	<input type="number" name="user_age" id="user_age" value="20">
	<span id="age_check"></span>
	<br>
	<label for="user_email">이메일</label>
	<input type="text" name="user_email" id="user_email" placeholder="이메일">@
	<select name="user_email" id="user_email">
		<option value="@naver.com">naver.com</option>
		<option value="@google.com">google.com</option>
		<option value="@hanmail.net">hanmail.net</option>
		<option value="@">직접입력</option>
	</select>
	<input class="hide" type="text" name="user_email" id="user_email" placeholder="이메일">
	<span id="email_check"></span>
	<br>
	<label for="user_nickname">닉네임</label>
	<input type="text" name="user_nickname" id="user_nickname" placeholder="닉네임">
	<span id="nickname_check"></span>
	<br>
	<label for="user_img">이미지</label>
	<div id="post-list"></div><br>
	<input type="text" name="user_img" id="user_img" placeholder="이미지" readonly>
	<button type="button" onclick="openPop()">이미지 등록</button>
	<br>
	<label for="user_phone">전화번호</label>
	<select name="user_phone" id="user_phone">
		<option value="010">010</option>
		<option value="011">011</option>
		<option value="016">016</option>
		<option value="017">017</option>
		<option value="019">019</option>
	</select>
	<input type="number" name="user_phone" id="user_phone">
	<input type="number" name="user_phone" id="user_phone">
	<span id="phone_check"></span>
	<br>
	<label for="user_address">주소</label>
	<input type="text" name="user_address" id="user_address" placeholder="주소" readonly>
	<input type="button" id="btn_user_address" onclick="execDaumPostcode()" value="주소 찾기">
	<span id="address_check"></span>
	<br>
	<input type="hidden" name="user_city" id="user_city">
	<input type="hidden" name="user_gu" id="user_gu">
	<input type="hidden" name="user_dong" id="user_dong">
	<input type="hidden" name="user_dir_x" id="user_dir_x">
	<input type="hidden" name="user_dir_y" id="user_dir_y">
	<button type="button" onclick="validCheck()">가입</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services,clusterer"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../../js/singleFileUpload.js"></script>
<script src="../../js/userJusoSearch.js"></script>
<script src="../../js/userInsertValidCheck.js"></script>
<script src="../../js/user.js"></script>