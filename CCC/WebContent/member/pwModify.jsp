<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/member/member_top.jsp" %>
<body>
	<div class="Line"></div>
	<div align="center">
		<table>
			<br />
			<br />
			<span style="color: #fff; font-size: 20px">내 정보</span>
			<br />
			<br />
			<tr align="left">
				<form action="pwModify1.mem" method="post" name="frm">
					<span id="font1">비밀번호 : </span> <input type="password"
						name="userPw" id="pw" /><br />
					<br /> <input type="submit" value="확인" />
				</form>
		</table>
	</div>
	
<%@ include file="/member/member_bottom.jsp" %>

</body>
</html>