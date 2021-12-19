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
		<title>Insert title here</title>
	</head>
<body>
<div class="container">
	<h2>상세보기</h2>
	<br/>
	<form action="update.doo" method="post">
		<input type="hidden" name="btitle" value="${dto.btitle}">
		<table class="table table-striped table-hover">
			<tr>
				<th>btitle</th><td>${dto.btitle}</td>
			</tr>
			<tr>
				<th>id</th><td><input type="text" value="${dto.id}" name="id"></td>
				<th>bcontent</th><td><input type="text" value="${dto.bcontent}" name="bcontent" style="width:300px;height:200px;font-size:30px;"></td>
			</tr>
			<tr>
				<th>bdate</th><td colspan="3"><input type="text" value="${dto.bdate}" name="bdate"></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value ="게시물 수정" >
					<input type="button" value ="게시물 삭제" onclick ="location.href='bdelete.do?btitle=${dto.btitle}'">
					<input type="button" value ="게시물 목록" onclick ="location.href='blist.doo'">
					<input type="button" value ="게시물 등록" onclick ="location.href='binsertform.doo'">
				</td>
			</tr>
		</table><br><br>
	</form>
</div>
</body>
</html>
