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
<title>Danh sách khách hàng</title>
<!-- ======= Styles ====== -->
<link rel="stylesheet"
	href="<c:url value='/views/vendor/css/home.css'/>">



</head>

<body>
	<c:url value="${Vendor}" var="vendor"></c:url>
	<c:url value="${Shop}" var="shop"></c:url>


	<!-- =============== Navigation ================ -->
	<%@include file="/views/vendor/sidebar.jsp"%>

	<div class="details">
		<div class="recentOrders">
			<div class="cardHeader">
				<h2>Danh sách khách hàng đã mua</h2>
				
			</div>

			<table>
				<thead>
					<tr>
						<td>Mã </td>
						<td>Tên </td>
						<td>Số điện thoại</td>
						<td>Email</td>
						<td>Địa chỉ</td>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${listkh }" var="o">
						<tr>
							<td>${o.maKH }</td>
							<td><a style="text-decoration: none; font-weight: 600; color: black;" href ="<c:url value='/vendor/order/list?action=getcustomerorder&maKH=${o.maKH }'/>">${o.tenKH }</a></td>
							<td>${o.phone }</td>
							<td>${o.email }</td>
							<td>${o.diaChi }</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>








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

