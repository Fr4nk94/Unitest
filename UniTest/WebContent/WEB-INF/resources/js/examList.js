// BUTTON FOR THE STUDENT PART
$(document).ready(function() {
	
	updateListExam()
});


function goToExam(id) {
	console.log("function gotoexam");
	$.ajax({
		type : "POST",
		url : "goToExamDario",
		data : {
			"examID" : id,
			"startingDate" : new Date()
		},
		success : function(response) {
			console.log("success gotoexam");
			window.location.href = "./redirectExam";
		},
		error : function() {
			console.log("error gotoexam");
		}
	});
}



// BUTTON FOR THE PROFESSOR PART

function changeAvailability(id) {

	$.ajax({
		type : "POST",
		url : "changeAvailability",
		data : {
			"exam_ID" : id
		},
		success : function(result) {
			console.log("l'availability dell'esame e' "+result);
			var risp = result.split("-"); 
			
			
			if (risp[1] == "false") {
				console.log("RISP 1 FALSEEE");
				$('#avalButton-'+risp[0]).removeClass();
				$('#avalButton-'+risp[0]).addClass("btn btn-warning");
				$('#avalButton-'+risp[0]).val("make available");
			} else {
				console.log("RISP 1 TRUEEEE");
				$('#avalButton-'+risp[0]).removeClass();
				$('#avalButton-'+risp[0]).addClass("btn btn-primary");
				$('#avalButton-'+risp[0]).val("make unavailable");
			}
		},
		error : function(res) {

		}
	});
}
	
	
	

function updateListExam()
{
	setTimeout(() => {
		location.reload();
	}, 3000);
}
