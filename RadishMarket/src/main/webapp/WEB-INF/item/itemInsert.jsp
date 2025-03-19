<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="item-insert-container">

	<form action="/insertItem.do" method="post">
		<input type="hidden" id="user_itme_img" name="user_itme_img" />
		<div class="post-list" id="post-list">
			<!-- 사진 들어오는 공간 -->
		</div>
		<input type="file" id="ofile" name="ofile" multiple />
		<div class="save-filename" id="save-filename"></div>
		<hr>
		<label>제목<input type="text" name="item_name" placeholder="제목"
			required></label><br> <label>카테고리<select
			id="item_category_no" name="item_category_no">
				<c:forEach var="category" items="${itemCategoryList}">
					<option value="${category.item_category_no}">${category.item_category_name}</option>
				</c:forEach>
		</select></label><br> 
		<label>거래 가격<input type="number" name="item_price"
			placeholder="₩ 가격을 입력해주세요." required></label><br> 
			<label>자세한 설명<textarea name="item_content"
				placeholder="${user_dong}에 올릴 게시글 내용을 작성해 주세요. (판매 금지 물품은 게시가 제한될 수 있어요.) 신뢰할 수 있는 거래를 위해 자세히 적어주세요. 과학기술정보통신부, 한국 인터넷진흥원과 함께 해요."
				required></textarea>
		</label><br>
		<button class="btn submit-btn" type="submit">작성 완료</button>
	</form>
</div>
<script src="../../js/multiFile.js"></script>
<%@ include file="../main/footer.jsp"%>