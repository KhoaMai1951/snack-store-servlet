<%@	page import="dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Chỉnh sửa sản phẩm</title>

<script type="text/javascript">
	function getAttribute(product_id) {

	}
	function testchinhsua(product_id) {
		document.getElementById("name_" + product_id).value = "khoa";
	}
</script>
</head>
<body>
	<table class="table">
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
					<td><img width=500rem height=500rem
						src="resources/${product.imgName}"></td>
					<td>${product.quantity}</td>
					<td>${product.price}</td>
					<td>${product.categoryNameFromForeignKey}</td>
					<td>
						<textarea readonly name="description" rows="10" cols="30">
							${product.description}
						</textarea>
					</td>
					<td>
						<form method="POST"
							action="/CuaHangAnVat_WebServlet_2/ProductDeleteController">
							<input type="submit" value="Xóa">
							<input type="text" hidden name="productID" value="${product.id}"/>
						</form>
						<form method="POST"
							action="/CuaHangAnVat_WebServlet_2/View_ProductUpdateController">
							<input type="number" hidden value="${product.id}" name="product_id">
							<input type="submit" value="Đến phần chỉnh sửa">
						</form>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>