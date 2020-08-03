<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
<link rel="stylesheet" href="../creatorCenter/css/board.css">
</head>
<body>
<div class="container">
	<h1>공 지 사 항</h1>
	<table>
	<c:forEach items="${listSet}" var="dto" varStatus="cnt"> 
		<tr>
		<td class="first_column" align="center">
		<c:if test="${dto.boardStep == '중요' }">${dto.boardStep}</c:if>
	  <c:if test="${dto.boardStep == '긴급' }"><span style="color: red;">${dto.boardStep}</span></c:if> </td>

			<td class="second_column" align="left"><a href="CreateboardView.cen?num=${dto.boardNum}">${dto.boardSubject}</a></td>
		</tr>
		</c:forEach>
		<c:if test="${!empty logMaster }">
   <tr align="right">
      <td colspan="5">
         <div align="center" id="font1" class="font1">   <a href="boardCreateWrite.cen">[글쓰기]</a></div>
      </td>
   </tr>
</c:if>
	</table>
</div>
</body>
</html>