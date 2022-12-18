
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
@charset "UTF-8";

@import
	url('https://fonts.googleapis.com/css?family=Montserrat:400,800');

* {
	box-sizing: border-box;
}

body {
	font-family: 'Montserrat', sans-serif;
	background: #f6f5f7;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: -20px 0 50px;
	margin-top: 20px;
}

h1 {
	font-weight: bold;
	margin: 0;
}

p {
	font-size: 14px;
	font-weight: 100;
	line-height: 20px;
	letter-spacing: .5px;
	margin: 20px 0 30px;
}

span {
	font-size: 12px;
}

a {
	color: #333;
	font-size: 14px;
	text-decoration: none;
	margin: 15px 0;
}

.container {
	background: #fff;
	border-radius: 10px;
	box-shadow: 0 14px 28px rgba(0, 0, 0, .2), 0 10px 10px rgba(0, 0, 0, .2);
	position: relative;
	overflow: hidden;
	width: 768px;
	max-width: 100%;
	height: 100%;
	min-height: 480px;
}

.form-container form {
	background: #fff;
	display: flex;
	flex-direction: column;
	padding: 0 50px;
	height: 100%;
	justify-content: center;
	align-items: center;
	text-align: center;
}

.social-container {
	margin: 20px 0;
}

.social-container a {
	border: 1px solid #ddd;
	border-radius: 50%;
	display: inline-flex;
	justify-content: center;
	align-items: center;
	margin: 0 5px;
	height: 40px;
	width: 40px;
}

.form-container input {
	background: #eee;
	border: none;
	padding: 12px 15px;
	margin: 8px 0;
	width: 100%;
}

.password-field {
	position: relative;
}

.password-field span {
	margin: 8px;
	/* 	display: flex;
	flex-direction: row;
	padding: 12px 15px;
	margin-top: -47px;
	margin-left: 218px; */
	margin-left: -30px;
}

#toggler1, #toggler2 {
	width: 15px;
}

button {
	border-radius: 20px;
	border: 1px solid #ff4b2b;
	background: #ff445c;
	color: #fff;
	font-size: 12px;
	font-weight: bold;
	padding: 12px 45px;
	letter-spacing: 1px;
	text-transform: uppercase;
	transition: transform 80ms ease-in;
}

button:active {
	transform: scale(.95);
}

button:focus {
	outline: none;
}

button.ghost {
	background: transparent;
	border-color: #fff;
}

.form-container {
	position: absolute;
	top: 0;
	height: 100%;
	transition: all .6s ease-in-out;
}

.sign-in-container {
	left: 0;
	width: 50%;
	z-index: 2;
}

.sign-up-container {
	left: 0;
	width: 50%;
	z-index: 1;
	opacity: 0;
}

.overlay-container {
	position: absolute;
	top: 0;
	left: 50%;
	width: 50%;
	height: 100%;
	overflow: hidden;
	transition: transform .6s ease-in-out;
	z-index: 100;
}

.overlay {
	background: #ff416c;
	background: linear-gradient(to right, #ff4b2b, #ff416c) no-repeat 0 0/cover;
	color: #fff;
	position: relative;
	left: -100%;
	height: 100%;
	width: 200%;
	transform: translateY(0);
	transition: transform .6s ease-in-out;
}

.overlay-panel {
	position: absolute;
	top: 0;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	padding: 0 40px;
	height: 100%;
	width: 50%;
	text-align: center;
	transform: translateY(0);
	transition: transform .6s ease-in-out;
}

.overlay-right {
	right: 0;
	transform: translateY(0);
}

.overlay-left {
	transform: translateY(-20%);
}

/* Move signin to right */
.container.right-panel-active .sign-in-container {
	transform: translateY(100%);
}

/* Move overlay to left */
.container.right-panel-active .overlay-container {
	transform: translateX(-100%);
}

/* Bring signup over signin */
.container.right-panel-active .sign-up-container {
	transform: translateX(100%);
	opacity: 1;
	z-index: 5;
}

/* Move overlay back to right */
.container.right-panel-active .overlay {
	transform: translateX(50%);
}

/* Bring back the text to center */
.container.right-panel-active .overlay-left {
	transform: translateY(0);
}

/* Same effect for right */
.container.right-panel-active .overlay-right {
	transform: translateY(20%);
}

.footer {
	margin-top: 25px;
	text-align: center;
}

.icons {
	display: flex;
	width: 30px;
	height: 30px;
	letter-spacing: 15px;
	align-items: center;
}
</style>
</head>
<body>
	<!-- partial:index.partial.html -->
	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
		integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
		crossorigin="anonymous">



	<div class="container" id="container">
		<!--  <div class="form-container sign-up-container">
            <form role="form" action="signup" method="POST">
                <h1>Create Account</h1>
                
                
                <input type="text" name = "TenKH"  placeholder="Tên" />
                <input type="text" name = "TenTK" placeholder="Tên tài khoản" />                              
                <input type="email" name = "Email" placeholder="Email" />
                <input type="password" name = "MK" placeholder="Mật khẩu" />
                
                <input type="password" placeholder="Xác nhận lại mật khẩu" />
                <input type="text" name = "Phone" placeholder="Số điện thoại" />
                <input type="text" name = "DiaChi" placeholder="Địa chỉ" />
                <button type = "submit" value ="Đăng ký">Sign Up</button>
            </form>
        </div> -->

		<!-- Form đăng nhập -->
		<div class="form-container sign-in-container">
			<form role="form" action="login" method="POST">
				<h1>Đăng nhập với người dùng</h1>

				 <input type="text" id="accountName"
					name="TenTK" placeholder="Tên tài khoản" /> <input type="password"
					id="password" name="MK" placeholder="Mật khẩu"
					pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$" required />
				<span>${msg }</span>
				<button>Đăng nhập</button>
			</form>
		</div>


		<div class="overlay-container">
			<div class="overlay">
				<!-- <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">Sign In</button>
                </div> -->
				<div class="overlay-panel overlay-right">
					<p>Bạn chưa có tài khoản ? Hãy đăng ký</p>
					<a href="<c:url value='/customer/signup'/>"><button
							class="ghost" id="signUp">Đăng ký</button></a>
					<p>Đăng nhập với người bán</p>
					<a href="<c:url value='/vendor/login'/>"><button
							class="ghost" id="login">Đăng nhập</button></a>
				</div>
			</div>
		</div>
	</div>

	<div class="footer">
		<b> Follow me on </b>
		<div class="icons">
			<a href="https://github.com/kvaibhav01" target="_blank"
				class="social"><i class="fab fa-github"></i></a> <a
				href="https://www.instagram.com/vaibhavkhulbe143/" target="_blank"
				class="social"><i class="fab fa-instagram"></i></a> <a
				href="https://medium.com/@vaibhavkhulbe" target="_blank"
				class="social"><i class="fab fa-medium"></i></a> <a
				href="https://twitter.com/vaibhav_khulbe" target="_blank"
				class="social"><i class="fab fa-twitter-square"></i></a> <a
				href="https://linkedin.com/in/vaibhav-khulbe/" target="_blank"
				class="social"><i class="fab fa-linkedin"></i></a>
		</div>
	</div>
	<!-- partial -->

</body>
</html>