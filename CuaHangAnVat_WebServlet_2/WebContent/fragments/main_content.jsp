<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-9 main_content">
	<div class="container bg-light">
		<div class="row">
			<!-- Output product info in bootstrap card -->
			<!-- Each product is in col-4-md -->
			<c:forEach items="${requestScope.productList}" var="product">
			<form method="POST" action="/CuaHangAnVat_WebServlet_2/AddToCartController">
				<div class="card col-4-md p-3 m-4" style="width: 13rem;">
					<img class="card-img-top" src="resources/${product.imgName}"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${product.name}</h5>
						<p class="card-text">${product.description}</p>
						<b class="card-title">Giá: ${product.price} đ</b>
						<p></p>
						<b class="card-text">Số lượng mua: 
							<input name="quantity" value=1 style="width:7rem;" type="number">
						</b>
						<br><br>
						<input hidden type="text" name ="product_id" value="${product.id}">
						<input type="submit" value="Thêm vào giỏ"> 
					</div>
				</div>
			</form>
			</c:forEach>
		</div>
	</div>
</div>