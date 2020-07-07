<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">Admin</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value = "/admin/product"/>"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Chỉnh sửa sản
						phẩm</span></a></li>
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value = "/admin/product/add"/>"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Thêm mới sản
						phẩm</span></a></li>
			<li class="nav-item active"><a class="nav-link"
				href="index.html"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Xử
						lý đơn hàng</span></a></li>
			<li class="nav-item active"><a class="nav-link"
				href="index.html"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Báo
						cáo doanh thu</span></a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

		</ul>
		<!-- End of Sidebar -->