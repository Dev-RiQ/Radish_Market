<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<section>
<div class="dir-history">
	<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 > </a> <span> 일정 수정 </span>
</div>
<div class="modal" style="display:block; position:relative; z-index:0;" id="calendar-info-modal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">일정 수정</h4>
				<button type="button" class="close" id="close-Btn"
					data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="/updateCalendar.do?check=1" method="post">
			<div class="modal-body">
				<div class="form-group">
					<label for="calendar_title">제목</label>
					<input type="text" name="calendar_title" id="calendar_title" value="${ calendar.calendar_title }" class="form-control">
					<span id="title_check"></span>
				</div>
				<div class="form-group">
					<label for="calendar_content">내용</label>
					<textarea name="calendar_content" id="calendar_content" placeholder="내용" class="form-control">${ calendar.calendar_content }</textarea><br>
				</div>
				<div class="form-group">
					<label for="calendar_datetime">시간</label> 
					<div style="display:flex; gap: 20px;">
					<input type="date" name="calendar_datetime" id="calendar_datetime" value="${ calendar.calendar_datetime.split(' ')[0] }" class="form-control">
					<select name="calendar_datetime" id="calendar_datetime" class="form-control">
						<c:forEach var="i" begin="1" end="24">
							<option value="${ i < 10 ? '0' + i : i }" ${ calendar.calendar_datetime.split(' ')[1].split(':')[0] ? 'selected' : '' }>${ i < 10 ? '0' + i : i }시</option>
						</c:forEach>
					</select>
					<select name="calendar_datetime" id="calendar_datetime" class="form-control">
						<c:forEach var="i" begin="0" end="59">
							<option value="${ i < 10 ? '0' + i : i }" ${ calendar.calendar_datetime.split(' ')[1].split(':')[1] ? 'selected' : '' }>${ i < 10 ? '0' + i : i }분</option>
						</c:forEach>
					</select>
					</div>
					<span id="datetime_check"></span>
				</div>
				<div class="guid-box">
					<label>장소</label> 
					<div style="display:flex; gap: 20px;">
					<input type="text" name="calendar_address" id="calendar_address" placeholder="주소" value="${ calendar.address }" class="form-control">
					<input type="button" onclick="execDaumPostcode()" value="주소 변경"><br>
					</div>	
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onclick="validCheck()">일정 수정</button>
				<button type="button" class="btn btn-default" onclick="history.back()">취소</button>
			</div>
			<input type="hidden" name="calendar_dir_x" id="calendar_dir_x" value="${ calendar.calendar_dir_x }">
			<input type="hidden" name="calendar_dir_y" id="calendar_dir_y" value="${ calendar.calendar_dir_y }">
			<input type="hidden" name="sub_user_no" id="sub_user_no" value="${ sub_user_no }">
			<input type="hidden" name="meet_no" id="meet_no" value="${ meet_no }">
			<input type="hidden" name="calendar_no" id="calendar_no" value="${ calendar.calendar_no }">
			
			<input type="hidden" name="user_no" id="user_no" value="${ sub_user_no }">
			<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="7">
			<input type="hidden" name="link_no" id="link_no" value="${ item_no }">
			</form>
		</div>
	</div>
</div>
</section>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services,clusterer"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../../js/calendarUpdateValidCheck.js"></script>
<script src="../../js/calendarJusoSearch.js"></script>
<script src="../../js/user.js"></script>

<%@ include file="../main/footer.jsp" %>