<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="commons/headInclude.jsp"></jsp:include>
<link rel="stylesheet" href="resources/style/examStyle.css" />
<title>Exam</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="privew">
		<p id="timer">${timer}</p>
		<c:set var="count" value="0" scope="page" />
		<c:set var="dario" value="0" scope="page" />
		<c:forEach items="${questions}" var="element">
			<c:set var="count" value="${count + 1}" scope="page" />
			<c:choose>
				<c:when test="${element.type=='SINGLE_CHOICE' }">
					<div class="questionsBox">
						<div class="questions multipleQuestion" id="${dario}">
							<c:out value="${element.question_body}"></c:out>
						</div>
						<div class="answerList">
							<c:forEach var="i" begin="0"
								end="${fn:length(element.answers)-1}">

								<label> <input type="radio" name="answerG${dario}"
									value="${element.answers[i].answer_body}"> <c:out
										value="${element.answers[i].answer_body}"></c:out>
								</label>

							</c:forEach>
						</div>
						<div class="questionsRow">
							<!--  	<button class="button" id="backquestions">Back</button>
							<button class="button" id="nextquestions">Next</button> -->
							<span>${count} of <c:out value="${totQuestions}"></c:out>
							</span>
						</div>
					</div>
				</c:when>
				<c:when test="${element.type=='OPEN_ANSWER' }">
					<div class="questionsBox">
						<div class="questions openQuestion" id="${dario}">
							<c:out value="${element.question_body}"></c:out>
						</div>
						<div class="form-group">
							<label for="comment">Answer:</label>
							<textarea class="form-control" rows="5" id="comment"></textarea>
						</div>
						<div class="questionsRow">
							<!-- 	<button class="button" id="backquestions">Back</button>
							<button class="button" id="nextquestions">Next</button> -->
							<span>${count} of <c:out value="${totQuestions}"></c:out>
							</span>
						</div>
					</div>
				</c:when>
				<c:when test="${element.type=='ATTACH_FILE' }">
					<div class="questionsBox">
						<div class="questions attachFile" id="${dario}">
							<c:out value="${element.question_body}"></c:out>
						</div>
						<div class="form-group">
							<label for="comment">Answer:</label> <input type="file"
								name="pic"></input>
						</div>
						<div class="questionsRow">
							<!-- 	<button class="button" id="backquestions">Back</button>
							<button class="button" id="nextquestions">Next</button> -->
							<span>${count} of <c:out value="${totQuestions}"></c:out>
							</span>
						</div>
					</div>
				</c:when>
				<c:when test="${element.type=='MULTIPLE_CHOICE' }">
					<div class="questionsBox">
						<div class="questions multipleQuestionCorrect" id="${dario}">
							<c:out value="${element.question_body}"></c:out>
						</div>
						<div class="answerList">
							<c:forEach var="i" begin="0"
								end="${fn:length(element.answers)-1}">

								<label> <input type="checkbox" name="answerG${dario}"
									value="${element.answers[i].answer_body}"> <c:out
										value="${element.answers[i].answer_body}"></c:out>
								</label>

							</c:forEach>
						</div>
						<div class="questionsRow">
							<!-- 	<button class="button" id="backquestions">Back</button>
							<button class="button" id="nextquestions">Next</button> -->
							<span>${count} of <c:out value="${totQuestions}"></c:out>
							</span>
						</div>
					</div>
				</c:when>
			</c:choose>
			<c:set var="dario" value="${dario + 1}" scope="page" />
		</c:forEach>
		<div id="divSubmit">
			<button id="buttonSubmit" type="button" data-toggle="modal"
				data-target="#myModal" class="btn btn-success">Submit Exam</button>


			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Are you sure to submit the exam?</h4>
						</div>
						<div class="modal-body">
							<p>Sei sicuro</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-success"
								data-dismiss="modal" onclick="submitExam()">Yes</button>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>

						</div>
					</div>

				</div>
			</div>

			<div class="alert" role="alert" id="result"></div>
		</div>
	</div>
