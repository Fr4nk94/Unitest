$(document).ready(timer());

function submitExam() {
	var comment = $("#comment").val();
	var map = {};
	// var array = [];
	$(".multipleQuestion").each(
			function() {
				map[$(this).attr("id")] = $(this).siblings(".answerList").find(
						"input:checked").val();
			});
	/*
	 * $(".multipleQuestionCorrect").each(function() { var array = [];
	 * $(':checkbox:checked').each(function(i) { array[i] = $(this).val(); });
	 * map[$(this).attr("id")] = array; });
	 */

	$(".multipleQuestionCorrect").siblings(".answerList").each(function() {
		console.log($(this).siblings(".multipleQuestionCorrect").attr("id"));
		var array = [];
		$(this).find('input:checked').each(function() {
			console.log($(this).val());
			array.push($(this).val());
		});
		map[$(this).siblings(".multipleQuestionCorrect").attr("id")] = array;
	});

	$(".openQuestion").each(
			function() {
				map[$(this).attr("id")] = $(this).siblings(".form-group").find(
						"textarea").val();
			});

	$(".attachFile").each(
			function() {
				map[$(this).attr("id")] = $(this).siblings(".form-group").find(
						"input").val();
			});
	for ( var key in map) {
		// check if the property/key is defined in the object itself, not in
		// parent
		console.log("key : " + key);
		if (map.hasOwnProperty(key)) {
			console.log(key, map[key]);
		}
	}
	var json = JSON.stringify(map);
	$.ajax({
		url : "submitExam",
		type : "POST",
		dataType : "json",
		data : {
			'json' : json,
		},
		success : function(result) {
			if (result) {
				alert("esame sottomesso");
				localStorage.clear();
				// window.location();
			}
		}
	});

}

function timer() {
	// Set the date we're counting down to
	var datona = document.getElementById("timer").innerHTML;
	var ore = document.getElementById("timeAvailable").innerHTML;
	var oreProf = ore.split(".");
	var minuti = 0;

	if (oreProf[1] == 5) {
		minuti = 30;
	}
	console.log("minuti" + minuti);
	var data = new Date(datona);
	var oo = Number(data.getHours()) + Number(oreProf[0]);
	var min = Number(data.getMinutes()) + Number(minuti);
	console.log("data javascript + ore" + oo);
	console.log("data javascript + minuti" + min);
	data.setHours(oo);
	data.setMinutes(min);

	var countDownDate = new Date(data).getTime();
	// Update the count down every 1 second
	var x = setInterval(function() {

		// Get todays date and time
		var now = new Date().getTime();

		// Find the distance between now and the count down date
		var distance = countDownDate - now;

		// Time calculations for hours, minutes and seconds

		var hours = Math.floor((distance % (1000 * 60 * 60 * 24))
				/ (1000 * 60 * 60));
		var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
		var seconds = Math.floor((distance % (1000 * 60)) / 1000);
		// Output the result in an element with id="demo"
		document.getElementById("demo").innerHTML = hours + "h " + minutes
				+ "m " + seconds + "s ";

		// If the count down is over, write some text
		if (distance < 0) {
			// clearInterval(x);
			document.getElementById("demo").innerHTML = "EXPIRED";
			// submitExam();
		}
	}, 1000);
}

window.onbeforeunload = function() {
	$(".openQuestion").each(
			function() {
				localStorage.setItem($(this).attr("id"), $(this).siblings(
						".form-group").find("textarea").val());
			});
}
window.onload = function() {
	$(".openQuestion").each(function() {
		var name = localStorage.getItem($(this).attr("id"));
		$(this).siblings(".form-group").find("textarea").val(name);
	});
}