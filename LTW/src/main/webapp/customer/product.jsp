<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container">
			<div class="collapse navbar-collapse justify-content-end"
				id="navbarsExampleDefault">
				<ul class="navbar-nav m-auto">
					<li class="nav-item active"><a class="nav-link"
						href="<c:url value='/home'/>">Home<span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/shop'/>">Shop</a>
					</li>
				</ul>

				<form class="form-inline my-2 my-lg-0">
					<a class="btn btn-success btn-sm ml-3" href="cart.html"> <i
						class="fa fa-shopping-cart"></i>Cart <span
						class="badge badge-light">@</span>
					</a>
					<c:choose>
						<c:when test="${logged == 0}">
							<li><a href="<c:url value='/customer/login'/>">Đăng nhập</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="<c:url value='/customer/profile' />">Tài
									khoản</a></li>
							<li><a href="<c:url value='/customer/logout' />">Đăng
									xuất</a></li>
						</c:otherwise>
					</c:choose>
				</form>
			</div>
		</div>
	</nav>
	<h1>Tên sản phẩm : ${product.getTenSP()}</h1>
	<c:forEach items="${listimage}" var="image" varStatus="STT">
		<c:url value="/image?fname=${image.getAnh() }" var="imgUrl"></c:url>
		<td><img height="150" width="200" src="${imgUrl}" /></td>
	</c:forEach>
	<p>Giá bán thường : ${product.getGiaBanThuong()} VND</p>
	<p>Khuyến mãi : ${product.getGiaKhuyenMai() } VND</p>
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