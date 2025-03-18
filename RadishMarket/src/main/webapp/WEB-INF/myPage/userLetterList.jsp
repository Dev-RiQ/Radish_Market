<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>

<div class="useritemlist-container">

	<div class="user-profile">
		<div class="user-img">유저 이미지</div>
		<p>${user.user_nickname}</p>
		<p>${user.user_dong}</p>
		<p>${user.user_deg}</p>
		<p>매너온도</p>
	</div>

	<div class="user-sendletterlist">
		<h3>받은 쪽지</h3>
		<c:choose>
			<c:when test="${letterList eq null or letterList.size() == 0}">
				<p>아직 받은 쪽지가 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${letterList.size()-1}">
						<div class="receiveletter-body">
							<div class="item-box" id="show-letter${ letterList.get(i).letter_no }" style="cursor: pointer;"
						onclick="openPop('read')">
							<p>아이템 번호: ${letterList.get(i).item_no}</p>
							<p>받은 사람 번호: ${letterList.get(i).receive_user_no}</p>
							<p>보낸 사람 번호: ${letterList.get(i).send_user_no}</p>
							<p>제목: ${letterList.get(i).letter_title}</p>
							<p>내용: ${letterList.get(i).letter_content}</p>
							<p>전송시간: ${ letterList.get(i).letter_reg_datetime }</p>
							<p id="check-letter${ letterList.get(i).letter_no }">${letterList.get(i).letter_check == 0 ? '미확인 쪽지' : '확인한 쪽지'}</p>
						</div>
							<button onclick="location.href='deleteLetter.do?letter_no=${letterList.get(i).letter_no}'">삭제</button>
							<hr>
						</div>
				</c:forEach>
				<div class="btn-box">
					<c:if test="${itemList.size() == 30 && itemTotalCnt > offset + 30}">
						<form action="/item/listItem.do" method="get">
							<input type="hidden" name="offset" value="${offset + 30}">
							<button type="submit" class="btn btn-submit">더 보기</button>
						</form>
					</c:if>
				</div>
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
				<div class="btn-box">
					<c:if test="${itemList.size() == 30 && itemTotalCnt > offset + 30}">
						<form action="/item/listItem.do" method="get">
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
<script src="../../js/letter.js"></script>