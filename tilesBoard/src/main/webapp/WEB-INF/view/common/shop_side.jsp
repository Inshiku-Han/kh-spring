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
<li role="presentation" <c:if test="${goodsVO.subMenu eq 'allCategory' }">class="active"</c:if> ><a href="shopList.sh?categoryCode=0&subMenu=allCategory">전체 카테고리</a></li>
<c:forEach items="${categoryList }" var="category">
  <li role="presentation" <c:if test="${category.categoryName eq goodsVO.subMenu}">class="active"</c:if> ><a href="shopList.sh?categoryCode=${category.categoryCode }&subMenu=${category.categoryName }">${category.categoryName }</a></li>
</c:forEach>
</ul>
</body>
</html>















