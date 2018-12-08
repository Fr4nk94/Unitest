$(document).ready(function(){
	
	var currentPage=1;
	var numberOfPage=5;
	
	
	$("#goRight").click(function() {
		
	
		if(currentPage==numberOfPage){
			$("#goRight").addClass("disabled");
			}
		else{
			
			$("#goRight").removeClass("disabled");
			
		/**
		 * removing the class active on the current Page
		 */
		
		$("#page"+currentPage).removeClass("active");
		
		
		/*
		 * refresh value of the var current page
		 */
		currentPage=(currentPage+1)%(numberOfPage+1);
		
		
		/*
		 * perform ajax request
		 * TODO
		 */
		
		
		
		
		/*
		 *Put class active to the new page selected 
		 */
		
		$("#page"+currentPage).addClass("active");
		}
		
	});
	
	
$("#goLeft").click(function() {
		
		
	if(currentPage==1){
		$("#goLeft").addClass("disabled");
		}
	else{
		$("#goLeft").removeClass("disabled");
		

		/**
		 * removing the class active on the current Page
		 */
		
		$("#page"+currentPage).removeClass("active");
		
		
		/*
		 * refresh value of the var current page
		 */
		currentPage=(currentPage-1)%(numberOfPage+1);
		
		
		/*
		 * perform ajax request
		 * TODO
		 */
		
		
		
		
		/*
		 *Put class active to the new page selected 
		 */
		
		$("#page"+currentPage).addClass("active");
	}
		
	});


$("#info").click(function(){
	
	$("#informationModal").show();
});

});