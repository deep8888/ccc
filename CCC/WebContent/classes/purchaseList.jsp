<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../top.jsp"%>
<script src="https://code.jquery.com/jquery-1.8.1.js" charset="utf-8"></script>

</head>
<body style="color:white">
<div class="my_sukang" style="padding-right: 8px">
			  	<h3 style="align-items: center;">내 강의실</h3>
			  	<hr />
			  		<div style="justify-content: space-between;">
			  		</div>
			  		<table border="1px" align="center" cellpadding="3">
			  			<tr>
			  								<td>주문번호</td>
											<td>강좌명</td>
											<td>구매일</td>
											<td>만료일</td>
											<td>결제금액</td>
											<td>강의실</td>
			  			</tr>
			  			<c:forEach items="${list }" var="dto">
			  			<c:if test="${dto.refundOk ne 'Y' }">
			  			<tr>
			  								<td>${dto.purchaseNum }</td>
											<td>${dto.classesSubject }</td>
											<td>
											<fmt:formatDate value="${dto.purchaseDate }" type="date" pattern="yyyy-MM-dd"/> 
											</td>
											<td>
											<fmt:formatDate value="${dto.expireDate }" type="date" pattern="yyyy-MM-dd"/> 
											</td>
											<td><fmt:formatNumber value="${dto.purchasePrice }" type="currency"></fmt:formatNumber>
											</td>
											<td><a style="color:red" href="classesDetailView.cs?classesNum=${dto.classesNum }&classesListNum=${dto.classesNum}_01">바로가기</a></td>
											
			  			</tr>
			  			
			  			</c:if>
			  			</c:forEach>
			  		</table>
			  	</div>


</body>
</html>