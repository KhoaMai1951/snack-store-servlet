<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style>
<%@include file="../css/index.css" %>
</style>
</head>

<body>
	<!-- Navigation -->
	<%@include file="../fragments/navigation.jsp"%>

	<!-- Page Content -->
	<div class="container mb-auto">

		<div class="row">
			<!--sidebar col-lg-3 -->
			<%@include file="../fragments/sidebar.jsp"%>

			<!--main content col-lg-9 -->
			<%@include file="../fragments/main_content.jsp"%>
		</div>

	</div>
	<!-- /.container -->

	<!-- Footer -->

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>