</body>
<jsp:include page="commons/bottomInclude.jsp"></jsp:include>
<script src="resources/js/examScript.js"></script>
</html>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="commons/headInclude.jsp"></jsp:include>
<link rel="stylesheet" href="resources/style/examStyle.css" />
<title>Exam</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="privew">
		<p id="timer">${timer}</p>
		<c:set var="count" value="0" scope="page" />
		<c:set var="dario" value="0" scope="page" />
		<c:forEach items="${questions}" var="element">
			<c:set var="count" value="${count + 1}" scope="page" />
			<c:choose>
				<c:when test="${element.type=='SINGLE_CHOICE' }">
					<div class="questionsBox">
						<div class="questions multipleQuestion" id="${element.questionID}">
							<c:out value="${element.question_body}"></c:out>
						</div>
						<div class="answerList">
							<c:forEach var="i" begin="0"
								end="${fn:length(element.answers)-1}">

								<label> <input type="radio" name="answerG${element.questionID}"
									value="${element.answers[i].answer_body}"> <c:out
										value="${element.answers[i].answer_body}"></c:out>
								</label>

							</c:forEach>
						</div>
						<div class="questionsRow">
							<!--  	<button class="button" id="backquestions">Back</button>
							<button class="button" id="nextquestions">Next</button> -->
							<span>${count} of <c:out value="${totQuestions}"></c:out>
							</span>
						</div>
					</div>
				</c:when>
				<c:when test="${element.type=='OPEN_ANSWER' }">
					<div class="questionsBox">
						<div class="questions openQuestion" id="${element.questionID}">
							<c:out value="${element.question_body}"></c:out>
						</div>
						<div class="form-group">
							<label for="comment">Answer:</label>
							<textarea class="form-control" rows="5" id="comment"></textarea>
						</div>
						<div class="questionsRow">
							<!-- 	<button class="button" id="backquestions">Back</button>
							<button class="button" id="nextquestions">Next</button> -->
							<span>${count} of <c:out value="${totQuestions}"></c:out>
							</span>
						</div>
					</div>
				</c:when>
				<c:when test="${element.type=='ATTACH_FILE' }">
					<div class="questionsBox">
						<div class="questions attachFile" id="${element.questionID}">
							<c:out value="${element.question_body}"></c:out>
						</div>
						<div class="form-group">
							<label for="comment">Answer:</label> <input type="file"
								name="pic"></input>
						</div>
						<div class="questionsRow">
							<!-- 	<button class="button" id="backquestions">Back</button>
							<button class="button" id="nextquestions">Next</button> -->
							<span>${count} of <c:out value="${totQuestions}"></c:out>
							</span>
						</div>
					</div>
				</c:when>
				<c:when test="${element.type=='MULTIPLE_CHOICE' }">
					<div class="questionsBox">
						<div class="questions multipleQuestionCorrect" id="${element.questionID}">
							<c:out value="${element.question_body}"></c:out>
						</div>
						<div class="answerList">
							<c:forEach var="i" begin="0"
								end="${fn:length(element.answers)-1}">

								<label> <input type="checkbox" name="answerG${element.questionID}"
									value="${element.answers[i].answer_body}"> <c:out
										value="${element.answers[i].answer_body}"></c:out>
								</label>

							</c:forEach>
						</div>
						<div class="questionsRow">
							<!-- 	<button class="button" id="backquestions">Back</button>
							<button class="button" id="nextquestions">Next</button> -->
							<span>${count} of <c:out value="${totQuestions}"></c:out>
							</span>
						</div>
					</div>
				</c:when>
			</c:choose>
			
		</c:forEach>
		<div id="divSubmit">
			<button id="buttonSubmit" type="button" data-toggle="modal"
				data-target="#myModal" class="btn btn-success">Submit Exam</button>


			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Are you sure to submit the exam?</h4>
						</div>
						<div class="modal-body">
							<p>Sei sicuro</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-success"
								data-dismiss="modal" onclick="submitExam()">Yes</button>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>

						</div>
					</div>

				</div>
			</div>

			<div class="alert" role="alert" id="result"></div>
		</div>
	</div>
</body>
<jsp:include page="commons/bottomInclude.jsp"></jsp:include>
<script src="resources/js/examScript.js"></script>
</html>


>>>>>>> refs/remotes/origin/master
