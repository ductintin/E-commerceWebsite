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
	<h1>Thông tin người dùng</h1>
	<h3 style="color:green">${msg}</h3>
	<div style="border-style: solid; border-width: 1px;">
		<p>Tên khách hàng : ${KH.getTenKH()}</p>
		<p>Email : ${KH.getEmail()}</p>
		<p>Điện thoại : ${KH.getPhone()}</p>
		<p>Địa chỉ : ${KH.getDiaChi()}</p>
	</div>

	<a href="<c:url value='/customer/changepassword' />">Đổi mật khẩu</a>
	<br>
	<a href="<c:url value='/customer/profile/edit' />">Thay đổi thông
		tin cá nhân</a>
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
