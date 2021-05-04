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
		<div class="title">Change Password</div>
		<form action="<%=request.getContextPath() %>/change-password" method="post">
			<div class="field">
				<input type="text" required name="id"> <label>Username</label>
			</div>
			<div class="field">
				<input type="password" required name="current-pass"> <label>Current Password</label>
			</div>
			<div class="field">
				<input type="password" required name = "new-pass"> <label>New Password</label>
			</div>
			<div class="field">
				<input type="password" required name="confirm"> <label>Confirm New Password</label>
			</div>
			<p>${message }</p>
			<div class="field">
				<input type="submit" value="Change">
			</div>
		</form>
	</div>
</body>
</html>