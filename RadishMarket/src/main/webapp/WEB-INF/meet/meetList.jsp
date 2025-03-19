<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>

<div class="dir-history">
		<a href='/index.jsp'>홈 > </a> <a href='/listMeet.do'>모임 </a>
	</div>

<button onclick="location.href='/insertMeet.do'">모임생성</button>

	<input type="hidden" id="user_dong" value="역삼동" >
<div id="list-box">
	<!-- 여기 리스트 출력 -->
</div>
<button id="btn-more-list" value="meet/0" onclick="getMoreList()">더보기</button>

<script src="../../js/listPaging.js"></script>

<%@ include file="../main/footer.jsp"%>