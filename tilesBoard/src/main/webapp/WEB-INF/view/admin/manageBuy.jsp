<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="panel panel-danger"> <!-- 회색 패널 시작 -->
		<div class="panel-heading">
			<div class="panel panel-danger">
				<div class="panel-body" style="padding-left: 20px; padding-right: 20px;"><!-- 제목 패널 시작 -->
					<div class="row">
						<div class="col-md-12 text-right">
							<ol class="breadcrumb" style="background-color: white; margin-bottom: 0px;">
							  <li><a href="#">관리자메뉴</a></li>
							  <li class="active">구매관리</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<h2 style="margin-top: 5px;">MANAGE BUY</h2>
						</div>
					</div>
				</div><!-- 제목 패널 끝 -->
			</div>
			<div class="panel panel-danger"><!-- 내용 패널 시작 -->
				<div class="panel-body" style="padding-left: 20px; padding-right: 20px;">
					<div class="panel panel-danger">
						<div class="panel-body">
							<form action="manageBuy.ad" method="post" class="form-inline">
								<input type="hidden" name="mainMenu" value="admin">
								<input type="hidden" name="subMenu" value="manageBuy" >
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
										    <select class="form-control" style="width: 99%;" name="searchKeyword">
										    	<option value="MEMBER_ID" <c:if test="${searchVO.searchKeyword eq 'MEMBER_ID' or empty searchVO.searchKeyword}">selected</c:if> >구매자</option>
										    	<option value="GOODS_NAME" <c:if test="${searchVO.searchKeyword eq 'GOODS_NAME'}">selected</c:if> >상품명</option>
										    	<option value="ORDER_ID" <c:if test="${searchVO.searchKeyword eq 'ORDER_ID'}">selected</c:if> >주문ID</option>
										    </select>
										</div>
										<div class="form-group">
										    <label class="sr-only" for="manageBuySearch">검색</label>
										    <input type="text" class="form-control" id="manageBuySearch" name="searchValue" value="${searchVO.searchValue }">
										</div>
										<div class="form-group">
										    <label class="sr-only" for="manageBuyFromDate">fromDate</label>
										    <input type="date" class="form-control" value="${dateResult[0] }" id="manageBuyFromDate" style="width: 150px;" name="fromDate">
										</div>
										<div class="form-group">
											<label>~</label>
										</div>
										<div class="form-group">
										    <label class="sr-only" for="manageBuyToDate">toDate</label>
										    <input type="date" class="form-control" value="${dateResult[1] }" id="manageBuyToDate" style="width: 150px;" name="toDate">
									 	</div>
									 	<div class="form-group">
											<div class="radio">
										    	<label>
												    <input type="radio" name="isConfirm"  value="N" <c:if test="${searchVO.isConfirm eq 'N' or empty searchVO.isConfirm}">checked</c:if> >
												   	 전체
										    	</label>
											</div>
											<div class="radio">
												<label>
												  	<input type="radio" name="isConfirm"  value="Y" <c:if test="${searchVO.isConfirm eq 'Y'}">checked</c:if> >
												     구매확인
												</label>
											</div>
									 	</div>
										<div class="form-group">
										    <input type="submit" class="btn btn-primary" value="검색" style="width: 80px;">
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="panel panel-danger">
						<div class="panel-body">
							<div class="col-md-12 text-center">
								<table class="table table-striped">
									<colgroup>
										<col width="10%">
										<col width="15%">
										<col width="10%">
										<col width="15%">
										<col width="25%">
										<col width="10%">
										<col width="15%">
									</colgroup>
									<thead>
										<tr>
											<td>번호</td>
											<td>주문ID</td>
											<td>구매자</td>
											<td>구매일</td>
											<td>상품명</td>
											<td>주문금액</td>
											<td>주문확인</td>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${buyList }" var="buyList">
										<tr>
											<td>${buyList.orderNum }</td>
											<td>${buyList.orderId }</td>
											<td>${buyList.memberId }</td>
											<td>${buyList.buyDate }</td>
											<td>${buyList.goodsName }</td>
											<td>${buyList.orderPrice }</td>
											<td>
												<c:choose>
													<c:when test="${buyList.isConfirm eq 'N'}">
														<input type="button" data-orderNum="${buyList.orderNum }" class="btn btn-danger btn-block confirmOrderBtn" value="주문확인">
													</c:when>
													<c:otherwise>
														<span style="color: red;">확인완료</span>
													</c:otherwise>
												</c:choose>
											</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div><!-- 내용 패널 끝 -->		
		</div>
	</div><!-- 회색 패널 끝 -->
<script src="resources/js/manageBuy.js?ver=2"></script>
</body>
</html>