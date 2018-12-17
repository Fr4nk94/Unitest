var sum = 0;
var idExam;
function showExam() {
	$
			.ajax({
				type : "GET",
				url : "showExam",
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				success : function(data) {

					console.log(data);
					var str = "";
					var tmp = "";
					idExam = data.idExam;
					// var sum = 0;
					var questions = data.questions;
					console.log("QUESTION " + questions);
					for ( var i in questions) {
						var answers = questions[i].answers;
						var question = questions[i];
						console.log(i);

						// str += "<table width=\"100%\"class=\"table
						// table-striped table-bordered table-hover\"
						// id=\"dataTables-example\"><thead><tr><th>Question</th><th>Score</th></tr></thead><tbody><tr
						// class=\"odd gradeX\"><td>"
						// + questions[i].name
						// + "</td><td class=\"center\"><input id=\"\"
						// type=\"number\" min=\"0\" max="
						// + questions[i].score + "></td></tr></tbody>";

						var ta = $("<table width=\"100%\"class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\">");
						ta
								.append($("<thead><tr><th>Question</th><th>Score</th></tr></thead>"));
						var tb = $("<tbody></tbody>");
						ta.append(tb);
						tb.append("<tr class=\"odd gradeX\"></tr>");
						tb.find("tr").append(
								"<td>" + questions[i].name + "</td>")
						var input = $("<input id='q" + i
								+ "' type=\"number\" min=\"0\" max="
								+ questions[i].score
								+ " onChange='changeInput("
								+ questions[i].score + "," + "q" + i + ")'>");
						//						
						//						
						tb.find("tr").append(
								$("<td class=\"center\"></td>").append(input));

						for ( var j in answers) {

							ta
									.append("<thead><tr><th>Answer</th></tr></thead><tr class=\"odd gradeX\"><tbody><td>"
											+ answers[j].answer
											+ "</td><td class=\"center\"></td></tr></tbody></table>");

						}
						$("#exam-question").append(ta);
					}

					$("#premo").click(function() {
						$(".table").each(function() {
							sum += Number($(this).find('input').val());
						});
						setScore();
						sum = 0;
					});
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

function setScore() {
	console.log("Sommo " + sum);
	$.ajax({
		type : "GET",
		url : "setScore",
		data : {
			"totalScore" : sum,
			"idExam" : idExam
		},
		success : function(data) {
			window.location.href = "./";
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

function changeInput(score, id) {

	var value = $(id).val();
	console.log(score);

	if ((value !== '') && (value.indexOf('.') === -1)) {

		$(id).val(Math.max(Math.min(value, score), 0));
	}
}

$(document).ready(function() {
	console.log("doc ready");
	showExam();
});