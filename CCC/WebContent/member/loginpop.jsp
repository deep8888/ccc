<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
<!DOCTYPE html>
<script>
    	$(function(){
		$("#frm").submit(function(){
			if($("#userEmail").val() == "" || $("#userEmail").val() == null ){
				alert("이메일을 입력해 주세요");
				$("#userEmail").focus();
				return false;
			}
			if($("#userPw").val() == "" || $("#userPw").val() == null ){
				alert("비밀번호를 입력해 주세요");
				$("#userPw").focus();
				return false;
			}
			
			
		});
    	});
		
</script>
<html>
<head>
<%@ include file="member_top.jsp"%>
<meta charset="UTF-8">
<style type="text/css" >
body{background-color: #000;}
body table tr td{color:white; top-margin:0; left-margin:0;}
#login {text-align: center;}
#login2 {text-align: center;}
#login3 {text-align: right;}
#login4 {text-align: right;}

.btn2 {
  width: 90px;
  height: 30px;
  font-size:15px;
  font-family: 'Nanum Gothic';
  color: white;
  line-height: 25px;
  text-align: center;
  background: red;
  border: solid 1px white;
  border-radius: 12px;
}
.btn3 {
  width: 90px;
  height: 30px;
  font-size:15px;
  font-family: 'Nanum Gothic';
  color: red;
  line-height: 25px;
  text-align: center;
  background: black;
  border: solid 1px red;
  border-radius: 12px;
}
.btn2:hover {
	background: white;
	border-color: #b13428;
	color: red;}
.btn3:hover {
	background: #b13428;
	border-color: #b13428;
	color: white}
.btn4 {
  width: 80px;
  height: 30px;
  font-size:10px;
  font-family: 'Nanum Gothic';
  color: white;
  line-height: 25px;
  text-align: center;
  background: black;
  border: solid 1px orange;
  border-radius: 12px;
}
.btn4:hover {
	background: #b13428;
	border-color: #b13428;
	color: white}
#tb { border-color: white; background-color: #0E0E0E; border-radius: 20px;}
.input-btn{
border-radius: 20px;
}
</style>


<title>login</title>
<link rel="shortcut icon" href="images/logo2.png" type="image/x-icon"/>
</head>

<body>
<br/>
<hr/>
<br/><br/>
<c:if test="${empty logEmail }">
<table id="tb" align = 'center'  rules= "cols">
<form action='loginPro.ccc' method='post' name='frm' id="frm">
<tr>
<td>
<div id="login">
<img src="../images/pngwing.com2.png" width=50px height=50px style="border-radius: 12px;
"/><span style=color:white;font-size:2em>로그인</span>
<br/>
</td>
</tr>
		<input type="hidden" name="logPage" id="logPage" value="${logPage }" /> 
		<td >자동로그인<input type="checkbox" name="autologin" value="auto"></td>
<tr><td align = 'center' class="input-btn"><input type="email" name="userEmail" id="userEmail" value="${isEmail }" style="width:250px; height:40px; border-radius: 12px;" placeholder="이메일">
	<div id ="idmsg"></div>
<tr><td align = 'center' class="input-btn"><input type="password" name="userPw" id="userPw"  style="width:250px; height:40px;border-radius: 12px;
" placeholder="비밀번호"></td></tr>
</div>
<tr>
<td><div id="login2">
<br/>
     <button class="btn2" >로그인</button>
   
</div>
</td>
</tr>
</form>
<tr>
<div align = 'center'>

<div id="login3">
<td><br/>
<span style=color:white;>아직 회원이 아니신가요?</span>
     <button class="btn3" onclick="location.href='../mem/memberRegist.mem' ">회원가입</button>
     <br/>
</div>
</td>
<div id="login4">
<br/>
<tr>
<td><span style=color:white;font-size:10px;>로그인이 안되시나요?</span>
     <button class="btn4" onclick="location.href='../mem/emailCk.mem' ">회원찾기</button>
     <button class="btn4" onclick="location.href='../mem/passCk.mem' ">비밀번호찾기</button>
     <br/></td>
</div>
</tr>
</div>
</tr>
</table>
</c:if>
<c:if test="${!empty logEmail }">
<span style=color:white;font-size:2em>${memberDTO.userName}님 CCC에 오신걸 환영합니다.<br/>즐거운 하루되세요.</span>
</c:if>
<%@ include file="member_bottom.jsp" %>
</body>
</html>