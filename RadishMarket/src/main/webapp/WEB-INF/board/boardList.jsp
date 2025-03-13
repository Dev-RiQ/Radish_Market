<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<button onclick="location.href='/insertBoard.do'">글쓰기</button>

<c:forEach var="i" begin="0" end="${ boardList.size() - 1 }">
		<div style="cursor:pointer;" onclick="location.href='/infoBoard.do?board_no=${ boardList.get(i).board_no }'">
			${ boardList.get(i).board_no }
			${ boardList.get(i).user_no }
			${ boardList.get(i).board_category_no }
			${ boardList.get(i).meet_no }
			${ boardList.get(i).board_title }<br>
			${ boardList.get(i).board_content }<br>
			${ boardList.get(i).board_reg_datetime }
			${ boardList.get(i).board_update_datetime }
			${ boardList.get(i).board_img }
			${ boardList.get(i).board_hits }<br>
			${ likeList.get(i) }
			${ commentList.get(i) }<br>
		</div>
</c:forEach>
<c:if test="${ hasNext ne null }">
	<button onclick="location.href='/listBoard.do?start=${ start + 30 }'">더보기</button>
</c:if>

<%@ include file="../main/footer.jsp" %>