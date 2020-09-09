<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.stuName:hover{
	cursor: pointer;
	color: skyblue;
}
table{
	text-align: center;
	margin: auto;
}
h2{
	color: #03C75A;
}
.tabColor{
	border: 1px solid #03C75A;
}
.tabColor > tr{
	border: 1px solid #03C75A;
}
.tabColor > tr > td{
	border: 1px solid #03C75A;
}
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
</style>
</head>
<body>
<div align="center">
	<table border="1" style="width: 900px; height: 500px;">
		<tr>
			<td align="center" style="width: 450px;">
				<div class="js-clock">
					<h2 class="js-title"></h2>
				</div>
				<div>
					<select id="classSelector">
						<option value="0" >전체</option>
						<c:forEach items="${classList }" var="classVO">
							<option value="${classVO.classCode }" <c:if test="${studentVO.classCode eq classVO.classCode }">selected</c:if> >${classVO.className }</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<table id="listTable">
						<tr>
							<td>이름</td>
							<td>나이</td>
							<td>주소</td>
						</tr>
						<c:forEach items="${studentList }" var="student">
							<tr>
								<td><div class="stuName" data-stuNum="${student.stuNum }">${student.stuName }</div></td>
								<td>${student.stuAge }</td>
								<td>${student.stuAddr }</td>
								<td><input type="button" value="삭제" class="deleteBtn" data-stuNum="${student.stuNum }"></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div>
					<input type="hidden" value="학생추가" id="insertBtn">
				</div>
			</td>
			<td align="center" id="gradeTd">
				<table id="gradeTable">
				</table>
				<div style="height: 20px"></div>
				<div id="gradeDiv"></div>
			</td>
		</tr>
	</table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/studentManagement.js?ver=2"></script>
<script src="resources/js/clock.js?ver=3"></script>
</body>
</html>