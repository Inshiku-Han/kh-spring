<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
<style type="text/css">
div{
	text-align: center;
}
a{
	color: black;
}
.menuDiv{
	background: skyblue;	
	height: 100px;
	
}
.sideDiv{
	width:10%;
	height:410px;
	background: orange;
	float: left;
	
}
.mainDiv{
	width:90%;
	height:410px;
	background: #FDFD96;
	
}
.sideDiv, .mainDiv{
	display: inline-block;
}
</style>
</head>
<body>

<div class="menuDiv">
	<tiles:insertAttribute name="header"/>
</div>
<div class="sideDiv">
	<tiles:insertAttribute name="side"/>
</div>
<div class="mainDiv">
	<tiles:insertAttribute name="body"/>
</div>

</body>
</html>