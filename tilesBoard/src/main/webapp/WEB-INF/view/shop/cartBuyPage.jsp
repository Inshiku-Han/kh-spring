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
<form action="insertBuyList.sh" method="post">
<div class="panel panel-default"> <!-- 회색 패널 시작 -->
	<div class="panel-heading">
		<div class="panel panel-default">
			<div class="panel-body" style="padding-left: 20px; padding-right: 20px;"><!-- 제목 패널 시작 -->
				<div class="row">
					<div class="col-md-12 text-right">
						<ol class="breadcrumb" style="background-color: white; margin-bottom: 0px;">
						  <li><a href="#">쇼핑하기</a></li>
						  <li class="active">구매정보</li>
						</ol>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h2 style="margin-top: 5px;">ORDER INFOMATION</h2>
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
									<col width="10%">
									<col width="*">
									<col width="15%">
									<col width="15%">
									<col width="10%">
									<col width="10%">
									<col width="10%">
								</colgroup>
								<thead>
									<tr>
										<th>이미지</th>
										<th>도서명</th>
										<th>정 가(판매가)</th>
										<th>적립금</th>
										<th>수 량</th>
										<th>배송비</th>
										<th>총가격</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cartBuyList }" var="cartBuy">
										<tr>
											<td>
												<img src="/upload/${cartBuy.fileName }" style="width: 95%;">
												<input type="hidden" value="${cartBuy.goodsId }" name="goodsId">
											</td>
											<td>
												${cartBuy.goodsName }
												<input type="hidden" value="${cartBuy.goodsName }" name="goodsName">
											</td>
											<td>
												${cartBuy.goodsPrice }
												<input type="hidden" value="${cartBuy.cartId }" name="cartIdArr">
											</td>
											<td>
												${cartBuy.goodsPoint }
											</td>
											<td>
												${cartBuy.goodsCnt }
												<input type="hidden" value="${cartBuy.goodsCnt }" name="orderGoodsCnt">
											</td>
											<td>
												${cartBuy.goodsDeliveryPrice }
											</td>
											<td class="totalPrice">
												${cartBuy.totalPrice }
												<input type="hidden" value="${cartBuy.totalPrice }" name="orderPrice">
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">주문자 정보</h3>
					</div>
					<div class="panel-body">
						<div class="form-horizontal">
							<div class="form-group">
								<label class="col-md-2 control-label">주 문 자</label>
								<div class="col-md-10">
									<p class="form-control-static">${sessionScope.loginInfo.memberId }</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">연 락 처1</label>
								<div class="col-md-3">
									<p class="form-control-static">${sessionScope.loginInfo.tel1 }</p>
								</div>
								<label class="col-md-2 control-label">연 락 처2</label>
								<div class="col-md-3">
									<p class="form-control-static">${sessionScope.loginInfo.tel2 }</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">주 소</label>
								<div class="col-md-10">
									<p class="form-control-static">${sessionScope.loginInfo.memberAddr }</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">주문 금액</h3>
					</div>
					<div class="panel-body">
						<div class="form-horizontal text-right">
							<h4 style="font-weight: bold; color: red;"><span id="finalPrice" ></span><span>원</span></h4>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<input type="button" class="btn btn-default" value="이전 화면">
						<input type="submit" id="buyBtn" class="btn btn-success" value="구매하기">
					</div>
				</div>
			</div>
		</div><!-- 내용 패널 끝 -->		
	</div>
</div><!-- 회색 패널 끝 -->
</form>
	
<script src="resources/js/cartBuyPage.js?ver=3"></script>
</body>
</html>











