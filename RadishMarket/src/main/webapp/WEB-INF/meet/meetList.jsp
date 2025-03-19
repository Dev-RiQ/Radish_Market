<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>

<button onclick="location.href='/insertMeet.do'">모임생성</button>

<div id="list-box">
	<!-- 여기 리스트 출력 -->
</div>
<button id="btn-more-list" value="meet/0" onclick="getMoreList()">더보기</button>

<%@ include file="../main/footer.jsp"%>

<script src="../../js/listPaging.js"></script>