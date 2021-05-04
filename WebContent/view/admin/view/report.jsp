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
	href="<%=request.getContextPath()%>/view/admin/static/css/video-form.css">
</head>

<body>
	<jsp:include page="home.jsp"></jsp:include>
	<main class="container-fluid">

		<section>
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item" role="presentation"><a
					class="nav-link active" id="videoEdit-tab" data-toggle="tab"
					href="#Favorite" role="tab" aria-controls="Favorite"
					aria-selected="true">Favorite</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="videoList-tab" data-toggle="tab" href="#FavoriteUser"
					role="tab" aria-controls="videoList" aria-selected="false">Favorite
						Users</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="videoList-tab" data-toggle="tab" href="#Share" role="tab"
					aria-controls="videoList" aria-selected="false">Share Friends</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="Favorite" role="tabpanel"
					aria-labelledby="videoEdit-tab">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>VideoTitle</th>
								<th>Favorite Count</th>
								<th>Lastest Date</th>
								<th>Oldest Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="fr" items="${listFR }">
								<tr>
									<td>${fr.videoTitle }</td>
									<td>${fr.favoriteCount }</td>
									<td>${fr.newestDate }</td>
									<td>${fr.oldestDate }</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<div class="tab-pane fade" id="FavoriteUser" role="tabpanel"
					aria-labelledby="videoList-tab">
					<form action="" method="get">
						<div class="row mt-3">
							<div class="col">
								<div class="form-inline">
									<div class="form-group">
										<label>Video Title
											<select name="videoUserId" class="form-control ml-3">
												<c:forEach var="item" items="${listVi }">
													<option value="${item.id }" ${item.id == videoUserId ? 'selected':'' }
													>${item.title }</option>
												</c:forEach>
											</select>
										</label>
										<button formaction="<%=request.getContextPath()%>/admin/report" class="btn btn-primary">Report</button>
									</div>
								</div>
							</div>
						</div>
					</form>
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Username</th>
								<th>Fullname</th>
								<th>Email</th>
								<th>likeDate</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="fu" items="${listFU }">
								<tr>
									<td>${fu.userId }</td>
									<td>${fu.fullName }</td>
									<td>${fu.emails }</td>
									<td>${fu.likeDate }</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<div class="tab-pane fade" id="Share" role="tabpanel"
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