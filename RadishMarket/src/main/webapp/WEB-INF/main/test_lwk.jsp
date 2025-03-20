<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
 <input type="hidden" id="item_status" value="1" />
<input type="hidden" id="category_no" value="0" />
<input type="hidden" id="price_min" value="100" />
<input type="hidden" id="price_max" value="100000" />
<input type="hidden" id="gu" value="강남구" />
<input type="hidden" id="dong" value="역삼동" />
<input type="hidden" id="order_by" value="0" />
<input type="hidden" id="meet_no" value="13" /> 
<div id="list-box">

</div>
<button id="btn-more-list" class="" value="item/0" onclick="getMoreList()">아이템더보기</button><br>
<button id="btn-more-list" class="" value="board/0" onclick="getMoreList()">게시판더보기</button><br>
<button id="btn-more-list" class="" value="meetBoard/0" onclick="getMoreList()">모임게시판더보기</button><br>
<button id="btn-more-list" class="" value="meet/0" onclick="getMoreList()">모임더보기</button><br>
<button id="btn-more-list" class="" value="receiveLetter/0" onclick="getMoreList()">받은쪽지더보기</button><br>
<button id="btn-more-list" class="" value="sendLetter/0" onclick="getMoreList()">보낸쪽지더보기</button><br>
<button id="btn-more-list" class="" value="zzim/0" onclick="getMoreList()">찜더보기</button><br>
<button id="btn-more-list" class="" value="cart/0" onclick="getMoreList()">구매항목더보기</button><br>
<button id="btn-more-list" class="" value="myItem/0" onclick="getMoreList()">내아이템더보기</button><br>
<button id="btn-more-list" class="" value="review/0" onclick="getMoreList()">리뷰더보기</button><br>
<button id="btn-more-list" class="" value="myBoard/0" onclick="getMoreList()">내게시글더보기</button><br>
<button id="btn-more-list" class="" value="hostMeet/0" onclick="getMoreList()">내가주인모임더보기</button><br>
<button id="btn-more-list" class="" value="myMeet/0" onclick="getMoreList()">내가가입모임더보기</button><br>
<button id="btn-more-list" class="" value="adminUser/0" onclick="getMoreList()">관리자유저더보기</button><br>
<button id="btn-more-list" class="" value="adminBoard/0" onclick="getMoreList()">관리자게시판더보기</button><br>
<button id="btn-more-list" class="" value="adminItem/0" onclick="getMoreList()">관리자아이템더보기</button><br>
<button id="btn-more-list" class="" value="adminMeet/0" onclick="getMoreList()">관리자모임더보기</button>

<%@ include file="../main/footer.jsp" %>
<script src="../../js/listPaging.js"></script>