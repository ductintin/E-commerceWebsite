
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Đăng nhập</title>
    <link rel="stylesheet" href="<c:url value='/views/vendor/css/login.css'/>">

</head>
<body>
<!-- partial:index.partial.html -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
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
                <h1>Sign in</h1>
                
                <span>or use your account</span>
                <input type="text" id="accountName" name="TenTK" placeholder="Tên tài khoản" />
                
                <div class="password-field" style="width: 100%;" >
	                <input type="password" name = "MK" placeholder="Mật khẩu" id="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$" onkeyup="checkValidation()" required/>
	                <span>
	                <!-- <i class="fa-solid fa-check" id="correct1" style="color: green;  " hidden="true"></i>
                    <i class="fa-solid fa-xmark" id="wrong1" style="color: red; " hidden="true"></i>  -->
	                <i id="toggler1"class="far fa-eye"></i>
	                </span>

                                

                </div>
                <span style="color: red;">${msg }</span>
                <a href="#">Forgot your password?</a>
                <button>Sign In</button>
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
                    <h1>Hello, Friend!</h1>
                    <p>Enter your personal details and start journey with us</p>
                    <a href="<c:url value='/vendor/signup'/>"><button class="ghost" id="signUp" > Sign Up</button></a>
                </div>
            </div>
        </div>
    </div>

<div class="footer">
<b>	Follow me on </b>
	<div class="icons">
		<a href="https://github.com/kvaibhav01" target="_blank" class="social"><i class="fab fa-github"></i></a>
		<a href="https://www.instagram.com/vaibhavkhulbe143/" target="_blank" class="social"><i class="fab fa-instagram"></i></a>
		<a href="https://medium.com/@vaibhavkhulbe" target="_blank" class="social"><i class="fab fa-medium"></i></a>
		<a href="https://twitter.com/vaibhav_khulbe" target="_blank" class="social"><i class="fab fa-twitter-square"></i></a>
		<a href="https://linkedin.com/in/vaibhav-khulbe/" target="_blank" class="social"><i class="fab fa-linkedin"></i></a>
		</div>
	</div>
<!-- partial -->
    <script src="<c:url value='/views/vendor/js/login.js'/>"></script>

</body>
</html>
