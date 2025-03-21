
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>
<div class="item-list-container">
	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/listItem.do'>중고거래</a>
	</div>
	<c:choose>
		<c:when test="${log ne null}">
			<h1>${user.user_city} ${user.user_gu} ${user.user_dong} 중고거래</h1>
		</c:when>
		<c:otherwise>
			<h1>${address} 중고거래</h1>
		</c:otherwise>
	</c:choose>
	
<div style="display:flex;">
	<div style="width:200px;">
		<form action="/listItem.do?filter=true" method="post">
		
			<hr>
			<label for="item_status">필터</label><br>
			<label><input type="radio" name="item_status" id="item_status" value=0
				${ item_status eq null || item_status == 0 ? 'checked' : '' } />전체보기</label><br>
			<label><input type="radio" name="item_status" id="item_status"
				value=1 ${ item_status eq 1 ? 'checked' : '' } />판매 중</label><br>
			<label><input type="radio" name="item_status" id="item_status"
				value=2 ${ item_status eq 2 ? 'checked' : '' } />예약 중</label><br>
			<label><input type="radio" name="item_status" id="item_status"
				value=3 ${ item_status eq 3 ? 'checked' : '' } />판매 완료</label><br>
			
			
			<hr>
			
			<input type="hidden" id="gu" name="gu" value="${ gu }"/>
			<label for="user_dong">위치</label><br> <label><input
				type="radio" name="dong" id="dong" value="전체"
				${ userDong eq '전체' ? 'checked' : '' } />전체보기</label><br>
			<c:forEach var="category_dong" items="${ dongList }">
				<label><input type="radio" name="dong" id="dong"
					value="${ category_dong }"
					${ userDong eq category_dong ? 'checked' : '' } />${ category_dong }</label>
				<br>
			</c:forEach>
		
			<hr>
		
			<label for="category_no">카테고리</label><br> <label><input
				type="radio" name="category_no" id="category_no" value="0"
				${ categoryNo eq null || categoryNo eq 0 ? 'checked' : '' } />전체보기</label><br>
			<c:forEach var="category" items="${ categoryList }">
				<label><input type="radio" name="category_no" id="category_no"
					value="${ category.item_category_no }"
					${ categoryNo eq category.item_category_no ? 'checked' : '' } />${ category.item_category_name }</label>
				<br>
			</c:forEach>
		
			<hr>
			
			<label for="price_min">최소 가격</label><br>
			<input type="number" name="price_min" id="price_min" value=${ price_min ne null ? price_min : 0 } /><br>
			<label for="price_max">최대 가격</label><br>
			<input type="number" name="price_max" id="price_max" value=${ price_max ne null ? price_max : 0 } /><br>
			
			<hr>
		
			<label for="order_by">정렬</label><br> <label><input
				type="radio" name="order_by" id="order_by" value=0
				${ order_by eq null || order_by == 0 ? 'checked' : '' } />최신순</label><br>
			<label><input type="radio" name="order_by" id="order_by"
				value=1 ${ order_by eq 1 ? 'checked' : '' } />인기순</label><br>
			<label><input type="radio" name="order_by" id="order_by"
				value=2 ${ order_by eq 2 ? 'checked' : '' } />가격 높은 순</label><br>
			<label><input type="radio" name="order_by" id="order_by"
				value=3 ${ order_by eq 3 ? 'checked' : '' } />가격 낮은 순</label><br>
			<button>필터적용</button>
		</form>
	</div>
	<div style="width:100%;">
		<a href='/insertItem.do'>글 쓰기</a>
		
		<div id="list-box" style="width:calc(100vw - 220px); flex-wrap:wrap; display:flex;">
			<!-- 여기 리스트 출력 -->
		</div>
		<button id="btn-more-list" value="item/0" onclick="getMoreList()">더보기</button>
	</div>
</div>
	
	
</div>

<%@ include file="../main/footer.jsp"%>