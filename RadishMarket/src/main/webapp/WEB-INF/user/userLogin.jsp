<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>

<div class="dir-history">
	<a href='/index.jsp'>홈 > </a>  <span>로그인</span>
</div>

<form action="/login.do" method="post">
	<input type="text" name="user_id" id="user_id" placeholder="아이디"><br>
	<input type="text" name="user_pw" id="user_pw" placeholder="비밀번호"><br>
	<button>로그인</button>
</form>

<%@ include file="../main/footer.jsp"%>
<script src="../../js/user.js"></script>