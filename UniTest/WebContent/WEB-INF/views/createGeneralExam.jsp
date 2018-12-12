<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Exam</title>
</head>
<body>

<form method="POST" action="createGeneralExam">
	Name : <input type="text" name="examName" required/>
	 <select name="examType">
		  <option value="OPEN_ANSWER" >Open Answer</option>
		  <option value="MULTIPLE_CHOISE" >Multiple Choise</option>
		  <option value="SINGLE_CHOISE" >Single Choise</option>
		  <!-- <option value="MIXED">Mixed</option> -->
	</select> 

<label>
 	<input type="radio" name="isAvailable" value="true" required> Exam Available<br>
 	<input type="radio" name="isAvailable" value="false" required> Not yet Available<br>
 </label>


<button type="submit"> Create the exam </button>
</form>

</body>
</html>