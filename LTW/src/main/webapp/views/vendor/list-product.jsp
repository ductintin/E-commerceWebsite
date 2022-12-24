<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<%@ page session="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>

<link rel="stylesheet"
	href="<c:url value='/views/vendor/css/home.css'/>">


</head>
<body>
	<%@include file="/views/vendor/sidebar.jsp"%>
	<%@include file="/views/vendor/add-product.jsp"%>

	
	
	
	<!-- ================ Products List ================= -->
            <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Tất cả sản phẩm</h2>
                        <c:if test="${deleted eq 1}">
                        <a href="<c:url value='/vendor/product/list?action=get-alldeletedproduct'/>" class="btn">Danh sách lưu trữ</a>
                        </c:if>
                        <c:if test="${empty deleted }">
                        <a href="<c:url value='/vendor/product/list'/>" class="btn">Danh sách đang bán</a>
                        </c:if>
                    </div>
                    
                    <c:forEach var="o" items="${listdm}" varStatus="STT">
		<c:if test="${not empty o.products}">
			<h2>Tên danh mục : ${o.tenDM }</h2>
                    <table>
                        <thead>
                            <tr>
                                <td>Tên sản phẩm</td>
                                <td>Mô tả</td>
                                <td>Giá bán thường</td>
                                <td>Giá khuyến mãi</td>
                                <td>Số lượng kho</td>
                                <td>Số lượng đã bán</td>
                                <td>Chi tiết</td>
                                <td>Trạng thái</td>
                                <td>Thao tác</td>
                            </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${o.products}" var="sp">
                            <tr>
                               <td>${sp.tenSP}</td>
						<td>${sp.moTa}</td>
						<td data-type="money">${sp.giaBanThuong}</td>
						<td data-type="money">${sp.giaKhuyenMai}</td>
						<td>${sp.soLuong}</td>
						<td>${sp.soLuongDaBan}</td>
                                
                                <td>
							<div class="container-modal">

								<!-- Button đăng nhập để mở form đăng nhập -->
								<button id="myBtnEdit" href="#myModaleidt${sp.maSP}" style="border: none; background-color: #fff;">Chi tiết</button>

								<div id="myModaleidt${sp.maSP}" class="modal">
									<div class="modal-content">

										<form action="edit" method="POST"
											enctype="multipart/form-data">
											<span class="closeEdit">&times;</span>
											<h2>${sp.tenSP}</h2>
											<div class="fomrgroup">



												<b>Danh mục:</b> <select name="maDM" id="pet-select"
													required>

													<c:if test="${not empty sp.maDM }">
														<option value="${sp.maDM}">${o.tenDM}</option>

													</c:if>
												</select>


											</div>

											<div class="fomrgroup">
												<b>Mã cửa hàng:</b>
												<c:url value="${Shop}" var="shop"></c:url>
												<input type="text" id=" " value="${Shop.maShop }"
													name="shop" readonly>
											</div>

											<div class="fomrgroup">
												<b>Mã người bán:</b>
												<c:url value="${Vendor}" var="vendor"></c:url>
												<input type="text" id=" " value="${Vendor.maKH }"
													name="vendor" readonly>
											</div>

											<div class="fomrgroup">
												<b>Tên sản phẩm:</b> <input type="text" id=" "
													value="${sp.tenSP }" name="TenSP" required>
											</div>

											<div class="fomrgroup">
												<b>Mã sản phẩm:</b> <input type="text" id=" "
													value="${sp.maSP }" name="MaSP"  readonly>
											</div>
											<div class="fomrgroup">
												<b>Mô Tả:</b> <input type="text" id=" " value="${sp.moTa }"
													name="MoTa" required>
											</div>

											<div class="fomrgroup">
												<b>Giá bán:</b> <input type="text" id=" "
													value="${sp.giaBanThuong }" name="Gia" required>
											</div>

											<div class="fomrgroup">
												<b>Giá khuyến mãi:</b> <input type="text" id=" "
													value="${sp.giaKhuyenMai }" name="KhuyenMai" required>
											</div>

											<div class="fomrgroup">
												<b>Số lượng kho:</b> <input type="text" id=" "
													value="${sp.soLuong }" name="SoLuongKho" required>
											</div>

											<div class="fomrgroup">
												<b>Mô tả ngắn:</b> <input type="text" id=" "
													value="${sp.moTaNgan }" name="MoTaNgan" required>
											</div>
											
											<div class="form-group">
												<c:forEach items="${sp.productImages}" var="img"
													varStatus="STT">
													<c:url value="/image?fname=${img.anh}" var="imgUrl"></c:url>
														<input type="file" name="anh${STT.index+1 }"
															value="${img.anh }" />
														<img height="50" width="50" src="${imgUrl}"
															alt="chưa thêm ảnh" />
	
												</c:forEach>
												
												<c:if test="${sp.productImages eq null}">
												
												 <c:forEach var="i" begin="0" end="3">
												 	<input type="file" name="anh${i+1 }"
															 />
												</c:forEach>
												</c:if>

											</div>




											<button type="submit">Chỉnh sửa sản phẩm</button>
											<button type="reset" class="">Hủy</button>

										</form>
									</div>

								</div>
							</div>


						</td>
						
						
						
						<c:if test="${sp.isDeteted eq 0}">
							<td>
								<span style="color: green; font-weight: 600;">Active</span>
							</td>
							
							<td><a
							href="<c:url value='/vendor/product/delete?id=${sp.maSP}'/>"
							class="center" style="text-decoration: none; color: red; font-weight: 600;">Lưu trữ</a></td>
							
						</c:if>
						
						<c:if test="${sp.isDeteted eq 1}">
							<td>
								<span style="color: red; font-weight: 600;">Deleted</span>
							</td>
							
							<td><a
							href="<c:url value='/vendor/product/list?maSP=${sp.maSP}&action=restore'/>"
							class="center" style="text-decoration: none; color: green; font-weight: 600;">Khôi phục</a></td>
						</c:if>
						
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>
                    
                    			</c:if>
		</c:forEach>
                    
                </div>
                
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
				for ( var index in modals) {
					console.log(modals[index]);
					if (typeof modals[index].style !== 'undefined')
						modals[index].style.display = "none";
				}

			}
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target.classList.contains('modal')) {
				for ( var index in modals) {
					if (typeof modals[index].style !== 'undefined')
						modals[index].style.display = "none";
				}
			}
		}
		
		document.querySelectorAll('[data-type="money"]').forEach(item => {

	        item.innerHTML = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'vnd'}).format(item.innerHTML);
	    })
	</script>
</body>
</html>