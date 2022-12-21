

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
	
	<link
      class="jsbin"
      href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css"
      rel="stylesheet"
      type="text/css"
    />
    <script
      class="jsbin"
      src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"
    ></script>
    <script
      class="jsbin"
      src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"
    ></script>
</head>
<body>
	
	
	<div class="container-modal">
 
			    <h2>Thêm sản phẩm</h2>
			 
			    <!-- Button đăng nhập để mở form đăng nhập -->
			    <button id="myBtn">Thêm</button>
			    
	 <div id="myModal" class="modal">
	<div class="modal-content">
		<form action="add" method="POST" enctype="multipart/form-data">
			<span class="close">&times;</span>
			<h2>Đăng kí sản phẩm</h2>
			<div class="fomrgroup">



				<b>Chọn danh mục:</b> <select name="maDM" id="pet-select" required>
					
					<c:forEach var="o" items="${listdm}">

						<option value="${o.maDM}">${o.tenDM}</option>

					</c:forEach>
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
				<input type="text" id=" " value="${Vendor.maKH }" name="vendor"
					readonly >
			</div>

			<div class="fomrgroup">
				<b>Tên sản phẩm:</b> <input type="text" id=" " name="TenSP" required>
			</div>
			<div class="fomrgroup">
				<b>Mô Tả:</b> <input type="text" id=" " name="MoTa" required>
			</div>

			<div class="fomrgroup">
				<b>Giá bán:</b> <input type="text" id=" " name="Gia" required>
			</div>

			<div class="fomrgroup">
				<b>Giá khuyến mãi:</b> <input type="text" id=" " name="KhuyenMai"
					required>
			</div>

			<div class="fomrgroup">
				<b>Số lượng kho:</b> <input type="text" id=" " name="SoLuongKho"
					required>
			</div>

			<div class="fomrgroup">
				<b>Mô tả ngắn:</b> <input type="text" id=" " name="MoTaNgan"
					required>
			</div>

			<div class="form-group">
				<input type="file" name="anh1" onchange="readURL(this);"required/>
				<img id="blah1" src="#" alt="your image" />
				 <input
					type="file" name="anh2" onchange="readURL(this);"required/> 
					<img id="blah2" src="#" alt="your image" />
					<input type="file" name="anh3" onchange="readURL(this);"required/> 
					<img id="blah3" src="#" alt="your image" />
					<input
					type="file" name="anh4"onchange="readURL(this);" required/>
					<img id="blah4" src="#" alt="your image" />
			</div>




			<button type="submit">Thêm sản phẩm</button>

		</form>
	</div>
	
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
    var modalAdd = document.getElementById('myModal');
  
    // Lấy phần button mở Modal
    var btnAdd = document.getElementById("myBtn");
  
    // Lấy phần span đóng Modal
    var spanAdd = document.getElementsByClassName("close")[0];
  
    // Khi button được click thi mở Modal
    btnAdd.onclick = function() {
        modalAdd.style.display = "block";
    }
  
    // Khi span được click thì đóng Modal
    spanAdd.onclick = function() {
        modalAdd.style.display = "none";
    }
  
    // Khi click ngoài Modal thì đóng Modal
    window.onclick = function(event) {
        if (event.target == modalAdd) {
            modalAdd.style.display = "none";
        }
    }
    
/*     function readURL(input) {
    	  if (input.files && input.files[0]) {
    	    var reader = new FileReader();

    	    reader.onload = function (e) {
    	    	
    	       $('this').closest("img").attr('src', e.target.result).width(50).height(50); 
    	    	$('img').attr('src', e.target.result).width(50).height(50);
    	    };

    	    reader.readAsDataURL(input.files[0]);
    	  }
    	} */
    
</script>
</body>
</html>