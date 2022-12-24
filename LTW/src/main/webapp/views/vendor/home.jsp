<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<%@ page session="true"%>

<!-- partial:index.partial.html -->
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trang chủ</title>
<!-- ======= Styles ====== -->
<link rel="stylesheet"
	href="<c:url value='/views/vendor/css/index.css'/>">

<script class="jsbin"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>

<link href="${root}plugins/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${root}plugins/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link
	href="${root}plugins/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">



</head>

<body>
	<c:url value="${Vendor}" var="vendor"></c:url>
	<c:url value="${Shop}" var="shop"></c:url>


	<c:if test="${not empty shop }">
		<span></span>
		<!-- =============== Navigation ================ -->
		<%@include file="/views/vendor/sidebar.jsp"%>





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
					<div class="numbers">${SLDH }</div>
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

		<div class="cardBox">

			<div class="card" style="padding: 15px; text-align: center;">
				<div>
					
					<div class="cardName" style="color: #FF6E31; font-weight: 600">Sản phẩm bán chạy nhất </div>
					<div class="numbers" style="font-size: 16px;">${topproduce.tenSP }</div>
					<div class="cardName" style="color: #DC0000;">Doanh số: ${toproducesale}</div>
					
					
				</div>

				<div class="iconBx">
					<c:forEach items="${topproduce.productImages}" var="img"
						varStatus="STT">
						<c:if test="${STT.index eq 0}">
							<c:url value="/image?fname=${img.anh}" var="imgUrl"></c:url>
							<img height="80" width="80" src="${imgUrl}" alt="chưa thêm ảnh" />
						</c:if>

					</c:forEach>
				</div>
			</div>
		</div>



		<%@include file="/views/vendor/chart.jsp"%>



	</c:if>


	<!-- Nếu người bán chưa có cửa hàng -->
	<c:if test="${empty shop }">
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
							<b>Tên cửa hàng:</b> <input type="text" id=" " name="TenShop"
								required>
						</div>

						<div class="fomrgroup">
							<b>Tên người bán:</b>
							<c:url value="${Vendor}" var="vendor"></c:url>
							<input type="text" id=" " value="${Vendor.tenKH }" name="vendor"
								readonly>
						</div>

						<div class="fomrgroup">
							<b>Số điện thoại:</b> <input type="text" id=" " name="SDT"
								required>
						</div>
						<div class="fomrgroup">
							<b>Địa chỉ:</b> <input type="text" id=" " name="DiaChi" required>
						</div>

						<div class="fomrgroup">
							<b>Email:</b> <input type="email" id=" " name="Email" required>
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

	<script src="${root}plugins/vendor/jquery/jquery.min.js"></script>
	<script
		src="${root}plugins/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="${root}plugins/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="${root}plugins/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="${root}plugins/vendor/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${root}plugins/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="${root}plugins/js/demo/datatables-demo.js"></script>
	<script>
  
  
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

