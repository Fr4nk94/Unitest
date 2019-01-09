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

<title>UniTest - Taken Exams</title>

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
					<h1 class="page-header" style="font-family: serif;">Taken Exams</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<table width="100%"
				class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Name</th>
						<th>Professor</th>
						<th>Start Date</th>
						<th>Score</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="exam" items="${exams}">
						<tr class="odd gradeX">
							<td>${ exam.exam.name }</td>
							<td>${ exam.user.fullName }</td>
							<td>${ exam.submission_date }</td>
							<td class="center">${ exam.student_score }</td>
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
</html>