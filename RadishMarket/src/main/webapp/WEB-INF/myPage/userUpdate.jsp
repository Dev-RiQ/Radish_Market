<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateUser.do" method="post">
	<label for="user_id">아이디</label>
	<input type="text" name="user_id" id="user_id" value="${ user.user_id }"  readonly>
	<br>
	<label for="user_pw">비밀번호</label>
	<input type="text" name="user_pw" id="user_pw" value="${ user.user_pw }" >
	<span class="pw_length_check hide">8~ 16자 입력</span>
	<span class="pw_value_check hide">영어, 숫자, 특수문자 모두 포함 입력</span><br>
	
	<label for="user_name">이름</label>
	<input type="text" name="user_name" id="user_name" value="${ user.user_name }" >
	<span class="name_length_check hide">2~ 10자 입력</span>
	<span class="name_value_check hide">한글만 입력</span><br>
	<label for="user_age">나이</label>
	<input type="number" name="user_age" id="user_age" value="${ user.user_age }" readonly><br>
	<label for="user_email">이메일</label>
	<input type="text" name="user_email" id="user_email" value="${ user.user_email.split('@')[0] }" >@
	<select name="user_email" id="user_email">
		<option value="@naver.com" ${ user.user_email.split('@')[1] == 'naver.com' ? 'selected' : '' }>naver.com</option>
		<option value="@google.com" ${ user.user_email.split('@')[1] == 'google.com' ? 'selected' : '' }>google.com</option>
		<option value="@hanmail.net" ${ user.user_email.split('@')[1] == 'hanmail.net' ? 'selected' : '' }>hanmail.net</option>
		<option value="@">직접입력</option>
	</select>
	<label></label>
	<input class="hide" type="text" name="user_email" id="user_email" placeholder="이메일">
	<span class="email_value_check hide">test@example.com 형식으로 입력</span><br>
	<label for="user_nickname">닉네임</label>
	<input type="text" name="user_nickname" id="user_nickname" value="${ user.user_nickname }" >
	<span class="nickname_length_check hide">2~6자 입력</span>
	<span class="nickname_value_check hide">사용할 수 없는 닉네임입니다.</span><br>
	
	<label for="user_img">이미지</label>
	<div id="post-list">
		<img alt="프로필" src="/images/${ imageName }">
	</div><br>
	<input type="text" name="user_img" id="user_img" value="${ user.user_img }" readonly><br>
	<button type="button" onclick="openPop()">이미지 등록</button>
	<label for="user_phone">전화번호</label>
	<select name="user_phone" id="user_phone">
		<option value="010" ${ user.user_phone.split('-')[0] == '010' ? 'selected' : '' }>010</option>
		<option value="011" ${ user.user_phone.split('-')[0] == '011' ? 'selected' : '' }>011</option>
		<option value="016" ${ user.user_phone.split('-')[0] == '016' ? 'selected' : '' }>016</option>
		<option value="017" ${ user.user_phone.split('-')[0] == '017' ? 'selected' : '' }>017</option>
		<option value="019" ${ user.user_phone.split('-')[0] == '019' ? 'selected' : '' }>019</option>
	</select>
	<input type="number" name="user_phone" id="user_phone" value="${ user.user_phone.split('-')[1] }">
	<label></label>
	<input type="number" name="user_phone" id="user_phone" value="${ user.user_phone.split('-')[2] }"><br>
	<span class="phone_value_check hide">올바르지 않은 전화번호입니다.</span>
	<label for="user_address">주소</label>
	<input type="text" name="user_address" id="user_address" value="${ user.user_address }"  readonly><br>
	<input type="button" onclick="execDaumPostcode()" value="주소 변경"><br>
	<input type="hidden" name="user_city" id="user_city" value="${ user.user_city }">
	<input type="hidden" name="user_gu" id="user_gu" value="${ user.user_gu }" >
	<input type="hidden" name="user_dong" id="user_dong" value="${ user.user_dong }" >
	<input type="hidden" name="user_dir_x" id="user_dir_x" value="${ user.user_dir_x }" >
	<input type="hidden" name="user_dir_y" id="user_dir_y" value="${ user.user_dir_y }" >
	<button type="button" onclick="validCheck()">수정</button>
	
</form>

<%@ include file="../main/footer.jsp" %>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services,clusterer"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../../js/userJusoSearch.js"></script>
<script src="../../js/userUpdateValidCheck.js"></script>
<script src="../../js/user.js"></script>