<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Your Exam</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/creationExam.js"></script>
</head>
<body>

<p>${ currentExamID }</p>

<form id="questionForm" action="examCreated" method="POST">


			Question: <input id="questionTitle" type="text" name="questionTitle" required><br>
			
		<select id="questionType" name="questionType">
		  <option value="OPEN_ANSWER" >Open Answer</option>
		  <option value="MULTIPLE_CHOICE" >Multiple Choice</option>
		  <option value="SINGLE_CHOICE" >Single Choice</option>
		</select> 
	
			
			
			Correct Answer score : <input id="correctScore" type="number" name="correctScore" required><br>
			<label id="wrong">Wrong Answer score : <input id="wrongScore" type="number" name="wrongScore" required><br></label>


			<div class="input_fields_wrap">
			    <button id="multiple" class="add_field_button btn btn-info">Add More Answers</button>
			    <div>
			    	<input id="answer0" type="text" name="answer" required>
			    	<input id="isCorrect" name="isCorrect" value="true-0"> Correct<br>
			    </div>
			</div>

		 <!--   <input id="submit" type="submit" value="Submit"> -->
		 <button id="submit" >Done</button>
		  <input id="exam_ID" type="hidden" value="${ currentExamID }" name="exam_ID" />
			
		  <button id="oneMoreQuestion" type="button">One more question</button>
</form> 



</body>
</html>