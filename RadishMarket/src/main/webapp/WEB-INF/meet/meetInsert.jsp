<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="../../css/meetInsert.css">
<section>
<div class="meet-insert-box">
    <div class="productsts">

      <div class="txt" style="border-bottom:1px solid #ddd ;">
        <h1>모임 등록</h1>
      </div>
<form action="/insertMeet.do" method="post">
      <div class="txt">
        <h3>카테고리<span>*</span></h3>
      </div> <!--모임등록 유형 카테고리-->
       <select class="category" name="meet_category_no" id="meet_category_no">
			<c:forEach var="category" items="${ meetCategoryList }">
				<option value="${ category.meet_category_no }">${ category.meet_category_name }</option>
			</c:forEach>
		</select>


      <div class="txt">
        <h3>모임 이름<span> *</span></h3>
      </div>
      <input type="text" name="meet_title" id="meet_title" placeholder="제목">
		<span id="title_check"></span>

      <div class="txt">
        <h3>모임 설명<span> *</span></h3>
      </div>
      <textarea name="meet_content" id="meet_content" placeholder="내용"></textarea>
	<span id="content_check"></span>

      <div class="txt">
        <h3>나이</h3>
      </div>

      <div class="ages">
        <input type="number" name="age_min" id="age_min" placeholder="최소"> ~ 
		<input type="number" name="age_max" id="age_max" placeholder="최대">
      </div>
      <br>
      <div class="ages-span">
		<span id="age_min_check"></span> 
		<span id="age_max_check"></span>
      </div>


      <div class="txt" style="margin-bottom: 10px;">
        <h3>프로필 이미지</h3>
      </div>

      <div class="imguplod">
        <div id="post-list"></div><br>
		<input type="hidden" name="meet_img" id="meet_img" placeholder="이미지" readonly>
		<button type="button" id="btn_meet_img" onclick="openPop()">이미지 업로드</button>
      </div>

		<input type="hidden" name="meet_gu" id="meet_gu" value="${ user.user_gu }">
		<input type="hidden" name="meet_dong" id="meet_dong" value="${ user.user_dong }">


      <div class="registrationbtn">
        <button type="button" onclick="history.back()">취소</button>
        <button class="rbtn" type="button" onclick="validCheck()">생성하기</button>
      </div>
</form>
    </div>
  </div>
</section>
<%@ include file="../main/footer.jsp" %>
<script src="../../js/meetInsertValidCheck.js"></script>
<script src="../../js/singleFileUpload.js"></script>
