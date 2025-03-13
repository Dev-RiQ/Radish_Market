<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<button onclick="location.href='/insertBoard.do'">글쓰기</button>

<c:forEach var="board" items="${ boardList }">
		<div style="cursor:pointer;" onclick="location.href='/infoBoard.do?board_no=${ board.board_no }'">
			${ board.board_no }
			${ board.user_no }
			${ board.board_category_no }
			${ board.meet_no }
			${ board.board_title }<br>
			${ board.board_content }<br>
			${ board.board_reg_datetime }
			${ board.board_update_datetime }
			${ board.board_img }
			${ board.board_hits }<br>
		</div>
</c:forEach>
<c:if test="${ boardList.size() % 30 == 0 }">
	<button onclick="location.href='/listBoard.do?limit=${ limit + 30 }'">더보기</button>
</c:if>

<%@ include file="../main/footer.jsp" %>