<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ultilities.Constants_Value"%>
<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="<c:url value="<%=Constants_Value.ADMIN_PRODUCT_MANAGER_URL %>"/>">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">Admin</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link"
		href="<c:url value="<%=Constants_Value.ADMIN_PRODUCT_MANAGER_URL %>"/>"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Chỉnh sửa sản
				phẩm</span></a></li>
	<li class="nav-item active"><a class="nav-link"
		href="<c:url value="<%=Constants_Value.ADMIN_PRODUCT_UPLOAD_URL %>"/>"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Thêm mới sản
				phẩm</span></a></li>
	<li class="nav-item active"><a class="nav-link" href="<c:url value="<%=Constants_Value.ADMIN_PRODUCT_DELETED_PRODUCT_URL %>"/>"/>
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Sản phẩm đã xóa</span>
	</a></li>
	
	<!-- Divider -->
	<hr class="sidebar-divider my-0">
	
	<li class="nav-item active"><a class="nav-link" href="<c:url value = "/admin/order"/>">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Xử lý đơn
				hàng</span>
	</a></li>
	<li class="nav-item active"><a class="nav-link" href="<c:url value = "/admin/report"/>">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Báo cáo
				doanh thu</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<li class="nav-item active"><a class="nav-link" href="<c:url value="/admin/logout"/>">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Đăng Xuất</span>
	</a></li>

</ul>
<!-- End of Sidebar -->