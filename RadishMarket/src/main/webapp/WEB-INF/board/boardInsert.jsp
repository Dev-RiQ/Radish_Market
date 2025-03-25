<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="../../css/boardInsert.css">

<section>
<div class="board-insert-box">
      <div class="productsts">
      	<form action="/insertBoard.do" method="post">
	        <div class="txt" style="border-bottom: 1px solid #ddd">
	          <h1>게시글 작성</h1>
	        </div>
	
	        <div class="txt">
	          <h3>카테고리<span>*</span></h3>
	        </div>
	        <select class="category" name="board_category_no" id="board_category_no">
				<c:forEach var="category" items="${ boardCategoryList }">
					<option value="${ category.board_category_no }">${ category.board_category_name }</option>
				</c:forEach>
			</select>
			
			<c:choose>
				<c:when test="${ meet_no ne null }">
					<input type="text" name="meet_no" id="meet_no" value="${ meet_no }" readonly><br>
				</c:when>
				<c:otherwise>
					<input type="hidden" name="meet_no" id="meet_no" value=0>
				</c:otherwise>
			</c:choose>
	
	        <div class="txt">
	          <label for="board_title">글 제목<span> *</span></label>
	        </div>
			<input type="text" name="board_title" id="board_title" placeholder="제목">
			<span id="title_check"></span>
	
	        <div class="txt">
	          <label for="board_content">내용<span> *</span></label>
	        </div>
			<textarea name="board_content" id="board_content" placeholder="내용"></textarea>
			<span id="content_check"></span>
	
	        <div class="txt" style="margin-bottom: 10px">
	        	<label for="board_img">이미지</label>
	        </div>
	
	        <div class="imguplod">
				<div id="post-list"></div><br>
				<input type="hidden" name="board_img" id="board_img" placeholder="이미지" readonly>
				<button type="button" onclick="openPop()">이미지 업로드</button>
	        </div>
	
			<input type="hidden" name="board_gu" id="board_gu" value="${ user.user_gu }">
			<input type="hidden" name="board_dong" id="board_dong" value="${ user.user_dong }">
	
	        <div class="registrationbtn">
	            <button onclick="history.back()">취소</button>
				<button class="rbtn" type="button" onclick="validCheck()">등록하기</button>
	        </div>
        </form>
      </div>
    </div>
</section>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/boardInsertValidCheck.js"></script>
<script src="../../js/singleFileUpload.js"></script>
<script src="../../js/board.js"></script>