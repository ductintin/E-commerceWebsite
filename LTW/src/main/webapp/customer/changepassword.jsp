<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root" />
<!DOCTYPE html>
<html lang="en">
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
						href="<c:url value='/home'/>">Home<span class="sr-only">(current)</span></a>
					</li>
				</ul>

				<form class="form-inline my-2 my-lg-0">
					<a class="btn btn-success btn-sm ml-3" href="cart.html"> <i
						class="fa fa-shopping-cart"></i>Cart <span
						class="badge badge-light">@</span>
					</a>
					<li><a href="<c:url value='/customer/profile' />">Tài
							khoản</a></li>
					<li><a href="<c:url value='/customer/logout' />">Đăng xuất</a></li>
				</form>
			</div>
		</div>
	</nav>
	<h1>Đổi mật khẩu</h1>
	<h3 style="color:red">${msg}</h3>
	<form role="form" action="changepassword" method="POST">
		<div class="password-field" style="width: 100%;">
			<label>Mật khẩu cũ : </label> <input type="password" name="old_password"
				placeholder="Mật khẩu" id="old_password"
				pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"
				onkeyup="checkValidation1()" required />
		</div>
		<span id="msgCheckValidPw1"></span>

		<div class="password-field" style="width: 100%;">
			<label>Mật khẩu mới : </label> <input type="password" name="new_password"
				placeholder="Mật khẩu" id="new_password"
				pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"
				onkeyup="checkValidation2()" required />
		</div>
		<span id="msgCheckValidPw2"></span>


		<div class="password-field" style="width: 100%;">
			<label>Xác nhận mật khẩu mới : </label> <input type="password"
				name="confirmPassword" placeholder="Xác nhận lại mật khẩu"
				id="confirmPassword"
				pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"
				onkeyup="check()" required /> </span>


		</div>
		<span id="msgCheckPw3"></span> 
		<p>Mật khẩu ít nhất 8 kí
			tự, bao gồm ít nhất 1 kí tự thường, 1 kí tự hoa, 1 chữ số</p>
		<button type="submit" value="changepassword">Xác nhận</button>
	</form>

	<!-- Footer -->
	<footer class="text-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-lg-4 col-xl-3">
					<h5>About</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<p class="mb-0">Le Lorem Ipsum est simplement du faux texte
						employé dans la composition et la mise en page avant impression.</p>
				</div>

				<div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
					<h5>Informations</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<ul class="list-unstyled">
						<li><a href="">Link 1</a></li>
						<li><a href="">Link 2</a></li>
						<li><a href="">Link 3</a></li>
						<li><a href="">Link 4</a></li>
					</ul>
				</div>

				<div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
					<h5>Others links</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<ul class="list-unstyled">
						<li><a href="">Link 1</a></li>
						<li><a href="">Link 2</a></li>
						<li><a href="">Link 3</a></li>
						<li><a href="">Link 4</a></li>
					</ul>
				</div>

				<div class="col-md-4 col-lg-3 col-xl-3">
					<h5>Contact</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<ul class="list-unstyled">
						<li><i class="fa fa-home mr-2"></i> My company</li>
						<li><i class="fa fa-envelope mr-2"></i> email@example.com</li>
						<li><i class="fa fa-phone mr-2"></i> + 33 12 14 15 16</li>
						<li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
					</ul>
				</div>
				<div class="col-12 copyright mt-3">
					<p class="float-left">
						<a href="#">Back to top</a>
					</p>
					<p class="text-right text-muted">
						created with <i class="fa fa-heart"></i> by <a
							href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>t-php</i></a>
						| <span>v. 1.0</span>
					</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- JS -->
	<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script>
		function checkValidation1() {
			let pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
			if (pattern.test(document.getElementById("old_password").value)) {
				document.getElementById("msgCheckValidPw1").innerHTML = "";

				/* document.getElementById("correct1").style.display = "";
				document.getElementById("wrong1").style.display = "none"; */
			} else {
				document.getElementById("msgCheckValidPw1").innerHTML = "Mật khẩu không hợp lệ";
				document.getElementById("msgCheckValidPw1").style.color = "red";
				/*  document.getElementById("correct1").style.display = "none";
				 document.getElementById("wrong1").style.display = ""; */
			}
		}

		function checkValidation2() {
			let pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
			if (pattern.test(document.getElementById("new_password").value)) {
				document.getElementById("msgCheckValidPw2").innerHTML = "";

				/* document.getElementById("correct1").style.display = "";
				document.getElementById("wrong1").style.display = "none"; */
			} else {
				document.getElementById("msgCheckValidPw2").innerHTML = "Mật khẩu không hợp lệ";
				document.getElementById("msgCheckValidPw2").style.color = "red";
				/*  document.getElementById("correct1").style.display = "none";
				 document.getElementById("wrong1").style.display = ""; */
			}
		}

		function check() {
			let pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
			if ((document.getElementById("new_password").value == document
					.getElementById("confirmPassword").value)
					&& pattern
							.test(document.getElementById("new_password").value)) {
				document.getElementById("msgCheckPw3").innerHTML = "";

				/* document.getElementById("correct").style.display = "";
				document.getElementById("wrong").style.display = "none"; */
			} else {
				/* document.getElementById("correct").style.display = "";
				document.getElementById("wrong").style.display = "none"; */
				document.getElementById("msgCheckPw3").innerHTML = "Mật khẩu không trùng khớp";
				document.getElementById("msgCheckPw3").style.color = "red";
			}
		}
	</script>
</body>
</html>
