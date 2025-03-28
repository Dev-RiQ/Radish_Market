
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
<link rel="stylesheet" href="../../css/itemList.css">

<section>
<div class="item-list-box">
      <div class="transaction">
        <div class="homt-transaction-txt">
          <div class="locallifetxt">
			<div class="item-list-container">
				<div class="dir-history">
					<a href='/index.jsp'>홈 > </a> <a href='/listItem.do'>중고거래</a>
				</div>
				<h1>${address} 중고거래</h1>
			</div>
          </div>
        </div>

        <div class="categoryandproduct">
        	<form action="/listItem.do?filter=true&search_value=${ search_value }" method="post">
		
			<hr>
			<label class="filter-label" for="item_status">필터</label><br>
			<label class="container"><input type="radio" name="item_status" id="item_status" value=0
				${ item_status eq null || item_status == 0 ? 'checked' : '' } />전체보기
				<span class="checkmark"></span>
				</label>
			<label class="container"><input type="radio" name="item_status" id="item_status"
				value=1 ${ item_status eq 1 ? 'checked' : '' } />판매 중
				<span class="checkmark"></span>
				</label>
			<label class="container"><input type="radio" name="item_status" id="item_status"
				value=2 ${ item_status eq 2 ? 'checked' : '' } />예약 중
				<span class="checkmark"></span>
				</label>
			<label class="container"><input type="radio" name="item_status" id="item_status"
				value=3 ${ item_status eq 3 ? 'checked' : '' } />판매 완료
				<span class="checkmark"></span>
				</label>
			
			
			<hr>
			
			<input type="hidden" id="gu" name="gu" value="${ gu }"/>
			<label class="filter-label" for="user_dong">위치</label><br> <label class="container"><input
				type="radio" name="dong" id="dong" value="전체"
				${ userDong eq '전체' ? 'checked' : '' } />전체보기
				<span class="checkmark"></span>
				</label>
			<c:forEach var="category_dong" items="${ dongList }">
				<label class="container"><input type="radio" name="dong" id="dong"
					value="${ category_dong }"
					${ userDong eq category_dong ? 'checked' : '' } />${ category_dong }
					<span class="checkmark"></span>
					</label>
			</c:forEach>
		
			<hr>
		
			<label class="filter-label" for="category_no">카테고리</label><br> <label class="container"><input
				type="radio" name="category_no" id="category_no" value="0"
				${ categoryNo eq null || categoryNo eq 0 ? 'checked' : '' } />전체보기
				<span class="checkmark"></span>
				</label>
			<c:forEach var="category" items="${ categoryList }">
				<label class="container"><input type="radio" name="category_no" id="category_no"
					value="${ category.item_category_no }"
					${ categoryNo eq category.item_category_no ? 'checked' : '' } />${ category.item_category_name }
					<span class="checkmark"></span>
					</label>
			</c:forEach>
		
			<hr>
			
			<label class="filter-label" for="price_min">최소 가격</label><br>
			<input type="number" name="price_min" id="price_min" value=${ price_min ne null ? price_min : 0 } /><br>
			<label class="filter-label" for="price_max">최대 가격</label><br>
			<input type="number" name="price_max" id="price_max" value=${ price_max ne null ? price_max : 0 } /><br>
			
			<hr>
		
			<label class="filter-label" for="order_by">정렬</label><br> <label class="container"><input
				type="radio" name="order_by" id="order_by" value=0
				${ order_by eq null || order_by == 0 ? 'checked' : '' } />최신순
				<span class="checkmark"></span>
				</label>
			<label class="container"><input type="radio" name="order_by" id="order_by"
				value=1 ${ order_by eq 1 ? 'checked' : '' } />인기순
				<span class="checkmark"></span>
				</label>
			<label class="container"><input type="radio" name="order_by" id="order_by"
				value=2 ${ order_by eq 2 ? 'checked' : '' } />가격 높은 순
				<span class="checkmark"></span>
				</label>
			<label class="container"><input type="radio" name="order_by" id="order_by"
				value=3 ${ order_by eq 3 ? 'checked' : '' } />가격 낮은 순
				<span class="checkmark"></span>
				</label>
			<button>필터적용</button>
		</form>

          <div class="product">
            <div class="product-child" id="list-box">
          	<p class="empty-info" id="itemList"></p>
            
            </div>
            <button class="addbtn" id="btn-more-list" value="item/0" onclick="getMoreList()">
              <i class="fa-solid fa-chevron-down"></i>
            </button>
          </div>
        </div>
      </div>
      <button id="myBtn" onclick="location.href='/insertItem.do'"><i class="fa-solid fa-toolbox"></i></button
      ><!--상품등록 버튼-->
      <button onclick="topFunction()" id="headerBtn" title="Go to top">
        <!--탑 버튼-->
        <i class="fa-solid fa-angle-up"></i>
      </button>
    </div>

	
</section>
	

<%@ include file="../main/footer.jsp"%>