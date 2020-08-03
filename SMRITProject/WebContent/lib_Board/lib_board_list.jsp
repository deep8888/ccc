<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.DTO.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실</title>
</head>
<body>
<table width=50% border="0" cellpadding="0" cellspacing="0">
<c:if test="${!empty list}">
	<tr align="center" valign="middle">
		<td colspan="4">자료실</td>
		<td align=right>
			<font size=2>글 개수 : ${libCount }</font>
		</td>
	</tr>
	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
			<div align="center">번호</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="50%">
			<div align="center">제목</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">작성자</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="17%">
			<div align="center">날짜</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="11%">
			<div align="center">조회수</div>
		</td>
	</tr>
	
	<c:forEach items="${list }" var="dto" varStatus="cnt">
	<tr align="center" valign="middle" bordercolor="#333333"
		onmouseover="this.style.backgroundColor='F8F8F8'"
		onmouseout="this.style.backgroundColor=''">
		<td height="23" style="font-family:Tahoma;font-size:10pt;">
		${cnt.count}</td>
		   <td><a href="libBoardDetail.lib?num=${dto.boardNum}"> ${dto.boardSubject}</a></td>
      <td>${dto.boardName}</td>
      <td>${dto.boardDate}</td>
      <td>${dto.readCount}</td>
   </tr>
</c:forEach>
		
		
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"></div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"></div>
		</td>	
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"></div>
		</td>
	</tr>

	<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>

<%@ include file="/include/includePage.jsp" %>

		</td>
	</tr>
</c:if>
<c:if test="${empty list}">
	<tr align="center" valign="middle">
		<td colspan="4">자료실</td>
		<td align=right>
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	</tr>
</c:if>
	<tr align="right">
		<td colspan="5">
	   		<a href="libBoardFom.lib">[글쓰기]</a>
		</td>
	</tr>
</table>
</body>

</html>