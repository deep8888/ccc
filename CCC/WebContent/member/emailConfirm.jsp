<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/include/include.jsp" %>
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
<body>
</br></br></br>
	<span id="font1">회원님이 가입한 이메일은 ${userEmail } 입니다.</span><br/>
	<br/><br/>
	<button class="btn3"
			onclick="location.href='../login/memberLogin.ccc' ">로그인 하러가기</button>
		<br />
</body>
</html>