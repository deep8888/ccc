<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../creatorCenter/jquery/jquery.js"></script>
<script src="../creatorCenter/js/comment.js"></script>
<title>comment</title>
<link rel="stylesheet" href="../creatorCenter/css/comment.css">
</head>
<body>
	<div class="container">
		<section>
			<header class="header">
				<div class="classCount">
					<h1>클래스 댓글 관리</h1>
					<span class="count">총 0개</span>
				</div>
				<div class="class_select">
					<select>
						<option selected="selected">클래스를 선택해주세요.</option>
						<option>html 강의 1</option>
						<option>html 강의 2</option>
						<option>html 강의 3</option>
						<option>html 강의 4</option>
					</select>
				</div>
			</header>
			<table class="table_replied">
				<thead>
					<tr>
						<td class="replied_notPost" id="replied_notPost">답변 대기중</td>
						<td class="replied_Post" id="replied_Post">답변 완료</td>
					</tr>
				</thead>
				<tbody>
					<tr class="replied_body">
						<td colspan="2">
							<a href="#">
								<h4>클래스 이름 : </h4>
								<p> 댓글 내용</p>
							</a>
						</td>
					</tr>
				</tbody>
			</table>
<!-- 			<div>
				<div>답변 대기중</div>
				<div>답변 완료</div>
			</div>
			<div>
				<h4>사용자이름</h4>
				<div>댓글내용</div>
			</div> -->
		</section>
	</div>
</body>
</html>