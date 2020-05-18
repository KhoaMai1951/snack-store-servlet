<%@page import="dao.CategoryDAO"%>
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
	<form method="POST"
		enctype="multipart/form-data"
		action="/CuaHangAnVat_WebServlet_2/ProductUpdateController">
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
				<tr>
					<td>${product.id}</td>
					<td><input type="text" name="name"
						value="${product.name}"></input></td>
					<td>
						<img width=500rem height=500rem
						src="resources/${product.imgName}">
						<input name="image" type="file" accept="image/*">
					</td>
					<td><input type="number" name="quantity"
						value="${product.quantity}"></input></td>
					<td><input type="number" name="price" value="${product.price}"></input></td>
					<td><select name="category">
							<c:forEach items="${requestScope.categoryList}" var="category">
								<c:choose>
									<c:when test="${product.categoryID == category.id }">
										<option value="${category.id}" selected="selected">${category.name}</option>
									</c:when>
									<c:when test="${product.categoryID != category.id }">
										<option value="${category.id}">${category.name}</option>
									</c:when>
								</c:choose>
							</c:forEach>
					</select></td>
					<td><textarea name="description" rows="10" cols="30">${product.description}</textarea></td>
					<td>
					<input type="number" hidden value="${product.id}"
						name="product_id"> 
					<input type="text" name="img_name" hidden value ="${product.imgName }">
					<input type="submit" value="Chỉnh sửa">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>