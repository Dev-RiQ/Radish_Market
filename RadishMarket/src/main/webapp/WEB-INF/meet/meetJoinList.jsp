<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<button onclick="location.href='/infoMeet.do?meet_no=${ meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }'">모임 홈</button>
<c:if test="${meetJoinList.size() > 0 }">
	<c:forEach var="i" begin="0" end="${meetJoinList.size() - 1}">
		<hr>
		${ meetJoinList.get(i).meet_no }
		${ joinUserList.get(i).user_nickname }
		${ joinUserList.get(i).user_age }
		${ meetJoinList.get(i).meet_join_content }
		
		<input type="hidden" name="user_no" id="user_no" value="${ meetJoinList.get(i).user_no }">
		<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="9">
		<input type="hidden" name="link_no" id="link_no" value="${ meetJoinList.get(i).meet_no }">
		<button type="button" onclick="sendAlarm()">승인</button>
		<button onclick="/deleteMeetJoin.do?meet_join_no=${meetJoinList.get(i).meet_join_no}">거절</button>
	</c:forEach>
</c:if>

<%@ include file="../main/footer.jsp" %>