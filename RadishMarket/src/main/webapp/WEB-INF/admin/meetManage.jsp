<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<div id="list-box">
	<!-- 여기 리스트 출력 -->
</div>
<button id="btn-more-list" value="adminMeet/0" onclick="getMoreList()">더보기</button>
<input type="hidden" id="category_no" name="category_no" value="0"/>
<input type="hidden" id="gu" name="gu" value="강남구"/>
<input type="hidden" id="dong" name="dong" value="전체"/>
<input type="hidden" id="order_by" name="order_by" value="0"/>
<input type="hidden" id="meet_no" name="meet_no" value="0"/>
<%@ include file="../main/footer.jsp" %>
<script src="../../js/listPaging.js"></script>