<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="div_h3">
		<h3>본인을 소개하고<br>활동중인 SNS 채널을 알려주세요</h3>
	</div>
	<div class="div_imgUpload">
		<label class="label_imgUpload"> 프로필을 등록해 주세요
			<input type="file"	name="creatorImg" id="creatorImg"> 
			<c:if
				test="${empty creDto.creatorPhoto }">
				<img style="width: 200px;"	src="../creatorCenter/img/svgtopng/photo.png" id="preImage" />
			</c:if> 
			<c:if test="${!empty creDto.creatorPhoto }">
				<img style="width: 200px;"	src="../creatorCenter/upload/${creDto.creatorPhoto }"
					id="preImage" />
			</c:if>
		</label>
	</div>
	<div class="cre_content">
		<div class="cre_Nname">
		</div>
		<div class="cre_Ph">
		</div>
	</div>
	<div class="cre_Intro">
	</div>
</div>
</body>
</html>