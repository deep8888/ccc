<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CCC</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
<style>

hr{
color:grey
}
.btn1 {
  width: 90px;
  height: 30px;
  font-size:15px;
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
	color: white}

</style>
<script>

$(function(){
	var id='${logEmail}';
	$("#frm").submit(function(){
		if(id== null || id==""){
			alert("먼저 로그인을 해주세요.");
			return false;
		}
				
				
	});	
});
</script>

</head>
<body>
	<%@ include file="/member/member_top.jsp"%>
	<br/><br/><br/>
	<%-- <c:if test="${dto.classesNum ne clpdto.classesDTO.classesNum }">
		<div style="color:white">수강신청 되지 않은 강의 입니다. 먼저 수강신청해주세요. </div>
	</c:if> --%>
	
	<table style="margin :0 auto;color:white;width:1100px;height:auto;table-layout:fixed;">
		<tr>
			<td colspan=2 >
			<img width="600px" height="400px" src="../creatorCenter/upload/${clpdto.classesDTO.classesPhoto}"/>
				
			</td>
			<td rowspan=2 width=250px height=auto style="color:white">
					<span style="color:grey;font-size:40px">episodes<hr/></span>
				<ul style="list-style:none">
			 <c:forEach items="${clpdto.classesList}" var="cl" varStatus="cnt">
					<li style="font-size:10px; overflow:auto">
					  ${cl.classesListSubject }<br/><hr/></li>
				</c:forEach>		
		
				</ul>
			</td>
		</tr>
		<form action="classesAdminSubmit.cs" method="get" name="frm" id="frm">		<tr>
			<td ><h1>${clpdto.classesDTO.classesSubject }</h1>
			<input type="hidden" name="classesNum" value="${clpdto.classesDTO.classesNum }"/> 
				<div style="color:grey; font-size:12px">${clpdto.classesDTO.classesContent }</div>
			</td>
			<td style="vertical-align:top"><br/>
				<br/>
				
			</td>
		
		</tr>
	</table>	<div style="text-align:center">
				<input type="submit" value="클래스 등록 승인"/>
				</div>
		</form>
	
	<br/><br/>

	<%@ include file="/bottom.jsp"%>
</body>
</html>