<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<%@ include file="/fragments/admin_sidebar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- Begin Page Content -->
				<!-- Search bar -->
				<div class="container-fluid row">
					<form method="POST"
						action='<c:url value = "/admin/order_search"></c:url>'>
						<div class="form-row">
							<div class="form-group col-md-3">
								<label>Mã đơn hàng</label> <input type="number"
									class="form-control" name="id" placeholder="Nhập mã đơn hàng">
							</div>
							<div class="form-group col-md-3">
								<label>Tên khách hàng</label> <input type="text"
									class="form-control" name="customer_name"
									placeholder="Nhập tên khách hàng">
							</div>
							<div class="form-group col-md-3">
								<label>Số điện thoại</label> <input type="number"
									class="form-control" name="phone"
									placeholder="Nhập số điện thoại">
							</div>
							<div class="form-group col-md-3">
								<label>Email</label> <input type="text" class="form-control"
									name="email" placeholder="Nhập email">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-3">
								<jsp:useBean id="date" class="java.util.Date" />
								<fmt:formatDate var="time" value="${date}" pattern="yyyy-MM-dd" />
								<label>Ngày đặt từ</label> <input type="date"
									class="form-control" name="order_date">
							</div>
							<div class="form-group col-md-3">
								<label>Trạng thái</label> orderStatus 
								<select name="order_status_id" 
								class="form-control form-control-md">
									<option value="">
									<c:forEach items="${orderStatus}" var="status">
										<option value="${status.id}">${status.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Tìm kiếm</button>
					</form>
				</div>
				<br>
				<div class="container-fluid row">
					<table class="table col-md-12">
						<thead class="thead-dark">
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Tên khách hàng</th>
								<th scope="col">Ngày đặt hàng</th>
								<th scope="col">Ngày nhận hàng</th>
								<th scope="col">SĐT</th>
								<th scope="col">Email</th>
								<th scope="col">Trạng thái đơn hàng</th>
								<th scope="col">Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.orderList}" var="order">
								<tr>
									<td>${order.orderID}</td>
									<td>${order.customerName}</td>
									<td>${order.orderDate}</td>
									<td>${order.deliveredDate}</td>
									<td>${order.phone}</td>
									<td>${order.email}</td>
									<td>${order.orderStatus}</td>
									<td><a
										href="<c:url value = "/admin/order/handle?id=${order.orderID}"/>"
										class="btn btn-primary active" role="button"
										aria-pressed="true">Xử lý đơn hàng</a></td>
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
