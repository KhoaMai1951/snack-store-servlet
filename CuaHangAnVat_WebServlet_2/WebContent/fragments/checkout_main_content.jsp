<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col-lg-9 main_content">
	<div class="container bg-light">
		<div class="row">
			<h1>Order nhanh - Giao ngay</h1>

			<table class="table table-hover">
				<thead class="bg-warning">
					<tr>
						<th scope="col">Sản phẩm</th>
						<th scope="col">Đơn giá</th>
						<th scope="col">Số lượng đặt</th>
						<th scope="col">Thành tiền</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${items}" var="item">
						<tr>
							<td>${item.name}</td>
							<td><fmt:formatNumber type="currency" value="${item.price}" /></td>
							<td>${item.orderQuantity}</td>
							<td><fmt:formatNumber type="currency"
									value="${item.orderQuantity * item.price}" /></td>
							<td><form method="POST"
									action="/CuaHangAnVat_WebServlet_2/ItemDeleteController">
									<button type="submit" class="btn btn-danger mb-2">Xóa</button>
									<input name="product_id" hidden type="text" value="${item.id}"></input>
								</form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<form method="POST" action="/CuaHangAnVat_WebServlet_2/CheckoutController">
							<div class="form-group">
								<label>Tên bạn</label> <input
									type="text" class="form-control" placeholder="Nhập tên" name="customer_name">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email</label> <input
									type="email" class="form-control" name="customer_email"
									aria-describedby="emailHelp" placeholder="Nhập email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Địa chỉ giao hàng</label> <input
									type="text" class="form-control" name="customer_address"
									placeholder="Nhập địa chỉ">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số điện thoại</label> <input
									type="text" class="form-control" name="customer_phone"
									placeholder="Nhập sđt">
							</div>
							<button type="submit" class="btn btn-primary">Đặt hàng</button>
						</form>
					</div>
					<div class="col-md-4">
						<h1 class="text-danger">
							TỔNG TIỀN:
							<fmt:formatNumber type="currency" value="${sumPrice}" />
						</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>