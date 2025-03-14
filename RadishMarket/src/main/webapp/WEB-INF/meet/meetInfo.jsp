<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<div>
	${ meet.meet_img }<br>
	${ meet.meet_title }<br>
	멤버 ${ meet_user_count }<br>
	${ meet.meet_content }<br>
	${ meet_dong }<br>
	${ meet_category_name }<br>
	${ meet.age_min }세~${ meet.age_max }세<br>
</div>
	<c:choose>
		<c:when test="${ hasUser eq null }">
			<a href="/${ hasMeetJoin eq null ? 'insert' : 'delete' }MeetJoin.do?meet_no=${ meet.meet_no }">${ hasMeetJoin eq null ? '모임 가입 신청' : '모임 가입 취소' }</a>
		</c:when>
		<c:otherwise>
			<a href="/listMeetUser.do?meet_no=${ meet.meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }">멤버 목록</a>
			<a href="/listBoard.do?meet_no=${ meet.meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }">게시판 목록</a>
			<a href="/deleteMeetUser.do?meet_no=${ meet.meet_no }">모임 탈퇴</a>
		</c:otherwise>
	</c:choose>
<c:if test="${ meet.host_user_no == log }">
	<button onclick="location.href='/deleteMeet.do?meet_no=${ meet.meet_no }'">모임삭제하기</button>
	<button onclick="location.href='/updateMeet.do?meet_no=${ meet.meet_no }'">정보수정하기</button>
</c:if>

<%@ include file="../main/footer.jsp" %>