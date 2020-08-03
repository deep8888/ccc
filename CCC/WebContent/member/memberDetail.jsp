<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/member/member_top.jsp"%>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$("#modify").click(function() {
			location.href = "memberPw.mem"
		});
		$("#memDel").click(function() {
			location.href = "memberUserDel.mem"
		});
		$("#pwModify").click(function() {
			location.href = "memberPwForm.mem"
		});
		
	});
	function btnclick(num){
		if(confirm("환불요청하시겠습니까? 자세한 환불금액은 환불규정을 참고해주세요.")){
		location.href=num;
			
		}
	}
	function btnSubmitclick(num){
		var test=confirm("취소승인을 하시겠습니까?");
		if(test==true){
			location.href=num;
			
		}
	
	}
			
		

</script>
<style type="text/css">
body {
	background-color: black;
	line-height: 1.5;
	color: white;
}

.page_body {
	margin-left: auto;
	margin-right: auto;
}

.mypage_container {
	padding-top: 16px;
	padding-bottom: 52px;
	display: flex;
	align-items: center;
	justify-content: space-around;
}

.buttum {
	padding: 8px 24px 0px;
}

.but {
	background-color: reg(248, 248, 249);
	border-bottom-color: rgb(27, 28, 29);
	border-bottom-left-radius: 3px;
	border-bottom-right-radius: 3px;
}

.myinpo {
	width: 230px;
	height: 279px;
	border-right: 1px align white;
	flex-grow: 1;
	padding-right: 10PX;
	background-color:;
}

.my_sukang {
	width: 230px;
	height: 279px;
	border-right: 1px align black;
	background-color:;
	flex-grow: 1;
}

.classbuy {
	width: 230px;
	height: 279px;
	border-left: 1px align black;
	background-color:;
	flex-grow: 1;
	padding-right: 10PX;
}
</style>
</head>

