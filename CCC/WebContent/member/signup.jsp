<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
<script>
	$(function() {
		
		$("#idChk").click(
				function() {
					window.open("userConfirm.mem?userEmail=" + $("#userEmail").val(),
							"이메일 확인", "width=300,height=200,left=550,top=200");
				});
		$("#frm").submit(function() {
			

			if ($("#userEmail").val() == "" || $("#userEmail").val() == null) {
				alert("이메일을 입력해 주세요");
				$("#userEmail").focus();
				return false;
			}
			
			if ($("#userName").val() == "" || $("#userName").val() == null) {
				alert("이름을 입력해 주세요");
				$("#userName").focus();
				return false;
			}
			if ($("#userPw").val() == "" || $("#userPw").val() == null) {
				alert("비밀번호를 입력해 주세요");
				$("#userPw").focus();
				return false;
			}
			if ($("#userPw").val() != $("#userPwCon").val()) {
				alert("비밀번호가 일치하지 않습니다.");
				$("#userPw").val("");
				$("#userPwCon").val("");
				$("#userPw").focus();
				return false;
			}
			if ($("#userAddr").val() == "" || $("#userAddr").val() == null) {
				alert("주소를 입력해 주세요");
				$("#userAddr").focus();
				return false;
			}
			if ($("#userPh1").val() == "" || $("#userPh1").val() == null) {
				alert("연락처를 입력해 주세요");
				$("#userPh1").focus();
				return false;
			}
			if($("#userIdChk").val() == 1){
				alert("중복체크를 해주세요");
				return false;
			}	
			

		});

		
	});
</script>
<!DOCTYPE html>
<html>
<head>
<%@ include file="member_top.jsp"%>
<meta charset="UTF-8">
<style type="text/css">
body {
	background-color: #000;
}

body table tr td {
	color: white;
	top-margin: 0;
	left-margin: 0;
}

#login {
	text-align: center;
}

#login2 {
	text-align: center;
}

#login3 {
	text-align: right;
}

.btn2 {
	width: 90px;
	height: 30px;
	font-size: 15px;
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
	font-size: 15px;
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
	color: red;
}

.btn3:hover {
	background: #b13428;
	border-color: #b13428;
	color: white
}
#tb { border-color: white; background-color: #0E0E0E; border-radius: 20px;}
.input-btn{
border-radius: 20px;
}
</style>


<title>회원가입</title>
</head>
<br/>
<hr/>

<body>
	<div id="login">
	<table id='tb' align='center' >
		<form action='memberOk.mem' method='post' name='frm' id="frm" >
			<input type="hidden" name="num" value="1" id="userIdChk" /> 
			<tr><td align = "center">
			<span style="color: white; font-size: 2em">회원가입</span> <br />
			</td></tr>

				<tr>
					
					<td>
					<input type="email" name="userEmail" id="userEmail" 
						style="width:250px; height:40px;border-radius: 12px;" placeholder="아이디(이메일)" readonly></td>
						<td><button type="button" id="idChk" >아이디 입력</button></td>
						
				</tr>
				<br />
				<tr>
					
					<td><input type="text" name="userName" id="userName"
						style="width:250px; height:40px;border-radius: 12px;" placeholder="이름"></td>
				</tr>
				<tr>
					
					<td><input type="password" name="userPw" id="userPw"
						style="width:250px; height:40px;border-radius: 12px;" placeholder="비밀번호"></td>
				</tr>
				<tr>
					
					<td><input type="password" name="userPwCon" id="userPwCon"
						style="width:250px; height:40px;border-radius: 12px;" placeholder="비밀번호확인"></td>
				</tr>
				<tr>
					
					<td><input type='text' name='userAddr' id='userAddr'
						style="width:250px; height:40px;border-radius: 12px;" placeholder="주소"></td>
				</tr>
				<tr>
					
					<td><input type='text' name='userPh1' id='userPh1'
						style="width:250px; height:40px;border-radius: 12px;" placeholder="연락처" /></td>
				</tr>
		
		
	</div>
	<tr><td>
	<br />
			<div id="login2">
		<button class="btn2" type='submit'>회원가입</button>
		
	</div>
	</td></tr>
	</form>
	
	<tr><td>	
	
	<div id="login3">
		<br /> <span style="color: white;">계정이 있으신가요?</span>
		<button class="btn3"
			onclick="location.href='../login/memberLogin.ccc' ">로그인</button>
		<br />
	</div>
	</td></tr>
		</table>

<%@ include file="member_bottom.jsp" %>
</body>
</html>