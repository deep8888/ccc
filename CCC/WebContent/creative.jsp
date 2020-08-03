<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@include file="/include/include.jsp"%>

<!DOCTYPE html>


<html>
<head>
<%@ include file="top.jsp"%>
<meta charset="UTF-8">
<title>CCC</title>
<script src="https://code.jquery.com/jquery-1.8.1.js" charset="utf-8"></script>
<script type="text/javascript">
var id='${logEmail}';
function btnclick(num){
	if(id== null || id==""){
		alert("먼저 로그인을 해주세요.");
		return false;
	}else{
		location.href=num;
	}
}
 
 
</script>

<style>
a {
	text-decoration-color: #FF0000;
}

.tb1 {
	background-size: cover;
	width: 1200px;
	height: 400px;
	margin-bottom: 100px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

.tb1 h1 {
	color: #FFF;
	padding-left: 100px;
}

.tb1 h3 {
	color: #808080;
	padding-left: 20px
}

h2 {
	color: #FFF;
	margin-left: 230px
}

.tb2 {
	width: 1200px;
	margin-left: auto;
	margin-right: auto;
}

div {
	margin-left: auto;
	margin-right: auto;
}

p {
	margin: 10px 30px;
	color: white;
	text-align: center;
}


}
</style>

</head>
<body>
<hr />
	<br /><br />
<form action="classesPay.cs" method="get" name="frm" id="frm">
	 <br />
	<br />
	
	<table class='tb1' background="creatorCenter/upload/${list[0].classesPhoto }">
		<tr>
			<td colspan=2 height=320px></td>
		</tr>
		<tr>
			<td align=left>
				<h1>${list[0].classesSubject }</h1>
				<h3>${list[0].classesContent }</h3>
			</td>
			<td width=200px></td>
		</tr>

	</table>
	<hr />
	<br />
	<br />
	<span><h2>오픈예정인 클래스</h2></span>
	
	<div style="padding-left: 200px">
		<c:forEach items="${NotOpenlist }" var="dto"  begin="0" end="1" step="1" varStatus="cnt">
			<div style="display: inline-block">
				<p>
					<img src="creatorCenter/upload/${dto.classesPhoto }" width="530" height="350" />
				</p>
				<p>${dto.classesSubject }</p>
				<p>
					${dto.classesContent }
				</p>
			</div>
		</c:forEach>
	</div>
	<br />
	<br />
	<br />
	<span><h2>지금 인기 있는 클래스</h2></span>
	<div style="padding-left: 200px">
		<c:forEach items="${list }" var="dto"  begin="0" end="3" step="1">
			<div style="display: inline-block">
				<p>
					<img src="creatorCenter/upload/${dto.classesPhoto }" width="230" height="200" />
				</p>
				<p>${dto.classesSubject }</p>
				<p>																												
					 <button type="button" id="btn" style="font-size: 12px; color: #8A8A8A; background-color: #494747"  onclick="btnclick('classSubmit.cs?classesNum=${dto.classesNum }')">수강신청</button>
				</p>
			</div>
		</c:forEach>
	</div>
	
	<br />
	<br />
	<br /> 
	<span><h2>오픈된 클래스</h2></span>
	<div style="padding-left: 200px">
		<c:forEach items="${list }" var="dto">
			<div style="display: inline-block">
				<p>
					<img src="creatorCenter/upload/${dto.classesPhoto }" width="330" height="250" />
				</p>
				<p>${dto.classesSubject }</p>
				<p>
		<button type="button" id="btn" style="font-size: 12px; color: #8A8A8A; background-color: #494747"  onclick="btnclick('classSubmit.cs?classesNum=${dto.classesNum }')">수강신청</button>
				</p>
			</div>
		
		</c:forEach>
	</div>


	<br />
	<br />
	</form>
<%@ include file="bottom.jsp" %>
</body>
</html>