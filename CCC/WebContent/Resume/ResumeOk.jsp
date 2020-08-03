<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
    <%@ include file="/include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${YesNo}
<c:if test="${YesNo eq '합격'}">
<table style=" width: 600px; board: 1px; text-align: center; ">
<tr>
	<td>
	<h1>있습니다!!</h1><br/>
	(주)CCCcomperny 축하드립니다. <span>${dto.resumeName}님</span><br/>
	2020년 상반기 (주)CCCcomperny 신입사원 모집 서류전형에서 합격하셨습니다. 면접일정은 다음과 같습니다<br/>
	2017년 09월 18일 10시00분 면접장소 : 솔데스크 5층 / 면접장소로 10분전 까지 도착해주시기 바랍니다.
</td>
</tr>
</table>
</c:if>
<c:if test="${YesNo eq '불합격'}">
<table style=" width: 600px; board: 1px; text-align: center; ">
<tr>
	<td>
	<h1>없습니다!!</h1><br/>
	(주)CCCcomperny: 함꼐할수 없어서 정말 아쉽습니다. <span>${dto.resumeName}님</span><br/>
	힘네세요 다음기회에 만나요<br/>
	
	</td>
</table>
</c:if>
</body>
</html>