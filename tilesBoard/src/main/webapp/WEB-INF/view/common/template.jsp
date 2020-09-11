<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<link rel="stylesheet" type="text/css" href="resources/css/reset.css?ver=2"/>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- Jquey를 사용을 위한 태그 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>



<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script> -->


<script src="resources/js/jquery.validate.js"></script>
<style type="text/css">
label.error{
	color: red;
	font-size: 12px;
	display: block;		
}
.panel, .panel-heading{
		border-radius: 20px;
}

.myContainer{
	margin-left: auto;
	margin-right: auto;
	width: 70%;
}
</style>
<script type="text/javascript">
//validate에 정규식 사용하게 설정
$.validator.addMethod('regx', function(value, element, regexpr){
	return regexpr.test(value);
});
</script>
</head>
<body>
<div style="height: 30px;"></div>
<div class="container-fluid">
	<div class="myContainer">
		<div class="row">
			<div class="col-md-12">
				<tiles:insertAttribute name="menu" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-2" style="padding: 0px;">
				<tiles:insertAttribute name="side" />
			</div>
			<div class="col-md-10" id="bodyDiv">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
</div>






</body>
</html>





















