<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">


</style>
</head>
<body>
<form action="endWriteProAction.res" method="post" name="frm" enctype="multipart/form-data">

<div id='ResumeTab'>
<fieldset>
		<legend style="text-align: center;">지원자 정보</legend>
<table width = '600' align = 'center' border = '1' id="em">
	<colgroup>
	    <col width="25%" />
		<col width="75%"  />
    </colgroup>
	<tfoot align="center" valign="middle">
	<tr>
		<th colspan = 2>
			<a href="javascript:frm.submit();">[지원서 제출]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>
			</th>
	</tr>
	</tfoot>
	<tbody>
	<tr>
		<th colspan= '2'>신청서 제출</th>
	</tr>
	<tr>
		<th ><label for='ResumeCV'>이력서제출</label></th><!-- id:#userId1, .userId2 -->
		<td >
		<div id="fileUp">
		<label for=>이력서 첨부</label>
		<input type="file" id="fileUp" name="fileUp">
		</div>
		</td>
	</tr>
	<tr>
		<th ><label for='ResumeName'>성명</label></th><!-- id:#userId1, .userId2 -->
		<td ><input type='text' name='ResumeName' id='ResumeName' class='ResumeName' size='20' maxlength='50' autofocus="autofocus" />
		
	</tr>
	<tr>
		<th ><label for='ResumeEmail'>이메일</label></th>
		<td ><input type='text' name='ResumeEmail' id='ResumeEmail' size='50' maxlength='50'/></td>
	</tr>
	<tr>
		<th><label for='PhCon'>전화</label></th>
		<td><input type='text' name='ResumePhCon' id='ResumePhCon' size='50' maxlength='50' placeholder="'-'입력하지않고 숫자만 입력하세요"/></td>
	</tr>
	<tr>
		<th colspan= '2'>연결</th>
	</tr>
	<tr>
		<th><label for='GithubURL'>Github URL</label></th>
		<td><input type ='text' name='githubURL' id='githubURL' size='50' maxlength='50'></td>
	</tr>
	<tr>
		<th><label for='PortURL'>포트폴리오 URL</label></th>
		<td><input type ='text' name='portURL' id='portURL' size='50' maxlength='50'></td>
	</tr>
 	<tr>
		<th><label for='DepartmentName'>지원 하고싶은 부서</label></th>
		<td><select name='departmentName' id='departmentName' >
		<option value="1">백앤드 개발자</option>
		<option value="2">커머스 개발자</option>
		<option value="3">커머스 MD(라이프)</option>
		<option value="4">커머스 MD(기술,공예)</option>
		<option value="5">물류관리담당자</option>
		
		</select>
		</td>
	</tr>
	</tbody>
		<tr>
		<th><label for='Moreinfo'>추가 정보</label></th>
		<td><textarea name="ResumeContent" placeholder="자기 소개서 나 공유 할 다른 것을 추가하십시오."style="margin-top: 17.5px; margin-bottom: 30px; width: 80%; height: 151px;"></textarea></td>
		</tr>
		</table>
	</fieldset>
</div>
</form>
</body>
</html>