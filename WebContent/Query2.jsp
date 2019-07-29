<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FB Ad Queries</title>
<style type="text/css">
<%@ include file = "bootstrap/css/bootstrap.min.css" %>
</style>
<link rel="stylesheet" type="text/css"
	href="${ pageContext.request.contextPath }/css/style.css">
</head>
<body>

	<div class="row full-height align-items-center">

		<!-- LEFT NAVBAR -->
		<div class="col-sm-2 bg-light">
			<ul
				class="nav flex-column justify-content-center align-items-center full-height">
				<h4 class="text-dark">Pick a query!</h4>
				<li class="nav-item"><a class="nav-link active" href="Query1"
					data-toggle="tooltip" data-placement="right"
					title="List corporations and their total impressions"> Query 1
				</a></li>
				<li class="nav-item"><a class="nav-link active" href="Query2"
					data-toggle="tooltip" data-placement="right"
					title="List ads by corporation and the number of impressions per ad">
						Query 2 </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query3"
					data-toggle="tooltip" data-placement="right"
					title="List companies and their target audience"> Query 3 </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query4"
					data-toggle="tooltip" data-placement="right"
					title="Show proportion of all ads a company is responsible for">
						Query 4 </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query5"
					data-toggle="tooltip" data-placement="right"
					title="Rank companies by perceived politicalness"> Query 5 </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query6"
					data-toggle="tooltip" data-placement="right"
					title="List all ads within a date range"> Query 6 </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query7"
					data-toggle="tooltip" data-placement="right"
					title="List correlation between market cap and impressions">
						Query 7 </a></li>
			</ul>
		</div>

		<!-- MAIN CONTENT -->
		<div class="col-sm-10 d-flex justify-content-center align-items-center full-height bg-dark text-light results-content">
			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th>Paid for By</th>
						<th>Ad Name</th>
					</tr>
				</thead>
				<c:forEach items="${ result_tuples }" var="item">
					<tr class="text-light">
						<td>${ item.getPaidForBy() }</td>
						<td>${ item.getAdTitle() }</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

	<script src="bootstrap/js/bootstrap.js"></script>
	<script src="jquery/jquery-3.4.1.slim.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>