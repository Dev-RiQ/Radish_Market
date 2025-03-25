<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../main/header.jsp" %>
		<link rel="stylesheet" href="../../css/boardInfo.css">
		<section>
			<div class="board-info-box">
				<div class="lifethelook">
					<div class="titlebox"><a href='/index.jsp'>홈 > </a> <a href='/listBoard.do'>동네생활 > </a>
						<span>${board.board_title}</span></div>



					<progress id="progress" value="${user.user_deg}" max="100"></progress><br>

					<button onclick="location.href='/listBoard.do'">목록</button>
					<div class="lifethelooktxt">
						<div class="besttexts">
							<form action="/listBoard.do?filter=true" method="post">
								<input type="hidden" id="meet_no" name="meet_no" value="${ meet_no }" />
								<input type="hidden" id="gu" name="gu" value="${ gu }" />
								<label for="user_dong">위치</label><br> <label class="container"><input type="radio" name="dong" id="dong"
										value="전체" ${ userDong eq '전체' ? 'checked' : '' } />전체보기
									<span class="checkmark"></span>
								</label>
								<c:forEach var="category_dong" items="${ dongList }">
									<label class="container"><input type="radio" name="dong" id="dong" value="${ category_dong }" ${
											userDong eq category_dong ? 'checked' : '' } />${ category_dong }
										<span class="checkmark"></span>
									</label>
								</c:forEach>

								<hr>

								<label for="category_no">카테고리</label><br> <label class="container"><input type="radio"
										name="category_no" id="category_no" value="0" ${ categoryNo eq null || categoryNo eq 0 ? 'checked'
										: '' } />전체보기
									<span class="checkmark"></span>
								</label>
								<c:forEach var="category" items="${ categoryList }">
									<label class="container"><input type="radio" name="category_no" id="category_no"
											value="${ category.board_category_no }" ${ categoryNo eq category.board_category_no ? 'checked'
											: '' } />${ category.board_category_name }
										<span class="checkmark"></span>
									</label>
								</c:forEach>

								<hr>

								<label for="order_by">정렬</label> <label class="container"><input type="radio" name="order_by"
										id="order_by" value=0 ${ order_by eq null || order_by==0 ? 'checked' : '' } />최신순
									<span class="checkmark"></span>
								</label>
								<label class="container"><input type="radio" name="order_by" id="order_by" value=1 ${ order_by eq 1
										? 'checked' : '' } />인기순
									<span class="checkmark"></span>
								</label>
								<button>필터적용</button>
							</form>
						</div>


						<div class="pepoletxts">

							<div class="propil">
								<table>
									<tr>
										<td><button
												onclick="location.href='/listBoard.do?filter=true&category_no=${board.board_category_no}'">동네친구</button>
										</td>
										<td><button onclick="location.href='/listBoard.do'">목록</button></td>
										<c:if test="${ board.user_no == log }">
											<td><button onclick="location.href='/deleteBoard.do?board_no=${ board.board_no }'">삭제하기</button>
											</td>
											<td><button onclick="location.href='/updateBoard.do?board_no=${ board.board_no }'">수정하기</button>
											</td>
										</c:if> <!--게시글 유형-->
									</tr>

									<tr>
										<td rowspan="2">
											<div id="propilimg"><img alt="이미지"
													src="/images/${ user.user_img ne '' ? user.user_img : 'usersDefaultImg.png' }" /></div>
										</td> <!--프로필-->

										<td><a href="/userItemList.do?user_no=${ user.user_no }">${ user.user_nickname }</a></td> <!--이름-->
										<td>${ user.user_deg }℃</td>
									</tr> <!--온도-->
									<tr>
										<td colspan="5"><span><a href="listBoard.do?filter=true&dong=${user.user_dong }">${ user.user_dong
													}</a></span></td>
									</tr> <!--주소,시간-->



								</table>

								<div class="propiltxt">
									<h1>${ board.board_title }</h1> <!--게시글 제목-->
									<p>${ board.board_content }</p> <!--게시글 내용-->
									<div class="propiltxtimg">
										<c:if test="${ board.board_img ne '' }">
											<img alt="이미지" src="/images/${ board.board_img }" />
										</c:if>
									</div> <!--게시글 이미지-->
									<div class="likeandtxtbox">
										<div class="iconbox">
											<input type="hidden" name="user_no" id="user_no" value="${ board.user_no }">
											<input type="hidden" name="alarm_category_no" id="alarm_category_no" value="1">
											<input type="hidden" name="link_no" id="link_no" value="${ board.board_no }">
											<input type="hidden" name="isLike" id="isLike" value="${ isLike ne null ? isLike : 0 }">
											<button id="btn-like-submit" type="button" onclick="sendAlarm()"><i class="fa-solid fa-heart"
													style="color: ${isLike ne null && isLike == 1 ? 'red':'#ddd'};"></i> <span id="like-count">${
													likeCount }</span></button> <!--좋아요-->
											<i class="fa-solid fa-pen" style="color: greenyellow;"></i> ${ commentList.size() } <!--댓글-->

										</div>
										<div class="inquiry">
											<p>조회 ${ board.board_hits }</p> <!--조회수-->
										</div>

									</div>



									<div class="comments">
										<c:if test="${commentList.size() != 0}">
											<c:forEach var="i" begin="0" end="${commentList.size() - 1}">
												<table class="comment-img-table">
													<tr>
														<td rowspan="2">
															<div id="propilimg"><img alt="이미지" src="/images/usersDefaultImg.png" /></div>
														</td> <!--댓글 프로필-->
														<td>${ commentNickname.get(i) }</td> <!--이름-->
													</tr>
													<tr>
														<td colspan="5"><span>${ commentList.get(i).comment_reg_datetime } ${
																commentList.get(i).check_update == 1 ? '수정됨' : '' }</span></td>
													</tr> <!--온도-->
												</table>
												<div class="comments-txt" id="comment_content_box${ commentList.get(i).comment_no }">
													<div id="comment_content${ commentList.get(i).comment_no }">${
														commentList.get(i).comment_content }</div>
													<c:if test="${ log == commentList.get(i).user_no }">
														<button id="btn-comment-update${ commentList.get(i).comment_no }"
															onclick="commentUpdate(this)">수정</button>
													</c:if>
													<c:if test="${ log == commentList.get(i).user_no || log == board.user_no }">
														<button
															onclick="location.href='/deleteComment.do?user_no=${ board.user_no }&board_no=${ board.board_no }&comment_no=${commentList.get(i).comment_no}'">삭제</button>
													</c:if>
												</div>
											</c:forEach>
										</c:if>

									</div>

									<div class="writingout">
										<textarea name="comment_content" id="comment_content" placeholder="내용을 입력하세요."></textarea>
										<button id="btn-comment-submit" onclick="sendAlarm()"><i
												class="fa-solid fa-paper-plane"></i></button>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
		</section>

		<%@ include file="../main/footer.jsp" %>
			<script src="../../js/board.js"></script>