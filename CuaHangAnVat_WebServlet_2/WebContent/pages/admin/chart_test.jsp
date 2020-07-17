<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Exploring Chart.js</title>

<script>
function float2vnd(value) {
	return "vnd " + (value).toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');
}

function renderChart() {
	data = [ 
		<c:forEach items="${incomeList}"
			var="income">
			<c:out value="${income}"/>,
		</c:forEach>
		];
	 console.log(data);
	labels = [ "tháng 1", "tháng 2", "tháng 3", "tháng 4", "tháng 5",
			"tháng 6", "tháng 7", "tháng 8", "tháng 9", "tháng 10", "tháng 11", "tháng 12" ];
	var ctx = document.getElementById("myChart").getContext('2d');
	var myChart = new Chart(ctx, {
		type : 'line',
		data : {
			labels : labels,
			datasets : [ {
				label : 'Năm nay',
				data : data,
				borderColor : 'rgba(75, 192, 192, 1)',
				backgroundColor : 'rgba(75, 192, 192, 0.2)',
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true,
						callback : function(value, index, values) {
							return float2vnd(value);
						}
					}
				} ]
			}
		},
	});
}
</script>
</head>
<style>
.container {
	width: 50%;
	height: 50%;
}
</style>
<body onload="renderChart();">
	<div class="container">
		<canvas id="myChart"></canvas>
	</div>
</body>

<!-- Page level plugins -->
<script src="./pages/admin/vendor/chart.js/Chart.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>


</html>