<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Multiple Choise Answer Exam</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/assets/javascript/creationExam.js"></script>
</head>
<body>

<p>${ currentExamID }</p>


<form id="questionForm" action="examCreated" method="POST">


			Question: <input id="questionTitle" type="text" name="questionTitle" required><br>
			Correct Answer score : <input id="correctScore" type="number" name="correctScore" required><br>
			Wrong Answer score : <input id="wrongScore" type="number" name="wrongScore" required><br>


			<div class="input_fields_wrap">
			    <button id="multiple" class="add_field_button btn btn-info">Add More Answers</button>
			    <div>
			    	<input id="answer0" type="text" name="answer" required>
			    	<input id="isCorrect" type="checkbox" name="isCorrect" value="true-0"> Correct<br>
			    </div>
			</div>

		 <!--   <input id="submit" type="submit" value="Submit"> -->
		 <button id="submit" type="button">Done</button>
		  <input id="exam_ID" type="hidden" value="${ currentExamID }" name="exam_ID" />
			
		  <button id="moreMultipleChoiseQuestion" type="button">One more question</button>
</form> 



</body>
</html>