<body>

	<div class="root">
		<div id="wrapper">
			<div class="page_body">

				<main class="page_main">
					<div class="sc">
						<div class="mypage" style="ppadding-top: 24px;">
							<div class="mypage_rowcontainer"
								style="border-bottom: 1px align black;">
								<span>마이 페이지</span>
							</div>
							<hr />
							<div style="height:auto" class="mypage_container">

								<div class="myinpo" style="">
									<h3 style="align-items: center;">내정보</h3>
									<hr style="border:2px dotted grey"/>
									<div style="">
										<table border="1px" align="center" cellpadding=3
											border-right: 1pxalignblack; >
											<tr>
												<td><span id="font1">이메일</span></td>
												<td><span id="font1">${memberDTO.userEmail }</span></td>
											</tr>
											<tr>
												<td><span id="font1">사용자 이름</td>
												<td><span id="font1"> ${memberDTO.userName } </span></td>
											<tr>
												<td colspan="2"><span id="font1">기본정보 </span></td>
											</tr>
											</tr>

											<tr>
												<td><span id="font1">사용자 주소</span></td>

												<td><span id="font1"> ${memberDTO.userAddr } </span></td>
												</span>
											</tr>
											<tr>
												<td><span id="font1">연락처</span></td>
												<td><span id="font1"> ${memberDTO.userPh1 } </span> </span>
											</tr>

											<td colspan=2 align="center"><input type="button"
												name="modify" id="modify" value="수   정"> <input
												type="button" name="pwModify" id="pwModify" value="비밀번호변경">
												<input type="button" value="탈퇴" id="memDel" /></td>


										</table>
									</div>
								</div>
								<c:if test="${userEmail ne 'master@ccc.com' }">
									<div class="myinpo" style="">
										<h3 style="align-items: center;">구매이력</h3>
										<hr style="border:2px dotted grey"/>
										<div style="">
											<table  style="text-align: right"border="1px" align="center" cellpadding=3
												border-right: 1pxalignblack; >
												<tr>
													<td><span id="font1">구매번호</span></td>
													<td><span id="font1">클래스</span></td>
													<td><span id="font1">클래스 가격</span></td>
													<td><span id="font1">패키지 구성품 가격<br/>(배송비포함)</span></td>
													<td><span id="font1">구매일</span></td>
													<td><span id="font1">만료일</span></td>
													<td><span id="font1">취소요청</span></td>
												</tr>
												<c:forEach items="${Purchaselist }" var="dto">
												<form action="../classesRefund.cs" id="frm">
													<tr>
														<td>${dto.purchaseNum }</td>
														<td>${dto.classesSubject }</td>
														<td><fmt:formatNumber value="${dto.classesPrice }" type="currency"></fmt:formatNumber></td>
														<td><fmt:formatNumber value="${dto.purchasePrice-dto.classesPrice}" type="currency"></fmt:formatNumber></td>
																
														<td><fmt:formatDate value="${dto.purchaseDate }"
																type="date" pattern="yyyy-MM-dd" /></td>
														<td><fmt:formatDate value="${dto.expireDate }"
																type="date" pattern="yyyy-MM-dd" /></td>
																<c:if test="${dto.refund eq 'Y' && dto.refundOk ne 'Y'	}">
																<td style="text-align:center">취소확인중</td></c:if>
																
																<c:if test="${dto.refundOk eq 'Y' && dto.refund eq 'Y' }">
																<td style="text-align:center">취소완료</td>
																</c:if>
																
																
																<c:if test="${dto.refund ne 'Y' }">
																<td style="text-align:center">
																<button type="button" value="취소" id="btn" onclick="btnclick('../classesRefund.cs?purchaseNum=${dto.purchaseNum }')">취소</button></td>
																</c:if>

													</tr>
												</form>
												</c:forEach>
												
											</table>
											
										</div>
									</div>
								


							</div>
							<br />
							<hr style="border:2px dotted grey"/>
							<div style="width:700px;margin-left:800px;text-align:left"><h4>※ 환불 규정 ※</h4>소비자가 구매한 클래스 수강취소를 원할시 환불규정(구매일 기준 7일이내, 클래스 수강률 0% ~ 20% : 100% 환불, 수강률 21% ~ 30% : 80% 환불, 수강률 31% ~ 40% : 60% 환불, 수강률 41% 이상 : 환불불가)기준에 의해 처리된다. 패키지 구성품의 환불을 요청할시에 관리자는 소비자로부터 취소요청서(구매자, 구매일, 제품명, 수량)를 제출받고 환불규정을 공지하고 물품을 회수한다.(배송완료일로부터 7일이내의 재판매가 가능한 상태의 제품, 즉 본품과 포장박스가 훼손되지않은 상태의 제품만 환불가능)</div>
								</c:if>
								</div>
							<c:if test="${userEmail eq 'master@ccc.com' }">
							<h2>승인 대기 중인 클래스</h2>
							<hr/>
							<div style="text-align:center">
							<table style="border:1px solid white;margin:0 auto">
								<tr>
									<td style="border:1px solid white">No</td>
									<td style="border:1px solid white">클래스명</td>
									<td style="border:1px solid white">등록일</td>
									<td style="border:1px solid white">승인여부</td>
								</tr>
								<c:forEach items="${NotOpenlist }" var="dto" varStatus="cnt">
									<tr>
										<td style="border:1px solid white">${cnt.count }</td>
										<td style="border:1px solid white"><a href="classesViewAdmin.cs?classesNum=${dto.classesNum }">${dto.classesSubject }</a></td>
										<td style="border:1px solid white">${dto.regDate }</td>
										<td style="border:1px solid white">${dto.submitOk }</td>
									</tr>
								</c:forEach>
							</table>
							
							</div>
							<hr/>
							<h2>취소 요청 중인 클래스</h2>
							
							<table style="border:1px solid white;margin:0 auto">
								<tr>
									<td style="border:1px solid white">No</td>
									<td style="border:1px solid white">구매번호</td>
									<td style="border:1px solid white">구매일</td>
									<td style="border:1px solid white">구매자</td>
									<td style="border:1px solid white">구매가격</td>
									<td style="border:1px solid white">취소승인</td>
								</tr>
								<c:forEach items="${refundlist }" var="dto" varStatus="cnt">
									<tr>
										<td style="border:1px solid white">${cnt.count }</td>
										<td style="border:1px solid white">${dto.purchaseNum }</td>
										<td style="border:1px solid white">${dto.purchaseDate }</td>
										<td style="border:1px solid white">${dto.userEmail }</td>
										<td style="border:1px solid white">${dto.purchasePrice }</td>
										<td style="border:1px solid white"><button type="button" value="취소" id="btn" onclick="btnSubmitclick('?purchaseNum=${dto.purchaseNum }')">취소승인</button></td>
									</tr>
								</c:forEach>
							</table>
							
							
							
							
							
							
							
							
							
							
							</c:if>
						</div>
					</div>
				</main>
				<hr />

			</div>
		</div>
	</div>
	<%@ include file="/member/member_bottom.jsp"%>
</body>
</html>