<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root" />
<!DOCTYPE html>
<html lang="fr">
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Home</title>
<!-- CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<style>
h1 {
	text-align: center;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container">
			<div class="collapse navbar-collapse justify-content-end"
				id="navbarsExampleDefault">
				<ul class="navbar-nav m-auto">
					<li class="nav-item active"><a class="nav-link"
						href="<c:url value='/'/>">Home<span class="sr-only">(current)</span></a>
					</li>
				</ul>

				<form class="form-inline my-2 my-lg-0">
					<a class="btn btn-success btn-sm ml-3" href="cart.html"> <i
						class="fa fa-shopping-cart"></i>Cart <span
						class="badge badge-light">@</span>
					</a>
					<li><a href="<c:url value='/customer/logout' />">Đăng xuất</a></li>
				</form>
			</div>
		</div>
	</nav>
	<h1>Thay đổi thông tin cá nhân</h1>
	<h3 style="color:green">${msg }</h3>
	
	<form role="form" action="edit" method="post">
		<input name="MaKH" value="${KH.getMaKH() }" hidden="">
		<div class="form-group">
			<label>Tên khách hàng :</label> <input class="form-control"
				placeholder="please enter" name="TenKH"
				value="${KH.getTenKH() }" />
		</div>
		<div class="form-group">
			<label>Email :</label> <input class="form-control"
				placeholder="please enter" name="Email"
				value="${KH.getEmail() }" type="email" />
		</div>
		<div class="form-group">
			<label>Điện thoại :</label> <input class="form-control"
				placeholder="please enter" name="Phone" value="${KH.getPhone() }" />
		</div>
		<div class="form-group">
			<label>Địa chỉ :</label> <input class="form-control"
				placeholder="please enter" name="DiaChi" value="${KH.getDiaChi() }" />
		</div>
		<button type="submit" class="btn btn-default">Edit</button>
	</form>
	<!-- JS -->
	<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>

</body>
</html>
