<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- sample.css 파일 사용을 위한 태그 -->
<link rel="stylesheet" type="text/css" href="resources/css/insertGradeForm.css?ver=2"/>
<!-- Jquey를 사용을 위한 태그 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- smaple.js를 사용하기 위한 태그 -->
<script src="resources/js/insertGradeForm.js?ver=2"></script>
</head>
<body>
<div style="height: 50px;"></div>
<div id="mainContainer" align="center">
<form action="insertGrade.do" method="post">
	<div align="center">
		<table>
			<tr>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
			</tr>
			<tr>
				<td><input type="text" name="korScore"></td>
				<td><input type="text" name="engScore"></td>
				<td><input type="text" name="mathScore"></td>
			</tr>
		</table>
	</div>
	<div style="height: 30px;"></div>
	<div align="center">
		<input type="hidden" value="${insik }" name="stuNum">
		<input type="submit" value="점수등록">
	</div>
</form>
</div>
</body>
</html>