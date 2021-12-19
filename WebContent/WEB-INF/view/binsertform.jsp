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
	<title>게시물 등록</title>
</head>
<body>
<div class="container">
	<h2>게시물 등록</h2> 
	<form method="post" action="insert.doo" class="form-horizontal">
			<div class="form-group">
				<div class="col-sm-4">
					제목 : <input type="text" name ="btitle" class="form-control">
				</div>
			</div>
		
			<div class="form-group">
				<div class="col-sm-4">
					아이디 : <input type="text" name ="id" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4">
					내용 : <input type="text" name ="bcontent" style="width:300px;height:200px;font-size:30px;" class="form-control">
				</div>
			</div>
			<input type="submit" value="등록하기">
			<input type="reset" value="다시입력">
			<input type="button" value="홈으로" onclick="location.href='index.html'">
			<br><br>
	</form>
</div>

</body>
</html>