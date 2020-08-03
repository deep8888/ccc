<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디(이메일) 입력</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			if($("#num").val()=='2'){
		 	$(opener.document).find("#userIdChk").val($("#num").val());
			$(opener.document).find("#userEmail").val($("#userEmail").val()); 
			
		
			
			window.self.close();
		
			}

		});

	});
</script>
</head>
<body>
	<form action="userConfirm.mem" method="post" name="frm" >
	<input type="hidden"/>
		<input type="text" name="userEmail" value="${userEmail }" id="userEmail" />
		

		<div>
			
			<c:if test="${!empty userEmail }">
			<c:if test="${empty confirmEmail }" >
			
 		사용가능한 이메일 입니다.
 		<c:set var="num" value="2" />
			</c:if>
			</c:if>
			<c:if test="${!empty confirmEmail }">
 		사용중인 이메일 입니다. <br/>다른 이메일을 입력하세요.
 		<c:set var="num" value="1" />
			</c:if>
		</div>
		<input type="hidden" name="num" value="${num }" id="num" /> <input
			type="submit" value="아이디 확인" /> <input type="button" value="아이디 사용"
			id="btn" />
			 <input type="hidden" name="xxxx" id="xxxx" value="xxxx" />
	</form>
</body>
</html>