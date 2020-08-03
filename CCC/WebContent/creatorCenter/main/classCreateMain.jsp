<%@page import="model.DTO.ClassesDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class Create Main</title>
<link rel="stylesheet" href="../creatorCenter/css/class_Main.css">
<script src="https://kit.fontawesome.com/19c81546e5.js" crossorigin="anonymous"></script>
<script src="../creatorCenter/jquery/jquery.js"></script>
</head>
<body>
<div class="container">
	<nav class="navbar">
		<div class="navbar_logo">
			<span class="ccc_logo">C.C.C</span>
			<span>수요조사 시작하기</span>
			<c:if test="${stepChk eq 0 || stepChk eq null}">
            	<span class="persent">0%완료</span>
	         </c:if>
	         <c:if test="${stepChk eq 1}">
	            <span class="persent">25%완료</span>
	         </c:if>
	         <c:if test="${stepChk eq 2}">
	            <span class="persent">50%완료</span>
	         </c:if>
	         <c:if test="${stepChk eq 3}">
	            <span class="persent">75%완료</span>
	         </c:if>
	         <c:if test="${stepChk eq 4}">
	            <span class="persent">100%완료</span>
	         </c:if>
			
		</div>
		<div class="exit">
			<a href="classCreateExit.cen"><button type="button" class="exit_btn" id="exit_btn">나가기</button></a>
		</div>
	</nav>
	<div class="menu">
		<ul class="menu_ul">
			<li id="defaltInfo"><input type="image" src="../creatorCenter/img/svgtopng/one.png" class="numIcon">기본정보</li>
			<li id="classIntro"><input type="image" src="../creatorCenter/img/svgtopng/two.png" class="numIcon">클래스 등록</li>
			<li id="creatorIntro"><input type="image" src="../creatorCenter/img/svgtopng/three.png" class="numIcon">크리에이터 소개</li>
			<li id="openChk"><input type="image" src="../creatorCenter/img/svgtopng/four.png" class="numIcon">오픈 전 확인사항</li>
		</ul>
	</div>
	<div class="contents">
		<form class="form" method="post" name="classform" id="classform">
		<input type="hidden" name="classesStepChk" id="classesStepChk" value="${stepChk }">
			<div class="form_contents" id="form_contents">
			</div>
			<div class="space"></div>
			<div class="form_footer">
				<button type="button" id="backBtn">이전</button>
				<button type="button" id="saveBtn">저장하기</button>
				<!-- <button type="button" id="nextBtn">다음</button> -->
			</div>
		</form>
	</div>
</div>
</body>
<script src="../creatorCenter/js/classCreateMain.js"></script>
</html>