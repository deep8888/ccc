<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js">

$(function(){
$("#frm").submit(function(){
	if($("#ResumeName").val() == "" || $("#ResumeName").val() == null ){
		alert("이력서 첨부시 입력한 이름을 입력해 주세요");
		$("#ResumeName").focus();
		return false;
	}
	if($("#ResumePhcon").val() == "" || $("#ResumePhcon").val() == null ){
		alert("이력서 첨부시 입력한 전화번호를 입력해 주세요");
		$("#ResumePhcon").focus();
		return false;
	}
	
		
		
	
});
});


</script>
<!--  <script type="text/javascript">
var obj = document.getElementByld("departmentName")
var value = obj.option[obj.selectedlndex].value;
alert(value);
</script>-->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "ResselectPro.res" name="frm" id="frm" method = "post">
	<br/><br/><br/><table border = 1 align="center">
		<tr><td><span id="email1">당신 저희와 함께하실수......</span></td></tr>
		<tr><td><input type = "text" name = "ResumeName" id = "ResumeName" style= width:300px; height:70px; placeholder ="첨부시 입력한 이름을 입력하세요"/></td></tr>
		<tr><td><input type = "text" name = "resumePhcon" id = "resumePhcon" style= width:300px; height:70px; placeholder = "첨부시 입력한 전화번호를 입력하세요"/>
		<tr><td><select name="departmentName" id="departmentName">
		<option value="1">백앤드 개발자</option>
		<option value="2">커머스 개발자</option>
		<option value="3">커머스 MD(라이프)</option>
		<option value="4">커머스 MD(기술,공예)</option>
		<option value="5">물류관리담당자</option>
		
		</select>
		</td></tr>
		</table>
		<br/>
		<div style="text-align: center;">
		<button   class="btn4" onclick="location.href='../res/ResselectPro.res' " id="btn_resultYn">채용 이력서 결과조회</button>
		</div>
	</form>
	
	
</div>
</body>
</html>