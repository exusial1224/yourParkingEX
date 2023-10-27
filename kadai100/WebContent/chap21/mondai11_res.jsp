<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>
<%@page import="bean.Course, java.util.List" %>

<% List<Course> list = (List<Course>) request.getAttribute("list"); %>

<% if (list != null && !list.isEmpty()) { %>
	<form>
	<table border="1">
	<tr>
	<th>コースID</th><th>コース名</th>
	</tr>
	<tr>
	<th>${lit.get(0).course_Id }</th>
	<th>${list.get(0).course_Name}</a></th>
    </tr>
    </form>

<% } else { %>
    <p>検索結果はありません。</p>
<% } %>


<%@include file="../footer.html" %>