<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/member/member_top.jsp" %>

<script>
    	$(function(){
		$("#btn").click(function(){
					var result = confirm("정말로 탈퇴하시겠습니까?");
					if(result ==  true){
						$("#frm").submit();
					}else{
						history.back();
					}
			});
			
		
    	});
		
</script>


<body>
	<div class="Line"></div>
	<div align="center">
		<table>
			<br />
			<br />
			<span style="color: #fff; font-size: 20px">회원 탈퇴</span>
			<br />
			<br />
			<tr align="left">
					<form action="memberUserDelPro.mem" method="post" name="frm" id="frm">
					<span id="font1">비밀번호 : </span> <input type="password"
						name="userPw" id="pw" /><br />
					<br /> <input type="submit" value="확인" id="btn"  name="btn"/>
				</form>
		</table>
	</div>
	<%@ include file="/member/member_bottom.jsp" %>
</body>
</html>