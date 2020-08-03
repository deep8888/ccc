<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width=50% border="1" cellpadding="0" cellspacing="0" >
<tr align="center" valign="middle">
	<td colspan =6 >이력서리스트</td>
</tr>
<tr align="center" valign="middle">
	<td align="center">번호</td>
	<td align="center">이름</td>
	<td align="center">연락처</td>
	<td align="center">이메일</td>
	<td align="center">지원부서</td>
	<td align="center">합격여부</td>
</tr>
<c:forEach var="dto" items="${list }">
<tr align="center" valign="middle">
	<td align="center">
		<a href ="ResumeDetail.res?resumeNum=${dto.resumeNum }">
			${dto.resumeNum }
		</a>
	</td>
	<td align="center">${dto.resumeName }</td>
	<td align="center">${dto.resumePhcon }</td>
	<td align="center">${dto.resumeEmail }</td>
	<td align="center">${dto.departmentName }</td>
	<td align="center"><c:if test="${dto.yesNo == '합격' }">합격</c:if>
	  <c:if test="${dto.yesNo == '불합격' }">불합격</c:if> </td>
	
</tr>
</c:forEach>
</body>
</html>