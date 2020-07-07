<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<style>
.container{
	margin-top: 3rem;
	 
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 m-auto">
				<h1 class="m-auto">Đăng nhập admin</h1>
				<br>
				<form method="POST" action="/CuaHangAnVat_WebServlet_2/login">
					<div class="form-group">
						<label>Tên người dùng</label> <input name="username" class="form-control"
							placeholder="username">
					</div>
					<div class="form-group">
						<label>Mật khẩu</label> <input name="password" class="form-control"
							placeholder="password">
					</div>
					<button type="submit" class="btn btn-primary">Đăng nhập</button>
				</form>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>