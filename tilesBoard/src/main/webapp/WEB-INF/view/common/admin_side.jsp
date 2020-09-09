<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul class="nav nav-pills nav-stacked">
  <li role="presentation" <c:if test="${memberVO.subMenu eq 'manageBuy' }">class="active"</c:if>><a href="manageBuy.ad?mainMenu=admin&subMenu=manageBuy">구매관리</a></li>
  <li role="presentation" <c:if test="${memberVO.subMenu eq 'insertItem' }">class="active"</c:if>><a href="insertItem.ad?mainMenu=admin&subMenu=insertItem">상품등록</a></li>
  <li role="presentation" <c:if test="${memberVO.subMenu eq 'manageItem' }">class="active"</c:if>><a href="manageItem.ad?mainMenu=admin&subMenu=manageItem">상품관리</a></li>
  <li role="presentation" <c:if test="${memberVO.subMenu eq 'manageMember' }">class="active"</c:if>><a href="manageMember.ad?mainMenu=admin&subMenu=manageMember">회원관리</a></li>
</ul>
</body>
</html>











