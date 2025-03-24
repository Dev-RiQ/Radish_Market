<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.css" />

<div class="dir-history">
	<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 </a>
</div>

<div class="mypage-container">

	<div class="user-profile">
		<img alt="유저 이미지" src="/images/${user.user_img}">
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃${emoji}</p>
		<progress id="progress" value="${user.user_deg}" max="100"></progress>
		<p>매너온도</p>
	</div>

	<div class="link-group">
		<a href='/updateUser.do'>프로필 수정</a> <a href='/listLetter.do'>쪽지함</a> <a
			href='/zzimListUser.do'>찜목록</a> <a href='/itemListUser.do'>내 상품</a> <a
			href='/cartListUser.do'>구매내역</a> <a href='/sellListUser.do'>판매내역</a>
		<a href='/boardListUser.do'>내 게시글</a> <a href='/meetListUser.do'>내
			모임</a> <a style="cursor: pointer;" onclick="deleteUserDoubleCheck()">회원탈퇴</a>
	</div>

	<div class="user-calendar">
		<div class="container">
			<div>
				<button onclick="location.href='/insertCalendar.do'">일정 등록</button>
			</div>
			<div id="calendar"></div>
		</div>
	</div>

	<div class="modal fade" id="calendar-info-modal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">일정 정보</h4>
					<button type="button" class="close" id="close-Btn"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="dir-history">
						<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 >
						</a> <span>일정</span>
					</div>

					<div class="form-group">
						<label for="calendar_title">제목</label> <input type="text"
							id="calendar_title" name="calendar_title" class="form-control"
							readonly>
					</div>
					<div class="form-group">
						<label for="calendar_content">내용</label>
						<textarea id="calendar_content" name="calendar_content"
							class="form-control" readonly></textarea>
					</div>
					<div class="form-group">
						<label for="calendar_datetime">시간</label> <input type="text"
							id="calendar_datetime" name="calendar_datetime"
							class="form-control" readonly>
					</div>
					<div class="guid-box">
						<label>장소</label> <input type="text" id="calendar_address"
							name="calendar_address" class="form-control" readonly>
						<div id="map" style="width: 100%; height: 300px;"></div>
						<input type="hidden" id="calendar_dir_x" value=""> <input
							type="hidden" id="calendar_dir_y" value="">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="updateEventBtn" class="btn btn-primary">일정
						수정하기</button>
					<button type="button" id="deleteEventBtn" class="btn btn-danger">일정
						삭제하기</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
</div>

</div>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.min.js"></script>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script src="../../js/user.js"></script>
<script src="../../js/calendar.js"></script>

<%@ include file="../main/footer.jsp"%>