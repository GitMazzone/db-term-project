<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="icon" 
      type="image/png" 
      href="https://lh3.googleusercontent.com/8C5GNVMjuD0_jHbIsVH0UqJu_G_mpk_KXtclPkg2ZwnyC9fTfWbWGemUtG_siSXOv2s">
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
		<div class="col-sm-2 mr-5 bg-light full-height">
			<ul
				class="nav flex-column justify-content-center align-items-center full-height">
				<h4 class="text-dark">Pick a query!</h4>
				<li class="nav-item"><a class="nav-link active" href="Query1"
					data-toggle="tooltip" data-placement="right"
					title="List entity and their total impressions"> Impressions by
						Entity </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query2"
					data-toggle="tooltip" data-placement="right"
					title="List entity and the ads they pay for">
						Ads by Entity </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query3"
					data-toggle="tooltip" data-placement="right"
					title="List ads by entity and the number of impressions per ad">
						Ads & Impressions </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query4"
					data-toggle="tooltip" data-placement="right"
					title="List companies and their target audience">
						Target Audience </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query5"
					data-toggle="tooltip" data-placement="right"
					title="Show proportion of all ads an entity is responsible for">
						Impression Prop. </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query6"
					data-toggle="tooltip" data-placement="right"
					title="Rank entities by average proportion of political/not_political">
						Political Perception </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query7"
					data-toggle="tooltip" data-placement="right"
					title="List all ads within a date range">
						Date Range </a></li>
				<li class="nav-item"><a class="nav-link active" href="Query8"
					data-toggle="tooltip" data-placement="right"
					title="List well-known entities and compare their total impressions to average of all entities">
						Well-Known </a></li>
			</ul>
		</div>

		<!-- MAIN CONTENT -->
		<div class="col-sm-8 ml-5 results-content">
			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th class="fixed-th">Advertiser</th>
						<th class="fixed-th">Total Impressions</th>
					</tr>
				</thead>
				<c:forEach items="${ result_tuples }" var="item">
					<tr>
						<td>${ item.getAdvertiserName() }</td>
						<td>${ item.getAdImpressions() }</td>
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