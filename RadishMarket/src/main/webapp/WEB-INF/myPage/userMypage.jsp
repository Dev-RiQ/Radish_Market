<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.css" />
<link rel="stylesheet" href="../../css/userMypage.css">

<section>
	<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 </a>
	</div>
	
	<div class="user-mypage-box">
    <div class="mypag">
      <div class="myprofil">
        <div class="user-profile-container">
			<div class="user-profile-inner-container">
				<section class="user-profile-section1">
					<img alt="대표이미지" src="/images/${user.user_img ne '' ? user.user_img : 'usersDefaultImg.png'}">
					<div class="user-profile-text-box">
						<a class="user-profile-nickname" href='/itemListUser.do?user_no=${user.user_no}'>${user.user_nickname}</a>
						<span class="user-profile-dong">
							<a href='/listItem.do?filter=true&gu=${user.user_gu}&dong=${user.user_dong}'>${user.user_dong}</a>
						</span>
					</div>
				</section>
				<section class="user-profile-section2">
					<div class="user-profile-inner-section">
						<div class="user-profile-inner-box1">
							<span class="user-profile-deg">${user.user_deg}℃</span> <span class="user-profile-emoji">${emoji}</span>
						</div>
						<div class="user-profile-inner-box2">
							<progress value="${user.user_deg}" max="100"></progress>
						</div>
						<div class="user-profile-inner-box3">
							<p class="ondo-label">매너온도</p>
						</div>
					</div>
				</section>
			</div>
		</div>
      </div>


      <div class="menu">


        <div class="cartegory">
          <button class="tablinks clicked" id="defaultOpen" onclick="location.href='/mypageUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-home" style="font-size: 20px; color: #000"></i>
              </div><span>마이페이지</span>
            </div>
          </button><!-- 프로필 수정-->
          <button class="tablinks" onclick="location.href='/updateUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-user" style="font-size: 20px; color: #000"></i>
              </div><span>프로필 수정</span>
            </div>
          </button><!-- 프로필 수정-->
          <button class="tablinks" onclick="location.href='/boardListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-folder" style="font-size: 20px; color:  #F7D358 "></i>
              </div><span>내 게시글</span>
            </div>
            <!--  내 게시글-->
          </button>
          <button class="tablinks" onclick="location.href='/listLetter.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-envelope" style="font-size: 20px;  color: #FF0080"></i>
              </div><span>쪽지함</span>
            </div>
            <!--  쪽지함-->
          </button>
          <button class="tablinks" onclick="location.href='/zzimListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-bookmark" style="font-size: 20px;  color: gray"></i>
              </div><span>찜목록</span>
            </div>
            <!--  찜목록-->
          </button>
          <button class="tablinks" onclick="location.href='/itemListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-gift" style="font-size: 20px;  color: skyblue"></i>
              </div><span>내 상품</span>
            </div>
            <!--  내 상품-->
          </button>
          <button class="tablinks" onclick="location.href='/cartListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-bag-shopping" style="font-size: 20px; color: pink"></i>
              </div><span>구매 내역</span>
            </div>
            <!--   구매 내역 -->
          </button>
          <button class="tablinks" onclick="location.href='/sellListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa-solid fa-piggy-bank" style="font-size: 20px; color: #5fcc29"></i>
              </div><span>판매 내역</span>
            </div>
            <!--    판매 내역-->
          </button>

          <button class="tablinks" onclick="location.href='/meetListUser.do'">
            <div class="btn-inner-box">
              <div class="menu-box"><i class="fa fa-users" style="font-size: 20px;color: yellowgreen"></i>
              </div><span>내 모임</span>
            </div>
            <!--   내 모임<-->
          </button>
        </div>


        <div class="menulist">
          <div class="menulistbtn">
            <button>일정</button> <!-- 보낸 쪽지함-->
          </div>
          <div class="cartegorymenue">
          		<div class="user-calendar">
					<div class="container">
						<div class="btn-cal-box">
							<div></div>
							<button class="btn-cal-sub" onclick="location.href='/insertCalendar.do'">일정 등록</button>
						</div>
						<div id="calendar"></div>
					</div>
				</div>
			
				<div class="modal fade" id="calendar-info-modal" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">일정 정보</h4>
								<div class="dir-history">
									<a href='/index.jsp'>홈 > </a> <a href='/mypageUser.do'>마이페이지 >
									</a> <span>일정</span>
								</div>
								<button type="button" class="close" id="close-Btn"
									data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
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
          </div><!-- 내용-->
        </div>
      </div>
  </div>
  </div>


</section>

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

<script src="../../js/calendar.js"></script>

<%@ include file="../main/footer.jsp"%>