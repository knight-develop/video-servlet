<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/view/client/static" var="url"></c:url>
<link rel="stylesheet" href="${url }/css/login.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body>
	<div class="row">
		<div class="col-md-6 mx-auto p-0">
			<div class="card">
				<div class="login-box">
					<div class="login-snip">
						<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
							for="tab-1" class="tab">Login</label> <input id="tab-2"
							type="radio" name="tab" class="sign-up"><label
							for="tab-2" class="tab">Sign Up</label>
						<div class="login-space">
							<form action="<%=request.getContextPath() %>/login" method="post">
								
								<div class="login">
									<div class="group">
										<label for="user" class="label">Username</label> <input
											id="user" type="text" class="input"
											placeholder="Enter your username" name="id">
									</div>
									<div class="group">
										<label for="pass" class="label">Password</label> <input
											id="pass" type="password" class="input" data-type="password"
											placeholder="Enter your password" name="password">
									</div>
									<div class="group">
										<input id="check" type="checkbox" class="check" checked>
										<label for="check"><span class="icon"></span> Keep me
											Signed in</label>
									</div>
									<div class="group">
										<input type="submit" class="button" value="Sign In">
									</div>
									<div class="hr"></div>
									<div class="foot">
										<a href="<%=request.getContextPath() %>/forgot-password">Forgot Password?</a>
									</div>
								</div>
							</form>
							<jsp:include page="sign-up.jsp"></jsp:include>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>