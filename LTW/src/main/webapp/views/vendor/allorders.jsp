<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<%@ page session="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách đơn hàng</title>

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
                                <td>Mã đơn hàng</td>
                                <td>Mã khách hàng</td>
                                <td>Tổng tiền</td>
                                <td>Thời gian</td>
                                <td>Trạng thái</td>
                                <td>Thao tác</td>
                            </tr>
                        </thead>

                        <tbody>
                         <c:forEach var="i" begin="0" end="${size-1}">
                            <tr>
                                <td>${listdh[i].getMaDH()}</td>
                                <td>${listdh[i].getMaKH()}</td>
                                <td data-type="money">${listdh[i].getTongTien()}</td>
                                <td>${listdh[i].getThoiGian()}</td>
                                <c:url value = "${listdh[i].getIsDelete()}" var ="status"></c:url>
                                 <c:if test="${status eq 0 }">
                                <td> <span style="color: green; font-weight: 600;">Active</span></td>
                                </c:if>
                                
                                <c:if test="${status eq 1 }">
                                <td> <span style="color: red; font-weight: 600;">Deleted</span></td>
                                </c:if>
                                <c:if test="${status eq 2 }">
                                <td> <span style="color: green; font-weight: 600;">Đã xác nhận</span></td>
                                </c:if>
                                <c:if test="${status eq 3 }">
                                <td> <span style="color: green; font-weight: 600;">Chưa nhận hàng</span></td>
                                </c:if>
                                <c:if test="${status eq 4 }">
                                <td> <span style="color: green; font-weight: 600;">Đã nhận</span></td>
                                </c:if>
                                <td><a href='<c:url value='/vendor/order/detail?maDH=${listdh[i].getMaDH()}'></c:url>' style="text-decoration: none; color: black; font-weight: 600;">Chi tiết</a></td>
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