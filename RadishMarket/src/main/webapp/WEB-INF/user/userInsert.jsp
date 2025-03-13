<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="${ctx}/insertUser.do" method="post">
	<input type="text" name="user_id" id="user_id" placeholder="아이디"><br>
	<input type="text" name="user_pw" id="user_pw" placeholder="비밀번호"><br>
	<input type="text" name="user_name" id="user_name" placeholder="이름"><br>
	<input type="number" name="user_age" id="user_age" value="1"><br>
	<input type="text" name="user_email" id="user_email" placeholder="이메일"><br>
	<input type="text" name="user_nickname" id="user_nickname" placeholder="닉네임"><br>
	<input type="text" name="user_img" id="user_img" placeholder="이미지"><br>
	<input type="text" name="user_phone" id="user_phone" placeholder="전화번호"><br>
	<input type="text" name="user_address" id="user_address" placeholder="주소" readonly><br>
	<input type="button" onclick="execDaumPostcode()" value="주소 찾기"><br>
	<input type="hidden" name="user_city" id="user_city">
	<input type="hidden" name="user_gu" id="user_gu">
	<input type="hidden" name="user_dong" id="user_dong">
	<input type="hidden" name="user_dir_x" id="user_dir_x">
	<input type="hidden" name="user_dir_y" id="user_dir_y">
	<button>가입</button>
</form>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services,clusterer"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${ctx}/js/user.js"></script>