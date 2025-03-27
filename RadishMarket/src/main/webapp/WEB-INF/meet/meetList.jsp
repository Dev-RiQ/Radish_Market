<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
<link rel="stylesheet" href="../../css/meetList.css">

<section>

 <div class="meet-list-box">
      <div class="life">
		<div class="locallife">
          <div class="locallifetxt">
          	<div class="dir-history">
            <a href='/index.jsp'>홈 > </a> <a href='/listMeet.do'>모임 </a>
            </div>
            <h2>${ address } 모임</h2>
          </div>
          <div class="lbtns">
          </div>
        </div>
        <div class="texts">
          <div class="besttexts">
          	<form action="/listMeet.do?filter=true" method="post">
			<input type="hidden" id="meet_no" name="meet_no" value="${ meet_no }" />
			<input type="hidden" id="gu" name="gu" value="${ gu }" />
			<hr>
			<label class="filter-label" for="user_dong">위치</label><br> <label class="container"><input
				type="radio" name="dong" id="dong" value="전체"
				${ userDong eq '전체' ? 'checked' : '' } />전체보기
				<span class="checkmark"></span>
				</label>
			<c:forEach var="category_dong" items="${ dongList }">
				<label class="container"><input type="radio" name="dong" id="dong"
					value="${ category_dong }"
					${ userDong eq category_dong ? 'checked' : userDong eq null and logUserDong eq category_dong? 'checked' : '' } />${ category_dong }
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
					value="${ category.meet_category_no }"
					${ categoryNo eq category.meet_category_no ? 'checked' : '' } />${ category.meet_category_name }
					<span class="checkmark"></span>
					</label>
			</c:forEach>
		
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
			<button>필터적용</button>
		</form>
          </div>
          
          <div class="pepoletxts">
          <p class="empty-info" id="meetList"></p>
			<div id="list-box"></div>          	
            
           <button class="addbtn" id="btn-more-list" value="meet/0" onclick="getMoreList()">
             <i class="fa-solid fa-chevron-down"></i
             ><!--더보기 버튼-->
           </button>
          </div>
        </div>
      </div>

      <button id="myBtn" onclick="location.href='/insertMeet.do'"><i class="fa fa-users"></i></button
      ><!--모임 등록버튼-->
      <button onclick="topFunction()" id="headerBtn" title="Go to top">
        <!--답버튼-->
        <i class="fa-solid fa-angle-up"></i>
      </button>
    </div>

<input type="hidden" id="user_dong" value="${ dong }">


</section>


<%@ include file="../main/footer.jsp"%>