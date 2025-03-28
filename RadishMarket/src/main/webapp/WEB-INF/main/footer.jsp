<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<footer>
			<div class="footertext">
		        <div class="footerleft">
		          <img src="/images/logo.png" alt="로고" />
		          <div class="sns">
		          <a href="https://github.com/Dev-RiQ/Radish_Market.git">
		            <i class="fa-brands fa-instagram"></i>
		          </a>
		          <a href="https://github.com/Dev-RiQ/Radish_Market.git">
		            <i class="fa-brands fa-github"></i>
		          </a>
		          <a href="https://github.com/Dev-RiQ/Radish_Market.git">
		            <i class="fa-brands fa-twitter"></i>
		          </a>
		          </div>
		        </div>
		
		        <div class="footerright">
		          <span>조장 이원규 | 조원 이종현, 정지원</span>
		          <span>직업정보제공사업 신고번호 J100001122382</span>
		          <span>통신판매업 신고번호 2025-서울강남-99999</span>
		          <span>호스팅 사업자 LocalHost:8080</span>
		          <span>전화 1234-5678 | 고객문의 cs@radish.com</span>
		        </div>
		      </div>
		      <div class="termsandconditionsofuse">
		        <div class="termsandconditionsofuse-link">
		          <a href="/eyongyakgwan.jsp">이용약관</a>
		          <a href="/gainjungbo.jsp">개인정보처리방침</a>
		
		          <a href="/eunyoungjungcheck.jsp">운영정책</a>
		
		          <a href="/witchgibanservice.jsp">위치기반서비스 이용약관</a>
		
		          <a href="/eyongjaboho.jsp">이용자보호 비전과 계획</a>
		          <a href="/cheongsoyeonboho.jsp">청소년보호정책</a>
		        </div>
		      </div>
			<input type="hidden" name="address" id="address" value="${ address }">
			<input type="hidden" name="gu" id="gu" value="${ gu }">
			<input type="hidden" name="dong" id="dong" value="${ dong }">
	</footer>
	
		
</body>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d1caf6cb5052d4cc130fc975732c5c15&libraries=services"></script>
<script src="../../js/listPaging.js"></script>
<script src="../../js/getUserJuso.js"></script>
<script src="../../js/main.js"></script>
<script src="../../js/alarm.js"></script>
<script src="../../js/pageLoading.js"></script>
<script src="../../js/changeViewMode.js"></script>
<script src="../../js/filterMenu.js"></script>
</html>