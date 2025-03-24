<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<footer>
			<h1>Radish</h1>
		
			<div class="textbox">
		   		 <p>프로젝트명:Radish<br>전화번호:010-xxxx-xxxx<br>팀원: 이원규(팀장), 이종현(벡엔드), 정지원(프론트)</p>
		   
				<div class="sns">
					<i class="fa-brands fa-instagram"style="font-size: 30px;"></i>
				   <i class="fa-brands fa-github"style="font-size: 30px;"></i>
					<i class="fa-brands fa-twitter"style="font-size: 30px;"></i>
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
</html>