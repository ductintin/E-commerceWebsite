<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/common/taglib.jsp" %>
<%@ page session="true" %>

<!-- partial:index.partial.html -->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thay đổi mật khẩu</title>
    <!-- ======= Styles ====== -->
    
    
    <link rel="stylesheet" href="<c:url value='/views/vendor/css/profile.css'/>">
    
    
    
</head>

<body>

 <c:url value="${Vendor}" var="vendor"></c:url>
 <c:url value="${Shop}" var="shop"></c:url>
 
 <%@include file="/views/vendor/sidebar.jsp"%>
  <div class="form-container sign-up-container">
            <form role="form" action="changepassword" method="POST">
                <h1>Thay đổi mật khẩu</h1>
                
                <span style ="color: red; font-size: 18px; font-weight: 500;">${msg }</span>
                
                
                
                <div class="password-field" style="width: 100%;" >
	                <input type="password" name = "oldpw" placeholder="Mật khẩu" id="oldpw" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$" onkeyup="checkValidation()" required/>
	                <span>
	                <!-- <i class="fa-solid fa-check" id="correct1" style="color: green;  " hidden="true"></i>
                    <i class="fa-solid fa-xmark" id="wrong1" style="color: red; " hidden="true"></i>  -->
	                <i id="toggler1"class="far fa-eye"></i>
	                </span>

                                

                </div>
                
                <span id ="msgCheckValidPw"></span>
                
                
                <div class="password-field" style="width: 100%;" >
	                <input type="password" name = "newpw" placeholder="Mật khẩu mới" id="newpw" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$" onkeyup="checkValidtion()"  required/>
	                <span>
	                <!-- <i class="fa-solid fa-check" id="correct" style="color: green; ;" hidden="true"></i>
                    <i class="fa-solid fa-xmark" id="wrong" style="color: red; ;" hidden="true"></i> -->
                     <i id="toggler2" class="far fa-eye"></i>
	                </span>
	                
	                	               
                </div>
                
                 <div class="password-field" style="width: 100%;" >
	                <input type="password" name = "confirmnewpw" placeholder="Xác nhận lại mật khẩu mới" id="confirmnewpw" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$" onkeyup="check()"  required/>
	                <span>
	                <!-- <i class="fa-solid fa-check" id="correct" style="color: green; ;" hidden="true"></i>
                    <i class="fa-solid fa-xmark" id="wrong" style="color: red; ;" hidden="true"></i> -->
                     <i id="toggler3" class="far fa-eye"></i>
	                </span>
	                
	                	               
                </div>
                
                <span id ="msgCheckPw"></span>
             
                
                <span>Mật khẩu ít nhất 8 kí tự, bao gồm ít nhất 1 kí tự thường, 1 kí tự hoa, 1 chữ số, 1 kí tự đặc biệt</span>
                <button type = "submit" value ="Thay đổi">Thay đổi</button>
            </form>
        </div>
 
 <script src="<c:url value='/views/vendor/js/changepassword.js'/>"></script>
     <script src="<c:url value='https://kit.fontawesome.com/361b32335c.js'/>"></script>
     


 		<script>
 		function checkValidation() {
            let pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
            if (pattern.test(document.getElementById("oldpw").value)) {
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
            if ((document.getElementById("newpw").value == document.getElementById("confirmnewpw").value) && pattern.test(document.getElementById("newpw").value)) {
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