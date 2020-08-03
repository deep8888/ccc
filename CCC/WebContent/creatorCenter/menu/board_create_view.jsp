    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <% 
    pageContext.setAttribute("cn", "\n");
    pageContext.setAttribute("br", "<br/>");
    pageContext.setAttribute("cr", "\r");
    pageContext.setAttribute("crcn", "\r\n");
    %>

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

<table align="center" cellpadding="0" cellspacing="0" name="tb">
<br/><br/>

  
   <tr align="center" valign="middle">
      <td colspan="4"><h1 >공지사항</h1></td><tr>
		<td class="first_column">
			<div align="center" >제 목&nbsp;&nbsp;</div>
		</td>
		<td align="left" class="second_column"><span >${dto.boardSubject}</span></td>
	</tr>
	 
	<tr>
		<td>
			<div align="center" class="first_column">내 용</div>
		</td>
		<td>
			<table border=1 width=490 height=250 style="table-layout:fixed">
				<tr>
					<td align="left" class="second_column">
					<span >${fn:replace(dto.boardContent,cn,br)}</span>
					</td>
				</tr>
						
		</td>
	
		</table>
		
		
<c:if test="${!empty logMaster }">

	<tr>
	<form action="optionck.cen" method="get" name="frm" id="frm">
			<td align="center" colspan=2>
			<input type="hidden" name="boardNum" value="${dto.boardNum }">
			<input type="radio" id="step" name="step" value="일반" checked="checked">일반</input>
		<input type="radio" id="step" name="step" value="중요">중요</input>
		<input type="radio" id="step" name="step" value="긴급">긴급</input>
		<input type="submit" name=btn value=공지별표변경/>
			</td>
	
			
			
			</tr>
			</form>
				
</c:if>		
	
		<tr>
		<td colspan=2 align="center">
			<font size=2>
			<c:if test="${!empty logMaster }">
			
			<a href="boardCreateModify.cen?num=${dto.boardNum }">
			<span >[수정]</span>
			</a>&nbsp;&nbsp;
			<a href="boardCreateDelete.cen?num=${dto.boardNum }">
			<span >[삭제]</span>
			</a>&nbsp;&nbsp;
			
			</c:if>
			<a href="CreateBoardList.cen"><span >[목록]</span></a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
	

	
	
	
  
</table>
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