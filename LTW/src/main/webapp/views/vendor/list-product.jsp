<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<%@ page session="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="<c:url value='/views/vendor/css/home.css'/>">
	
	
</head>
<body>
	<%@include file="/views/vendor/sidebar.jsp"%>
	<%@include file="/views/vendor/add-product.jsp"%>
	<div>

		<c:forEach var="o" items="${listdm}" varStatus="STT">
			<h2>Tên danh mục : ${o.tenDM }</h2>
			<table style="width: 100%">



				<tr>

					<th>Tên sản phẩm</th>
					<th>Mô tả</th>
					<th>Giá bán thường</th>
					<th>Giá khuyến mãi</th>
					<th>Số lượng kho</th>
					<th>Số lượng đã bán</th>
					<th>Ảnh 1</th>
					<th>Ảnh 2</th>
					<th>Ảnh 3</th>
					<th>Ảnh 4</th>
					<th>Thao tác</th>

				</tr>
				<c:forEach items="${o.products}" var="sp">
					<tr>
						<td>${sp.tenSP}</td>
						<td>${sp.moTa}</td>
						<td>${sp.giaBanThuong}</td>
						<td>${sp.giaKhuyenMai}</td>
						<td>${sp.soLuong}</td>
						<td>${sp.soLuongDaBan}</td>

						<c:forEach items="${sp.productImages}" var="img">
							<c:url value="/image?fname=${img.anh}" var="imgUrl"></c:url>
							<td><img height="50" width="50" src="${imgUrl}"
								alt="chưa thêm ảnh" /></td>
						</c:forEach>
						
						<td>
						<div class="container-modal">

						<!-- Button đăng nhập để mở form đăng nhập -->
						<button id="myBtnEdit" href="#myModaleidt${sp.maSP}">Chỉnh sửa</button>

						<div id="myModaleidt${sp.maSP}" class="modal">
							<div class="modal-content">
								<form action="edit" method="POST" enctype="multipart/form-data">
									<span class="closeEdit">&times;</span>
									<h2>${sp.tenSP}</h2>
									<div class="fomrgroup">



										<b>Chọn danh mục:</b> <select name="maDM" id="pet-select"
											required>
											
											<c:if test="${not empty sp.maDM }">
											<option value="${sp.maDM}">${o.tenDM}</option>
											
											</c:if>
											<%-- <c:forEach var="o" items="${listdm}">

												<option value="${o.maDM}">${o.tenDM}</option>

											</c:forEach> --%>
										</select>


									</div>

									<div class="fomrgroup">
										<b>Mã cửa hàng:</b>
										<c:url value="${Shop}" var="shop"></c:url>
										<input type="text" id=" " value="${Shop.maShop }" name="shop"
											readonly >
									</div>

									<div class="fomrgroup" >
										<b>Mã người bán:</b>
										<c:url value="${Vendor}" var="vendor"></c:url>
										<input type="text" id=" " value="${Vendor.maKH }"
											name="vendor" readonly>
									</div>

									<div class="fomrgroup">
										<b>Tên sản phẩm:</b> <input type="text" id=" " value="${sp.tenSP }" name="TenSP"
											required>
									</div>
									<div class="fomrgroup">
										<b>Mô Tả:</b> <input type="text" id=" " value="${sp.moTa } }"name="MoTa" required>
									</div>

									<div class="fomrgroup">
										<b>Giá bán:</b> <input type="text" id=" " value="${sp.giaBanThuong }"name="Gia" required>
									</div>

									<div class="fomrgroup">
										<b>Giá khuyến mãi:</b> <input type="text" id=" " value="${sp.giaKhuyenMai }"
											name="KhuyenMai" required>
									</div>

									<div class="fomrgroup">
										<b>Số lượng kho:</b> <input type="text" id=" " value="${sp.soLuong }"
											name="SoLuongKho" required>
									</div>

									<div class="fomrgroup">
										<b>Mô tả ngắn:</b> <input type="text" id=" " value="${sp.moTaNgan }"name="MoTaNgan"
											required>
									</div>

									<div class="form-group">
										<label>Ảnh sản phẩm</label> <input type="file" name="anh1"
											required /> <input type="file" name="anh2" required /> <input
											type="file" name="anh3" required /> <input type="file"
											name="anh4" required />
									</div>




									<button type="submit">Chỉnh sửa sản phẩm</button>
									<button type="reset" class="">Thoát</button>

								</form>
							</div>

						</div>
						</div>
						
						
						</td>

					</tr>

					
						
				</c:forEach>



			</table>
		</c:forEach>


	</div>

	<!-- =========== Scripts =========  -->
	

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
		/* // lấy phần Modal
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
			
		} */
		
		
		// Get the button that opens the modal
		var btn = document.querySelectorAll("#myBtnEdit");

		// All page modals
		var modals = document.querySelectorAll(".modal");
		
		

		// Get the <span> element that closes the modal
		var spans = document.querySelectorAll(".closeEdit");
		

		// When the user clicks the button, open the modal
		for (var i = 0; i < btn.length; i++) {
		 btn[i].onclick = function(e) {
		    e.preventDefault();
		    modal = document.querySelector(e.target.getAttribute("href"));
		    modal.style.display = "block";
		    console.log(modal);
		 }
		}

		// When the user clicks on <span> (x), close the modal
		for (var i = 0; i < spans.length; i++) {
		 spans[i].onclick = function() {
		    for (var index in modals) {
		    	console.log(modals[index]);
		      if (typeof modals[index].style !== 'undefined')  modals[index].style.display = "none";    
		    }
		    
		 }
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		    if (event.target.classList.contains('modal')) {
		     for (var index in modals) {
		      if (typeof modals[index].style !== 'undefined') modals[index].style.display = "none";    
		     }
		    }
		}
	</script>
</body>
</html>