<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Notice_Board/notice_top.jsp" %>
<body>
<div class="Line"></div>
	
<table align="center" border="1" bordercolor="orange" cellpadding="0" cellspacing="0">
<br/><br/>
   <tr align="center" valign="middle">
      <td colspan="4"><div id="fonttop" class="fonttop">글 삭제</div></td><tr>
		
<form name="deleteForm" action="noticeDeletePro.not" 
	method="post">
	<input type="hidden" name="boardNum" value="${boardNum}">
<tr>
	<td>
		<font size=2 ><span style=color:white;>글 비밀번호 : </span> </font>
	</td>
	<td>
		<input name="boardPass" type="password">
	</td>
</tr>
<tr>
	<td colspan=2 align=center>
		<a href="javascript:deleteForm.submit()"><span style=color:white;>[삭제]</span></a>
		&nbsp;&nbsp;
		<a href="javascript:history.go(-1)"><span style=color:white;>[돌아가기]</span></a>
	</td>
</tr>
</table>
</form>

<%@ include file="/Notice_Board/notice_bottom.jsp" %>
</body>
</html>