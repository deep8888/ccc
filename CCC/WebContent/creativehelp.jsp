<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="top.jsp"%>
<meta charset="UTF-8">
<title>creativehelp</title>
<script src="https://code.jquery.com/jquery-1.8.1.js" charset="utf-8"></script>


<style>

#dv1 {
	border: 1px solid;
	background: #F67A42;
	color: #F67A42;
	width: 230px;
	height: 35px;
	line-height: 30px;
	text-align: center;
}

#dv1:hover {
	background: #b13428;
	border-color: #b13428;
	color: white
}

.tb1 {
	background-size: cover;
	width: 1200px;
	height: 400px;
	margin-bottom: 100px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

.tb1 h1 {
	color: #FFF;
	padding-left: 100px;
}

.tb1 h3 {
	color: #FFF;
	padding-left: 20px
}

.fcolor1 {
	color: #FFF;
	
}

.fcolor2 {
	color: #FFF;
	font-size: 12px;
	
}

.imgback {
	background: #FFF;
	
}
.tab { white-space: pre; text-align: left;}

</style>
</head>
<body>
	<hr />
	<br /><br />

	<div id='tbdiv'>
	
		<table class='tb1' background="images/honey-hero-image-lg.png">
		
			<tr>
				<td colspan=2 height=320px></td>
			</tr>
			<tr>
				<td align=left>
					<h1>사랑하는 일로 <br/>매달 연금 타가세요</h1>
					<h3>단 한 번의 클래스 제작으로 지속적인 수익을 창출할 수 있어요. 사랑하는 일을 하면서요!</h3>
				</td>
				<c:if test="${empty logEmail }"><td width=200px><div id='dv1'>
						<a href="login/memberLogin.ccc">무료로 크리에이터 시작하기</a>
					</div></td>
					</c:if>
					<c:if test="${!empty logEmail }"><td width=200px><div id='dv1'>
						<a href="cr/creative.cr">크리에이터 센터가기</a>
					</div></td>
					</c:if>
			</tr>
          </table>
          </div>
<table align="center">
<tr>
<span class="tab"><h2 style=color:#fff; font-weight="bold" >&#9;&#9;CCC와<br>&#9;&#9;함께하면 다릅니다.</h2></span>
</tr>
<tr>
<div class="" style="animation-duration: 1s; opacity: 0;">
<td>
<img src="images/new-service-point-01.db472084.png" class="imgback"></div>
<div class="fcolor">
<div font-weight="bold" class="fcolor1" >더 빠르고, 더 쉽게</div></div>
<div color="#fff" class="fcolor2">평균 8주 제작, 첫달 600만원 정산<br>출판보다 빠르고, 유튜브보다 쉽게<br>수익을 창출할 수 있습니다</div>
</td>


<div class="" style="animation-duration: 1s; opacity: 0;">
<td>
<img src="images/new-service-point-02.1d12891c.png" class="imgback"></div>
<div font-weight="bold" class="fcolor1">데이터로 수요 파악, 무료 홍보 효과까지</div>
<div color="#fff" class="fcolor2">온라인 광고가 무료로 집행됩니다.<br>매일 N만명의 사람들에게 도달하고<br>사진 선택까지도 데이터로 결정하세요.</div>
</td></tr>
<tr>
<div class="" style="animation-duration: 1s; opacity: 0;">
<td>
<img src="images/new-service-point-03.bf45c4b9.png" class="imgback"></div>
<div font-weight="bold" class="fcolor1">판매부터 제작까지 1:1 클래스 관리</div>
<div color="#fff" class="fcolor2">매칭된 MD와 PD가 놀랄만큼<br>긴밀한 소통으로 서포트해드립니다.</div>
</td>

<div class="" style="animation-duration: 1s; opacity: 0;">
<td>
<img src="images/new-service-point-04.819371ec.png" class="imgback"></div>
<div font-weight="bold" class="fcolor1">작가로서의 발판</div>
<div color="#fff" class="fcolor2">클래스 콘텐츠는 새로운 포트폴리오입니다.<br>클래스 하나로 출판과 강연 제안을 받아보세요.</div>
</td></tr>
</table>
<div id='tbdiv'>
	<br/>
	<span class="tab" style=color:#fff; align="center"><h1>꿈만 꾸던 나만의 클래스 <br/>도전해 보고싶다면?</h1></span>

		<table align="center">
		<c:if test="${empty logEmail }">
		<td width=220px><div id='dv1'>
						<a href="login/memberLogin.ccc">무료로 크리에이터 시작하기</a></td></div></c:if>
						<c:if test="${!empty logEmail }">
		<td width=220px><div id='dv1'>
						<a href="cr/creative.cr">크리에이터 센터가기</a></td></div></c:if>
          </table>
          	</div>

	
	
<%@ include file="bottom.jsp" %>
</body>

</html>