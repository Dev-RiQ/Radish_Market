<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>
<input type="hidden" id="log" value="${ log }" />
<div class="useritemlist-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}℃ ${emoji}</p>
		<progress id="progress" value="${user.user_deg}" max="100"></progress>
		<p>매너온도</p>
	</div>

	<div class="user-sendletterlist">
		<h3>받은 쪽지 (${empty letterList ? 0 : letterList.size()})</h3>
		<c:choose>
			<c:when test="${empty letterList}">
				<p>아직 받은 쪽지가 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${letterList.size()-1}">
					<div class="item-box"
						id="show-letter${ letterList.get(i).letter_no }"
						style="cursor: pointer;" onclick="openPop('read')">
						<p>아이템 번호: ${letterList.get(i).item_no}</p>
						<p>받은 사람 번호: ${letterList.get(i).receive_user_no}</p>
						<p>보낸 사람 번호: ${letterList.get(i).send_user_no}</p>
						<p>제목: ${letterList.get(i).letter_title}</p>
						<p>내용: ${letterList.get(i).letter_content}</p>
						<p>전송시간: ${ letterList.get(i).letter_reg_datetime }</p>
						<p id="check-letter${ letterList.get(i).letter_no }">${letterList.get(i).letter_check == 0 ? '미확인 쪽지' : '확인한 쪽지'}</p>
					</div>
					<button
						onclick="location.href='deleteLetter.do?letter_no=${letterList.get(i).letter_no}'">삭제</button>
					<hr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="user-receiveletterlist">
		<h3>보낸 쪽지</h3>
		<c:choose>
			<c:when test="${itemList eq null or itemList.size() == 0}">
				<p>아직 보낸 쪽지가 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${itemList.size()-1}">
					<div class="item-box" style="cursor: pointer;"
						onclick="location.href='/infoItem.do?item_no=${itemList.get(i).item_no}'">
						<div class="sendletter-body">
							<p>${itemList.get(i).item_name}</p>
							<p>${itemList.get(i).item_price}원</p>
							<p>${userDongList.get(i)}</p>
							<hr>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<script src="../../js/letter.js"></script>

<%@ include file="../main/footer.jsp"%>