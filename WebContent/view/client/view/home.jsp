<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/view/client/static" var="url"></c:url>
<link rel="stylesheet" href="${url }/css/home.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${url }/plugin/fontawesome/css/all.css">
<style type="text/css">
.pagination {
	display: inline-block;
	float: right;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}
</style>
</head>
<body>
	<jsp:include page="../../layout/header.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<!-- Card deck -->
		<form action="" method="post">
			<div class="card-deck row">
				<c:forEach var="video" items="${listVi }">
					<c:set var="check" value="true" />
					<div class="col-xs-12 col-sm-6 col-md-4">
						<!-- Card -->
						<div class="card">
							<!--Card image-->
							<div class="view overlay">
								<a href="<%=request.getContextPath()%>/details?id=${video.id}">
									<img class="card-img-top"
									src="<%=request.getContextPath() %>/uploads/${video.poster }"
									alt="Card image cap">
								</a>

							</div>
							<!--Card content-->
							<div class="card-body">

								<!--Title-->
								<h4 class="card-title">${video.title }</h4>
								<!--Text-->
								<p class="card-text">Some quick example text to build on the
									card title and make up the bulk of the card's content.</p>
								<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
								<c:if test="${isLogin == null }">
									<button type="submit" class="btn btn-light-blue btn-primary"
										formaction="<%=request.getContextPath() %>/favorite/like?vid=${video.id}">
										<i class="fas fa-thumbs-up">Like</i>
									</button>
								</c:if>
								<c:if test="${isLogin != null }">
									<c:forEach var="favorite" items="${listFa }">
										<c:choose>
											<c:when test="${favorite.video.id == video.id }">
												<c:set var="check" value="false" />
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:if test="${check == false }">
										<button type="submit" class="btn btn-light-blue btn-danger"
											formaction="<%=request.getContextPath() %>/favorite/unlike?vid=${video.id}">
											<i class="fas fa-thumbs-up">Unlike</i>
										</button>
									</c:if>
									<c:if test="${check == true }">
										<button type="submit" class="btn btn-light-blue btn-primary" 
											formaction="<%=request.getContextPath() %>/favorite/like?vid=${video.id}">
											<i class="fas fa-thumbs-up">Like</i>
										</button>
									</c:if>
								</c:if>


								<a href="<%=request.getContextPath() %>/share?vid=${video.id}"
									class="btn btn-light-blue btn-success" style="float: right;"><i
									class="fas fa-share" >Share</i> </a>
							</div>
						</div>
						<!-- Card -->
					</div>
				</c:forEach>

			</div>
			<!-- Card deck -->
		</form>
		<div class="pagination">
			<c:forEach begin="1" end="${endpage }" var="i">
				<a href="<%=request.getContextPath() %>/home?page=${i }">${i }</a>
			</c:forEach>
		</div>
	</div>

</body>
</html>
