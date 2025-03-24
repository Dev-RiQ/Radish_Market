<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/listMeet.do'>모임 > </a> <span>${meet.meet_title}</span>
	</div>

<div>
	${ meet.meet_img }<br>
	${ meet.meet_title }<br>
	멤버 ${ meet_user_count }<br>
	${ meet.meet_content }<br>
	${ meet_dong }<br>
	${ meet_category_name }<br>
	${ meet.age_min }세~${ meet.age_max }세<hr>
</div>
	<c:choose>
		<c:when test="${ hasUser eq null }">
			<a href="/${ hasMeetJoin eq null ? 'insert' : 'delete' }MeetJoin.do?meet_no=${ meet.meet_no }">${ hasMeetJoin eq null ? '모임 가입 신청' : '모임 가입 취소' }</a>
		</c:when>
		<c:otherwise>
			<div>
				<p>멤버 (${meet_user_count})</p>
				<c:if test="${meet_user_count > 4}">
					<a href="/listMeetUser.do?meet_no=${ meet.meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }">더보기 ></a><br>
				</c:if>
				<span>${host_user.user_nickname}👑</span> <span>${host_user.user_dong}</span><br>
				<c:forEach var="user" items="${memberUserList}">
					<span>${user.user_nickname}</span> <span>${host_user.user_dong}</span><br>
				</c:forEach>
			</div><hr>
			
			<div>
				<p>일정 (${calendarCount})</p>
				<c:choose>
					<c:when test="${empty  calendarList or empty calendarDateList or empty calendarTimeList}">
						<p>현재 모임의 일정이 없습니다.</p>
					</c:when>
					<c:otherwise>
						<a href="/mypageUser.do">더보기 ></a><br>
						<c:forEach begin="0" end="${calendarList.size()-1}" var="i">
							<span>${calendarDateList[i]}</span> <span>${calendarList.get(i).calendar_title}</span> <span>${calendarTimeList[i]}</span><br>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div><hr>
			
			<div>
				<p>게시글 (${boardCount})</p>
				<c:if test="${boardCount > 4}">
					<a href="/listBoard.do?meet_no=${ meet.meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }">더보기 ></a><br>
				</c:if>
				<c:choose>
					<c:when test="${empty boardList or empty boardUserNickNameList or empty boardTime}">
						<p>현재 모임의 게시글이 없습니다.</p>
					</c:when>
					<c:otherwise>
						<c:forEach begin="0" end="${boardList.size()-1}" var="i">
							<h4>${boardList.get(i).board_title}</h4>
							<p>${boardUserNickNameList.get(i)}</p>
							<span>${boardTime[i]}</span> <span>❤️ ${boardLikeList.get(i)}</span>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div><hr>
			
			<a href="/deleteMeetUser.do?meet_no=${ meet.meet_no }">모임 탈퇴</a>
		</c:otherwise>
	</c:choose>
<c:if test="${ meet.host_user_no == log }">
	<button onclick="location.href='/deleteMeet.do?meet_no=${ meet.meet_no }'">모임삭제하기</button>
	<button onclick="location.href='/updateMeet.do?meet_no=${ meet.meet_no }'">정보수정하기</button>
	<button onclick="location.href='/listMeetJoin.do?meet_no=${ meet.meet_no }'">가입신청목록</button>
</c:if>

<%@ include file="../main/footer.jsp" %>