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

function updateListExam()
{
	setTimeout(() => {
		location.reload();
	}, 3000);
}
