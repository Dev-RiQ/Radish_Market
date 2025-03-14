<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="item-update-container">
	<form action="/updateItem.do" method="post">
		<input type="hidden" name="item_no" value="${item.item_no}">
		<label>사진 올리는 곳<input type=""></label><br>
		<label>제목<input type="text" name="item_name" value="${item.item_name}" required></label><br>
		<label>카테고리<select id="item_category_no" name="item_category_no">
		  <c:forEach var="category" items="${itemCategoryList}">
			<option value="${category.item_category_no}" ${category.item_category_no == item.item_category_no ? 'selected' : '' }>${category.item_category_name}</option>
			</c:forEach>
		</select></label><br>
		<label>거래 가격<input type="number" name="item_price" value="${item.item_price}" required></label><br>
		<label>자세한 설명<textarea name="item_content" placeholder="${user_dong}에 올릴 게시글 내용을 작성해 주세요. (판매 금지 물품은 게시가 제한될 수 있어요.) 신뢰할 수 있는 거래를 위해 자세히 적어주세요. 과학기술정보통신부, 한국 인터넷진흥원과 함께 해요." required>${item.item_content}</textarea></label><br>
		<label>판매 상태<select id="item_status" name="item_status">
			<option value="1">판매 중</option>
			<option value="2">예약 중</option>
			<option value="3">판매 완료</option>
		</select></label><br>
		<button class="btn submit-btn" type="submit">수정 완료</button>
	</form>
</div>

<%@ include file="../main/footer.jsp"%>

