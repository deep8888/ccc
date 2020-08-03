<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
<%@ include file="../../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script language="javascript">
function chk() {
	/* var f = document.ctF;
	if (f.agree4.checked && f.agree3.checked && f.agree2.checked
			&& f.agree1.checked) {
		f.but.disabled = false;

	} else {
		f.but.disabled = true;

	} */
}
</script>
</head>
<style>
input[type=checkbox] {
	-ms-transform: scale(1.5);
	-moz-transform: scale(1.5);
	-webkit-transform: scale(1.5);
	-o-transform: scale(1.5);
	padding: 5px;
}
.container{
	width: 100%;
	margin: 20px;
}
#btn1 {
	background: #eee;
	color: black;
	width: 50px;
	height: 35px;
	line-height: 30px;
	text-align: center;
	border-radius: 8px;
}

#btn1:hover {
	background: #999797;
	color: black;
	border-radius: 8px;
}

#btn3 {
	border: 1px solid;
	background: #FBE7D0;
	color: white;
	width: 90px;
	height: 35px;
	line-height: 30px;
	text-align: center;
	border-radius: 8px;
}

.cklist {
	background: #EAE8E8;
	border-radius: 8px;
	width: 600px;
	padding: 15px 15px 15px 15px;
}

.ckopenmain {
	font-weight: bold;
	font-size: 25px;
	padding: 0px;
	margin: 0;
}

.ckopenmain2 {
	color: #B9B7B7;
}

.cksubject {
	font-weight: bold;
}

.ckfont {
	font-size: 15px;
}

.cktestck {
	font-size: 15px;
	color: orange;
}

a {
	text-decoration: none;
}
</style>
<body>
	<div class="container">
	<input type="hidden" name="classesStep" id="classesStep" value="4" />
		<div class="">
			<h3 class="ckopenmain">오픈 전 확인사항</h3>
			<div color="#858a8d" class="ckopenmain2">완벽한 페이지를 위해 오픈 전 마지막으로
				점검을 해보아요!</div>

			<br />
				<div class="cklist">
					<div font-weight="bold" class="cksubject">구체적으로 어떤 걸 배울 수 있는지
						알려주셨나요?</div>
					<div class="ckfont">내 클래스를 통해 배우게 될 나만의 기법, 노하우, 스킬을 소개해주세요.</div>
					<div class="">
						<hr color="#edeff0" class="">
					</div>
					<div class="">
						<label class=""> 
							<c:if test="${empty openRes }">
								<input type="checkbox" name="agree1"
								id="agree1" onClick="chk()" > 
							</c:if>	
							<c:if test="${!empty openRes }">
								<input type="checkbox" name="agree1"
								id="agree1" onClick="chk()" checked="${openRes }"> 
							</c:if>	
							<span class="ckfont">네, 모두 잘  적었어요.</span>
						</label>
					</div>
				</div>

				<br />

				<div class="cklist">
					<div font-weight="bold" class="cksubject">클래스를 통해 어떤 결과를 얻을 수
						있는지 알려주셨나요?</div>
					<div class="ckfont">내 클래스를 듣고 클래스메이트님들이 완성할 수 있는 작품 혹은 얻을 수
						있는 결과를 알려주세요.</div>

					<div class="">
						<hr color="#edeff0" class="">
					</div>

					<div class="">
						<label class=""> 
							<c:if test="${empty openRes }">
									<input type="checkbox" name="agree2"
								id="agree2" onClick="chk()" > 
							</c:if>
							<c:if test="${!empty openRes }">
									<input type="checkbox" name="agree2"
								id="agree2" onClick="chk()" checked="${openRes }"> 
							</c:if>
							<span class="ckfont">네, 모두 잘 적었어요.</span></label>
					</div>
				</div>

				<br />

				<div class="cklist">
					<div font-weight="bold" class="cksubject">맞춤법이 틀린 부분은 없었나요?</div>
					<div class="ckfont">오로지 텍스트와 이미지로 나의 클래스를 보여주는 곳이기 때문에 맞춤법은
						나의 인상을 결정짓는 중요한 부분이랍니다. 맞춤법 검사를 필수적으로 진행해 주세요.</div>
					<span class=""> <a
						href="https://search.naver.com/search.naver?sm=top_sug.pre&amp;fbm=1&amp;acr=1&amp;acq=%EB%84%A4%EC%9D%B4%EB%B2%84+%EB%A7%9E%EC%B6%A4&amp;qdt=0&amp;ie=utf8&amp;query=%EB%84%A4%EC%9D%B4%EB%B2%84+%EB%A7%9E%EC%B6%A4%EB%B2%95+%EA%B2%80%EC%82%AC%EA%B8%B0"
						target="_blank" rel="noreferrer" color="orange"
						class="sc-pbvYO hMYTdE sc-fznKkj sc-fzoXWK cyEwzl"> <span
							class="cktestck">맞춤법 검사기로 확인해보기</span></a></span>
					<div class="">
						<hr color="#edeff0" class="">
					</div>
					<div class="">
						<label class=""> 
						<c:if test="${empty openRes }">
							<input type="checkbox" name="agree3" id="agree3" onClick="chk()" > 
						</c:if>	
						<c:if test="${!empty openRes }">
							<input type="checkbox" name="agree3" id="agree3" onClick="chk()" checked="${openRes }" > 
						</c:if>	
						<span class="ckfont">네, 모두 잘
								적었어요.</span></label>
					</div>
				</div>

				<br />

				<div class="cklist">
					<div font-weight="bold" class="cksubject">부적절한 콘텐츠는 검토 후 유보될
						수 있습니다.</div>
					<div class="ckfont">클래스 내 광고성 및 불법(저작권 침해 등), 유해 콘텐츠가 포함된 경우
						클래스101에서 즉시 유보 처리할 수 있음을 안내드립니다. 이 부분에 충분히 인지하셨다면 체크 박스를 눌러주세요.</div>

					<div class="">
						<hr color="#edeff0" class="">
					</div>
					<div class="">
						<label class=""> 
						<c:if test="${empty openRes }">
							<input type="checkbox" name="agree4" id="agree4" onClick="chk()" >
						</c:if> 
						<c:if test="${!empty openRes }">
							<input type="checkbox" name="agree4" id="agree4" onClick="chk()" checked="${openRes }" >
						</c:if> 
						<span class="ckfont">네, 모두 잘 적었어요.</span></label>
					</div>
				</div>
</body>
</html>
