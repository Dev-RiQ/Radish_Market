<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<button onclick="location.href='/insertMeet.do'">모임생성</button>
<c:forEach var="i" begin="0" end="${ meetList.size() - 1 }">
		<div style="cursor:pointer;" onclick="location.href='/infoMeet.do?meet_no=${ meetList.get(i).meet_no }&meet_dong=${ meetDongList.get(i) }&meet_user_count=${ meetUserCountList.get(i) }&meet_category_name=${ meetCategoryList.get(i) }'">
			${ meetList.get(i).meet_img }<br>
			${ meetList.get(i).meet_title }<br>
			${ meetList.get(i).meet_content }<br>
			위치 : ${ meetDongList.get(i)}
			인원 : ${ meetUserCountList.get(i) }
			카테고리 : ${ meetCategoryList.get(i) }
		</div>
		<hr>
</c:forEach>
<c:if test="${ hasNext ne null }">
	<button onclick="location.href='/listBoard.do?start=${ start + 30 }'">더보기</button>
</c:if>

<%@ include file="../main/footer.jsp" %>