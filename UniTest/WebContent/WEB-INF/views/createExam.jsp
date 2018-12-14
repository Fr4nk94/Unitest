<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Exam</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/style/examStyle.css" />
<script src="resources/js/creationExam.js"></script>

</head>
<body>

<jsp:include page="navbar.jsp" />

<div class="questionsBox">	
			<label class="questions">Name :</label>
			 <input class="insertQuestionsRow insertQuestionsBox"  id="examName" type="text" name="examName" required/>
		
		<label id="availableOption">
		 	<input type="radio" name="isAvailable" value="true" required> Exam Available<br>
		 	</label>
		 	<label>
		 	<input type="radio" name="isAvailable" value="false" required> Not yet Available<br>
		 </label>
		
		
		<button class="button btn" id="createExam" type="button"> Create the exam </button>
</div>
</body>
</html>