<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UniTest - Evaluate Exam</title>
<jsp:include page="commons/headInclude.jsp"></jsp:include> 

</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<jsp:include page="commons/navbar.jsp"></jsp:include>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div id="main-container" class="col-lg-12">
						<h1 class="page-header">Exams to evaluate</h1>

						<div class="panel-body prova table-responsive" id="exam-question"></div>
						<button type="button" id="premo" class="btn btn-success">Success</button>
						<br>
						<div></div>

					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>
<jsp:include page="commons/bottomInclude.jsp"></jsp:include>
<script type="text/javascript" src="resources/js/exam.js"></script>
</html>