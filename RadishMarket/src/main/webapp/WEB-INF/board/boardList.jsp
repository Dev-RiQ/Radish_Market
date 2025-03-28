<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
<link rel="stylesheet" href="../../css/boardList.css">

<section>
<div class="board-list-box">
      <div class="life">
        <div class="locallife">
          <div class="locallifetxt">
            <p class="t"><a href='/index.jsp'>홈 > </a> <a href='/listBoard.do'>동네생활</a></p>
            <c:if test="${ meet_no eq '0' }">
          	  <h2>${ address } 동네생활</h2>
            </c:if>
            <c:if test="${ meet_no ne '0' }">
	            <h2>${ meetName }의 생활</h2>
            </c:if>
          </div>
          <div class="lbtns">
          </div>
        </div>

        <div class="texts">
          <div class="besttexts">
            <form action="/listBoard.do?filter=true" method="post">
				<input type="hidden" id="meet_no" name="meet_no" value="${ meet_no }"/>
				<input type="hidden" id="gu" name="gu" value="${ gu }"/>
				<hr>
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
						value="${ category.board_category_no }"
						${ categoryNo eq category.board_category_no ? 'checked' : '' } />${ category.board_category_name }
						<span class="checkmark"></span>
						</label>
				</c:forEach>
			
				<hr>
			
				<label class="filter-label" for="order_by">정렬</label> <label class="container"><input
					type="radio" name="order_by" id="order_by" value=0
					${ order_by eq null || order_by == 0 ? 'checked' : '' } />최신순
					<span class="checkmark"></span>
					</label>
				<label class="container"><input type="radio" name="order_by" id="order_by"
					value=1 ${ order_by eq 1 ? 'checked' : '' } />인기순
					<span class="checkmark"></span>
					</label>
				<button>필터적용</button>
			</form>
          </div>

          <div class="pepoletxts">
          	<div id="list-box"></div>
          	<p class="empty-info" id="boardList"></p>
	          <button class="addbtn" id="btn-more-list" value="board/0" onclick="getMoreList()">
	            <i class="fa-solid fa-chevron-down"></i>
	          </button>
          </div>
        </div>
      </div>

      <button id="myBtn" onclick="location.href='/insertBoard.do?meet_no=${meet_no}'"><i class="fa-solid fa-pen"></i></button
      ><!--글쓰기 버튼-->
      <button onclick="topFunction()" id="headerBtn" title="Go to top">
        <i class="fa-solid fa-angle-up"></i>
      </button>
    </div>
</section>

<%@ include file="../main/footer.jsp"%>