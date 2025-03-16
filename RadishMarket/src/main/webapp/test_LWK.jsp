<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
<form action="/insertCalendar.do" method="post">
	<label for="calendar_title">제목</label>
	<input type="text" name="calendar_title" id="calendar_title" placeholder="제목"><br>
	<label for="calendar_datetime">주소</label>
	<input type="text" name="calendar_datetime" id="calendar_datetime" placeholder="주소" readonly>
	<input type="button" onclick="execDaumPostcode()" value="주소 찾기"><br>
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
	<br>
	<label for="calendar_content">내용</label>
	<textarea name="calendar_content" id="calendar_content" placeholder="내용"></textarea><br>
	<input type="hidden" name="calendar_dir_x" id="calendar_dir_x">
	<input type="hidden" name="calendar_dir_y" id="calendar_dir_y">
	<input type="hidden" name="sub_user_no" id="sub_user_no" value="${ sub_user_no }">
	<input type="hidden" name="meet_no" id="meet_no" value="${ meet_no }">
	
	<button>일정 등록</button>
</form>



</body>
