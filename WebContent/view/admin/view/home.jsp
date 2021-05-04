<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="../../layout/header.jsp"></jsp:include>
	<nav class="navbar navbar-expand-lg navbar-info bg-dark">
		<a class="navbar-brand text-warning" href="#">ADMINISTRATION TOOL</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/home">Home
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/admin/video">Video
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/admin/user">Users
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/admin/report">Report
				</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>