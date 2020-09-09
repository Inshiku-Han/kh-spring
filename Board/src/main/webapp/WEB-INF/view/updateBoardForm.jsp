<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<form action="updateBoard.do" method="post">
	<table>
		<tr>
			<td>제목<input type="text" value="${board.boardTitle }" name="boardTitle" readonly="readonly" style="border: none;"></td>
		</tr>
		<tr>
			<td>내용<input type="text" value="${board.boardContent }" name="boardContent"></td>
		</tr>
		<tr>
			<td>작성자<input type="text" value="${board.boardWriter }" name="boardWriter"></td>
		</tr>
		<tr>
			<td>작성일 ${board.boardDate }</td>
		</tr>
	</table>
	<input type="submit" value="수정">	
	</form>
</div>
</body>
</html>