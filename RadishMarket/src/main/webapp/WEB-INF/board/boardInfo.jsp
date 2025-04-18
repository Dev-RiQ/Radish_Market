<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../main/header.jsp" %>
		<link rel="stylesheet" href="../../css/boardInfo.css">
		<link rel="stylesheet" href="../../css/boardList.css">

		<section>
			<div class="board-info-box">
				<div class="lifethelook">
					<div class="titlebox">
						<div class="dir-history">
							<a href='/index.jsp'>홈 > </a> <a href='/listBoard.do'>동네생활 </a>
						</div>
					</div>
					<button class="btn-action-filter" onclick="openNav()"><i class="fa-solid fa-sliders"></i> 필터</button>
					<div class="lifethelooktxt">
						<div class="besttexts">
							<form action="/listBoard.do?filter=true" method="post">
							<hr>
								<input type="hidden" id="meet_no" name="meet_no" value="${ meet_no }" />
								<input type="hidden" id="gu" name="gu" value="${ gu }" />
								<label class="filter-label" for="user_dong">위치</label><br>

								<label class="container">
									<input type="radio" name="dong" id="dong" value="전체" ${ user_dong eq '전체' ? 'checked' : '' } />
									전체보기
									<span class="checkmark"></span>
								</label>
								<c:forEach var="category_dong" items="${ dongList }">
									<label class="container">
										<input type="radio" name="dong" id="dong" value="${ category_dong }" ${user_dong eq category_dong
											? 'checked' : '' } />
										${ category_dong }
										<span class="checkmark"></span>
									</label>
								</c:forEach>
								<hr>

								<label class="filter-label" for="category_no">카테고리</label>
								<br>
								<label class="container">
									<input type="radio" name="category_no" id="category_no" value="0" ${category_no eq null ||
										category_no==0 ? 'checked' : '' } />전체보기
									<span class="checkmark"></span>
								</label>
								<c:forEach var="category" items="${ categoryList }">
									<label class="container">
										<input type="radio" name="category_no" id="category_no" value="${ category.board_category_no }" ${
											category_no eq category.board_category_no ? 'checked' : '' } />
										${ category.board_category_name }
										<span class="checkmark"></span>
									</label>
								</c:forEach>
								<hr>

								<label class="filter-label" for="order_by">정렬</label>
								<label class="container">
									<input type="radio" name="order_by" id="order_by" value=0 ${order_by eq null || order_by==0
										? 'checked' : '' } />최신순
									<span class="checkmark"></span>
								</label>

								<label class="container">
									<input type="radio" name="order_by" id="order_by" value=1 ${ order_by==1 ? 'checked' : '' } />인기순
									<span class="checkmark"></span>
								</label>
								<button>필터적용</button>
							</form>
						</div>

						<div class="pepoletxts">
							<div class="propil">
								<table>
									<tr>
										<td><button class="board-info-btn"
												onclick="location.href='/listBoard.do?filter=true&category_no=${board.board_category_no}'">${category_name}</button>
										</td>
										<td><button class="board-info-btn" onclick="location.href='/listBoard.do?meet_no=${board.meet_no}'">목록</button></td>
										<c:if test="${ board.user_no == log }">
											<td><button onclick="location.href='/deleteBoard.do?board_no=${ board.board_no }'">삭제하기</button>
											</td>
											<td><button onclick="location.href='/updateBoard.do?board_no=${ board.board_no }'">수정하기</button>
											</td>
										</c:if>
										<!--게시글 유형-->
									</tr>

									<!--주소,시간-->
								</table>
								<div class="user-profile-container">
									<div class="user-profile-inner-container">
										<section class="user-profile-section1">
											<img alt="대표이미지" src="/images/${user.user_img ne '' ? user.user_img : 'usersDefaultImg.png'}">
											<div class="user-profile-text-box">
												<a class="user-profile-nickname" href='/itemListUser.do?user_no=${user.user_no}'>${user.user_nickname}</a>
												<span class="user-profile-dong">
													<a style="margin-left:0;" href='/listItem.do?filter=true&gu=${user.user_gu}&dong=${user.user_dong}'>${user.user_dong}</a>
												</span>
											</div>
										</section>
										<section class="user-profile-section2">
											<div class="user-profile-inner-section">
												<div class="user-profile-inner-box1">
													<span class="user-profile-deg">${user.user_deg}℃</span> <span class="user-profile-emoji">${emoji}</span>
												</div>
												<div class="user-profile-inner-box2">
													<progress value="${user.user_deg}" max="100"></progress>
												</div>
												<div class="user-profile-inner-box3">
													<p class="ondo-label">매너온도</p>
												</div>
											</div>
										</section>
									</div>
								</div>

								<div class="propiltxt">
									<h1>${ board.board_title }</h1>
									<!--게시글 제목-->
									<p>${ board.board_content }</p>
									<!--게시글 내용-->
									<div class="propiltxtimg">
										<c:if test="${ board.board_img ne '' }">
											<img alt="이미지" src="/images/${ board.board_img }" />
										</c:if>
									</div>
									<!--게시글 이미지-->
									<div class="likeandtxtbox">
										<div class="iconbox">
											<input type="hidden" name="user_no" id="user_no" value="${ board.user_no }"> <input type="hidden"
												name="alarm_category_no" id="alarm_category_no" value="1">
											<input type="hidden" name="link_no" id="link_no" value="${ board.board_no }"> <input type="hidden"
												name="isLike" id="isLike" value="${ isLike ne null ? isLike : 0 }">
											<button id="btn-like-submit" type="button" onclick="sendAlarm()">
												<i class="fa-solid fa-heart"
													style="color: ${isLike ne null && isLike == 1 ? 'red':'#ddd'};"></i>
												<span id="like-count">${
													likeCount }</span>
											</button>
											<!--좋아요-->
											<div>
												<i class="fa-solid fa-pen" style="color: greenyellow;"></i><span> ${ commentList.size() }</span>
											</div>
											<!--댓글-->
										</div>
										<div class="inquiry">
											<p>조회 ${ board.board_hits }</p>
											<!--조회수-->
										</div>
									</div>

									<div class="comments">
										<c:if test="${commentList.size() != 0}">
											<c:forEach var="i" begin="0" end="${commentList.size() - 1}">
												<div class="user-profile-container">
													<div class="user-profile-inner-container">
														<section class="user-profile-section1">
															<img class="comment-img" alt="대표이미지" src="/images/${commentUserImgList.get(i) ne '' ? commentUserImgList.get(i) : 'usersDefaultImg.png'}">
															<div class="user-profile-text-box">
																<a href="/itemListUser.do?user_no=${commentList.get(i).user_no}">${ commentNickname.get(i) }</a>
																<span class="user-profile-dong">
																	<a></a>
																	<span>${commentUserDongList.get(i)}</span>
																	<span> · ${commentUpdateTime.get(i)}</span>
																	<span>${commentList.get(i).check_update == 1 ? ' · 수정됨' : '' }</span>
																</span>
															</div>
														</section>
													</div>
												</div>
												<div class="comments-txt" id="comment_content_box${ commentList.get(i).comment_no }">
													<div id="comment_content${ commentList.get(i).comment_no }">${
														commentList.get(i).comment_content }</div>
												</div>
													<div class="btn-boxs">
												<c:if test="${ log == commentList.get(i).user_no }">
													<button id="btn-comment-update${ commentList.get(i).comment_no }"
														onclick="commentUpdate(this)">수정</button>
												</c:if>
												<c:if test="${ log == commentList.get(i).user_no || log == board.user_no }">
													<button
														onclick="location.href='/deleteComment.do?user_no=${ commentList.get(i).user_no }&board_no=${ board.board_no }&comment_no=${commentList.get(i).comment_no}'">삭제</button>
												</c:if>
													</div>
											</c:forEach>
										</c:if>

									</div>

									<div class="writingout">
										<textarea name="comment_content" id="comment_content" placeholder="내용을 입력하세요."></textarea>
										<button id="btn-comment-submit" onclick="checkValid()">
											<i class="fa-solid fa-paper-plane"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
			<div id="myNav" class="overlay">
	<form action="/listBoard.do?filter=true&search_value=${ search_value }" method="post">
      <div class="category-header">
        <h3>자유게시판 검색 필터</h3>
        <button type="button" class="closebtn" onclick="closeNavbar()"><i class="fa-solid fa-xmark"></i></button>
      </div>
      <div class="categorymain">
        <div class="local">
          <div class="title">
            <h3>
              위치 - ${ address }
            </h3>
          </div>
			   <label class="container"><input
				type="radio" name="dong" id="dong" value="전체"
				${ userDong eq '전체' ? 'checked' : '' } />전체보기
				<span class="checkmark"></span>
				</label>
			<c:forEach var="category_dong" items="${ dongList }">
				<label class="container"><input type="radio" name="dong" id="dong"
					value="${ category_dong }"
					${ userDong eq category_dong ? 'checked' : '' } />${ category_dong }
					<span class="checkmark"></span>
					</label>
			</c:forEach>
        </div>
        
        <div class="menue">
          <div class="title"><h3>카테고리</h3></div>
          <label class="container"><input
				type="radio" name="category_no" id="category_no" value="0"
				${ categoryNo eq null || categoryNo eq 0 ? 'checked' : '' } />전체보기
				<span class="checkmark"></span>
				</label>
			<c:forEach var="category" items="${ categoryList }">
				<label class="container"><input type="radio" name="category_no" id="category_no"
					value="${ category.board_category_no }"
					${ categoryNo eq category.board_category_no ? 'checked' : '' } />${ category.board_category_name }
					<span class="checkmark"></span>
					</label>
			</c:forEach>
        </div>
        
        <div class="order-by">
          <div class="title">
            <h3>
              정렬
            </h3>
          </div>
          <label class="container"><input
				type="radio" name="order_by" id="order_by" value=0
				${ order_by eq null || order_by == 0 ? 'checked' : '' } />최신순
				<span class="checkmark"></span>
				</label>
			<label class="container"><input type="radio" name="order_by" id="order_by"
				value=1 ${ order_by eq 1 ? 'checked' : '' } />인기순
				<span class="checkmark"></span>
				</label>
         </div>
          
        
      </div>
      <div class="categoryfooter">
        <button class="application">적용하기</button>
      </div>
      </form>
    </div>
		</section>

		<%@ include file="../main/footer.jsp" %>
			<script src="../../js/board.js"></script>