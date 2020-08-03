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
	<c:forEach items="${list }" var="dto" varStatus="status">
	<div class="class_box">
		<div class="newClass">
			<div class="class_tag_Div_Img"><img alt="" src="../creatorCenter/upload/${dto.classesPhoto }" class="class_tag_Img"></div>
			<div class="class_tag_Div_content">
				<div class="class_tag_Div_content_header">
					<span>${dto.classesSubject}</span>
					 <div class="class_tag_Div_DelImg" id="class_tag_Div_DelImg${status.index}" style=""><i class="fas fa-ellipsis-h"></i>
						<div class="class_tag_Div_DeleteBox_1${status.index}" id="class_tag_Div_DeleteBox_1${status.index}" style="display: none; overflow: visible;" >
							 <div class="class_tag_Div_DeleteBox_2">
								<span class="class_tag_Span_DeleteBox_1"><button type="button" class="btn_classDelete" id="delimg${status.index}" onclick="delclick('../cen/myClassDel.cen?classesNum=${dto.classesNum}')">삭제하기</button></span>
							</div> 
						 </div>
					</div>
				</div>
				<span class="class_tag_span_Sttus">클래스 작성 중</span>
				<span id="btn_pakegeAdd"><button type="button" class="class_tag_btn" onclick="pakegeAdd('../pd/productList.pd?classesNum=${dto.classesNum}')">패키지 상품 구성</button></span>
				<button type="button" class="class_tag_btn" id="btn_write" onclick="writePro('classSelect.cen?classesNum=${dto.classesNum}')">계속 작성하기</button>
			</div>
		</div>
	</div>
	</c:forEach>
</div>
</body>
<script src="../creatorCenter/js/myClass.js"></script>
</html>