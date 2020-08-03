<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../creatorCenter/css/class_Video.css">
<script src="../creatorCenter/js/class_Video.js"></script>
</head>
<body>
<div class="video_Container" id="video_Container">
<input type="hidden" name="classesStep" id="classesStep" value="2" />
<c:if test="${!empty list }">
	<c:forEach items="${list }" var="dto" varStatus="cnt">
		<div class="classBox" id="classBox">
			<div class="classInput" id="classInput">
				영상 경로 : <input type="text" name="classUrl" id="classUrl" value="${dto.classesListContent }">
				순서 		<select name="classOrderNum" class="classOrderNum" id="classOrderNum">
							<option value="${dto.classesListNum }">${dto.classesListNum }강</option>
						</select>
				 강의 목차 <input type="text" name="classListSubject" id="classListSubject" value="${dto.classesListSubject }">
			</div>
			<div class="classBox" id="classBox1">
			</div>
		</div>
	</c:forEach>
</c:if>
<c:if test="${empty list }">
	<div class="classBox" id="classBox">
		<div class="classInput" id="classInput">
				영상 경로 : <input type="text" name="classUrl" value="">
					순서 <!--  <input type="text" name="classOrderNum" class="classOrderNum" id ="classOrderNum" value="1"> -->
					<select name="classOrderNum" class="classOrderNum" id ="classOrderNum">
						<option value="01"> 1강 </option>
						<option value="02"> 2강 </option>
						<option value="03"> 3강 </option>
						<option value="04"> 4강 </option>
						<option value="05"> 5강 </option>
						<option value="06"> 6강 </option>
						<option value="07"> 7강 </option>
						<option value="08"> 8강 </option>
						<option value="09"> 9강 </option>
						<option value="10"> 10강 </option>
						<option value="11"> 11강 </option>
						<option value="12"> 12강 </option>
						<option value="13"> 13강 </option>
						<option value="14"> 14강 </option>
						<option value="15"> 15강 </option>
						<option value="16"> 16강 </option>
						<option value="17"> 17강 </option>
						<option value="18"> 18강 </option>
						<option value="19"> 19강 </option>
						<option value="20"> 20강 </option>
					</select>
				 강의 목차 <input type="text" name="classListSubject" value="">
			</div>
	</div>
</c:if>
	<div class="videoAdd">
		<button type="button" id="videoAdd">+ 강의 추가하기</button>
	</div>
</div>
</body>
</html>