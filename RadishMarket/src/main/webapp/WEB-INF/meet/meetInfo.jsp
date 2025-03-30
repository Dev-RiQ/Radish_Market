<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="../../css/meetInfo.css">
<section>
	
<div class="joined-meet-info-box">
		
        <div class="meetingthelooks">
			<div class="dir-history">
				<a href='/index.jsp'>홈 > </a> <a href='/listMeet.do'>모임 </a>
			</div>
            <div class="meetingsactives">
                <div class="meetingtext">
                    <div class="meetingpropil">
                        <table>
                            <tr><td rowspan="2"><img alt="대표이미지" src="/images/${ meet.meet_img ne '' ? meet.meet_img : 'meetsDefaultImg.png' }"></td></tr><!--모임 프로필-->
                            <tr>
                            <td>
                                <h3>${ meet.meet_title }</h3><!--모임 이름-->
                                <span>멤버 ${meet_user_count} · 게시글 ${boardCount}</span><!-- 모임 멤버 ,게시글수-->
                            </td>
                           
                        </tr>
                        </table>
                    </div>
                    <div class="meetingpropiltxt"><!-- 모임 게시글-->
                        <p>${ meet.meet_content }</p>
                    </div>
                    <div class="meetinglocalbtns"><!--모아 유형-->
                        <button>${ meet.meet_dong }</button>
                        <button>${ meet_category_name }</button>
                        <button>${ meet.age_min }세~${ meet.age_max }세</button>

                    </div>
                    <c:if test="${ hasUser ne null }">
                    	<button onclick="location.href='/insertCalendar.do?meet_no=${ meet.meet_no }'">일정 추가</button>
                   	</c:if>
                    <c:if test="${ meet.host_user_no != log && hasUser ne null }">
                    	<button onclick="location.href='/deleteMeetUser.do?meet_no=${ meet.meet_no }'">모임 탈퇴</button>
                   	</c:if>
                    <c:if test="${ meet.host_user_no != log && hasUser eq null }">
                    	<button onclick="location.href='/${ hasMeetJoin ne null ? 'delete' : 'insert' }MeetJoin.do?meet_no=${ meet.meet_no }'">${ hasMeetJoin ne null ? '가입 신청 취소' : '모임 가입 신청' }</button>
                    </c:if>
                    <c:if test="${ meet.host_user_no == log }">
						<button onclick="location.href='/deleteMeet.do?meet_no=${ meet.meet_no }'">모임삭제하기</button>
						<button onclick="location.href='/updateMeet.do?meet_no=${ meet.meet_no }'">정보수정하기</button>
						<button onclick="location.href='/listMeetJoin.do?meet_no=${ meet.meet_no }'">가입신청목록</button>
					</c:if>
                </div>




                <div class="meetingactive">
                    <div class="pepoles">
                        <div class="pepoles-num">
                            <h3>멤버 ${meet_user_count}</h3><!--멤버 수-->
                            <c:if test="${meet_user_count > 4}">
								<a href="/listMeetUser.do?meet_no=${ meet.meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }">더보기 ></a>
							</c:if>
                        </div>

                        <div class="members">

                            <div class="pepole">
                               <div class="m">
                               <div class="user-img-box">
	                                <img alt="대표이미지" src="/images/${ host_user.user_img ne '' ? host_user.user_img : 'usersDefaultImg.png' }">
                               </div>
                                    <div class="mname">
                                    <p>${host_user.user_nickname }👑 <br><span>${host_user.user_dong}</span></p>   <!--멤버 이름, 상태메세지-->
                                </div>
                               </div> 
                            </div>
                            <c:forEach var="user" items="${memberUserList}">
                            <div class="pepole">
                                <div class="m">
                                <div class="user-img-box">
                              	  <img alt="대표이미지" src="/images/${ user.user_img ne '' ? user.user_img : 'usersDefaultImg.png' }">
                                </div>
                                     <div class="mname">
                                     <p>${user.user_nickname} <br><span> ${user.user_dong}</span></p>   
                                 </div>
                                </div> 
                             </div>
                             </c:forEach>
                            </div>
                    </div>
                    <div class="mebertxt">
                        <h3>일정 ${calendarCount}</h3><!--게시글 수-->
                        <c:if test="${calendarCount > 4}">
							<a href="/userMypage.do">더보기 ></a>
						</c:if>
                    </div>
                     <div class="members">
						<c:choose>
							<c:when test="${empty calendarList or empty calendarMonth or empty calendarDay or empty calendarTimeList}">
								<p>현재 모임의 일정이 없습니다.</p>
							</c:when>
							<c:otherwise>
								<c:forEach begin="0" end="${calendarList.size()-1}" var="i">
		                            <div class="pepole">
		                                <div class="m">
			                                <div class="meet-date-box">
			                              	  <p>${ calendarMonth[i] }월</p>
			                              	  <p>${ calendarDay[i] }</p>
			                                </div>
		                                     <div class="date-box">
			                                     <div>
			                                     	<p>${calendarList.get(i).calendar_content}</p>  
			                                     </div>
			                                     <div>
			                                     	<span>시간 ${calendarTimeList[i] }</span>  
			                                     </div>
		                                	 </div>
		                                     <div class="mname">
		                                	 </div>
		                                </div> 
		                             </div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
                        </div>
                    <div class="mebertxt">
                        <h3>게시글 ${boardCount}</h3><!--게시글 수-->
						<a href="/listBoard.do?meet_no=${ meet.meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }">게시판 이동 ></a>
                    </div>
                    <div class="meberactivetxt">
						<c:choose>
							<c:when test="${empty boardList or empty boardUserNickNameList or empty boardTime}">
								<p>현재 모임의 게시글이 없습니다.</p>
							</c:when>
							<c:otherwise>
								<c:forEach begin="0" end="${boardList.size()-1}" var="i">
									<div class="txtcald">
			                            <div class="txtbox" style="cursor: pointer;" onclick="location.href='/infoBoard.do?board_no=${ boardList.get(i).board_no}'"><!--게시글 박그-->
			                              <h3>${boardList.get(i).board_title}</h3><!--게시글 제목-->
			                              <p>
			                                ${boardUserNickNameList.get(i)}
			                              </p><!--게시글 내용-->
			                              <span>${boardList.get(i).board_dong} · ${boardCategoryNameList.get(i)} · ${boardTime[i]}</span><!--게시글 위치, 유형 , 시간-->
			                              <pre>❤️ ${boardLikeList.get(i)} · <i class="fa-solid fa-comment"></i> ${ boardCommentCountList.get(i) }</pre><!---->
			                            </div>
			                            <c:if test="${ boardList.get(i).board_img ne null && boardList.get(i).board_img ne '' }">
				                            <div class="imgbox"><img alt="대표 이미지" src="/images/${ boardList.get(i).board_img }"/></div><!--게시글 이미지-->
			                            </c:if>
			                          </div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
</section>

<%@ include file="../main/footer.jsp" %>