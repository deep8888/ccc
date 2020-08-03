<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Notice_Board/notice_top.jsp" %>
<body>
<div class="Line"></div>

<script language="javascript">
	function addboard(){
		boardform.submit();
	}
	</script>
<form action="noticeWritePro.not" method="get" name="boardform" >
<table align="center" border="1" bordercolor="orange" cellspacing="0">
<br/><br/>
	  <tr align="center" valign="middle">
      <td colspan="4"><div id="fonttop" class="fonttop">공지사항</div></td></tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div id="font1" class="font1">글쓴이</div>
		</td>
		<td align="left">
			<input name="boardName" type="text" size="10" maxlength="10" 
				value=""/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16" >
			<div id="font1" class="font1">비밀번호</div>
		</td>
		<td align="left">
			<input name="boardPass" type="password" size="10" maxlength="10" 
				value=""/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div id="font1" class="font1">제 목</div>
		</td>
		<td align="left">
			<input name="boardSubject" type="text" size="50" maxlength="100" 
				value=""/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center"id="font1" class="font1">내 용</div>
		</td>
		<td>
			<textarea name="boardContent" cols="67" rows="15"></textarea>
		</td>
	</tr>
	

	<tr align="center" valign="middle">
		<td colspan="5">
			<a href="javascript:addboard()"><span style=color:white;>[등록]</span></a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)"><span style=color:white;>[뒤로]</span></a>
		</td>
	</tr>
</table>
</form>
</table>
<%@ include file="/Notice_Board/notice_bottom.jsp" %>
</body>
</html>