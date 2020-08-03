<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my Class</title>
<link rel="stylesheet" href="../creatorCenter/css/myClass.css">
<script src="https://kit.fontawesome.com/19c81546e5.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<div class="header">
		<span class="h1"><h1>온라인 클래스</h1></span>
		<span class="h2"><a href="classNewCreate.cen"><i class="fas fa-plus"></i>새로운 클래스</a></span>
	</div>
	<div class="class_box">
		<div class="newClass">
			<div class="class_tag_Div_Img"><img alt="" src="../creatorCenter/img/svgtopng/class_ex.png" class="class_tag_Img"></div>
			<div class="class_tag_Div_content">
				<div class="class_tag_Div_content_header">
					<span>온라인 쇼핑몰 창업준비는 여기로 !온라인 쇼핑몰 창업준비는 여기로 !</span>
					<div class="class_tag_Div_DelImg" id="class_tag_Div_DelImg"><i class="fas fa-ellipsis-h"></i>
						<div class="class_tag_Div_DeleteBox_1" id="class_tag_Div_DeleteBox_1">
							<div class="class_tag_Div_DeleteBox_2">
								<span class="class_tag_Span_DeleteBox_1"><button class="btn_classDelete">삭제하기</button></span>
							</div>
						</div>
					</div>
				</div>
				<span class="class_tag_span_Sttus">클래스 작성 중</span>
				<span id="btn_pakegeAdd"><input type="button" class="class_tag_btn" value="패키지 상품 구성"/></span>
				<input type="button" class="class_tag_btn" id="btn_write" value="계속 작성하기"/>
			</div>
		</div>
		<div class="newClass">
			
		</div>
	</div>
</div>
</body>
<script src="../creatorCenter/js/myClass.js"></script>
</html>