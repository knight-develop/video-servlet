<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url value="/view/client/static" var="url"></c:url>
<link rel="stylesheet" href="${url }/css/forgot.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<div class="wrapper">
		<div class="title">Edit Profile</div>
		<form action="<%=request.getContextPath()%>/edit-profile"
			method="post">
			<div class="field">
				<input type="text" required name="id" readonly="readonly" value=${user.id }> <label>Username</label>
			</div>
			<div class="field">
				<input type="text" required name="password" value=${user.password }> <label>
					Password</label>
			</div>
			<div class="field">
				<input type="text" required name="fullName" value=${user.fullName }> <label>fullName</label>
			</div>
			<div class="field">
				<input type="email" required name="email" value=${user.email }> <label>Email Address</label>
			</div>
			<p>${message }</p>
			<div class="field">
				<input type="submit" value="Update">
			</div>
		</form>
	</div>
</body>
</html>