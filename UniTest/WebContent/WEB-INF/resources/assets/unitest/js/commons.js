$(document).ready(function() {

	$("#logout").click(function() {
		$("#logoutModal").modal("show");
	});

	$("#yesButtonLog").click(function() {
		window.location = "logout";
	});

});