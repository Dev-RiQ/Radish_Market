<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>

<button
	onclick="location.href='/infoMeet.do?meet_no=${ meet_no }&meet_dong=${ meet_dong }&meet_user_count=${ meet_user_count }&meet_category_name=${ meet_category_name }''">모임
	홈</button>
<button onclick="location.href='/insertBoard.do?meet_no=${ meet_no }'">글쓰기</button>

<
<div id="list-box">
	<!-- 여기 리스트 출력 -->
</div>
<button id="btn-more-list" value="meetBoard/0" onclick="getMoreList()">더보기</button>

<%@ include file="../main/footer.jsp"%>

<script src="../../js/listPaging.js"></script>