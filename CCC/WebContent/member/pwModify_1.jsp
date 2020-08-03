<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/member/member_top.jsp" %>

<script type="text/javascript">
$(function(){
	$("#sbm").click(function(){
		if($("#pw").val()==""){
			alert("현재 비밀번호를 입력하세요.");
			$("#pw").focus();
			return false;
		}
		if($("#newPw").val()==""){
			alert("새 비밀번호를 입력하세요.");
			$("#newPw").focus();
			return false;
		}
		if($("#newPw").val() != $("#reNewPw").val()){
			alert("비밀번호확인이 일치하지 않습니다.");
			$("#reNewPw").focus();
			return false;
		}
		$("#frm").submit();
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

				<form action="pwModifyPro.mem" method="post" name="frm" id="frm">
					<td><span id="font1">현재비밀번호 : </span></td><td><input type="password" name="pw"
						id="pw" /></td></tr> 
						<tr><td><span id="font1">새 비밀번호 : </span>
						<td><input type="password" name="newPw" id="newPw" /></td></tr> 
						<tr><td><span id="font1">새 비밀번호 확인 : </span>
						<td><input type="password" name="reNewPw" id="reNewPw" /></td></tr> 
						<tr><td align="center" colspan="2"><br/><input type="button" value="비밀번호변경" id="sbm" /></td></tr>
				</form>
				</tr>
		</table>
	</div>

<%@ include file="/member/member_bottom.jsp" %>
</body>
</html>