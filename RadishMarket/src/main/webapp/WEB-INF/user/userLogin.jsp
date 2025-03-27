<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
<link rel="stylesheet" href="../../css/login.css">
<section>
<div class="dir-history">
	<a href='/index.jsp'>홈 > </a>  <span>로그인</span>
</div>

<main>
      <div class="login">
        <div class="txt"><h1>LOGIN</h1></div>
        <form action="/login.do" method="post">
        <table>
          <tr>
            <td>
              <input
                type="text"
                name="user_id"
                id="user_id"
                placeholder="ID"
              /><!--id-->
            </td>
          </tr>
          <tr>
            <td>
              <input
                type="password"
                name="user_pw"
                id="user_pw"
                placeholder="PW"
              /><!--pw-->
            </td>
          </tr>
        </table>
        <div class="login-btn">
          <button class="btn">로그인</button
          ><!--로그인-->
          <button type="button" class="btn" onclick="location.href='/insertUser.do'">회원가입</button
          ><!--회원가입-->
        </div>
          </form>
      </div>
    </main>
</section>
<%@ include file="../main/footer.jsp"%>
