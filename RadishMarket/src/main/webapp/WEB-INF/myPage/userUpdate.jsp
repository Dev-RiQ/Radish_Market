<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 > </a> <span>프로필 수정</span>
	</div>

<form action="/updateUser.do" method="post">
	
	
	<label for="user_id">아이디</label>
	<input type="text" name="user_id" id="user_id" value="${ user.user_id }"  readonly>
	<span id="id_check"></span>
	<br>
	<label for="user_pw">비밀번호</label>
	<input type="text" name="user_pw" id="user_pw" value="${ user.user_pw }" >
	<span id="pw_check"></span>
	<br>
	<label for="user_name">이름</label>
	<input type="text" name="user_name" id="user_name" value="${ user.user_name }" >
	<span id="name_check"></span>
	<br>
	<label for="user_age">나이</label>
	<input type="number" name="user_age" id="user_age" value="${ user.user_age }" readonly><br>
	<span id="age_check"></span>
	<br>
	<label for="user_email">이메일</label>
	<input type="text" name="user_email" id="user_email" value="${ user.user_email.split('@')[0] }" >@
	<select name="user_email" id="user_email">
		<option value="@naver.com" ${ user.user_email.split('@')[1] == 'naver.com' ? 'selected' : '' }>naver.com</option>
		<option value="@google.com" ${ user.user_email.split('@')[1] == 'google.com' ? 'selected' : '' }>google.com</option>
		<option value="@hanmail.net" ${ user.user_email.split('@')[1] == 'hanmail.net' ? 'selected' : '' }>hanmail.net</option>
		<option value="@">직접입력</option>
	</select>
	<input class="hide" type="text" name="user_email" id="user_email" placeholder="이메일">
	<span id="email_check"></span>
	<br>
	<label for="user_nickname">닉네임</label>
	<input type="text" name="user_nickname" id="user_nickname" value="${ user.user_nickname }" >
	<span id="nickname_check"></span>
	<br>
	<label for="user_img">이미지</label>
	<div id="post-list">
		<img alt="프로필" src="/images/${ user.user_img ne null || user.user_img.isBlank() ? usersDefaultImg.png : user.user_img }">
	</div><br>
	<c:if test="${ user.user_img eq null || user.user_img.isBlank() }">
		<input type="text" name="user_img" id="user_img" placeholder="이미지" readonly>
	</c:if>
	<c:if test="${ user.user_img ne null && !user.user_img.isBlank() }">
		<input type="text" name="user_img" id="user_img" value="${ user.user_img }" readonly><br>
	</c:if>
	<button type="button" onclick="openPop()">이미지 변경</button>
	<br>
	<label for="user_phone">전화번호</label>
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
	<br>
	<label for="user_address">주소</label>
	<input type="text" name="user_address" id="user_address" value="${ user.user_address }"  readonly><br>
	<input type="button" id="btn_user_address" onclick="execDaumPostcode()" value="주소 변경">
	<span id="address_check"></span>
	<br>
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