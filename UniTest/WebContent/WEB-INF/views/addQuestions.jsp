<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Your Exam</title>
<jsp:include page="commons/headInclude.jsp"></jsp:include>
<link rel="stylesheet" href="resources/style/examStyle.css" />


<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"
	crossorigin="anonymous">

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
						<div class="privew">



							<form id="questionForm">


								<div class="questionsBox">
									<label class="questions">Question:</label>

									<textarea class="insertQuestionsRow insertQuestionsBox"
										id="questionTitle" type="text" name="questionTitle" required></textarea>
									<br> <select class="btn secondary dropdown-toggle"
										id="questionType" name="questionType">
										<option value="OPEN_ANSWER">Open Answer</option>
										<option value="MULTIPLE_CHOICE">Multiple Choice</option>
										<option value="SINGLE_CHOICE">Single Choice</option>
										<option value="ATTACH_FILE">Attach File</option>
									</select> <label>Correct Answer score : <input id="correctScore"
										type="number" name="correctScore" required><br>
									</label> <label id="wrong">Wrong Answer score : <input
										id="wrongScore" type="number" name="wrongScore" required><br>
									</label>


									<div class="input_fields_wrap">
										<button id="multiple" class="add_field_button btn btn-info">Add
											More Answers</button>
										<div>
											<input class="answerInput" id="answer0" type="text" name="answer" required>
											<input id="isCorrect" name="isCorrect" value="true-0">
											Correct<br>
										</div>
									</div>

									<button class="btn btn-success" id="done">Done</button>
									<input id="exam_ID" type="hidden" value="${ currentExamID }"
										name="exam_ID" />

									<button class="btn btn-info" id="oneMoreQuestion" type="button">One
										more question</button>

								</div>

							</form>



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
<script src="resources/js/creationExam.js"></script>
</html>