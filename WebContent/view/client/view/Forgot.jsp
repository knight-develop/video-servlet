<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<c:url value="/view/client/static" var="url"></c:url>
<link rel="stylesheet" href="${url }/css/forgot.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>

<body>
	<div class="wrapper">
		
		<div class="title">Forgot Password</div>
		<form action="<%=request.getContextPath() %>/forgot-password" method="post">
		<div class="field">
				<input type="text" required name="username"> <label>Username</label>
			</div>
			<div class="field">
				<input type="text" required name="email"]> <label>Email Address</label>
			</div>
			<div class="field">
				<input type="submit" value="Retrieve">
			</div>
			<span>${message }</span>
		</form>
	</div>
</body>

</html>