<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Open Answer Exam</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/assets/javascript/creationExam.js"></script>
</head>
<body>

<p>${ currentExamID }</p>

<script>
var questionID = 0;

function oneMoreQuestion(){
	questionID++;
	var parent = document.getElementById("questionForm");
	var element = document.createElement("DIV");
	element.setAttribute("id", questionID);
	parent.appendChild(element);
	document.getElementById(questionID).innerHTML =
		
		"Question: <input type='text' name='questionTitle' required><br>"+
		"Max score : <input type='number' name='maxScore' required><br>"
		
	;	
	
}

</script>



<form id="OpenQuestionForm" action="examCreated" method="POST">
			Question: <input id="questionTitle" type="text" name="questionTitle" required><br>
			Max score : <input id="maxScore" type="number" name="maxScore" required><br>
		  
		  <button id="submit" type="button">Done</button>
		  <input id="exam_ID" type="hidden" value="${ currentExamID }" name="exam_ID" />
		
		  <button id="moreOpenAnswerQuestion" type="button">One more question</button>
</form> 


</body>
</html>