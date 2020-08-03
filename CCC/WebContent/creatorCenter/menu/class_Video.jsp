<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/include.jsp"%>

<c:if test="${empty creDto }">
<script type="text/javascript">
	var no = 2; 

	function add() {

		if (no <=20) {
			var target = document.getElementById('classBox');
			target.innerHTML +='영상 경로 : <input type="text" name="classUrl" value=""> 순서 <input type="text" name="classOrderNum" class="classOrderNum" id ="classOrderNum" value="'+no+'"readonly/>강의 목차 <input type="text" name="classListSubject" value=""><br/>';

			no++;
		}
		}
</script>
</c:if>
<c:if test="${!empty creDto }">
<script type="text/javascript">
var babo = document.getElementById('cln').value;
 no=babo.replace(/[^0-9]/g,'');
 no=Number(no)+1;
	function add() {
		
		if (no <=20) {
			var target = document.getElementById('classBox');
			target.innerHTML +='영상 경로 : <input type="text" name="classUrl2" value=""> 순서 <input type="text" name="classOrderNum2" class="classOrderNum" id ="classOrderNum2" value="'+no+'"readonly/>강의 목차 <input type="text" name="classListSubject2" value=""><br/>';

			no++;
			
		}

	}
</script>
	</c:if>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../creatorCenter/css/class_Video.css">
<script src="../creatorCenter/js/class_Video.js"></script>
</head>
<body>

	<div class="video_Container" id="video_Container" style="overflow:scroll;overflow-x: hideen;height:550px;">
		<input type="hidden" name="classesStep" id="classesStep" value="2" />
	<c:if test="${!empty creDto }">
		<table>
		<c:forEach items="${list }" var="dto" begin="${dto.classesListNum }" end="20" varStatus="cnt">
		<tr>
			<td>영상 경로 :  <input type="text" name="classUrl" id="classUrl" value='${dto.classesListContent }'> 
			순서    <input type="text" name="classOrderNum" class="classOrderNum" value="${dto.classesListNum }"readonly>
			강의 목차    <input type="text" name="classListSubject" id="classListSubject" value="${dto.classesListSubject }"> </td>
		</tr>
		
		</c:forEach>
		<tr><td><div class="classBox" id="classBox" >
				<div class="classInput" id="classInput" style="margin: 0; padding: 0;">
					<input type="hidden" name="cln" class="cln" id ="cln" value="${list[list.size()-1].classesListNum }"/>
				</div>
			</div>
			</td>
			</tr>
		</table>
		</c:if>
		<c:if test="${empty creDto }">
		</br>
			<div class="classBox" id="classBox" >
				
					영상 경로 : <input type="text" name="classUrl" value=""> 순서
					 <input type="text" name="classOrderNum" class="classOrderNum" id ="classOrderNum" value="1" readonly/>강의 목차 <input type="text" name="classListSubject" value=""><br/>
				
			</div>
		</c:if>
		<div class="videoAdd">
			<button type="button" id="videoAdd" onclick="add();">+ 강의 추가하기</button>
		</div>
		



	</div>
</body>
</div>
</html>