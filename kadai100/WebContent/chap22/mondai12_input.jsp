<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html"%>
<%@page import="bean.Course, java.util.List"  %>

<form action="update" method="get">
<table border="1">
<tr>
	<th>学生名</th><th>所属コース</th>
</tr>
<c:forEach var="i" begin="0" end="5">
	<tr>
		<th><input type="text" name= "name${i }" ></th>
			<th>
				<select name="course${i }">
					<c:forEach var="h" items="${ list}">
						<option value="${h.course_Id }">${h.course_Name }</option>
					</c:forEach>
				</select>
			</th>
	</tr>
</c:forEach>
</table>
<input type="submit" value="送信">
</form>
<%@include file="../footer.html" %>
