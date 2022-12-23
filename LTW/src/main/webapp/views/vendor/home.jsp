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
    <title>Trang chủ</title>
    <!-- ======= Styles ====== -->
    <link rel="stylesheet" href="<c:url value='/views/vendor/css/index.css'/>">
    
    
    
</head>

<body>
 <c:url value="${Vendor}" var="vendor"></c:url>
 <c:url value="${Shop}" var="shop"></c:url>
            
            
		      <c:if test = "${not empty shop }">
		        <span></span>
    <!-- =============== Navigation ================ -->
    <%@include file="/views/vendor/sidebar.jsp" %>            
           <%--  <a href="<c:url value='/vendor/store/add'/>">
            	<span id ="addStore">
            		<ion-icon name="add-circle-outline"></ion-icon>
            	</span>
            
            </a> --%>
            
            

            
            
            <!-- ======================= Cards ================== -->
            <div class="cardBox">
                <div class="card">
                    <div>
                        <div class="numbers" data-type="money">${SLKH }</div>
                        <div class="cardName">Số lượng khách hàng</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="eye-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers" >${SLDH }</div>
                        <div class="cardName">Tổng số đơn hàng</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="cart-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers">${SLSP }</div>
                        <div class="cardName">Số sản phẩm bán ra</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="chatbubbles-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers" data-type="money">${totalMoney }</div>
                        <div class="cardName">Doanh thu</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="cash-outline"></ion-icon>
                    </div>
                </div>
            </div>
            
             <%@include file="/views/vendor/chart.jsp" %>  

            <!-- ================ Order Details List ================= -->
            <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Recent Orders</h2>
                        <a href="#" class="btn">View All</a>
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>Name</td>
                                <td>Price</td>
                                <td>Payment</td>
                                <td>Status</td>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <td>Star Refrigerator</td>
                                <td>$1200</td>
                                <td>Paid</td>
                                <td><span class="status delivered">Delivered</span></td>
                            </tr>

                            <tr>
                                <td>Dell Laptop</td>
                                <td>$110</td>
                                <td>Due</td>
                                <td><span class="status pending">Pending</span></td>
                            </tr>

                            <tr>
                                <td>Apple Watch</td>
                                <td data-type="money">1200</td>
                                <td>Paid</td>
                                <td><span class="status return">Return</span></td>
                            </tr>

                            <tr>
                                <td>Addidas Shoes</td>
                                <td>$620</td>
                                <td>Due</td>
                                <td><span class="status inProgress">In Progress</span></td>
                            </tr>

                            <tr>
                                <td>Star Refrigerator</td>
                                <td>$1200</td>
                                <td>Paid</td>
                                <td><span class="status delivered">Delivered</span></td>
                            </tr>

                            <tr>
                                <td>Dell Laptop</td>
                                <td>$110</td>
                                <td>Due</td>
                                <td><span class="status pending">Pending</span></td>
                            </tr>

                            <tr>
                                <td>Apple Watch</td>
                                <td>$1200</td>
                                <td>Paid</td>
                                <td><span class="status return">Return</span></td>
                            </tr>

                            <tr>
                                <td>Addidas Shoes</td>
                                <td>$620</td>
                                <td>Due</td>
                                <td><span class="status inProgress">In Progress</span></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <!-- ================= New Customers ================ -->
                <div class="recentCustomers">
                    <div class="cardHeader">
                        <h2>Recent Customers</h2>
                    </div>

                    <table>
                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="assets/imgs/customer02.jpg" alt=""></div>
                            </td>
                            <td>
                                <h4>David <br> <span>Italy</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="assets/imgs/customer01.jpg" alt=""></div>
                            </td>
                            <td>
                                <h4>Amit <br> <span>India</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="assets/imgs/customer02.jpg" alt=""></div>
                            </td>
                            <td>
                                <h4>David <br> <span>Italy</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="assets/imgs/customer01.jpg" alt=""></div>
                            </td>
                            <td>
                                <h4>Amit <br> <span>India</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="assets/imgs/customer02.jpg" alt=""></div>
                            </td>
                            <td>
                                <h4>David <br> <span>Italy</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="assets/imgs/customer01.jpg" alt=""></div>
                            </td>
                            <td>
                                <h4>Amit <br> <span>India</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="assets/imgs/customer01.jpg" alt=""></div>
                            </td>
                            <td>
                                <h4>David <br> <span>Italy</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="assets/imgs/customer02.jpg" alt=""></div>
                            </td>
                            <td>
                                <h4>Amit <br> <span>India</span></h4>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
   
           
		      </c:if>
		      
		      
		 <!-- Nếu người bán chưa có cửa hàng -->      
		      <c:if test = "${empty shop }">
		        <div class="container-modal">
 
			    <h2>Chào bạn. Hãy bắt đầu tạo cửa hàng cho riêng mình nào!</h2>
			 
			    <!-- Button đăng nhập để mở form đăng nhập -->
			    <button id="myBtn">Tạo cửa hàng</button>
			 
			    <!-- The Modal -->
			    <div id="myModal" class="modal">
			        <!-- Nội dung form đăng nhập -->
			        <div class="modal-content">
			            <form action="store/add" method="POST">
			                <span class="close">&times;</span>
			                <h2>Đăng kí cửa hàng</h2>
			                <div class="fomrgroup">
			                    <b>Tên cửa hàng:</b>
			                     <input type = "text" id=" " name="TenShop" required>
			                </div>
			                
			                <div class="fomrgroup">
			                	<b>Tên người bán:</b>
			                	<c:url value="${Vendor}" var="vendor"></c:url>
			                   	<input type = "text" id=" " value="${Vendor.tenKH }" name="vendor" readonly>
			                </div>
			                
			                <div class="fomrgroup">
			                    <b>Số điện thoại:</b>
			                    <input type = "text" id=" " name="SDT" required>
			                </div>
			                <div class="fomrgroup" >
			                	<b>Địa chỉ:</b>
			                    <input type = "text" id=" " name="DiaChi" required>
			                </div>
			                
			                <div class="fomrgroup">
			                	<b>Email:</b>
			                   	<input type = "email" id=" " name="Email" required>
			                </div>
			               
			            	<button type="submit">Đăng ký</button>
			            	
			            </form>
			        </div>
			    </div>
			</div>
		      </c:if>
		      

			 
  
            
           


    <!-- =========== Scripts =========  -->
    <script src="<c:url value='/views/vendor/js/home.js'/>"></script>

    <!-- ====== ionicons ======= -->
    <script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  
  <script>
    // lấy phần Modal
    var modal = document.getElementById('myModal');
  
    // Lấy phần button mở Modal
    var btn = document.getElementById("myBtn");
  
    // Lấy phần span đóng Modal
    var span = document.getElementsByClassName("close")[0];
  
    // Khi button được click thi mở Modal
    btn.onclick = function() {
        modal.style.display = "block";
    }
  
    // Khi span được click thì đóng Modal
    span.onclick = function() {
        modal.style.display = "none";
    }
  
    // Khi click ngoài Modal thì đóng Modal
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
    
    document.querySelectorAll('[data-type="money"]').forEach(item => {

        item.innerHTML = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'vnd'}).format(item.innerHTML);
    })
</script>
  
  
</body>

</html>

