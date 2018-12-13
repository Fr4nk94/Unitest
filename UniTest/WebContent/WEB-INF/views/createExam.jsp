<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Exam</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/creationExam.js"></script>
</head>
<body>

	Name : <input id="examName" type="text" name="examName" required/>

<label id="availableOption">
 	<input type="radio" name="isAvailable" value="true" required> Exam Available<br>
 	<input type="radio" name="isAvailable" value="false" required> Not yet Available<br>
 </label>


<button id="createExam" type="button"> Create the exam </button>

</body>
</html>