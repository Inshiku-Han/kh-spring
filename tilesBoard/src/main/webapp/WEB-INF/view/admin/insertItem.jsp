<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.panel, .panel-heading{
		border-radius: 20px;
	}
</style>
</head>
<body>
<div class="panel panel-default"> <!-- 회색 패널 시작 -->
	<div class="panel-heading">
		<div class="panel panel-default">
			<div class="penal-body" style="padding-left: 20px; padding-right: 20px;"><!-- 제목 패널 시작 -->
				<div class="row">
					<div class="col-md-12 text-right">
						<ol class="breadcrumb" style="background-color: white; margin-bottom: 0px;">
						  <li><a href="#">관리자</a></li>
						  <li class="active">상품등록</li>
						</ol>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h2 style="margin-top: 5px;">Registration Goods</h2>
					</div>
				</div>
			</div><!-- 제목 패널 끝 -->
		</div>
		<div class="panel panel-default"><!-- 내용 패널 시작 -->
			<div class="penel-body" style="padding-left: 20px; padding-right: 20px;">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<form class="form-horizontal" action="insertGoods.ad" method="post" id="goodsForm" enctype="multipart/form-data">
							<div class="form-group has-success">
								<label class="control-label" for="categoryCode">Input Goods Category</label>
								<select class="form-control" name="categoryCode" id="categoryCode">
									<c:forEach items="${categoryList }" var="category">
										<option value="${category.categoryCode }">${category.categoryName }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group has-success">
								<label class="sr-only" for="goodsName">Amount(in dollars)</label>
								<div class="input-group">
									<div class="input-group-addon"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></div>
									<input type="text" class="form-control" id="goodsName" name="goodsName" placeholder="Input Goods Name">
								</div>
							</div>
							<div class="form-group has-success">
								<label class="sr-only" for="goodsPrice">Amount(in dollars)</label>
								<div class="input-group">
									<div class="input-group-addon"><span class="glyphicon glyphicon-tags" aria-hidden="true"></span></div>
									<input type="text" class="form-control" id="goodsPrice" name="goodsPrice" placeholder="Input Goods Price">
								</div>
							</div>
							<div class="form-group has-success">
								<label class="sr-only" for="goodsDeliveryPrice">Amount(in dollars)</label>
								<div class="input-group">
									<div class="input-group-addon"><span class="glyphicon glyphicon-tags" aria-hidden="true"></span></div>
									<input type="text" class="form-control" id="goodsDeliveryPrice" name="goodsDeliveryPrice" placeholder="Input Goods Delivery Price">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="">대표 이미지</label>
								<div class="input-group">
									<input type="file" class="form-control" id="" name="file1" placeholder="상품 이미지를 등록하세요.">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="">상세 이미지(복수가능)</label>
								<div class="input-group">
									<input type="file" multiple="multiple" class="form-control" id="" name="file2" placeholder="상품 이미지를 등록하세요.">
								</div>
							</div>
							<div class="form-group has-success">
								<label class="control-label" for="goodsContent">Input Goods Content</label>
								<textarea class="form-control" name="goodsContent" id="goodsContent" rows="3"></textarea>
							</div>
							<div class="row">
								<div class="col-md-2 col-md-offset-5">
									<input type="submit" class="btn btn-success btn-block" value="registration">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- 내용 패널 끝 -->		
	</div>
</div><!-- 회색 패널 끝 -->

<script src="resources/js/insertItem.js?ver=12"></script>
</body>
</html>








