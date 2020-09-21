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
	href="resources/css/studentList.css?ver=1" />
<!-- Jquey를 사용을 위한 태그 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- smaple.js를 사용하기 위한 태그 -->
<script src="resources/js/studentList.js?ver=1"></script>
</head>
<body>
	<div align="center">
		<div style="height: 50px;"></div>
		<div class="menuDiv">
			<div class="selectDiv">
				<select >
					<option value="0">전체</option>
					<c:forEach items="${classList }" var="classVO">
<%-- 						<option value="${classVO.classCode }" <c:if test="${classVO.classCode eq studentList[0].classCode }">selected</c:if> >${classVO.className }</option> --%>
						<option value="${classVO.classCode }" <c:if test="${studentVO.classCode eq classVO.classCode }">selected</c:if> >${classVO.className }</option>
					</c:forEach>
				</select>
			</div>
			<div class="searchDiv">
				<input type="text"> 
				<input type="button" value="검색">
			</div>
		</div>
		<div style="height: 60px;"></div>
		<div class="tableDiv">
			<table>
				<tr>
					<td>이름</td>
					<td>나이</td>
					<td>주소</td>
				</tr>
				<c:forEach items="${studentList }" var="student">
					<tr>
						<td><a href="studentDetail.do?stuNum=${student.stuNum }">${student.stuName }</a></td>
						<td>${student.stuAge }</td>
						<td>${student.stuAddr }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>