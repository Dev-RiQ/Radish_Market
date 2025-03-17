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

	<div class="user-boardlist">
		<h3>내 게시글</h3>
		<c:choose>
			<c:when test="${boardList eq null or boardList.size() == 0}">
				<p>아직 작성한 게시글이 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${boardList.size()-1}">
					<div class="board-box" style="cursor: pointer;"
						onclick="location.href='/infoBoard.do?board_no=${ boardList.get(i).board_no }'">
						<div class="board-body">
							${ boardList.get(i).board_no } ${ boardList.get(i).user_no } ${ boardList.get(i).board_category_no }
							${ boardList.get(i).meet_no } ${ boardList.get(i).board_title } <br>
							${ boardList.get(i).board_content } <br> ${ boardList.get(i).board_reg_datetime }
							${ boardList.get(i).board_update_datetime } ${ boardList.get(i).board_img }
							${ boardList.get(i).board_hits } <br> ${ likeList.get(i) }
							${ commentList.get(i) }
							<hr>
						</div>
					</div>
				</c:forEach>
				<div class="btn-box">
					<c:if test="${boardList.size() == 30 && boardTotalCnt > offset + 30}">
						<form action="/item/listBoard.do" method="get">
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