<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#scrollDiv{
	overflow:auto;
	overflow-x:hidden;
	height:440px;
}
#salesPerDayDiv{
	height: 36px;
}
.salesMonth:hover {
	cursor: pointer;
}

</style>
</head>
<body>
	<div class="col-md-12 text-center">
		<select>
			<option>2019</option>
			<option selected>2020</option>
			<option>2021</option>
		</select>
	</div>
	<div>
		<div class="col-md-6 text-center">
			<table class="table table-striped">
				<colgroup>
					<col width="50%" />
					<col width="50%" />
				</colgroup>
				<thead>
					<tr>
						<td>월</td>
						<td>매출액</td>
					</tr>
				</thead>
				<tbody id="leftTbody">
					<c:forEach items="${resultList }" var="sales">
						<tr>
							<td class="salesMonth">${sales.buyMonth }</td>
							<td>${sales.salesPerMonth }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-6 text-center">
			<div id="salesPerDayDiv"></div>
			<div id="scrollDiv"></div>
		</div>
	</div>

	<script src="resources/js/salesManage.js?ver=3"></script>
</body>
</html>