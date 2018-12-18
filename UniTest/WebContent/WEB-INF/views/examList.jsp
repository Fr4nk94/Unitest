<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Bootstrap Admin Theme</title>

<jsp:include page="commons/headInclude.jsp"></jsp:include>


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<jsp:include page="commons/navbar.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header" style="font-family: serif;">List of
						exams</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<div id="page-navigation">
				<div class="row">
					<div class="pagination">
						<!-- <a href="#">&laquo;</a> <a href="paging?pageNumber=1">1</a> <a
							class="active" href="paging?pageNumber=2">2</a> <a
							href="paging?pageNumber=3">3</a> <a href="paging?pageNumber=4">4</a>
						<a href="paging?pageNumber=5">5</a> <a href="paging?pageNumber=6">6</a>
						<a href="paging?pageNumber=1">&raquo;</a> -->
						<c:forEach begin="1" end="${numberOfPages}" varStatus="loop">
							<a href="examList?pageNumber=${loop.index}">${loop.index}</a>
						</c:forEach>
					</div>
				</div>
			</div>
			<!--	<div id="exams-list">
				<div class="row">
					<c:set var="count" value="${0}" />
					<c:forEach var="exam" items="${page}">
						<c:choose>
							<c:when test="${count%3==0}">
								<c:set var="count" value="${count+1}" />
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-red">
											<div class="panel-heading">
												<a href="somethingBeautiful">${exam.name}</a>
											</div>
											
											<div class="panel-footer">${exam.user.fullName}</div>
										</div>
									</div>
								</div>
							</c:when>
							<c:when test="${count%3==1}">
								<c:set var="count" value="${count+1}" />
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-green">
											<div class="panel-heading">
												<a href="somethingBeautiful">${exam.name}</a>
											</div>
											<div class="panel-footer">${exam.user.fullName}</div>
										</div>
									</div>
								</div>
							</c:when>
							<c:when test="${count%3==2}">
								<c:set var="count" value="${count+1}" />
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-yellow">
											<div class="panel-heading">
												<a href="somethingBeautiful">${exam.name}</a>
											</div>
											<div class="panel-body">
												<p>Lorem ipsum dolor sit amet, consectetur adipiscing
													elit. Vestibulum tincidunt est vitae ultrices accumsan.
													Aliquam ornare lacus adipiscing, posuere lectus et,
													fringilla augue. Pippo</p>
											</div>
											<div class="panel-footer"></div>
										</div>
									</div>
								</div>
							</c:when>
						</c:choose>
					</c:forEach>
				</div>
			</div>
			 /.exams-list -->
			<table width="100%"
				class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Name</th>
						<th>Professor</th>
						<th>Start Date</th>
						<th>Available Time</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="exam" items="${page}">
						<tr examID="${ exam.examID }" class="odd gradeX">
							<td>${ exam.name }</td>
							<td>${ exam.user.fullName }</td>
							<td>${ exam.creation_date }</td>
							<td class="center">${ exam.timeAvailable }</td>
							<td class="center">
								<!-- <a type="button" class="btn btn-primary" href="exam?examId=${ exam.examID }">Start</a>-->
								<button onclick="goToExam(${ exam.examID })" type="button" class="btn btn-primary">Start</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
</body>
<jsp:include page="commons/bottomInclude.jsp"></jsp:include>
<script src="resources/js/examList.js"></script>
</html>