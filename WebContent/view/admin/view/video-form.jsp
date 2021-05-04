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
					href="#videoEdit" role="tab" aria-controls="videoEdit"
					aria-selected="true">Video Editting</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
					aria-controls="videoList" aria-selected="false">Video List</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="videoEdit"
					role="tabpanel" aria-labelledby="videoEdit-tab">
					<form action="" method="post" enctype="multipart/form-data">
						<div class="card">
							<div class="card-body">
								<jsp:include page="logger.jsp"></jsp:include>
								<div class="row">
									<div class="col-3">
										<div class="border p-3">
											<c:if test="${video.poster != null }">
												<img
													src="<%=request.getContextPath() %>/uploads/${video.poster }"
													alt="" class=" img-fluid">
											</c:if>
											<c:if test="${video.poster == null }">
												<img src="/Assignment/images/desktop.png" alt=""
													class=" img-fluid">
											</c:if>
											<div class="input-group mb-3 mt-3">
												<div class="input-group-prepend">
													<span class="input-group-text">Upload</span>
												</div>
												<div class="custom-file">
													<input type="file" class="custom-file-input" id="cover"
														name="cover"> <label for="">Choose File</label>
												</div>
											</div>
										</div>
									</div>
									<div class="col-9">
										.
										<div class="form-group">
											<label for="youtubeID">Youtube ID</label> <input type="text"
												class="form-control" name="id" id="youtubeID"
												aria-describedby="youtubeID" placeholder="Youtube ID"
												value="${video.id }" ${read }> <small id="youtubeID"
												class="form-text text-muted">Youtube id is required</small>
										</div>
										<div class="form-group">
											<label for="videoTitle">Video Title</label> <input
												type="text" class="form-control" name="title"
												id="videoTitle" aria-describedby="videoTitle"
												placeholder="Video Title" value="${video.title }"> <small
												id="videoTitle" class="form-text text-muted">Video
												title is requird</small>
										</div>
										<div class="form-group">
											<label for="viewCount">View count</label> <input type="text"
												class="form-control" name="views" id="views"
												aria-describedby="viewCountHid" placeholder="View Count"
												value="${video.views }"> <small id="viewCountHid"
												class="form-text text-muted">View Count is requird</small>
										</div>
										<div class="form-check form-check-inline">
											<label><input type="radio" class="form-check-input"
												name="active" id="status" value="true"
												${video.active ?'checked':""}>Active &nbsp; </label> <label><input
												type="radio" class="form-check-input" name="active"
												id="status" value="false" ${!video.active ?'checked':"" }>Inactive
											</label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col">
										<label for="description">Description</label>
										<textarea name="description" id="description" cols="30"
											rows="4" class="form-control">${video.description  }</textarea>
									</div>
								</div>
							</div>
							<div class="card-footer text-muted">
								<button class="btn btn-primary"
									formaction="<%=request.getContextPath()%>/admin/video/create" ${reset == 1 ?'disabled="disabled"':'' }>Create</button>
								<button class="btn btn-warning"
									formaction="<%=request.getContextPath()%>/admin/video/update" ${reset == 0 ?'disabled="disabled"':'' }>Update</button>
								<button class="btn btn-danger"
									formaction="<%=request.getContextPath()%>/admin/video/delete" ${reset == 0 ?'disabled="disabled"':'' }>Delete</button>
								<button class="btn btn-info"
									formaction="<%=request.getContextPath()%>/admin/video/reset">Reset</button>
							</div>
						</div>
					</form>
				</div>
				<div class="tab-pane fade" id="videoList" role="tabpanel"
					aria-labelledby="videoList-tab">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>Title</th>
								<th>Views</th>
								<th>Status</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="video" items="${listVi }">
								<tr>
									<td>${video.id }</td>
									<td>${video.title }</td>
									<td>${video.views }</td>
									<td>${video.active ? 'active':'inactive' }</td>
									<td><a
										href="<%=request.getContextPath()%>/admin/video/edit?id=<c:out value='${video.id}' />"
										class="edit"> <i class="material-icons" title="Edit">&#xE254;
										</i>
									</a> <a
										href="<%=request.getContextPath()%>/admin/video/delete?id=<c:out value='${video.id}' />"
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