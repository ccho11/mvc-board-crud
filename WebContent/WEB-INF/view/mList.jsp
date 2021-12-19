<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page import = "ch.cho.dao.*, ch.cho.dto.*, java.util.List, java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>멤버 목록</title>
</head>
<body>
	<form action="list.do" method="post">
	<div class="container">
		<h2>멤버 목록</h2>
		<br/>
		<table class="table table-striped table-hover">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>email</th>
				<th>joinDate</th>
			</tr>
		<c:forEach var="dto" items = "${dtos}">
			<tr>
				<td><a href="view.do?id=${dto.id}">${dto.id}</a></td>
				<td>${dto.name}</td>
				<td>${dto.email}</td>
				<td><fmt:formatDate value="${dto.joinDate}"/></td>
			</tr>
		</c:forEach>
		</table>
		<input type="button" value ="홈으로" onclick ="location.href='index.html'">
		<input type="button" value ="멤버 등록" onclick ="location.href='insertform.do'">
	</div>
	</body>
</html>