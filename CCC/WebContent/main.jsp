<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="top.jsp"%>
<script src="https://code.jquery.com/jquery-1.8.1.js" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		adv_interval = setInterval(main_visual_up, 3000);
		$("#tbdiv table").mouseover(function() {
			clearInterval(adv_interval);
		})
		$("#tbdiv table").mouseleave(function() {
			adv_interval = setInterval(main_visual_up, 3000);

		})
	});

	function main_visual_up() {
		$("#tbdiv table:last").after($("#tbdiv table:first"));
	}
</script>

<style>
#dv1 {
	border: 1px solid;
	border-color: #808080;
	color: #808080;
	width: 120px;
	height: 35px;
	line-height: 35px;
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
	color: #808080;
	padding-left: 20px
}
</style>
</head>
<body>
	<hr />
	<br /><br />

	<div id='tbdiv'>
		
		<c:forEach items="${list }" var="dto" begin='0' end='4' step='1'>

		<table class='tb1' background="creatorCenter/upload/${dto.classesPhoto }">
			<tr>
				<td colspan=2 height=320px></td>
			</tr>
			<tr>
				<td align=left>
					<h1>${dto.classesSubject }<img src="images/logo2.png" width=30px
							height=30px />
					</h1>
					<h3>${dto.classesContent }</h3>
				</td>
				<td width=200px><div id='dv1'>
						<a href="classSubmit.cs?classesNum=${dto.classesNum }">클래스보기</a>
					</div></td>
			</tr>

		</table>
		</c:forEach>

		
	</div>
<%@ include file="bottom.jsp" %>

</body>
</html>