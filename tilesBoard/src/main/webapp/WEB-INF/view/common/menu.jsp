<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
span:hover{
	cursor: pointer;
}	
</style>
</head>
<body>
<div class="row">
	<div class="col-md-3 col-md-offset-9 text-right">
		<c:if test="${empty sessionScope.loginInfo }">
			<span data-toggle="modal" data-target="#loginModal">Login</span>&nbsp;&nbsp;<span data-toggle="modal" data-target="#joinModal">Join</span>
		</c:if>
		<c:if test="${not empty sessionScope.loginInfo }">
			${sessionScope.loginInfo.memberName }님 반갑습니다.&nbsp;&nbsp;<span id="logoutSpan">Logout</span>
		</c:if>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<h1>Shop</h1>
	</div>
</div>
<div class="row">
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">Brand</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li <c:if test="${goodsVO.mainMenu eq 'shopping' }">class="active"</c:if> ><a href="shopList.sh?mainMenu=shopping&subMenu=allCategory">쇼핑하기 <span class="sr-only">(current)</span></a></li>
	        <li <c:if test="${memberVO.mainMenu eq 'member' }">class="active"</c:if>><a href="selectMember.me?mainMenu=member&subMenu=selectMember">내정보관리</a></li>
	        <%-- <c:if test="${sessionScope.loginInfo.memberType eq 4 }"> --%>
		        <li <c:if test="${memberVO.mainMenu eq 'admin' }">class="active"</c:if>><a href="manageBuy.ad?mainMenu=admin&subMenu=manageBuy">관리자메뉴</a></li>
	        <%-- </c:if> --%>
	      </ul>
	      <form class="navbar-form navbar-right" role="search">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Search">
	        </div>
	        <button type="submit" class="btn btn-default">Submit</button>
	      </form>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
</div>




<!-- Login Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Login</h4>
			</div>
			<div class="modal-body">
				<form action="login.me" method="post">
					<div class="form-group">
					 	<label for="loginMemberId" class="sr-only">Email</label>
    					<input type="text" class="form-control" id="loginMemberId" name="memberId" placeholder="input your ID..." autocomplete="off">
  					</div>
  					<div class="form-group">
					 	<label for="loginMemberPassword" class="sr-only">Email</label>
    					<input type="password" class="form-control" id="loginMemberPassword" name="memberPassword" placeholder="input your PW...">
  					</div>
					<!-- <button type="button" class="btn btn-primary btn-block">L o g i n</button> -->
					<input type="submit" class="btn btn-primary btn-block" value="L O G I N">
				</form>
			</div>
			<!-- <div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Login</button>
			</div> -->
		</div>
	</div>
</div>

<!-- Join Modal -->
<div class="modal fade" id="joinModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Join</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="insertMember.me" method="post" id="joinForm">
					<!-- <div class="form-group has-success has-feedback"> -->
					<div class="form-group">
						<label for="memberId" class="col-md-2 control-label">I D</label>
    					<div class="col-md-10">
      						<input type="text" class="form-control" id="memberId" name="memberId" placeholder="I D" autocomplete="off">
      						<!-- <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span> -->
  							<!-- <span id="inputSuccess2Status" class="sr-only">(success)</span> -->
    					</div>
					</div>
					<div class="form-group">
						<label for="memberPassword" class="col-md-2 control-label">P W</label>
    					<div class="col-md-10">
      						<input type="password" class="form-control" id="memberPassword" name="memberPassword" placeholder="password">
    					</div>
					</div>
					<div class="form-group">
						<label for="memberPassword1" class="col-md-2 control-label">P W</label>
    					<div class="col-md-10">
      						<input type="password" class="form-control" id="memberPassword1" name="memberPassword1" placeholder="password">
    					</div>
					</div>
					<div class="form-group">
						<label for="mamberName" class="col-md-2 control-label">Name</label>
    					<div class="col-md-10">
      						<input type="text" class="form-control" id="mamberName" name="memberName" placeholder="name">
    					</div>
					</div>
					<div class="form-group">
						<label for="memberGender1" class="col-sm-2 control-label">Gender</label>
						<div class="col-md-10">
							<label class="radio-inline">
  								<input type="radio" name="memberGender" id="memberGender1" value="male" checked> 남
							</label>
							<label class="radio-inline">
		  						<input type="radio" name="memberGender" id="memberGender2" value="female"> 여
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="mamberTel1" class="col-md-2 control-label">Tel.</label>
    					<div class="col-md-10">
      						<input type="text" class="form-control" id="mamberTel1" name="tel1" placeholder="연락처1">
    					</div>
					</div>
					<div class="form-group">
						<label for="mamberTel2" class="col-md-2 control-label">Tel.</label>
    					<div class="col-md-10">
      						<input type="text" class="form-control" id="mamberTel2" name="tel2" placeholder="연락처2">
    					</div>
					</div>
					<div class="form-group">
						<label for="smsYN1" class="col-md-2 control-label">SMS수신</label>
						<div class="col-md-10">
							<label class="radio-inline">
  								<input type="radio" name="smsYn" id="smsYN1" value="Y" checked> 네
							</label>
							<label class="radio-inline">
		  						<input type="radio" name="smsYn" id="smsYN2" value="N"> 아니오
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email.</label>
    					<div class="col-sm-10">
      						<input type="text" class="form-control" id="email" name="email" placeholder="email">
    					</div>
					</div>
					<div class="form-group">
						<label for="emailYN1" class="col-md-2 control-label">Email수신</label>
						<div class="col-md-10">
							<label class="radio-inline">
  								<input type="radio" name="emailYn" id="emailYN1" value="Y" checked> 네
							</label>
							<label class="radio-inline">
		  						<input type="radio" name="emailYn" id="emailYN2" value="N"> 아니오
							</label>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							<label for="1" class="col-md-2 control-label">BirthDay</label>
							<div class="col-md-10">
							<div class=" col-md-4">
								<label for="birthdayYear" class="sr-only">birthdayYear</label>
    							<input type="text" class="form-control" id="birthdayYear" name="birthdayYear" placeholder="Year">
							</div>
							<div class="col-md-4">
								<input type="text" class="form-control" id="birthdayMonth" name="birthdayMonth" placeholder="Month">
								<label for="birthdayMonth" class="sr-only">birthdayMonth</label>
							</div>
							<div class="col-md-4">
								<input type="text" class="form-control" id="birthdayDay" name="birthdayDay" placeholder="Day">
								<label for="birthdayDay" class="sr-only">birthdayDay</label>
							</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="memberAddr" class="col-md-2 control-label">Addr.</label>
    					<div class="col-md-10">
      						<input type="text" class="form-control" id="memberAddr" name="memberAddr" placeholder="addr">
    					</div>
					</div>
					<!-- <button type="submit" class="btn btn-primary btn-block">Join</button> -->
					<input type="submit" class="btn btn-primary btn-block" value="Join">
				</form>
			</div>
		<!-- 	<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Join</button>
			</div> -->
		</div>
	</div>
</div>





<script src="resources/js/menu.js?ver=48"></script>
</body>
</html>










