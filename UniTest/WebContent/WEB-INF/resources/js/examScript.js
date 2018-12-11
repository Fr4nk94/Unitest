$(document).ready(timer());

function submitExam() {
	var comment = $("#comment").val();
	var map = {};
	var array = [];
	$(".multipleQuestion").each(
			function() {
				map[$(this).attr("id")] = $(this).siblings(".answerList").find(
						"input:checked").val();
			});
	$(".multipleQuestionCorrect").each(function() {
		$(':checkbox:checked').each(function(i) {
			array[i] = $(this).val();
		});
		map[$(this).attr("id")] = array;
	});

	$(".openQuestion").each(
			function() {
				map[$(this).attr("id")] = $(this).siblings(".form-group").find(
						"textarea").val();
			});

	for ( var key in map) {
		// check if the property/key is defined in the object itself, not in
		// parent
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
				// window.location();
			}
		}
	});
}

function timer() {
	// Set the date we're counting down to
	var countDownDate = new Date("Dec 11, 2018 15:10:45").getTime();

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
