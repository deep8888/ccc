<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/member/member_top.jsp" %>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$("#modify").click(function() {
			location.href = "memberPw.mem"
		});
		$("#memDel").click(function() {
			location.href = "memberUserDel.mem"
		});
		$("#pwModify").click(function() {
			location.href = "memberPwForm.mem"
		});
	});
</script>

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
			<tr>
				<td><span id="font1">이름 : ${memberDTO.userName }</span></td>
				<p />
			</tr>
			<tr>
				<td><span id="font1">이메일 : ${memberDTO.userEmail }</span></td>
				<p />
			</tr>
			<tr>
				<td><span id="font1">연락처 : ${memberDTO.userPh1 }</span></td>
				<p />
			</tr>
			<tr>
				<td><span id="font1">등록일 : ${memberDTO.userRegist }</span></td>
				<p />
			</tr>
			<tr><td><span id="font1">주소 : ${memberDTO.userAddr }</span></td>
			<p />
			</tr>
			</tr>
			<tr><td></td></tr>
			<tr><td></td></tr>
				<td><input type="button" name="modify" id="modify"
					value="수   정"></td>
				<td><input type="button" name="pwModify" id="pwModify"
					value="비밀번호변경"></td>
				<td><input type="button" value="탈퇴" id="memDel" /></td>
		</table>
	</div>
<%@ include file="/member/member_bottom.jsp" %>
</body>
</html>