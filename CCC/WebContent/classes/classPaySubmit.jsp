<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ include file="/include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>

<script type="text/javascript" 
	src="http://code.jquery.com/jquery-latest.js" ></script>
 <%@ include file="/include/include.jsp" %>
<style>
table{
margin:0 auto;
color:white;
width:600px;

}
select {

    width: auto; /* 원하는 너비설정 */
    padding: .5em .5em; /* 여백으로 높이 설정 */
	color:white;
	font-size:15px;
    border: 2px solid #999;
    border-radius: 0px; /* iOS 둥근모서리 제거 */
    -webkit-appearance: none; /* 네이티브 외형 감추기 */
    background:black;
    
}


/* td{
border:1px solid white;
}
 */
</style>
</head>
<body style="background:black">
<form action="classesPaid.cs">
<c:if test="${packages == 'No'}">
<table>
	<tr><td colspan=2><h1 style="text-align:left;padding-left:30px">결제하기</h1><hr style="border:double 3px grey"/></td></tr>
	<tr><td colspan=2 style="text-align:left"><h3>주문정보</h3></td></tr>
	<tr style="height:40px"><td>${pacdto.classesDTO.classesSubject }</td><td style="text-align:right"><fmt:formatNumber value="${pacdto.classesDTO.classesPrice }" type="currency"></fmt:formatNumber></td></tr>
	
	
	
	<tr><td colspan=2><hr style="border:dotted 1px grey"/></td></tr>
	
	<tr><td colspan=2 style="text-align:left"><h3>연락처정보</h3></td></tr>
	<tr><td colspan=2 style="text-align:left"><h6>받으시는분</h6>
			<input style="width:300px;height:30px;font-size:15px;background:black;border:1px solid white;color:white" type="text" name="userName" />		
		</td></tr>
	<tr><td colspan=2 style="text-align:left"><h6>휴대폰번호</h6>
			<input style="width:300px;height:30px;font-size:15px;background:black;border:1px solid white;color:white" type="text" name="userPh"/>	
		</td></tr>
		<tr><td colspan=2><hr style="border:dotted 1px grey"/></td></tr>
		
		<tr ><td style="height:30px;font-size:20px">결제 금액</td><td style="text-align:right;font-size:20px"></td></tr>
		<tr><td style="height:30px;font-size:15px">총 상품금액 금액</td><td style="text-align:right;font-size:15px"><fmt:formatNumber value="${pacdto.classesDTO.classesPrice }" type="currency"></fmt:formatNumber></td></tr>
		<tr><td style="height:30px;font-size:15px;font-weight:900">최종 가격</td><td style="text-align:right;font-size:15px"><fmt:formatNumber value="${pacdto.classesDTO.classesPrice }" type="currency"></fmt:formatNumber></td></tr>
		<tr><td><h3>결제 방식</h3>
		 </td><td style="text-align:right"><select name="pay">
			<option value="">결제방법선택</option>
			<option value="무통장입금">무통장입금 : 우리은행(예금주 : (주)CCC, 계좌번호 : 01062575264)</option>
			</select></td></tr>
			<tr><td colspan=2><hr style="border:dotted 1px grey"/></td></tr>
			<tr><td colspan=2><input style="background:red;width:595px;height:50px;font-size:20px;color:white" type='submit' value="주문완료" /></td></tr>
		<input type="hidden" name="classesPrice" value="${pacdto.classesDTO.classesPrice }"/>
			

</table>
</c:if>

<c:if test="${packages == 'Yes'}">
<table>
	<tr><td colspan=2><h1 style="text-align:left;padding-left:30px">결제하기</h1><hr style="border:double 3px grey"/></td></tr>
	<tr><td colspan=2 style="text-align:left"><h3>주문정보</h3></td></tr>
	<tr style="height:40px"><td>${pacdto.classesDTO.classesSubject }</td><td style="text-align:right"><fmt:formatNumber value="${pacdto.classesDTO.classesPrice }" type="currency"></fmt:formatNumber></td></tr>
	
	
	<c:set var="sum" value="0"/>
	<c:forEach items="${pacdto.product }" var="product">
	<c:set var="sum" value="${sum+ product.productPrice}"/>
<tr><td style="font-size:11px">&nbsp;&nbsp;&nbsp;${product.productName }</td><td style="font-size:11px;text-align:right"><fmt:formatNumber value="${product.productPrice }" type="currency"></fmt:formatNumber></td></tr>
	</c:forEach>
	<tr><td colspan=2><hr style="border:dotted 1px grey"/></td></tr>
	
	<tr><td colspan=2 style="text-align:left"><h3>배송정보</h3></td></tr>
	<tr><td colspan=2 style="text-align:left"><h6>받으시는분</h6>
			<input style="width:300px;height:30px;font-size:15px;background:black;border:1px solid white;color:white" type="text" name="userName"/>		
		</td></tr>
	<tr><td colspan=2 style="text-align:left"><h6>휴대폰번호</h6>
			<input style="width:300px;height:30px;font-size:15px;background:black;border:1px solid white;color:white" type="text" name="userPh"/>	
		</td></tr>
		<tr><td colspan=2 style="text-align:left"><h6>배송주소</h6>
			<input style="width:300px;height:30px;font-size:15px;background:black;border:1px solid white;color:white" type="text" placeholder="우편번호" name="postNum"/><br/><br>
			<input style="width:300px;height:30px;font-size:15px;background:black;border:1px solid white;color:white" type="text" placeholder="주소" name="addr"/><br/><br/>
			</td></tr>
			
		<tr><td colspan=2><h6>배송 요청 사항</h6>
		<input style="width:300px;height:30px;font-size:15px;background:black;border:1px solid white;color:white" type="text" placeholder="예)경비실에 맡겨주세요." name="msg"/>
		<hr style="border:dotted 1px grey"/></td></tr>
		<tr ><td style="height:30px;font-size:20px">결제 금액</td><td style="text-align:right;font-size:20px"></td></tr>
		<tr><td style="height:30px;font-size:15px">총 상품금액 금액</td><td style="text-align:right;font-size:15px"><fmt:formatNumber value="${sum+pacdto.classesDTO.classesPrice }" type="currency"></fmt:formatNumber></td></tr>
		<tr><td style="height:30px;font-size:13px">배송비</td><td style="text-align:right;font-size:13px">&#8361;2,500</td></tr>
		<tr><td style="height:30px;font-size:15px;font-weight:900">최종 가격</td><td style="text-align:right;font-size:15px"><fmt:formatNumber value="${sum+pacdto.classesDTO.classesPrice+2500 }" type="currency"></fmt:formatNumber></td></tr>
		
		<tr><td><h3>결제 방식</h3>
		 </td><td style="text-align:right"><select name="pay">
			<option value="">결제방법선택</option>
			<option value="무통장입금">무통장입금 : 우리은행(예금주 : (주)CCC, 계좌번호 : 01062575264)</option>
			</select></td></tr>
			<tr><td colspan=2><hr style="border:dotted 1px grey"/></td></tr>
			<tr><td colspan=2><input style="background:red;width:595px;height:50px;font-size:20px;color:white" type='submit' value="주문완료" /></td></tr>

</table>
	<input type="hidden" name="classesPrice" value="${sum+pacdto.classesDTO.classesPrice+2500 }"/>
</c:if>
<input type="hidden" name="classesNum" value="${pacdto.classesDTO.classesNum }" />

</form>



</body>
</html>