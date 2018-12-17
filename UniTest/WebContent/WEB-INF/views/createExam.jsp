<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UniTest - Create Exam</title>
<jsp:include page="commons/headInclude.jsp"></jsp:include>
<link rel="stylesheet" href="resources/style/examStyle.css" />
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
						<div class="examNameBox">
							<label class="questions">Name :</label> <input id="examName"
								type="text" name="examName" required />

							<div class="row">
								<div class="col-md-4 text-left">
									<label id="availableOption"> <input type="radio"
										name="isAvailable" class="custom-control-input" value="true"
										required> Exam Available<br>
									</label>
								</div>
								<div class="col-md-4 ">
									<label> <input type="radio" name="isAvailable"
										value="false" required> Not yet Available<br>
									</label>
								</div>

								<div class="col-md-4 ">
									<label> <input id="availableTime" type="number" min=0.5
										max=5 step=0.5 value=0.5> Time Available<br>
									</label>
								</div>
							</div>

							<div class="row">
								<div>
									<button class="btn btn-success" id="createExam" type="button">
										Create the exam</button>
								</div>
							</div>
							<!-- /.row -->
						</div>
						<!--  /.examNameBox -->
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
<script src="resources/js/creationExam.js"></script>
</html>