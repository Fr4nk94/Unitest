function addExamButton() {
	console.log("add button exam");
	$("#main-container")
			.append(
					"<button id=\"submit-exam\" type=\"button\" class=\"btn btn-primary\">Test Exam</button>");
	$("#main-container")
			.append(
					"<button id=\"list-exam\" type=\"button\" class=\"btn btn-primary\">List Exam</button>");
	$("#list-exam").on("click", function() {
		$.ajax({
			type : "GET",
			url : "listExam",
			success : function(data) {
				console.log("ajax success");
				console.log(data);
			},
			error : function(jqXHR, exception) {
				console.log("ERRORE ListExam");
				var msg = '';
				if (jqXHR.status === 0) {
					msg = 'Not connect.\n Verify Network.';
				} else if (jqXHR.status == 404) {
					msg = 'Requested page not found. [404]';
				} else if (jqXHR.status == 500) {
					msg = 'Internal Server Error [500].';
				} else if (exception === 'parsererror') {
					msg = 'Requested JSON parse failed.';
				} else if (exception === 'timeout') {
					msg = 'Time out error.';
				} else if (exception === 'abort') {
					msg = 'Ajax request aborted.';
				} else {
					msg = 'Uncaught Error.\n' + jqXHR.responseText;
				}
				console.log(msg);
			}
		});
	});
	$("#submit-exam").on("click", function() {
		console.log("calling ajax to save exam test");
		$.ajax({
			type : "GET",
			url : "saveExam",
			success : function(data) {
				console.log("ajax success");
				console.log(data);
			},
			error : function(jqXHR, exception) {
				console.log("ERRORE GetExam");
				var msg = '';
				if (jqXHR.status === 0) {
					msg = 'Not connect.\n Verify Network.';
				} else if (jqXHR.status == 404) {
					msg = 'Requested page not found. [404]';
				} else if (jqXHR.status == 500) {
					msg = 'Internal Server Error [500].';
				} else if (exception === 'parsererror') {
					msg = 'Requested JSON parse failed.';
				} else if (exception === 'timeout') {
					msg = 'Time out error.';
				} else if (exception === 'abort') {
					msg = 'Ajax request aborted.';
				} else {
					msg = 'Uncaught Error.\n' + jqXHR.responseText;
				}
				console.log(msg);
			}
		});
	});
}

$(document).ready(function() {
	addExamButton();
});