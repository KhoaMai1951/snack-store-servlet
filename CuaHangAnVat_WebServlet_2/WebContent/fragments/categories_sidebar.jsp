<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-lg-3 " id="mysidebar">
	<h1 class="my-4">Danh mục</h1>
	<div class="list-group">
		<a href="/CuaHangAnVat_WebServlet_2/View_HomeController"
			class="list-group-item active">Tất cả sản phẩm</a>
		<c:forEach items="${categoryList}" var="category">
			<a
				href="/CuaHangAnVat_WebServlet_2/View_ProductsByCategoryController?category_id=${category.id }"
				class="list-group-item">${category.name}</a>
		</c:forEach>
	</div>
</div>