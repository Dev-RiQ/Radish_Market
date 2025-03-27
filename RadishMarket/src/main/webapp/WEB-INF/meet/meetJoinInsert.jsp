<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
<link rel="stylesheet" href="../../css/meetJoinInsert.css">
<section>
	<div class="meet-join-insert-box ">
		<form action="/insertMeetJoin.do?meet_no=${ meet.meet_no }"
			method="post">
			<div class="lettergoings">
				<div class="propilreview">
					<table>
						<tr>
							<td><h2>모임가입 신청서</h2>
								<br /></td>
						</tr>

						<tr>
							<td class="img-box-td"><div class="img-box"><img alt="대표이미지"
								src="/images/${ meet.meet_img ne '' ? meet.meet_img : 'meetsDefaultImg.png'}"></div></td>
							<!--모임 프로필-->
						</tr>

						<tr>
							<td>
								<h3>${ meet.meet_title }<br />
								</h3> <!--모임 이름-->
							</td>
						</tr>
					</table>
				</div>
				<div class="productletter">
					<div class="text">
						<div class="title">
							<h3>
								가입 신청 인사<span> *</span>
							</h3>
							<!--모임 내용-->
						</div>
						<textarea name="meet_join_content" id="meet_join_content"
							placeholder="가입 인사"></textarea>
						<br> <span id="content_check"></span>
						<!--내용 작성-->
					</div>
				</div>
				<input type="hidden" name="user_no" id="user_no"
					value="${ meet.host_user_no }"> <input type="hidden"
					name="alarm_category_no" id="alarm_category_no" value="8">
				<input type="hidden" name="link_no" id="link_no"
					value="${ meet.meet_no }">
				<div class="going">
					<button type="button" onclick="validCheck()">가입하기</button>
					<!--가입버튼-->
					<button type="button" class="delect" onclick="history.back()">취소</button>
					<!--취소버튼-->
				</div>
			</div>
		</form>
	</div>

</section>
<%@ include file="../main/footer.jsp"%>
<script src="../../js/meetJoinInsertValidCheck.js"></script>