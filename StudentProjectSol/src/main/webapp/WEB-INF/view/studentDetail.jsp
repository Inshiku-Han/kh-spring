<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl 사용을 위한 taglib -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- sample.css 파일 사용을 위한 태그 -->
<link rel="stylesheet" type="text/css"
	href="resources/css/studentDetail.css?ver=1" />
<!-- Jquey를 사용을 위한 태그 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- smaple.js를 사용하기 위한 태그 -->
<script src="resources/js/studentDetail.js?ver=1"></script>
</head>
<body>
<form action="saveScore.do" method="post" id="scoreForm">
<input type="hidden" name="stuNum" value="${student.stuNum }">
	<div align="center">
		<div style="height: 50px;"></div>
		<div class="tableDiv">
			<table>
				<tr>
					<td>이름</td>
					<td>나이</td>
					<td>주소</td>
				</tr>
				<tr>
					<td>${student.stuName }</td>
					<td>${student.stuAge }</td>
					<td>${student.stuAddr }</td>
				</tr>
				<tr>
					<td>국어점수</td>
					<td>영어점수</td>
					<td>수학점수</td>
				</tr>
				<tr>
					<td><input type="number" name="korScore" value="<c:choose><c:when test="${empty student.gradeVO }">0</c:when><c:otherwise>${student.gradeVO.korScore }</c:otherwise></c:choose>"></td>
					<td><input type="number" name="engScore" value="<c:choose><c:when test="${empty student.gradeVO }">0</c:when><c:otherwise>${student.gradeVO.engScore }</c:otherwise></c:choose>" ></td>
					<td><input type="number" name="mathScore" value="<c:choose><c:when test="${empty student.gradeVO }">0</c:when><c:otherwise>${student.gradeVO.mathScore }</c:otherwise></c:choose>" ></td>
					
				</tr>
			</table>
		</div>
		<div style="height: 30px;"></div>
		<div class="menuDiv">
			<c:if test="${empty student.gradeVO }">
				<input type="button" value="점수등록" id="saveBtn">
			</c:if>
			<c:if test="${not empty student.gradeVO }">
				<input type="button" value="점수수정" id="saveBtn">
			</c:if>
		</div>
	</div>
</form>
</body>
</html>