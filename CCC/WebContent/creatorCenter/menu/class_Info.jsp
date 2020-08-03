<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p{
margin: 0;
padding-left: 5px;
color: #ff2222;
}
.container {
	/* max-width: 1240px; */
	width: 100%;
	margin: 20px;
}
.filebox{
	width:100%;
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
.waring{
	display: none;
}

#classesPhoto {
	display: none;
}
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>



</head>
<body>
	<div class="container">
		<h2>간단하게 어떤 클래스인지 알려주세요.</h2>
		<h5>
			언젠가 이런 걸 가르쳐봐야지 생각해본 적이 있으신가요? 감성적이면서도 클래스를 잘 표현하는 제목과 이미지를 등록하고 간단히
			크리에이터님이 <br /> 알려줄수 있는 카테고리를 설정해주세요. 모든 수정 사항은 즉시 저장되니 안심해 주세요.
		</h5>
		<table style="border: 2px solid black; height: 500px">
			<input type="hidden" name="classesStep" id="classesStep" value="1" />
			<tr>
				<td>클래스 메인 제목<br /> <br /> <textarea style="overflow: auto"
						rows="3" cols="75"
						placeholder="예)댄스퍼포먼스, 영화연출, BODY & MIND SET, 문예창작...."
						name="classSubject" id="classSubject">${cla.classesSubject }</textarea>
						<br>
						<span class="waring" id="waring-1" disabled ><i class="fas fa-exclamation-triangle" id="warning"></i><p>필수 입력 사항입니다.</p></span>
				</td>
				
				<td
					style="width: 300px; height:500px; border: 1px dotted black; text-align: center"
					rowspan=4>
					<div class="filebox" id="filebox">
						<label class="">
						<input type="file" name="classesPhoto" id="classesPhoto">
						<c:if test="${empty cla.classesPhoto }">
							<img style="width: 100%;" src="../creatorCenter/img/svgtopng/photo.png" id="preImage"/>
						<br /> <br />커버 이미지를 첨부해주세요
						</c:if>
						<c:if test="${!empty cla.classesPhoto }">
							<img style="width: 100%;" src="../creatorCenter/upload/${cla.classesPhoto }" id="preImage"/>
						</c:if>
						</label>
					</div>
				</td>
			</tr>
			<tr>
				<td>카테고리<br /> <br /> <textarea style="overflow: auto"
						rows="3" cols="75"
						placeholder="예)크리에이티브(미술, 음악, 요리 등 취미 클래스를 만들고 싶어요)"
						name="classCategory" id="classCategory">${cla.classCategory }</textarea>
						<br>
						<span class="waring" id="waring-2"><i class="fas fa-exclamation-triangle" id="warning"></i><p>필수 입력 사항입니다.</p></span>
				</td>
			</tr>

			<tr>
				<td>콘텐츠 내용<br /> <br /> <textarea style="overflow: auto"
						rows="3" cols="75"
						placeholder="예)가죽공예, 어반 스케치, 딥펜 캘리그라피, 다이어리 꾸미기, 가계부작성,...."
						name="classContent" id="classContent">${cla.classesContent }</textarea>
						<br>
						<span class="waring" id="waring-3"><i class="fas fa-exclamation-triangle" id="warning"></i><p>필수 입력 사항입니다.</p></span>
				</td>
			</tr>
			<tr>
				<td>클래스에 대한 한마디<br /> <br /> <textarea style="overflow: auto"
						rows="3" cols="75"
						placeholder="독자들에게  해당 클래스에 대한 의미를 한줄로 요약하여 설명해주세요.    	   ex) '춤을 잘 추고 싶다면, 춤과 함께하는 그 시간까지도 받아들여야 한다' ."
						name="classSubMent" id="classSubMent">${cla.classSubMent }</textarea>
						<br>
						<span class="waring" id="waring-4"><i class="fas fa-exclamation-triangle" id="warning"></i><p>필수 입력 사항입니다.</p></span>
				</td>
			</tr>
			<tr>
				<td>클래스 가격을 산정해 주세요( 관리자에 의해 조정될 수 있습니다. )<br>
								<span class="waring" id="waring-5"><i class="fas fa-exclamation-triangle" id="warning"></i><p>필수 입력 사항입니다.</p></span>
					클래스 가격 입력 : <input type="number" class="classPrice" name="classPrice" id="classPrice" min="0" max="999999999" 
								placeholder="관리자에 의해 조정될 수 있습니다." style="width:200px;" value="${cla.classesPrice }"> 원 
				</td>
			</tr>

		</table>
	</div>


</body>
<script  src="../creatorCenter/js/class_info.js"></script>
</html>