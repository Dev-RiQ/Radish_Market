<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../main/header.jsp"%>
<div class="item-list-container">
	<div class="dir-history">
		<a style="cursor: pointer;" onclick="location.href='/index.jsp'">홈 > </a>
		<a style="cursor: pointer;" onclick="location.href='/listItem.do'">중고거래</a>
	</div>
	<h1>??시 ??구 ??동 중고거래</h1>
	<div class="btn-box">
		<a style="cursor: pointer;" onclick="location.href='/insertItem.do'">글 쓰기</a>
	</div>
	<c:forEach var="i" begin="0" end="${itemList.size()-1}">
		<div class="item-box" style="cursor: pointer;"
			onclick="location.href='/infoItem.do?item_no=${itemList.get(i).item_no}'">
			<div class="item-img">
				<img alt="" src="">이미지가 들어가요
			</div>
			<div class="item-body">
				<p>${itemList.get(i).item_name}</p>
				<p>${itemList.get(i).item_price}원</p>
				<p>${userDongList.get(i)}</p>
				<hr>
			</div>
		</div>
	</c:forEach>
</div>

<div class="btn-box">
	<c:if test="${itemList.size() == 30 && itemTotalCnt > offset + 30}">
		<form action="/item/listItem.do" method="get">
			<input type="hidden" name="offset" value="${offset + 30}">
			<button type="submit" class="btn btn-submit">더 구경하기</button>
		</form>
	</c:if>
</div>

<%@ include file="../main/footer.jsp"%>

