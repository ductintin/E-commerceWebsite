<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>All Order</title>

    <!-- Custom fonts for this template -->
    <link href="${root}plugins/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${root}plugins/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="${root}plugins/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

       <%@include file="./sitebar.jsp" %>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
         <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <%@include file="./ad_header.jsp"%>
                <!-- End of Topbar -->

            <div class="page-content fade-in-up">
                <div class="row">
                <c:forEach var="o" items="${listkh}">
                    <div class="col-lg-3 col-md-4">
                        <div class="ibox">
                            <div class="ibox-body text-center">
                                <div class="m-t-20">
                                    <img class="img-circle" src="${root}plugins/images/user1-128x128.jpg" />
                                </div>
                                <h5 class="font-strong m-b-10 m-t-10">${o.tenKH}</h5>
                                <div class="m-b-20 text-muted">Phone: ${o.phone}</div>
                                 <div class="m-b-20 text-muted">Email: ${o.email}</div>
                                  <div class="m-b-20 text-muted">Địa chỉ: ${o.diaChi}</div>       
                            </div>
                        </div>
                        
                        <div class="ibox">
                            <div class="ibox-body">
                                <div class="row text-center m-b-20">
                                    <div class="col-4">
                                        <div class="font-24 profile-stat-count">${countorder}</div>
                                        <div class="text-muted">Orders</div>
                                    </div>
                                    <div class="col-4">
                                        <div class="font-24 profile-stat-count">${totalspend}</div>
                                        <div class="text-muted">Spends</div>
                                    </div>
                                    <div class="col-4">
                                        <div class="font-24 profile-stat-count">${totalproduce}</div>
                                        <div class="text-muted">Produces</div>
                                    </div>
                                </div>
                               
                            </div>
                        </div>
                        
                    </div>
                    </c:forEach>
                    <div class="col-lg-9 col-md-8">
                        <div class="ibox">
                            <div class="ibox-body">
                                
                                <div class="tab-content">
                                    <div class="tab-pane fade show active" id="tab-1">
                                        <div class="row">
                                            
                                          
                                        </div>
                                        <h4 class="text-info m-b-20 m-t-20"><i class="fa fa-shopping-basket"></i>Orders</h4>
                                        <div class="card shadow mb-4">
                        
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>Mã đơn hàng</th>
                                            <th>Tổng tiền</th>
                                            <th>Thời gian</th>
                                            <th>Tình trạng</th>
                                            
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                       <c:forEach var="i" begin="0" end="${size-1}">
                                    	<tr>
                                            <td><a href="orderdetail?maDH=${listdh[i].getMaDH()}&maKH=${listkh[i].getMaKH()}">${listdh[i].getMaDH()}</td>
                                            <td data-type="money">${listdh[i].getTongTien()}</td>
                                            <td>${listdh[i].getThoiGian()}</td>
                                            <td>${listdh[i].getMaTrangThai()}</td>
                                            
                                        </tr>
                                    </c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                                    </div>
                                
                                   
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <style>
                    .profile-social a {
                        font-size: 16px;
                        margin: 0 10px;
                        color: #999;
                    }

                    .profile-social a:hover {
                        color: #485b6f;
                    }

                    .profile-stat-count {
                        font-size: 22px
                    }
                </style>
               
            </div>

         

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="${root}plugins/vendor/jquery/jquery.min.js"></script>
    <script src="${root}plugins/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${root}plugins/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${root}plugins/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="${root}plugins/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="${root}plugins/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="${root}plugins/js/demo/datatables-demo.js"></script>
    <script>

    document.querySelectorAll('[data-type="money"]').forEach(item => {

        item.innerHTML = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'vnd'}).format(item.innerHTML);
    })
</script>

</body>

</html>