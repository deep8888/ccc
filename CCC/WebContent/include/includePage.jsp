<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.font1{color:white;}
</style>
<c:if test="${page <= 1 }"><span style="color:white;">[이전]</span></c:if>
<c:if test="${page > 1 }"><a href="${pageUrl }page=${page -1 }"><span style="color:white;">[이전]</span></a></c:if>

<c:forEach begin="${startPage }" end="${endPage }" var="i" step="1">
<a href="${pageUrl }page=${i }">[${i}]</a></c:forEach>

<c:if test="${page < maxPage }">
<a href="${pageUrl }page=${page +1 }"><span style="color:white;">[다음]</span></a>
</c:if>
<c:if test="${page >= maxPage }"><span style="color:white;">[다음]</span></c:if>