<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<link rel="stylesheet" href="../../css/meetJoinList.css">

<section>
	<button onclick="location.href='/infoMeet.do?meet_no=${ meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }'">모임 홈</button>
	
	<div class="meet-join-list-box">
      <div class="meetinginsertlist">
        <div class="meetinglist">
          <table>
            <tr>
              <td class="nickname">닉네임</td>
              <td class="age">나이</td>
              <td class="content">내용</td>
              <td class="yes">승인</td>
              <td class="no">거절</td>
            </tr>
          </table>
        </div>
		<c:if test="${meetJoinList.size() > 0 }">
			<c:forEach var="i" begin="0" end="${meetJoinList.size() - 1}">
		        <div class="meeting">
		          <table>
		            <tr>
		              <td class="nickname">${ joinUserList.get(i).user_nickname }</td>
		              <td class="age">${ joinUserList.get(i).user_age }</td>
		              <td class="content">${ meetJoinList.get(i).meet_join_content }</td>
		              <td class="yes"><button type="button" id="${ meetJoinList.get(i).user_no }" value="${meetJoinList.get(i).meet_join_no}" onclick="sendAlarm()">승인</button></td>
		              <td class="no"><button type="button" onclick="location.href='/deleteMeetJoin.do?meet_join_no=${meetJoinList.get(i).meet_join_no}&meet_no=${ meetJoinList.get(i).meet_no }'">거절</button></td>
		            </tr>
		          </table>
		          </div>
			</c:forEach>
			<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="9">
			<input type="hidden" name="link_no" id="link_no" value="${ meetJoinList.get(0).meet_no }">
		</c:if>
     </div>
   </div>
	
</section>

<%@ include file="../main/footer.jsp" %>