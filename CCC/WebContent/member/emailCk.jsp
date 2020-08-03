<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
           
           
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#font1 {color: #FFF;}
body {text-align:center;background-color: #000;}
</style>
<script>
    	$(function(){
		$("#frm").submit(function(){
			if($("#userName").val() == "" || $("#userName").val() == null ){
				alert("가입시 입력한 이름을 입력해 주세요");
				$("#userName").focus();
				return false;
			}
			if($("#userPh1").val() == "" || $("#userPh1").val() == null ){
				alert("가입시 입력한 전화번호를 입력해 주세요");
				$("#userPh1").focus();
				return false;
			}
			
			
		});
    	});
		
</script>
<body>
<form action = "emailCkPro.mem" name="frm" id="frm" method = "post">
	<br/><br/><br/><table border = 1 align="center">
		<tr><td><span id="font1">회원 찾기</span></td></tr>
		<tr><td><input type = "text" name = "userName" id = "userName" style= width:300px; height:70px; placeholder ="가입시 입력한 이름을 입력하세요"/></td></tr>
		<tr><td><input type = "text" name = "userPh1" id = "userPh1" style= width:300px; height:70px; placeholder = "가입시 입력한 전화번호를 입력하세요"/>
		</td></tr>
	</table>
		<br/>
		<button type ="submit" >다음으로</button>
		<input type="button" value="뒤로" 
				onclick = "javascript:history.back();" />
	</form>
	
	
	
</body>
</html>