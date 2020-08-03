<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/member/member_top.jsp" %>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function(){
	$("#modify").click(function(){
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
			<span style="color: #fff; font-size: 20px">내 정보 수정</span>
			<br />
			<br />
			<tr align="left">
<form name ="frm" id ="frm" method = "post" action ="memberInfoPro.mem">
<input type="hidden" name="memChk" value="${memChk }" />
<input type="hidden" name="userEmail" value="${memberDTO.userEmail }" />
<input type="hidden" name="userPw" value="${memberDTO.userPw }" />
<table border = 1  width = 600 align = "center" cellpadding = 3 ><tr><td ><span id="font1">이메일</span></td>
		<td ><span id="font1">${memberDTO.userEmail }</span></td></tr>
	<tr><td><span id="font1">사용자 이름</td>
		<td><span id="font1"> ${memberDTO.userName } </span></td>
	<tr><td colspan="2"><span id="font1">기본정보 입력</span></td>
		</tr>
	</tr>

	<tr><td><span id="font1">사용자 주소</span></td>
	    <td>
	    <input type ="text" id ="addr" name ="userAddr" 
	        value = "${memberDTO.userAddr }"/>
	    </td></span>
	</tr>
	<tr><td><span id="font1">연락처</span></td>
	    <td>
	    <input type ="text" id ="memberPh1" name ="userPh1" 
	        value = "${memberDTO.userPh1 }"/>
	    </td></span>
	</tr>
	<tr>
		<td colspan=2>
		<input type="button" name="modify" id ="modify" 
				value="수   정" >
		<input type="button" value="취  소" 
			onclick = "javascript:history.back();" />
		
		</td>
	</tr>
</table>

</form>

		</table>
	</div>
<%@ include file="/member/member_bottom.jsp" %>

</body>
</html>