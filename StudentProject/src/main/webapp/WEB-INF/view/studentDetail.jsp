<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- sample.css 파일 사용을 위한 태그 -->
<link rel="stylesheet" type="text/css" href="resources/css/studentDetail.css?ver=3"/>
<!-- Jquey를 사용을 위한 태그 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- smaple.js를 사용하기 위한 태그 -->
<script src="resources/js/studentDetail.js?ver=2"></script>
</head>
<body>
<div style="height: 50px;"></div>
<div id="mainContainer" align="center">
<form action="updateGrade.do" method="post">
	<div align="center">
		<table>
			<tr id="addr">
				<td>${student.stuName }</td>
				<td>${student.stuAge }살</td>
				<td>${student.stuAddr }</td>
			</tr>
			<tr id="cardinalty">
				
				<td>국어점수 : 
					<input type="text" name="korScore"  
						<c:choose>
							<c:when test="${empty grade }">
								value="0" readonly="readonly"
							</c:when>
							<c:otherwise>
								value="${grade.korScore }"
							</c:otherwise>
						</c:choose>
					>
				</td>
				<td>영어점수 : 
					<input type="text" name="engScore"  
						<c:choose>
							<c:when test="${empty grade }">
								value="0" readonly="readonly"
							</c:when>
							<c:otherwise>
								value="${grade.engScore }"
							</c:otherwise>
						</c:choose>
					>
				</td>
				<td>수학점수 : 
					<input type="text" name="mathScore"  
						<c:choose>
							<c:when test="${empty grade }">
								value="0" readonly="readonly"
							</c:when>
							<c:otherwise>
								value="${grade.mathScore }"
							</c:otherwise>
						</c:choose>
					>
				</td>
			</tr>
		</table>
	</div>
	<div style="height: 30px;"></div>
	<div align="center">
		<input type="button" value="뒤로가기" onclick="location.href='studentList.do';">&nbsp;&nbsp;&nbsp;
		<c:if test="${empty grade.gradeCode }">
		<input type="button" value="점수등록" onclick="location.href='insertGrade.do?stuNum=${student.stuNum }';">&nbsp;&nbsp;&nbsp;
		</c:if>
		<c:if test="${not empty grade.gradeCode }">
		<input type="hidden" value="${grade.stuNum }" name="stuNum">
		<input type="submit" value="점수수정">
		</c:if>
	</div>
</form>
</div>
</body>
</html>