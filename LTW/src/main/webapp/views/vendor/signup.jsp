
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ include file="/common/taglib.jsp" %>
	<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Đăng kí</title>
    <link rel="stylesheet" href="<c:url value='/views/vendor/css/signup.css'/>">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<!-- partial:index.partial.html -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
    integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
    crossorigin="anonymous">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />



<div class="container right-panel-active" id="container">
        <div class="form-container sign-up-container">
            <form role="form" action="signup" method="POST">
                <h1>Tạo tài khoản bán hàng</h1>
                
                <span style ="color: red; font-size: 18px; font-weight: 500;">${msg }</span>
                <input type="text" name = "TenKH"  placeholder="Tên" required/>
                <input type="text" name = "TenTK" id = "TenTK" placeholder="Tên tài khoản" pattern="^(?=.*[a-z])[a-zA-Z\d]{3,10}$" onkeyup ="checkValidAccountName()"required/>                              
                <input type="email" name = "Email" placeholder="Email" required/>
                
                
                <div class="password-field" style="width: 100%;" >
	                <input type="password" name = "MK" placeholder="Mật khẩu" id="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$" onkeyup="checkValidation()" required/>
	                <span>
	                <!-- <i class="fa-solid fa-check" id="correct1" style="color: green;  " hidden="true"></i>
                    <i class="fa-solid fa-xmark" id="wrong1" style="color: red; " hidden="true"></i>  -->
	                <i id="toggler1"class="far fa-eye"></i>
	                </span>

                                

                </div>
                
                <span id ="msgCheckValidPw"></span>
                
                
                <div class="password-field" style="width: 100%;" >
	                <input type="password" name = "confirmMK" placeholder="Xác nhận lại mật khẩu" id="confirmPassword" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$" onkeyup="check()"  required/>
	                <span>
	                <!-- <i class="fa-solid fa-check" id="correct" style="color: green; ;" hidden="true"></i>
                    <i class="fa-solid fa-xmark" id="wrong" style="color: red; ;" hidden="true"></i> -->
                     <i id="toggler2" class="far fa-eye"></i>
	                </span>
	                
	                	               
                </div>
                
                <span id ="msgCheckPw"></span>
             
                <input type="text" name = "Phone" placeholder="Số điện thoại" pattern="[0-9]{10}" required/>
                <input type="text" name = "DiaChi" placeholder="Địa chỉ" required />
                
                <span>Mật khẩu ít nhất 8 kí tự, bao gồm ít nhất 1 kí tự thường, 1 kí tự hoa, 1 chữ số, 1 kí tự đặc biệt</span>
                <button type = "submit" value ="Đăng ký">Sign Up</button>
            </form>
        </div>
        
       
        
        
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <a href="<c:url value='/vendor/login'/>"><button class="ghost" id="signIn" > Sign In</button></a>
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
    <script src="<c:url value='/views/vendor/js/signup.js'/>"></script>
     <script src="<c:url value='https://kit.fontawesome.com/361b32335c.js'/>"></script>
     


 		<script>
 		function checkValidation() {
            let pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
            if (pattern.test(document.getElementById("password").value)) {
            	document.getElementById("msgCheckValidPw").innerHTML = ""; 
            	
            	
            	 /* document.getElementById("correct1").style.display = "";
                 document.getElementById("wrong1").style.display = "none"; */
            }
            else {
            	document.getElementById("msgCheckValidPw").innerHTML = "Mật khẩu không hợp lệ"; 
            	document.getElementById("msgCheckValidPw").style.color = "red";
            	/*  document.getElementById("correct1").style.display = "none";
                 document.getElementById("wrong1").style.display = ""; */
            }
        }
 		
 		function check() {
            let pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
            if ((document.getElementById("password").value == document.getElementById("confirmPassword").value) && pattern.test(document.getElementById("password").value)) {
                document.getElementById("msgCheckPw").innerHTML = "";
               
            	/* document.getElementById("correct").style.display = "";
                document.getElementById("wrong").style.display = "none"; */
            }
            else {
            	/* document.getElementById("correct").style.display = "";
                document.getElementById("wrong").style.display = "none"; */
            	document.getElementById("msgCheckPw").innerHTML = "Mật khẩu không trùng khớp"; 
                document.getElementById("msgCheckPw").style.color = "red";
            }
        }
 		
 		function checkValidAccountName() {
            let pattern = /^(?=.*[a-z])[a-zA-Z\d]{3,10}$/;
            if (pattern.test(document.getElementById("TenTK").value)) {
                document.getElementById("msgCheckPw").innerHTML = "";
               
            	/* document.getElementById("correct").style.display = "";
                document.getElementById("wrong").style.display = "none"; */
            }
            else {
            	/* document.getElementById("correct").style.display = "";
                document.getElementById("wrong").style.display = "none"; */
            	document.getElementById("msgCheckPw").innerHTML = "Mật khẩu không trùng khớp"; 
                document.getElementById("msgCheckPw").style.color = "red";
            }
        }
 		</script>
</body>
</html>
