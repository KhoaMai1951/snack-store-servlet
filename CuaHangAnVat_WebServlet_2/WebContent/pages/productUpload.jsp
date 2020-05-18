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
<title>Insert title here</title>
</head>
<body>
	THÊM SẢN PHẨM
	<form action="/CuaHangAnVat_WebServlet_2/View_ProductUploadController"
		method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Tên sản phẩm:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Số lượng:</td>
				<td><input type="number" name="quantity"></td>
			</tr>
			<tr>
				<td>Gía:</td>
				<td><input type="number" name="price"></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Danh mục:</td>
				<td><select name="categories">
						<c:forEach items="${requestScope.categoryList}" var="category">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<input name="image" type="file" accept="image/*"><br> <br> 
		<input type="submit"
			name="upload" value="Upload sản phẩm mới">

	</form>
</body>
</html>