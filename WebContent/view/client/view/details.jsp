<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<c:url value="/view/client/static" var="url"></c:url>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="${url }/plugin/fontawesome/css/all.css">
</head>

<body>
	<main class="container">
		<div class="row">
			<div class="col-8">
				<div class="card text-center mt-3">
					<div class="card-body">
						<div class="row p-2">
							<img width="700" height="500" alt=""
								src="<%=request.getContextPath() %>/uploads/${vDetail.poster }">
						</div>
						<div class="row p-2">
							<b>${vDetail.title }</b>
						</div>
						<div class="row p-2">
							<b>${vDetail.description }</b>
						</div>
						<c:if test="${isLogin == null }">
							<div class="card-footer text-right">
								<a
									href="<%=request.getContextPath() %>/favorite/like?vid=${vDetail.id}"
									class="btn btn-light-blue btn-primary"><i
									class="fas fa-thumbs-up">Like</i></a> <a
									href="<%=request.getContextPath() %>/share/like?vid=${vDetail.id}"
									class="btn btn-light-blue btn-success"><i
									class="fas fa-share">Share</i></a>
							</div>
						</c:if>
						<c:if test="${isLogin != null }">
							<c:forEach var="favorite" items="${listFa }">
								<c:set var="check" value="true" />
								<c:choose>
									<c:when test="${favorite.video.id == vDetail.id }">
										<c:set var="check" value="false" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${check == false }">
								<div class="card-footer text-right">
								<a
									href="<%=request.getContextPath() %>/favorite/like?vid=${vDetail.id}"
									class="btn btn-light-blue btn-danger"><i
									class="fas fa-thumbs-up">Unlike</i></a> <a
									href="<%=request.getContextPath() %>/share/like?vid=${vDetail.id}"
									class="btn btn-light-blue btn-success"><i
									class="fas fa-share">Share</i></a>
							</div>
							</c:if>
							<c:if test="${check == true }">
								<div class="card-footer text-right">
								<a
									href="<%=request.getContextPath() %>/favorite/like?vid=${vDetail.id}"
									class="btn btn-light-blue btn-primary"><i
									class="fas fa-thumbs-up">Like</i></a> <a
									href="<%=request.getContextPath() %>/share/like?vid=${vDetail.id}"
									class="btn btn-light-blue btn-success"><i
									class="fas fa-share">Share</i></a>
							</div>
							</c:if>
						</c:if>
					</div>
				</div>
			</div>

			<div class="col-4">
				<c:forEach var="video" items="${listV }">
					<div class="row mt-3 mb-3">
						<div class="col-4">
							<img
								src="<%=request.getContextPath() %>/uploads/${video.poster }"
								alt="" class="img-fluid">
						</div>
						<div class="col-10 border-left">
							<a href="<%=request.getContextPath()%>/details?id=${video.id}">${video.title }</a>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</main>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>