<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" 
    src="http://code.jquery.com/jquery-latest.js" ></script>
<script type="text/javascript">
$(function(){
	if($("#frm").submit(function(){
		if(!$("input:radio[name='yesNo']").is(":checked")){
			alert("합격 여부를 선택하세요");
			//$("input:radio[name='btn1']:radio[value='합격']").attr("checked",true);
			return false;
		}
	}));

});
</script>
</head>
<body>
<form action="RessumeInfoModifyPro.res" method="post" name="frm" id="frm">
<input type="hidden" name="resChk" value="${resChk }" />
<input type="hidden" name="resumeNum" value="${list[0].resumeNum }" />
<div id='ResumeTab'>
<table width = '600' align = 'center' border = '1' id="res">
	<colgroup>
	    <col width="25%" />
		<col width="75%"  />
    </colgroup>
    <thead>
    <tr align="center" valign="middle">
    	<td colspan="5">이력서 게시판</td>
    </tr>
    <tr>
    <td>이름</td>
    <td>${list[0].resumeName }</td>
    </tr>
    <tr>
    <td>내용</td>
    <td>
    	<table border="0" width=490 height=250>
    		<tr>
    			<td valign=top>
    			${list[0].resumeContent }
    			</td>
    		</tr>
    	</table>
    </td>
    <tr>
		<td>전화번호</td>
		<td>	${list[0].resumePhcon }</td>
	</tr>
	<tr>
		<td>githubURL</td>
		<td>${list[0].githubUrl }</td>
	</tr>
	<tr>
		<td>githubURL</td>
		<td>${list[0].portUrl }</td>
	</tr>
	<tr>
		<td>지원부서</td>
		<td>${list[0].departmentName }</td>
	</tr>
	
	</thead>
	<tfoot align="center" valign="middle">
	<tr>
		<th colspan = 2>
		
	</tr>
	</tfoot>
	<tbody>
	<tr>
		<th colspan= '2'>이력서 </th>
	</tr>
	<tr>
		<th >이력서파일</th><!-- id:#userId1, .userId2 -->
		<td>
			<a href="../Resume/upload/${list[0].storeFileName }">
			${list[0].originalFileName }</a>
			&nbsp;&nbsp; / &nbsp;&nbsp;${liat[0].fileSize }
		</td>
	</tr>
		
		<tr>
		<th><h3>합격 여부</h3></th>
			<td><input type="radio" id="yesNo" name="yesNo" value="합격" checked="checked">합격</input>
		<input type="radio" id="yesNo" name="yesNo" value="불합격">불합격</input>
			<input type="submit" name="modify" id="modify" value="[결과 입력]"> &nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>
			</form>
			</th>
		</td>
		</tr>
		</table>
</div>
</form>
</body>
</html>