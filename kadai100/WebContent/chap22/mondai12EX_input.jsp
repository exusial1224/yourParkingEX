<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html"%>
<form action="update" method="get">
<table>
<tr>
	<th>名前</th><th>コース</th>
</tr>
<c:forEach var="p" items="${list }">
<tr>
	<th><input type="text" name="name" value="${p.student_Name}"></th><th>${p.course_Name }</th>
</c:forEach>
</table>
</form>
<%@include file="../footer.html" %>
