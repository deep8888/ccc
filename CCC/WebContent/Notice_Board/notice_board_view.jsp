<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Notice_Board/notice_top.jsp" %>
<body>
<div class="Line"></div>

<table align="center" border="1" bordercolor="orange" cellpadding="0" cellspacing="0">
<br/><br/>
   <tr align="center" valign="middle">
      <td colspan="4"><div id="fonttop" class="fonttop">공지사항</div></td><tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center" id="font1" class="font1">제 목&nbsp;&nbsp;</div>
		</td>
		
		<td align="left" style="font-family:돋음; font-size:12; font-color:white;"><span style=color:white;>${dto.boardSubject}</span></td>
	</tr>
	 
	<tr>
		<td style="font-family:돋음; font-size:12; font-color:white;">
			<div align="center" id="font1" class="font1">내 용</div>
		</td>
		<td style="font-family:돋음; font-size:12; font-color:white;">
			<table border=0 width=490 height=250 style="table-layout:fixed">
				<tr>
					<td align="left" style="font-family:돋음; font-size:12; font-color:white;">
					<span style=color:white;>${fn:replace(dto.boardContent,cn,br)}</span>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=2>
			<c:if test="${!empty logMaster }">
<a href="noticeModify.not?num=${dto.boardNum }">
			<span style=color:white;>[수정]</span>
			</a>&nbsp;&nbsp;
			<a href="noticeDelete.not?num=${dto.boardNum }">
			<span style=color:white;>[삭제]</span>
			</a>&nbsp;&nbsp;</c:if>
			<a href="notList.not"><span style=color:white;>[목록]</span></a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
  
</table>

<%@ include file="/Notice_Board/notice_bottom.jsp" %>

</body>
</html>