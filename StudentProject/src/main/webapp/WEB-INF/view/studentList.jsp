<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- sample.css 파일 사용을 위한 태그 -->
<link rel="stylesheet" type="text/css" href="resources/css/studentList.css?Ver=2"/>
<!-- Jquey를 사용을 위한 태그 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- smaple.js를 사용하기 위한 태그 -->
<script src="resources/js/studentList.js?ver=2"></script>
</head>
<body>
<div style="height: 50px;"></div>
<div id="mainContainer" align="center">
	<form action="studentList.do" method="post">
		<div id="searchSet" align="center">
			<div align="left">
				<select name="classCode" class="selectBox">
					<c:forEach items="${select }" var="select" varStatus="status">
						<option value="${select.classCode }" <c:if test="${select.classCode eq studentVO.classCode }">selected="selected"</c:if>> ${select.className }</option>
					</c:forEach>
				</select>
			</div>
			<div align="right">
				<input type="text" name="stuName">&nbsp; <input type="submit" value="검색">
			</div>
		</div>
	</form>
<div style="height: 30px;"></div>
	<div align="center">
		<table>
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
			</tr>
			<c:forEach items="${list }" var="list">
				<tr>
					<td><a href="studentDetail.do?stuNum=${list.stuNum }">${list.stuName }</a></td>				
					<td>${list.stuAge }</td>				
					<td>${list.stuAddr }</td>				
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>