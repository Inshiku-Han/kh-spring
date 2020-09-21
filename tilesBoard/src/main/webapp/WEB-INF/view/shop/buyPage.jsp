<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="insertBuy.sh" method="post" id="buyForm">
	<input type="hidden" name="goodsId" value="${goodsDetail.goodsId }">
	<input type="hidden" name="goodsName" value="${goodsDetail.goodsName }">
	<input type="hidden" name="orderPrice" value="${goodsDetail.goodsPrice * cnt + goodsDetail.goodsDeliveryPrice }" class="hiddenPrice">
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
										<col width="3%">
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
											<th><input type="checkbox" checked></th>
											<th></th>
											<th>도서명</th>
											<th>정 가(판매가)</th>
											<th>적립금</th>
											<th>수 량</th>
											<th>배송비</th>
											<th>총가격</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input type="checkbox" checked></td>
											<td><img src="/upload/${goodsDetail.fileName }" width="95%;"></td>
											<td>${goodsDetail.goodsName }</td>
											<td>${goodsDetail.goodsPrice }</td>
											<td>${goodsDetail.goodsPoint }</td>
											<td><input type="number" name="orderGoodsCnt" class="buyCnt" value="${cnt }" style="width: 70%; text-align: center;"></td>
											<td>${goodsDetail.goodsDeliveryPrice }</td>
											<td>${goodsDetail.goodsPrice * cnt + goodsDetail.goodsDeliveryPrice }원</td>
										</tr>
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
								<h4><span id="totalPrice" style="font-weight: bold; color: red;">${goodsDetail.goodsPrice * cnt + goodsDetail.goodsDeliveryPrice }원</span></h4>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 text-center">
							<input type="button" class="btn btn-default" value="이전 화면">
							<input type="button" class="btn btn-info" value="장바구니 담기">
							<input type="button" id="buyBtn" class="btn btn-success" value="바로 구매하기">
						</div>
					</div>
				</div>
			</div><!-- 내용 패널 끝 -->		
		</div>
	</div><!-- 회색 패널 끝 -->
</form>
<script src="resources/js/buyPage.js?ver=3"></script>
</body>
</html>











