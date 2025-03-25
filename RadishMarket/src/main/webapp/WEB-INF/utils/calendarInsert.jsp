<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<section>
<div class="dir-history">
	<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 > </a> <span> 일정 등록 </span>
</div>

<form action="/insertCalendar.do?item_no=${ item_no }" method="post">

	<label for="calendar_title">제목</label>
	<input type="text" name="calendar_title" id="calendar_title" placeholder="제목">
	<span id="title_check"></span>
	<br>
	
	<label for="calendar_address">주소</label>
	<input type="text" name="calendar_address" id="calendar_address" placeholder="주소" readonly>
	<input type="button" onclick="execDaumPostcode()" value="주소 찾기">
	<br>
	
	<label for="calendar_datetime">날짜</label>
	<input type="date" name="calendar_datetime" id="calendar_datetime">
	<select name="calendar_datetime" id="calendar_datetime">
		<c:forEach var="i" begin="1" end="24">
			<option value="${ i < 10 ? '0' + i : i }">${ i < 10 ? '0' + i : i }시</option>
		</c:forEach>
	</select>
	<select name="calendar_datetime" id="calendar_datetime">
		<c:forEach var="i" begin="0" end="59">
			<option value="${ i < 10 ? '0' + i : i }">${ i < 10 ? '0' + i : i }분</option>
		</c:forEach>
	</select>
	<span id="datetime_check"></span>
	<br>
	
	<label for="calendar_content">내용</label>
	<textarea name="calendar_content" id="calendar_content" placeholder="내용"></textarea>
	<br>
	
	<input type="hidden" name="calendar_dir_x" id="calendar_dir_x">
	<input type="hidden" name="calendar_dir_y" id="calendar_dir_y">
	<input type="hidden" name="sub_user_no" id="sub_user_no" value="${ sub_user_no }">
	<input type="hidden" name="meet_no" id="meet_no" value="${ meet_no }">
	
	<input type="hidden" name="user_no" id="user_no" value="${ sub_user_no }">
	<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="7">
	<input type="hidden" name="link_no" id="link_no" value="${ item_no }">
	<button type="button" onclick="validCheck()">일정 등록</button>
</form>

</section>
<%@ include file="../main/footer.jsp" %>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services,clusterer"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../../js/calendarInsertValidCheck.js"></script>
<script src="../../js/calendarJusoSearch.js"></script>
<script src="../../js/user.js"></script>