<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/19c81546e5.js"
	crossorigin="anonymous"></script>
<script src="../creatorCenter/js/class_creator.js"></script>
<style type="text/css">
.container {
	width: 100%;
}

.filebox {
	width: 300px;
	display: flex;
	flex-direction: column;
}

.filebox label {
	display: inline-block;
	padding: .5em .75em;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	cursor: pointer;
	-webkit-transition: background-color 0.2s;
	transition: background-color 0.2s;
}

.div_imgUpload {
	border: 1px dotted gray;
	width: 200px;
	height: 100px;
	margin-right: 30px;
}

.div_imgUpload p {
	margin: 20px 20px 0px;
}

#creatorImg {
	display: none;
}
</style>
</head>
<body style="width: 1000px; display: flex;">
	<div class="container">
		<input type="hidden" name="classesStep" id="classesStep" value="3" />
		<table width=1000px align="center" border=1 cellpadding=3>
			<tr test-align="center">
				<td colspan="2" style="text-align: center; border: none">
					<h2>본인을 소개하고 활동중인 SNS 채널을 알려주세요</h2>
				</td>

				<td rowspan="10" style="width: 300px; border: none;">
					<form></form>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border: none;">
					<div class="filebox" id="filebox">
						<div class="div_imgUpload">
							<label class="label_imgUpload"> 
								<input type="file"	name="creatorImg" id="creatorImg"> 
								<c:if
									test="${empty creDto.creatorPhoto }">
									<img style="width: 100%;"	src="../creatorCenter/img/svgtopng/photo.png" id="preImage" />
								</c:if> 
								<c:if test="${!empty creDto.creatorPhoto }">
									<img style="width: 100%;"	src="../creatorCenter/upload/${creDto.creatorPhoto }"
										id="preImage" />
								</c:if>
								<p>
									프로필을 등록해주세요.<br>'권장 사이즈 1200*1600px'
								</p>
							</label>
						</div>
					</div>
				</td>
			</tr>

			<tr style="border-left: none; border-right: none;">
				<td style="border: none;">크리에이터 닉네임<br /> <br /> <input
					type="text" style="width: 500px; height: 100px;"
					placeholder="사용할 닉네임을 적어주세요" name="creatorNname" id="creatorNname"
					value="${creDto.creatorNname }">
				</td>
			</tr>

			<tr style="border: none;">
				<td style="border: none;">연락처<br /> <br /> <input type="text"
					style="width: 500px; height: 100px;" placeholder='010-********'
					name="creatorPh" id="creatorPh" value="${creDto.creatorPh1 }">
				</td>
			</tr>
			<tr style="border: none;">
				<td style="border: none; align-content: center;">
					<button style="">+ 채널 추가하기</button>
				</td>
			</tr>
			<tr style="height: 100px; border: none;">

				<td style="border: none;">크리에이터 소개<br /> <br /> <input
					type="text" style="width: 500px; height: 100px;"
					placeholder="크리에이터님이 어떤분이신지 소개해주세요" name="creatorIntro"
					value="${creDto.creatorIntro }">

				</td>
			</tr>
			<tr style="border: none;">
				<td colspan="2" style="border: none;">응원을 얻기 위한 크리에이터님의 매력을
					소개해주세요. 마지막 크리에이터님의 한마디가 클래스메이트님들의 마음을 움직일 수 있을 거예요! 다른 크리에이터님들은
					어떻게 작성했는지 궁금하다면, <span><a href="#">크리에이터 소개 가이드</a></span> 를 참고해
					주세요.
				</td>
			</tr>
		</table>
	</div>
</body>
</html>