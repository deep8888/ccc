<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Notice_Board/notice_top.jsp" %>
<body>
<div class="Line"></div>

<table align="center" border="1" bordercolor="orange" cellpadding="0" cellspacing="0">
<br/><br/>
<c:if test="${!empty listSet}">
   <tr align="center" valign="middle">
      <td colspan="4"><div id="fonttop" class="fonttop">공지사항</div></td>
      <td align=right>
        <div id="font1" class="font1"> <font size=2>글 개수 : ${notCount}</font></div>
      </td>
   </tr>

   <tr align="center" valign="middle" bordercolor="#333333">
      <td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
         <div align="center" id="font1" class="font1">번호</div>
      </td>
      <td style="font-family:Tahoma;font-size:8pt;" width="50%">
         <div align="center" id="font1" class="font1">제목</div>
      </td>
      <td style="font-family:Tahoma;font-size:8pt;" width="14%">
         <div align="center" id="font1" class="font1">작성자</div>
      </td>
      <td style="font-family:Tahoma;font-size:8pt;" width="17%">
         <div align="center" id="font1" class="font1">날짜</div>
      </td>
      <td style="font-family:Tahoma;font-size:8pt;" width="11%">
         <div align="center" id="font1" class="font1">조회수</div>
      </td>
   </tr>
 </c:if>
<c:forEach items="${listSet}" var="dto" varStatus="cnt">   
   <tr align="center" valign="middle">
     <td height="23"> <div id="font1" class="font1">${cnt.count}</div></td>
     <td> <a href="noticeDetail.not?num=${dto.boardNum}"><div id="font1" class="font1"> ${dto.boardSubject}</div></a></td>
    <td><div id="font1" class="font1">  ${dto.boardName}</div></td>
<td><div id="font1" class="font1"><fmt:formatDate value="${dto.boardDate }" type="date" pattern="yyyy-MM-dd"/></div></td>
    <td><div id="font1" class="font1">  ${dto.readCount}</div></td>
   </tr>
   </div>
</c:forEach>
      
      
   </tr>
   <tr align=center height=20>
      <td colspan=7 style=font-family:Tahoma;font-size:10pt;>
       <%@ include file="/include/includePage.jsp" %>
      </td>
   </tr>
<c:if test="${!empty list }">
   <tr align="center" valign="middle">
      <td colspan="4"><div align="center" id="font1" class="font1">공지사항</div></td>
      <td align=right colspan="5">
<div align="center" id="font1" class="font1"><font size=2>등록된 글이 없습니다.</font></div>
      </td>
   </tr>
</c:if>
<c:if test="${!empty logMaster }">
   <tr align="right">
      <td colspan="5">
         <div align="center" id="font1" class="font1">   <a href="noticeWrite.not">[글쓰기]</a></div>
      </td>
   </tr>
</c:if>
</table>
<%@ include file="/Notice_Board/notice_bottom.jsp" %>		

</body>
</html>