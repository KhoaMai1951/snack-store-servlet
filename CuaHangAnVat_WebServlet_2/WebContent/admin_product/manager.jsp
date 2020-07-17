<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ultilities.Constants_Value"%>
<!DOCTYPE html>
<html lang="en">

<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin</title>

<!-- Custom fonts for this template-->
<link href="../pages/admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="../pages/admin/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="/fragments/admin_sidebar.jsp" %>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- Begin Page Content -->
				<div class="container-fluid row">
					<table class="table col-md-6"
						style="max-width: 50%; overflow-y: auto">
						<thead class="thead-dark">
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Tên sản phẩm</th>
								<th scope="col">Hình ảnh</th>
								<th scope="col">Số lượng</th>
								<th scope="col">Gía</th>
								<th scope="col">Danh mục</th>
								<th scope="col">Mô tả</th>
								<th scope="col">Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.productList}" var="product">
								<tr>
									<td>${product.id}</td>
									<td>${product.name}</td>
									<td><img width=200rem height=200rem
										src="../resources/${product.imgName}"></td>
									<td>${product.quantity}</td>
									<td>${product.price}</td>
									<td>${product.categoryNameFromForeignKey}</td>
									<td><textarea readonly name="description" rows="10"
											cols="30">
							${product.description}
						</textarea></td>
									<td>
										<a class="btn btn-danger"
										href="<c:url value = "<%=Constants_Value.ADMIN_PRODUCT_DELETE_URL%>" />?productID=${product.id}"
										role="button">Xóa</a>
										
										<a class="btn btn-primary"
										href="<c:url value = "<%=Constants_Value.ADMIN_PRODUCT_EDIT_URL%>" />?product_id=${product.id}"
										role="button">Chỉnh sửa</a>
									</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="../pages/admin/vendor/jquery/jquery.min.js"></script>
	<script
		src="../pages/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="../pages/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="../pages/admin/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="../pages/admin/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="../pages/admin/js/demo/chart-area-demo.js"></script>
	<script src="../pages/admin/js/demo/chart-pie-demo.js"></script>
</body>

</html>