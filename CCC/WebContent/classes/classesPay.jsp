<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>패키지 선택</title>
<style>
a {
	text-decoration:none;
}

#dv {
	display: inline-block;
	color: grey;
	width: 300px;
	height: 300px;
	border: 1px solid grey;
	margin: 0 auto;
	text-align: center;
}

.btn1 {
	width: 90px;
	height: 30px;
	font-size: 15px;
	font-family: 'Nanum Gothic';
	color: red;
	line-height: 25px;
	text-align: center;
	background: black;
	border: solid 1px red;
	border-radius: 12px;
}

.btn1:hover {
	background: #b13428;
	border-color: #b13428;
	color: white
}


</style>

</head>

<body style="background: black;margin:0 auto">
<c:set var="cnt" value="0"></c:set>
<c:forEach items="${list }" var="dto">
<c:if test="${dto.classesNum eq pacdto.classesDTO.classesNum && dto.refundOk ne 'Y'}">
<br/><br/>
<div style="text-align:center;color:white"><h1>이미 수강중인 클래스입니다.</h1>
<c:set var="cnt" value="1"></c:set>
				<a href="classesListView.cs"><button style="color:red;background:none;border:1px solid red">내강의실 바로가기</button></a></div>
</c:if>
</c:forEach>
<c:if test="${cnt eq 0 }">
	<div style="text-align:center">
	<br/><br/>
		<h2 style="width: 150px; height: 50px;color: white;margin:0 auto">패키지 선택</h2>
	
<form action="ClassesPaySub.cs" method="get" name="frm" id="frm">
	<div id="dv">
		<br /> <input type="radio" style="font-size:17px; width:23px;height:23px" name="packages" value="Yes" checked/>
		<h3>올인원 패키지</h3>
		<br />
		<p style="font-size: 13px;">
			온라인 수강권 <br /> &<br /> 패키지 구성품<br /> <br />
		</p>
		<c:set var="sum" value="0"/>
		<c:forEach items="${pacdto.product }" var="product">
	<c:set var="sum" value="${sum+ product.productPrice}"/>
	</c:forEach>
		<p style="font-size: 20px; color: white"><fmt:formatNumber value="${sum+pacdto.classesDTO.classesPrice }" type="currency"></fmt:formatNumber></p>
	</div>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


	<div id="dv">
		<br /> <input type="radio" style="font-size:17px; width:23px;height:23px" name="packages" value="No" />


		<h3>수강권 Only</h3>
		<br />
		<p style="font-size: 13px;">
			<br /> 온라인 수강권 <br /> <br /> <br />
		</p>
		<p style="font-size: 20px; color: white"><fmt:formatNumber value="${pacdto.classesDTO.classesPrice }" type="currency"></fmt:formatNumber></p>
	</div>
	<br />
	<br />
	<div>
		<input type="submit" class="btn1" value="수강신청"/><br />
		<br />
		<input type="hidden" name="classesNum" value="${pacdto.classesDTO.classesNum }"/>
	</div>
	</form>
</div>

</c:if>


</body>
</html>