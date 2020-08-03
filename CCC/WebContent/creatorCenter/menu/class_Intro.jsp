<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>class Introduce</title>
<link rel="stylesheet" href="../creatorCenter/css/class_intro.css">
<script src="https://kit.fontawesome.com/19c81546e5.js" crossorigin="anonymous"></script>
<script src="../creatorCenter/js/class_creator.js"></script>
</head>
<body>
<div class="container">
	<div class="intro">
	<input type="hidden" name="classesStep" id="classesStep" value="3" />
		<h3 class="form_h2">본인을 소개하고<br> 활동중인 SNS를 알려주세요</h3>
		<!-- <p>내 클래스를 한마디로 표현한다면 어떤 단어가 좋을까요? 간단하지만 효과적으로 클래스를 어필해보세요.</p> -->
		<div class="SummaryContent">
			<div class="form_container">
				<label class="form_h3">프로필</label>
				<label class="label_imgUpload">
					<input type="file" name="creatorImg" id="creatorImg"/>
					<div class="div_imgUpload">
					<c:if
						test="${empty creDto.creatorPhoto }">
						<img	src="../creatorCenter/img/svgtopng/profil2.png" id="preImage" />
					</c:if> 
					<c:if test="${!empty creDto.creatorPhoto }">
						<img	src="../creatorCenter/upload/${creDto.creatorPhoto }"
							id="preImage" />
					</c:if>
						<!-- <i class="fas fa-images fa-5x"></i> -->
					</div>
				</label>
			</div>
			<div class="form_tagDiv">
				<label class="tag_label">크리에이터 닉네임</label>
				<div class="tagBox">
					<input type="text" class="tag_text" name="creatorNname" placeholder="창의적인 닉네임이 기억에 남을것 같아요."
							value="${creDto.creatorNname }">
				</div>
					<h6>앞으로 활동할 닉네임을 적어주세요.</h6>
					<!-- <span>최대 6개 등록 가능</span> -->
				<div class="tag_texts">
					<h5>연락처</h5>
					<div class="tagBox">
						<input type="text" class="tag_text" name="creatorPh" placeholder="ex) 010-0000-****"
								value="${creDto.creatorPh1 }">
					</div>
					<h6>연락 가능한 연락처를 입력해주세요.</h6>
				</div>
			</div>
		</div>
		 <div class="div_creIntro">
			<h5>크리에이터 소개</h5>
			<div class="textAreaBox">
				<textarea  class="tag_textrea" name="creatorIntro">${creDto.creatorIntro }</textarea>
			</div>
		</div> 
		<div class="div_helpMent">
			<h6>응원을 얻기 위한 크리에이터님의 매력을 소개해주세요. 마지막 크리에이터님의 한마디가 클래스메이트님들의 마음을 움직일 수 있을 거예요! <br>다른 크리에이터님들은 어떻게 작성했는지 궁금하다면, 
				<a href="#">크리에이터 소개 가이드</a>를 참고해 주세요.</h6>
		</div>
	</div>
</div>
</body>
</html>