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
   
    <!-- ======= Styles ====== -->
    <link rel="stylesheet" href="<c:url value='/views/vendor/css/index.css'/>">
    
    
    
</head>
<body>
 <div class="container">
        <div class="navigation">
            <ul>
                <li>
                    <a href="vendor/home">
                        <span class="icon">
                            <ion-icon name="logo-apple"></ion-icon>
                        </span>
                        <span class="title">${Shop.tenShop}</span>
                    </a>
                </li>

                <li>
                    <a href="<c:url value='/vendor/home'/>">
                        <span class="icon">
                            <ion-icon name="home-outline"></ion-icon>
                        </span>
                        <span class="title">Dashboard</span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <span class="icon">
                            <ion-icon name="people-outline"></ion-icon>
                        </span>
                        <span class="title">Customers</span>
                    </a>
                </li>

                <li>
                    <a href="<c:url value='/vendor/product/list'/>">
                        <span class="icon">
                            <ion-icon name="chatbubble-outline"></ion-icon>
                        </span>
                        <span class="title">Sản phẩm</span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <span class="icon">
                            <ion-icon name="help-outline"></ion-icon>
                        </span>
                        <span class="title">Cửa hàng</span>
                    </a>
                </li>

                <li>
                    <a href="<c:url value='/vendor/order/list'/>">
                        <span class="icon">
                            <ion-icon name="settings-outline"></ion-icon>
                        </span>
                        <span class="title">Đơn hàng</span>
                    </a>
                </li>
                
                <li>
                    <a href="<c:url value='/vendor/shop/profile'/>">
                        <span class="icon">
                            <ion-icon name="settings-outline"></ion-icon>
                        </span>
                        <span class="title">Thông tin cửa hàng</span>
                    </a>
                </li>

                <li>
                    <a href="<c:url value='/vendor/changepassword'/>">
                        <span class="icon">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                        </span>
                        <span class="title">Password</span>
                    </a>
                </li>

                <li>
                    <a href="<c:url value='/vendor/logout'/>">
                        <span class="icon">
                            <ion-icon name="log-out-outline"></ion-icon>
                        </span>
                        <span class="title">Đăng xuất</span>
                    </a>
                </li>
            </ul>
        </div>
        
        
           
            

        <!-- ========================= Main ==================== -->
        <div class="main">
            <div class="topbar">
                <div class="toggle">
                    <ion-icon name="menu-outline"></ion-icon>
                </div>

                <div class="search">
                    <label>
                        <input type="text" placeholder="Search here">
                        <ion-icon name="search-outline"></ion-icon>
                    </label>
                </div>

                <div class="user">
                	<a href='<c:url value='/vendor/profile?idKH=${Vendor.maKH}'></c:url>'>
                	${Vendor.tenKH}
                	</a>
                    
                </div>
                
                
                
            </div>
            
            <script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</body>
</html>