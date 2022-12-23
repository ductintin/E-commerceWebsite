<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<%@ page session="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết đơn hàng</title>

<link rel="stylesheet"
	href="<c:url value='/views/vendor/css/home.css'/>">


</head>
<body>

<%@include file="/views/vendor/sidebar.jsp"%>

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
                                <td>Mã chi tiết đơn hàng</td>
                                <td>Mã đơn hàng</td>
                                <td>Mã sản phẩm</td>
                                <td>Số lượng</td>
                                <td>Tổng tiền</td>
                                <td>Trạng thái</td>
                                <td>Thao tác</td>
                            </tr>
                        </thead>

                        <tbody>
                         <c:forEach var="i" begin="0" end="${size-1}">
                            <tr>
                                <td>${listctdh[i].getMaCTDH()}</td>
                                <td>${listctdh[i].getMaDH()}</td>
                                <td>${listctdh[i].getMaSP()}</td>
                                <td>${listctdh[i].getSoLuong()}</td>
                                <td data-type="money">${listctdh[i].getTongTien()}</td>
                                
                                <c:url value = "${listctdh[i].getMaTrangThai()}" var ="status"></c:url>
                                <c:if test="${status eq 1 }">
                                <td> <span style="color: red; font-weight: 600;">Chưa xác nhận</span></td>
                                </c:if>
                                <c:if test="${status eq 2 }">
                                <td> <span style="color: green; font-weight: 600;">Đã xác nhận</span></td>
                                </c:if>
                                <c:if test="${status eq 3 }">
                                <td> <span style="color: green; font-weight: 600;">Chưa nhận hàng</span></td>
                                </c:if>
                                <c:if test="${status eq 4 }">
                                <td> <span style="color: green; font-weight: 600;">Đã nhận hàng</span></td>
                                </c:if>
                                
                                <c:if test="${listctdh[i].getMaTrangThai() eq 1}">
                                <td><a href='<c:url value='/vendor/order/detail?maDH=${listctdh[i].getMaDH()}&maCTDH=${listctdh[i].getMaCTDH()}&action=confirm'></c:url>' style="text-decoration: none; color: black; font-weight: 600;">Xác nhận đơn hàng</a></td>
                                </c:if>
                                
                                <c:if test="${listctdh[i].getMaTrangThai() eq 2}">
                                <td><a href='<c:url value='/vendor/order/detail?maDH=${listctdh[i].getMaDH()}&maCTDH=${listctdh[i].getMaCTDH()}&action=delivery'></c:url>' style="text-decoration: none; color: black; font-weight: 600;">Giao hàng</a></td>
                                </c:if>
                                
                               
                                
                                <c:if test="${listctdh[i].getMaTrangThai() eq 3}">
                                <td><a href="" style="text-decoration: none; color: yellow; font-weight: 600;">Đang giao hàng</a></td>
                                </c:if>
                                
                                <c:if test="${listctdh[i].getMaTrangThai() eq 4}">
                                <td><a href="" style="text-decoration: none; color: green; font-weight: 600;">Đã giao thành công</a></td>
                                </c:if>
                                
                                
                            </tr>
                          </c:forEach>
                        </tbody>
                    </table>
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
		
		document.querySelectorAll('[data-type="money"]').forEach(item => {

	        item.innerHTML = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'vnd'}).format(item.innerHTML);
	    })
		</script>
</body>
</html>