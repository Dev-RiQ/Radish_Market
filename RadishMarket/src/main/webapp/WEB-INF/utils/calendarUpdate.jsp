<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<form action="/updateCalendar.do?check=1" method="post">
	<label for="calendar_title">제목</label>
	<input type="text" name="calendar_title" id="calendar_title" value="${ calendar.calendar_title }">
	<span id="title_check"></span>
	<br>
	
	<label for="calendar_datetime">주소</label>
	<input type="text" name="calendar_datetime" id="calendar_datetime" placeholder="주소" readonly>
	<input type="button" onclick="execDaumPostcode()" value="주소 변경"><br>
	
	<input type="date" name="calendar_datetime" id="calendar_datetime" value="${ calendar.calendar_datetime.split(' ')[0] }">
	<select name="calendar_datetime" id="calendar_datetime">
		<c:forEach var="i" begin="1" end="24">
			<option value="${ i < 10 ? '0' + i : i }" ${ calendar.calendar_datetime.split(' ')[1].split(':')[0] ? 'selected' : '' }>${ i < 10 ? '0' + i : i }시</option>
		</c:forEach>
	</select>
	<select name="calendar_datetime" id="calendar_datetime">
		<c:forEach var="i" begin="0" end="59">
			<option value="${ i < 10 ? '0' + i : i }" ${ calendar.calendar_datetime.split(' ')[1].split(':')[1] ? 'selected' : '' }>${ i < 10 ? '0' + i : i }분</option>
		</c:forEach>
	</select>
	<span id="datetime_check"></span>
	<br>
	
	<label for="calendar_content">내용</label>
	<textarea name="calendar_content" id="calendar_content" placeholder="내용">${ calendar.calendar_content }</textarea><br>
	<input type="hidden" name="calendar_dir_x" id="calendar_dir_x" value="${ calendar.calendar_dir_x }">
	<input type="hidden" name="calendar_dir_y" id="calendar_dir_y" value="${ calendar.calendar_dir_y }">
	
	<button type="button" onclick="validCheck()">일정 수정</button>
</form>

<%@ include file="../main/footer.jsp" %>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services,clusterer"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../../js/calendarInsertValidCheck.js"></script>
<script src="../../js/calendarJusoSearch.js"></script>
<script src="../../js/user.js"></script>