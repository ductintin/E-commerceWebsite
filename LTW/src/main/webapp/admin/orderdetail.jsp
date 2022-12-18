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

    <title>Order Detail</title>

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

                <!-- Begin Page Content -->
                <div class="container-fluid">

                   <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <!-- Main content -->
                        <div class="invoice p-3 mb-3">
                            <!-- title row -->
                            <div class="row">
                                <div class="col-12">
                                    
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- info row -->
                            <div class="row invoice-info">
                                
                                <!-- /.col -->
                                <div class="col-sm-4 invoice-col">
                                    Đến
                                    <c:forEach var="o" items="${listkh}">
                                    <address>
                                        <strong>${o.tenKH}</strong>
                                        <br>
                                        ${o.diaChi }
                                        <br>
                                      	Email: ${o.email}
                                        <br>
                                        Phone: ${o.phone}
                                        <br>
                                    </address>
                                    </c:forEach>
                                </div>
                                <!-- /.col -->
                                <c:forEach var="o" items="${listdh}">
                                <div class="col-sm-4 invoice-col">                               
                                    <br>
                                     <b>ID đặt hàng: ${o.maDH}</b> 
                                     <br> <b>Ngày đặt hàng:${o.thoiGian} </b>
                                    <br> 
                                </div>
								</c:forEach>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->

                            <!-- Table row -->
                             <div class="card shadow mb-4">
                        
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>Mã sản phẩm </th>
                                            <th>Tên sản phẩm</th>         
                                             <th>Tên shop</th>                                 
                                            <th>Số lượng</th>
                                            <th>Thành tiền</th>
                                            <th>Trạng thái</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                       <c:forEach var="i" begin="0" end="${size-1}">
                                            <tr>
                                                <td>${listsp[i].getMaSP()}</td>
                                                <td>${listsp[i].getTenSP()}</td>
                                                <td>${listshop[i].getTenShop()}</td>
                                                <td>${listctdh[i].getSoLuong()}</td>
                                                <td>${listctdh[i].getTongTien()}</td>
                                                <c:forEach items="${listtt}" var="tt">
                                                <c:if test="${tt.maTrangThai == listctdh[i].getMaTrangThai()}">
                                                    <c:if test="${listctdh[i].getMaTrangThai() == 1}">
                                                        <td><span class="badge badge-success"
                                                        style="background : red">${tt.tenTrangThai}</span>
                                                        </td>
                                                    </c:if>
                                                    <c:if test="${listctdh[i].getMaTrangThai() == 2}">
                                                        <td><span class="badge badge-success"
                                                                  style="background : blue">${tt.tenTrangThai}</span>
                                                        </td>
                                                    </c:if>
                                                    
                                                </c:if>

                                            </c:forEach>
                                            </tr>
                                        </c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                            
                            <!-- /.row -->

                            <div class="row">
                                <div class="col-6">

                                    <div class="table-responsive">
                                        <table class="table">
                                            <tr>
                                                <th style="width: 50%">Tổng tiền:</th>
                                                <c:forEach var="o" items="${listdh}">
                                                <td >${o.tongTien}</td>
                                                </c:forEach>
                                                
                                            </tr>
                                            
                                        </table>
                                    </div>
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->

                            <!-- this row will not appear when printing -->
                            <div class="row no-print">
                                <div class="col-12">
                                    <!-- <a href="invoice-print.jsp" rel="noopener" target="_blank"
                                        class="btn btn-default"><i class="fas fa-print"></i>
                                        Print</a> -->
                                   
                                    <script>
                                        var check = ${donHang.maTrangThai};
                                        if (check == 2) {
                                            document.getElementById("changeStatus").innerHTML = "Đã xác nhận"
                                            document.getElementById("changeStatus").type = "button";
                                        }
                                        if (check == 3) {
                                            // document.getElementById("changeStatus").style.visibility= 'hidden';
                                            document.getElementById("changeStatus").type = "button";
                                            document.getElementById("changeStatus").innerHTML = "Đang giao hàng"
                                            document.getElementById("changeStatus").style.background = 'blue ';
                                        }
                                        if (check == 4) {
                                            // document.getElementById("changeStatus").style.visibility= 'hidden';
                                            document.getElementById("changeStatus").type = "button";
                                            document.getElementById("changeStatus").innerHTML = "Đã giao hàng"
                                            document.getElementById("changeStatus").style.background = 'red ';
                                        }
                                    </script>
                                </div>
                            </div>
                        </div>
                        <!-- /.invoice -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

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

</body>

</html>