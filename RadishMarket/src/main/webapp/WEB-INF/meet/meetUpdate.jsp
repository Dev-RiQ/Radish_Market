<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateMeet.do?meet_no=${ meetInfo.meet_no }" method="post">
	<select name="meet_category_no" id="meet_category_no">
		<c:forEach var="category" items="${ meetCategoryList }">
			<option value="${ category.meet_category_no }" ${ category.meet_category_no == meetInfo.meet_category ? 'selected' : '' }>${ category.meet_category_name }</option>
		</c:forEach>
	</select>
	<label for="meet_title">제목</label>
	<input type="text" name="meet_title" id="meet_title" value="${ meetInfo.meet_title }"><br>
	<span id="title_check"></span>
	<br>
	<label for="meet_content">내용</label>
	<textarea name="meet_content" id="meet_content" >${ meetInfo.meet_content }</textarea><br>
	<span id="content_check"></span>
	<br>
	<label for="age_min">최소 나이</label>
	<input type="number" name="age_min" id="age_min" value="${ meetInfo.age_min }"><br>
	<span id="age_min_check"></span>
	<br>
	<label for="age_max">최대 나이</label>
	<input type="number" name="age_max" id="age_max" value="${ meetInfo.age_max }"><br>
	<span id="age_max_check"></span>
	<br>
	<label for="meet_img">이미지</label>
	<div id="post-list">
		<img alt="프로필" src="/images/${ meetInfo.meet_img ne null || meetInfo.meet_img.isBlank() ? meetsDefaultImg.png : meetInfo.meet_img }">
	</div><br>
	<c:if test="${ meetInfo.meet_img eq null || meetInfo.meet_img.isBlank() }">
		<input type="text" name="meet_img" id="meet_img" placeholder="이미지" readonly>
	</c:if>
	<c:if test="${ meetInfo.meet_img ne null && !meetInfo.meet_img.isBlank() }">
		<input type="text" name="meet_img" id="meet_img" value="${ meetInfo.meetInfo.meet_img }"><br>
	</c:if>
	<button type="button" id="btn_meet_img" onclick="openPop()">이미지 등록</button>
	
	<input type="hidden" name="meet_gu" id="meet_gu" value="${ user.user_gu }">
	<input type="hidden" name="meet_dong" id="meet_dong" value="${ user.user_dong }">
	
	<button type="button" onclick="validCheck()">수정하기</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/meetInsertValidCheck.js"></script>
<script src="../../js/singleFileUpload.js"></script>
<script src="../../js/board.js"></script>