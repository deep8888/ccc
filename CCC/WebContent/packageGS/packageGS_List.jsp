<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/include.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="width:auto" border="1" cellpaddting="0" cellspacing="0" >
		<tr align="center" valign="middle">
			<td colspan="6">패키지 상품 등록 리스트</td>
		</tr>
		<tr><td>구성품번호</td><td>클래스번호</td><td>구성품명</td><td>구성품설명</td><td>구성품가격</td><td>삭제</td></tr>
	<c:forEach items="${list1234 }" var="dto" varStatus="cnt">
		<tr><td width=10%>
			${dto.productNum }
			</td>
			<td width=10%>${dto.classesNum }</td>
			<td width=20%>${dto.productName }</td>
			<td width=30%>${dto.productContent }</td>
			<td width=10%>
			<fmt:formatNumber value="${dto.productPrice }" type="currency"/>
			</td>
			<td><a href="../pd/productDel.pd?productNum=${dto.productNum }&classesNum=${dto.classesNum}"><button>삭제</button></a></td>
		</tr>
	
	</c:forEach>
	</table>
	<br/>
<span><a href="../pd/productForm.pd?classesNum=${classesNum}"><button>구성품 구매 신청</button></a></span>
<span><a href="../cen/classCreateExit.cen"><button>내 클래스 가기</button></a></span>
</body>
</html>