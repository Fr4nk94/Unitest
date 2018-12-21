function goToExam() {

	console.log("IDDDI " + tmp);
	$.ajax({
		type : "GET",
		url : "checkExam",
		async : false,
		data : {
			"idExam" : tmp
		},
		success : function(data) {
			window.location.href = "./goToExam";
		},
		error : function(jqXHR, exception) {
			console.log("ERRORE");
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
}

function showList() {
	$
			.ajax({
				type : "POST",
				url : "listExams",
				dataType : 'json',
				data : {
					"evaluate" : "false"
				},
				success : function(data) {
					console.log("Show list");
					console.log(data);
					var str = "";
					for ( var o in data) {
						var date = data[o].dateExam;
						var score = data[o].scoreExam;
						if (score == null) {
							score = 0;
						}
						var nameExam = data[o].nameExam;
						var questions = data[o].listQuestion;
						var answers = data[o].listAnswer;
						var currentExam = data[o].idExam;
						var student = data[o].user;
						str += "<tr class=\"odd gradeX\"><td id="
								+ currentExam
								+ ">"
								+ nameExam
								+ "</td><td>"+student+"</td><td>"
								+ score
								+ "</td><td class=\"center\">"
								+ date
								+ "</td><td><button id="
								+ currentExam
								+ " type=\"button\" class=\"buttonExam btn btn-primary\">Check</button></td></tr>";

					}
					$("#exam-container").html(str);
					$(".buttonExam").click(clickButton);
				},
				error : function(jqXHR, exception) {
					console.log("ERRORE");
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
}

function showListEvaluated() {
	$.ajax({
		type : "POST",
		url : "listExams",
		dataType : 'json',
		data : {
			"evaluate" : "true"
		},
		success : function(data) {
			console.log("Show list");
			console.log(data);
			var str = "";
			for ( var o in data) {
				var date = data[o].dateExam;
				var score = data[o].scoreExam;
				if (score == null) {
					score = 0;
				}
				var nameExam = data[o].nameExam;
				var questions = data[o].listQuestion;
				var answers = data[o].listAnswer;
				var currentExam = data[o].idExam;
				str += "<tr class=\"odd gradeX\"><td id=" + currentExam + ">"
						+ nameExam
						+ "</td><td>Nome Studente quando arriva</td><td>"
						+ score + "</td><td class=\"center\">" + date
						+ "</td></tr>";

			}
			$("#examEvaulated-container").html(str);
		},
		error : function(jqXHR, exception) {
			console.log("ERRORE");
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
}

function clickButton(e) {

	tmp = $(this).attr("id");
	console.log("ffffffffffffffffffffffffffffffffffffff");
	goToExam();
	e.stopPropagation();
	e.preventDefault();
}

$(document).ready(function() {
	console.log("doc ready");
	var aux = $("#exam-container");
	if(aux.length>0){
		showList();
	}else{
		showListEvaluated();
	}
	
});