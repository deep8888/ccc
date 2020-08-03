<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

var popupX = (document.body.offsetWidth / 2) - (200 / 2);
var popupY= (window.screen.height / 2) - (300 / 2);

function windowopenPopup(){
	window.open('login/memberLogin.ccc', '', 'status=no, height=400, width=500, left='+ popupX + ', top='+ popupY, "location=no, toolbar=no");
	
}

</script>


<style type="text/css">
body{
background-color: black;
}
#sec{
margin-top:2cm;
text-align:center;
color: white;
}

</style>
</head>
<body>
 <section id="sec" >
 <h3>Back-End-Chapter</h3>
 <article><a href="jobbackend.res" style="color:yellow;">[경력] 백앤드 개발자(JAVA/SPRING)</a></article>
 
 <article><a href="jobcommerce.res" style="color:yellow;">[경력] 커머스 개발자</a></article>
 
 </section>
 <section id="sec">
 <h3>Commerce Cell</h3>
 <article><a href="jobcommercelife.res" style="color:yellow;">[경력] 커머스 MD(라이프 스타일)</a></article>
 
 <article><a href="jobcommerceMD.res" style="color:yellow;">[경력] 커머스 MD(기술,공예)</a></article>

 </section>
 <section id="sec">
 <h3>CX/Operation chapter</h3>
 <article><a href="joblogistic.res" style="color:yellow;">[경력] 물류관리 담당자</a></article>
 	<article>
    	<button style="align-content: center;" class="btn1" onclick="location.href='../res/Resemailyesno.res' ">지원자 이력서 합격 결과조회</button>
    	 <br/>
	</article>
<c:if test="${!empty logMaster }">
     	<button style="align-content: center;" class="btn4" onclick="location.href='../res/ResemailCk.res' ">채용 이력서 결과조회</button>
</c:if>
 </section>
 
</body>
</html>