<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/view/admin/static/css/video-form.css">
</head>

<body>
	<jsp:include page="home.jsp"></jsp:include>
	<main class="container-fluid">

		<section>
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item" role="presentation"><a
					class="nav-link active" id="videoEdit-tab" data-toggle="tab"
					href="#videoEdit" role="tab" aria-controls="videoEdit"
					aria-selected="true">User Editting</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
					aria-controls="videoList" aria-selected="false">User List</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="videoEdit"
					role="tabpanel" aria-labelledby="videoEdit-tab">
					<form action="" method="post" enctype="multipart/form-data">
						<div class="card">
							<div class="card-body">
								<jsp:include page="logger.jsp"></jsp:include>
								<div class="row">
									<div class="col-9">
										<div class="form-group">
											<label for="youtubeID">Username</label> <input type="text"
												class="form-control" name="id" id="youtubeID"
												aria-describedby="youtubeID" placeholder="Username"
												value="${user.id }" ${read }> <small id="youtubeID"
												class="form-text text-muted">Username is requird</small>
										</div>
										<div class="form-group">
											<label for="youtubeID">Password</label> <input type="text"
												class="form-control" name="password" id="password"
												aria-describedby="youtubeID" placeholder="Password"
												value="${user.password }"> <small id="youtubeID"
												class="form-text text-muted">Password is requird</small>
										</div>
										<div class="form-group">
											<label for="videoTitle">Email</label> <input type="text"
												class="form-control" name="email" id=""emails""
												aria-describedby="videoTitle" placeholder="Email"
												value="${user.email }"> <small id="videoTitle"
												class="form-text text-muted">Email is requird</small>
										</div>
										<div class="form-group">
											<label for="viewCount">FullName</label> <input type="text"
												class="form-control" name="fullName" id="fullName"
												aria-describedby="fullName" placeholder="FullName"
												value="${user.fullName }"> <small id="viewCountHid"
												class="form-text text-muted">FullName is requird</small>
										</div>
										<div class="form-check form-check-inline">
											<label><input type="radio" class="form-check-input"
												name="admin" id="status" value="true"
												${user.admin ?'checked':""}>Admin &nbsp; </label> <label><input
												type="radio" class="form-check-input" name="admin"
												id="status" value="false" ${!user.admin ?'checked':"" }>User
											</label>
										</div>
									</div>
								</div>
							</div>
							<div class="card-footer text-muted">
								<button class="btn btn-warning"
									formaction="<%=request.getContextPath()%>/admin/user/update" ${reset == 0 ?'disabled="disabled"':'' } >Update</button>
								<button class="btn btn-danger"
									formaction="<%=request.getContextPath()%>/admin/user/delete" ${reset == 0 ?'disabled="disabled"':'' }>Delete</button>
								<button class="btn btn-info"
									formaction="<%=request.getContextPath()%>/admin/user/reset">Reset</button>
							</div>
						</div>
					</form>
				</div>
				<div class="tab-pane fade" id="videoList" role="tabpanel"
					aria-labelledby="videoList-tab">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Username</th>
								<th>Password</th>
								<th>Email</th>
								<th>Fullname</th>
								<th>Status</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${listUs }">
								<tr>
									<td>${user.id }</td>
									<td>${user.password }</td>
									<td>${user.email }</td>
									<td>${user.fullName }</td>
									<td>${user.admin ? 'Admin':'User' }</td>
									<td><a
										href="<%=request.getContextPath()%>/admin/user/edit?id=<c:out value='${user.id}' />"
										class="edit"> <i class="material-icons" title="Edit">&#xE254;
										</i>
									</a> <a
										href="<%=request.getContextPath()%>/admin/user/delete?id=<c:out value='${user.id}' />"
										class="delete"><i class="material-icons" title="Delete">&#xE872;</i></a>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</section>
		<footer class="row"></footer>
	</main>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script>
		$('#myTab a').on('click', function(event) {
			event.preventDefault()
			$(this).tab('show')
		})
	</script>
</body>

</html>