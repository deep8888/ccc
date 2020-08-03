<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Notice_Board/notice_top.jsp" %>
<script type="text/javascript">
	function modifyboard(){
		modifyform.submit();
	}
	</script>
<body>
<div class="Line"></div>
	
			
<form action="noticeModifyPro.not" method="post" name="modifyform">
<input type="hidden" name="boardNum" value="${dto.boardNum }">
<table align="center" border="1" bordercolor="orange" cellpadding="0" cellspacing="0">
<br/><br/>
   <tr align="center" valign="middle">
      <td colspan="4"><div id="fonttop" class="fonttop">공지사항</div></td><tr>
	<tr>
		<td height="16" style="font-family:돋음; font-size:12">
			<div align="center"id="font1" class="font1">제 목</div>
		</td>
		<td align="left">
			<input name="boardSubject" size="50" maxlength="100" 
				value="${dto.boardSubject}">
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center"id="font1" class="font1">내 용</div>
		</td>
		<td>
			<textarea name="boardContent" cols="67" rows="15">${dto.boardContent}</textarea>
		</td>
	</tr>
	<tr>
		<td height="16" style="font-family:돋음; font-size:12">
			<div align="center"id="font1" class="font1">비밀번호</div>
		</td>
		<td align="left">
			<input name="boardPass" type="password">
		</td>
	</tr>
	
		
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=2>
			<a href="javascript:modifyboard()"><span style=color:white;>[수정]</span></a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)"><span style=color:white;>[뒤로]</span></a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table>
</form>

<%@ include file="/Notice_Board/notice_bottom.jsp" %>

</body>
</html>