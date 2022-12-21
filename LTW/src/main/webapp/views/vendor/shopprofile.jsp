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
    <title>Trang thông tin của hàng</title>
    <!-- ======= Styles ====== -->
    
    
    <link rel="stylesheet" href="<c:url value='/views/vendor/css/profile.css'/>">
    
    
    
</head>

<body>

 <c:url value="${Vendor}" var="vendor"></c:url>
 <c:url value="${Shop}" var="shop"></c:url>
 
 <%@include file="/views/vendor/sidebar.jsp"%>
  <div class="form-container sign-up-container">
            <form role="form" action="profile/edit" method="POST">
                <h1>Thông tin cửa hàng</h1>
                       
                <span style ="color: red; font-size: 18px; font-weight: 500;">${msgShop }</span>
                <span>Mã cửa hàng</span>
                <input type="text" name = "MaShop"  placeholder="Tên" value="${Shop.maShop }" required readonly/>
                
                <span>Mã chủ sở hữu</span>
                <input type="text" name = "MaSeller"  placeholder="Tên" value="${Shop.maSeller }" required readonly/>
                
                <span>Tên cửa hàng</span>
                <input type="text" name = "TenShop"  placeholder="Tên" value="${Shop.tenShop }" required/>

                <span>Email</span>                             
                <input type="email" name = "EmailShop" placeholder="Email" value = "${Shop.emailShop }"required/>
                
                <span>Số điện thoại</span>
                <input type="text" name = "PhoneShop" placeholder="Số điện thoại" pattern="[0-9]{10}" value="${Shop.phoneShop }"required/>
                
                <span>Địa chỉ</span>
                <input type="text" name = "DiaChiShop" placeholder="Địa chỉ" value="${Shop.diaChiShop }" required />
                
                
                <button type = "submit" value ="Đăng ký">Cập nhật</button>
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