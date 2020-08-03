    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../creatorCenter/css/style.css">
<script src="https://kit.fontawesome.com/19c81546e5.js" crossorigin="anonymous"></script>
<script src="../creatorCenter/jquery/jquery.js"></script>
<title>Insert title here</title>
</head>
<style>
h1{padding:0; left-margin:0; margin: 0;}
</style>
<body>
<div class="containar">
	<nav class="navbar">
		<div class="navbar_logo">
			<span><a href="../main.ccc">CCC</a></span>
			<span><a href="classCreateExit.cen">CREATOR CENTER</a></span>
		</div>
		<ul class="navbar_icons">
			<li><a href="#">소개</a></li>
			<li><a href="#">크리에이터 가이드</a></li>
			<li><i class="fab fa-facebook"></i></li>
		</ul>
	</nav>
	<div class="menu">
		<ul class="navbar_menu">
				<li class="myClass" id="myClass">
					<a href="#">
						<img src="../creatorCenter/img/svgtopng/svg0.png"	width="24" height="24" fill="none" />내 클래스
					</a>
				</li>
				<li class="board" id="board">
					<a href="#"><a class="" href="#"> 
						<img src="../creatorCenter/img/svgtopng/svg1.png" width="24" height="24" fill="none" />공지사항
					</a>
				</li>
				
			<!--	<li class="commnet" id="commnet">
					<a href="#">
						<img src="../creatorCenter/img/svgtopng/svg2.png" width="24" height="24" fill="none" />댓글관리
					</a>-->
						<!-- <ul class="commnet_sub">
							<li id="community"><a href="#">커뮤니티 댓글 관리</a></li>
							<li id="classCommnet"><a href="#">클래스 댓글 관리 </a></li>
						</ul> -->
				</li>
				<li class="helpDesk" id="helpDesk">
					<a href="#">
						<img src="../creatorCenter/img/svgtopng/svg6.png"	width="24" height="24" fill="none" />도움말 센터
					</a>
				</li>
		</ul>
	</div>
	<div class="contents" id="contents" >
		<div class="class_creator" id="class_creator">
			
  


<link rel="stylesheet" href="../creatorCenter/css/board.css">
    

<div class="container">
<!-- 메인 내용 시작 -->



<form action="productForm2.pd" method="post"  >
	<table width='600' align = 'center' border="1">
		<tr><td>클래스 번호</td>
		
			<td><input type="text" name="classesNum" id="classesNum" value="${classesNum }" readonly/>
			</td>
		</tr>
		<tr><td>상품명</td>
			<td><input type="text" name="productName" id="productName" />
			</td>
		</tr>
		<tr><td>상품 설명</td>
			<td><textarea rows="13" cols="56" 
					name="productContent" id="productContent"></textarea>
			</td>
		</tr>
		<tr><td>상품 가격</td>
			<td><input type="text" name="productPrice" id="productPrice" >
			</td>
		</tr>
		<tr>
			<td colspan=2>
				<input type="submit" value="상품등록" />
				<input type="button" onclick="javascript:history.back();" value="취소"/>
			</td>
		</tr>
	</table>				
</form>
</div>



		</div>
		<div class="space"></div>
		<footer>
			<div class="footer">
				footer 준비중...
			</div>
		</footer>
	</div>
</div>
</body>
<script src="../creatorCenter/js/board_creator_view.js"></script>
</html>