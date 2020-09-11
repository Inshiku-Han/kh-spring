<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
th, td{
	text-align: center;
}
.table > tbody > tr > td {
	vertical-align: middle;
}
.table > thead > tr > th {
	font-weight: bold;
}
</style>
</head>
<body>
<form action="" method="post">
	
	<div class="panel panel-default"> <!-- 회색 패널 시작 -->
		<div class="panel-heading">
			<div class="panel panel-default">
				<div class="panel-body" style="padding-left: 20px; padding-right: 20px;"><!-- 제목 패널 시작 -->
					<div class="row">
						<div class="col-md-12 text-right">
							<ol class="breadcrumb" style="background-color: white; margin-bottom: 0px;">
							  <li><a href="#">쇼핑하기</a></li>
							  <li class="active">장바구니</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<h2 style="margin-top: 5px;">CART LIST</h2>
						</div>
					</div>
				</div><!-- 제목 패널 끝 -->
			</div>
			<div class="panel panel-default"><!-- 내용 패널 시작 -->
				<div class="panel-body" style="padding-left: 20px; padding-right: 20px;">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">도서 정보</h3>
						</div>
						<div class="panel-body">
							<div class="col-md-12 text-center">
								<table class="table table-striped">
									<colgroup>
										<col width="3%">
										<col width="6%">
										<col width="10%">
										<col width="*">
										<col width="15%">
										<col width="15%">
										<col width="9%">
										<col width="9%">
										<col width="7%">
									</colgroup>
									<thead>
										<tr>
											<th><input type="checkbox" id="allCheck" checked></th>
											<th>번호</th>
											<th>이미지</th>
											<th>도서명</th>
											<th>구매자(이름)</th>
											<th>구매일</th>
											<th>가격</th>
											<th>수량</th>
											<th>총가격</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${cartList }" var="cart" varStatus="status">
											<tr>
												<td><input type="checkbox" class="chk" checked value="${cart.cartId }"></td>
												<td>${status.index + 1 }</td>
												<td><img src="/upload/${cart.fileName }" width="95%;"></td>
												<td>${cart.goodsName }</td>
												<td>${cart.memberId }(${cart.memberName })</td>
												<td>${cart.createDate }</td>
												<td>${cart.goodsPrice }</td>
												<td>${cart.goodsCnt }</td>
												<td class="someTotal">${cart.totalPrice }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">전체 가격</h3>
						</div>
						<div class="panel-body">
							<div class="form-horizontal text-right">
								<span id="totalPrice" style="font-weight: bold; color: red; font-size: 24px;"></span>
								<span style="font-weight: bold; color: red; font-size: 24px;">원</span>
							</div>
						</div>
					</div>
					<div class="col-md-12 text-center">
						<input type="button" id="deleteCartBtn"  class="btn btn-success" value="장바구니 비우기">
						<input type="button"  class="btn btn-success" value="구매하기">
					</div>
				</div>
			</div><!-- 내용 패널 끝 -->		
		</div>
	</div><!-- 회색 패널 끝 -->
</form>
<script src="resources/js/cartList.js?ver=4"></script>
</body>
</html>











