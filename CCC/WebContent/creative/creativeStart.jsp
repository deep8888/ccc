<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
.hh4 {
	padding: 0px;
	Padding-top: 0px;
	margin: 0px;
}
.hh3 {
	color : orange;
	padding: 0px;
	Padding-top: 0px;
	margin: 0px;
}
#main2{ 
 position: absolute;
  top: 30%;
  left: 30%;
  width: 600px;
  height: 500px;
  margin: -50px 0 0 -50px;
}
.btn { background-color:orange;
font-size: 15px;}
.btn:hover {
	color: white;}
</style>


<div id="main2">
<table >

<tr>
</td>
</tr>

<tr>
<td>
<td><div color="#fd7e14" font-weight="bold" class="hh3">Welcome</div>
<h2 font-weight="bold" class="hh4">크리에이터님,<br>반갑습니다 :)</h2>
<div class="hh4">클래스 수요 조사 페이지를 작성하기 전,<br>크리에이터님의 기본적인 정보를 알려주세요.</div></td>

<td width="50px"></td>

<td><div class="input" align="right">
<form action="creativeStart.cr" method="post" name="frm">
<div align="left"> 
<label class="">이메일주소</label>
<div class=""><input class="" type="text" name="userEmail" disabled="" autocomplete="off" placeholder="ccc@master.com" style="width:180px; height:30px;" value="${memberDTO.userEmail }" ></div></div>
<div align="left"><label class="">휴대폰번호</label>
<div class=""><input class="" type="text" name="userPh1" autocomplete="off" placeholder="01012341234" style="width:180px; height:30px;" value="${memberDTO.userPh1 }"></div></div>
<div align="left"><label class="">지원 경로</label>
<div>
<select color="#1b1c1d" name="applyPath" class="" style="width:180px; height:30px;"><option value="" hidden="" disabled="">지원 경로를 선택해주세요</option>
<option value="크리에이터 추천">크리에이터 추천</option>
<option value="지인 추천">지인 추천</option>
<option value="광고">광고</option>
<option value="CCC 매니저 제안">CCC 매니저 제안</option>
<option value="스스로 알아냄">스스로 알아냄</option>
<option value="기타">기타</option></select></div>

</div>
<div align="center">
<button type="submit" class="btn" color="orange" style="width:180px; height:30px;">
<span class="">크리에이터로 시작하기</span></button></div>
</form>
</td></tr>
</table>
</div>