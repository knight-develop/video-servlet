<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-info bg-warning">
	<a class="navbar-brand text-danger"
		href="<%=request.getContextPath()%>/home">ONLINE ENTERTAINMENT</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="<%=request.getContextPath()%>/favorite">MY FAVORITE <span
					class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> MY ACCOUNT </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<c:if test="${isLogin == null }">
						<a class="dropdown-item"
							href="<%=request.getContextPath()%>/login">Login</a>
						<a class="dropdown-item"
							href="<%=request.getContextPath()%>/login"> Registration</a>
					</c:if>

					<div class="dropdown-divider"></div>
					<c:if test="${isLogin != null }">
						<a class="dropdown-item"
							href="<%=request.getContextPath()%>/logoff">Logoff</a>
						<a class="dropdown-item"
							href="<%=request.getContextPath()%>/forgot-password">Forgot
							Password</a>
						<a class="dropdown-item"
							href="<%=request.getContextPath()%>/change-password">Change
							Password</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item"
							href="<%=request.getContextPath()%>/edit-profile">Edit
							Profile</a>
					</c:if>

				</div></li>
		</ul>
	</div>
</nav>