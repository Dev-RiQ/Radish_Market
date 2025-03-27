<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="../../css/meetInsert.css">
<section>

<div class="meet-insert-box">
    <div class="productsts">

      <div class="txt" style="border-bottom:1px solid #ddd ;">
        <h1>모임 수정</h1>
      </div>
<form action="/updateMeet.do?meet_no=${ meetInfo.meet_no }" method="post">
      <div class="txt">
        <h3>카테고리<span>*</span></h3>
      </div> <!--모임등록 유형 카테고리-->
       <select class="category" name="meet_category_no" id="meet_category_no">
			<c:forEach var="category" items="${ meetCategoryList }">
				<option value="${ category.meet_category_no }" ${ category.meet_category_no == meetInfo.meet_category_no ? 'selected' : '' }>${ category.meet_category_name }</option>
			</c:forEach>
		</select>


      <div class="txt">
        <h3>모임 이름<span> *</span></h3>
      </div>
      <input type="text" name="meet_title" id="meet_title" value="${ meetInfo.meet_title }">
		<span id="title_check"></span>

      <div class="txt">
        <h3>모임 설명<span> *</span></h3>
      </div>
      <textarea name="meet_content" id="meet_content" >${ meetInfo.meet_content }</textarea>
	<span id="content_check"></span>

      <div class="txt">
        <h3>나이</h3>
      </div>

      <div class="ages">
        <input type="number" name="age_min" id="age_min" value="${ meetInfo.age_min }"> ~ 
		<input type="number" name="age_max" id="age_max" value="${ meetInfo.age_max }">
      </div>
		<div class="ages-span">
		<span id="age_min_check"></span> 
		<span id="age_max_check"></span>
      </div>

      <div class="txt" style="margin-bottom: 10px;">
        <h3>프로필 이미지</h3>
      </div>

      <div class="imguplod">
		<div id="post-list">
			<img alt="프로필" src="/images/${ meetInfo.meet_img ne null || meetInfo.meet_img.isBlank() ? 'meetsDefaultImg.png' : meetInfo.meet_img }">
		</div><br>
		<c:if test="${ meetInfo.meet_img eq null || meetInfo.meet_img.isBlank() }">
			<input type="hidden" name="meet_img" id="meet_img" placeholder="이미지" readonly>
		</c:if>
		<c:if test="${ meetInfo.meet_img ne null && !meetInfo.meet_img.isBlank() }">
			<input type="hidden" name="meet_img" id="meet_img" value="${ meetInfo.meet_img }"><br>
		</c:if>
		<button type="button" id="btn_meet_img" onclick="openPop()">이미지 업로드</button>
      </div>

		<input type="hidden" name="meet_gu" id="meet_gu" value="${ user.user_gu }">
		<input type="hidden" name="meet_dong" id="meet_dong" value="${ user.user_dong }">


      <div class="registrationbtn">
        <button type="button" onclick="history.back()">취소</button>
        <button class="rbtn" type="button" onclick="validCheck()">수정하기</button>
      </div>
</form>
    </div>
  </div>
</section>
<%@ include file="../main/footer.jsp" %>
<script src="../../js/meetInsertValidCheck.js"></script>
<script src="../../js/singleFileUpload.js"></script>
