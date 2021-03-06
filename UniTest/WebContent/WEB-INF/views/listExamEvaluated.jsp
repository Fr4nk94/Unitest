<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>UniTest - Evaluated Exams</title>
<jsp:include page="commons/headInclude.jsp"></jsp:include>
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}"
</script>
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

						<h1 class="page-header">Evaluated Exams</h1>
						<div class="row">
							<div class="col-md-12">
								<table width="100%"
									class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>Exam Name</th>
											<th>Student Name</th>
											<th>Score</th>
											<th>Exam Date</th>
										</tr>
									</thead>
									<tbody id="examEvaulated-container">
	
									</tbody>
								</table>
							</div>
						</div>
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
<script type="text/javascript" src="resources/js/professor.js"></script>
</html>