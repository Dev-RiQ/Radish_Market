<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="userboardlist-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}</p>
		<p>매너온도</p>
	</div>

	<div class="hostuser-boardlist">
		<h3>내가 호스트인 모임</h3>
		<c:choose>
			<c:when test="${hostMeetList eq null or hostMeetList.size() <= 0}">
				<p>회원님이 호스트인 모임이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${hostMeetList.size() - 1}">
					<div style="cursor: pointer;"
						onclick="location.href='/infoMeet.do?meet_no=${hostMeetList.get(i).meet_no}&meet_dong=${hostMeetDongList.get(i)}&meet_user_count=${hostMeetUserCountList.get(i)}&meet_category_name=${hostMeetCategoryList.get(i)}'">
						${hostMeetList.get(i).meet_img}<br>
						${hostMeetList.get(i).meet_title}<br>
						${hostMeetList.get(i).meet_content}<br> 위치 :
						${hostMeetDongList.get(i)} 인원 : ${hostMeetUserCountList.get(i)}
						카테고리 : ${hostMeetCategoryList.get(i)}
					</div>
					<hr>
				</c:forEach>
				<div class="btn-box">
					<c:if test="${hostMeetList.size() == 30 && meetHostTotalCnt > hostOffset + 30}">
						<form action="/item/listMeet.do" method="get">
							<input type="hidden" name="hostOffset" value="${hostOffset + 30}">
							<button type="submit" class="btn btn-submit">더 보기</button>
						</form>
					</c:if>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="user-boardlist">
		<h3>내 모임</h3>
		<c:choose>
			<c:when test="${meetList eq null or meetList.size() <= 0}">
				<p>현재 참여 중인 모임이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${meetList.size() - 1}">
					<div style="cursor: pointer;"
						onclick="location.href='/infoMeet.do?meet_no=${meetList.get(i).meet_no}&meet_dong=${meetDongList.get(i)}&meet_user_count=${ meetUserCountList.get(i) }&meet_category_name=${ meetCategoryList.get(i) }'">
						${meetList.get(i).meet_img}<br> ${meetList.get(i).meet_title}<br>
						${meetList.get(i).meet_content}<br> 위치 :
						${meetDongList.get(i)} 인원 : ${meetUserCountList.get(i)} 카테고리 :
						${meetCategoryList.get(i)}
					</div>
					<hr>
				</c:forEach>
				<div class="btn-box">
					<c:if test="${meetList.size() == 30 && meetTotalCnt > offset + 30}">
						<form action="/item/listMeet.do" method="get">
							<input type="hidden" name="offset" value="${offset + 30}">
							<button type="submit" class="btn btn-submit">더 보기</button>
						</form>
					</c:if>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

</div>

<%@ include file="../main/footer.jsp"%>