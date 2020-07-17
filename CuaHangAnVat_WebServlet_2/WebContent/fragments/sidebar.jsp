<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="ultilities.Constants_Value"%>

<div class="col-lg-3 " id="mysidebar">
	<h1 class="my-4">Giỏ hàng</h1>
	<table class="table">
		<tr>
			<th>Sản phẩm</th>
			<th>Số lượng mua</th>
		</tr>
		<c:forEach items="${items}" var="item">
			<tr>
				<td>${item.name}</td>
				<td>${item.orderQuantity}</td>
			</tr>
		</c:forEach>
		<tr class="bg-success">
			<td>Tổng giá:</td>
			<td><fmt:formatNumber type="currency" value="${sumPrice }" /></td>
		</tr>
		<tr>
			<a href="<c:url value = "<%=Constants_Value.CART_URL%>" />" class="btn btn-success">Thanh toán</a>
		</tr>
	</table>

	<h1 class="my-4">Danh mục</h1>
	<div class="list-group">
		<a href="<c:url value = "<%=Constants_Value.HOME_INDEX_URL%>" />"
			class="list-group-item active">Tất cả sản phẩm</a>
		<c:forEach items="${categoryList}" var="category">
			<a href="<c:url value = "<%=Constants_Value.HOME_CATEGORY_URL%>" />?id=${category.id}"
				class="list-group-item">${category.name}</a>
		</c:forEach>
	</div>
</div>