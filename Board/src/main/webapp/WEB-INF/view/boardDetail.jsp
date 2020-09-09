<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<table border="1" style="text-align: center;">
		<tr>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<tr>
			<td>${board.boardTitle }</td>
			<td>${board.boardContent }</td>
			<td>${board.boardWriter }</td>
			<td>${board.boardDate }</td>
		</tr>
	</table>
	<p>보드리스트에서 받아온 파라메터 : ${boardVO.boardTitle }</p>
	<a href="deleteBoard.do?boardTitle=${board.boardTitle }">삭제</a>
	<a href="updateBoard.do?boardTitle=${board.boardTitle }">수정</a>
</div>
</body>
</html>