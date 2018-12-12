$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    
    var x = 0; //initlal text box count
    $(add_button).on("click",function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            
            var type = e.target.id == "single" ? "radio" : "checkbox";
            
            
            $(wrapper).append('<div id="moreAnswer">'+
            '<input id="answer'+x+'" type="text" name="answer" required/>'+
            '<a href="#" class="remove_field">Remove</a>'+
            '<input id="isCorrect" type="'+type+'" name="isCorrect" value="true-'+x+'"> Correct<br>'+
            '</div>'); //add input box
        }
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
      
    
    
    
    $("#moreSingleChoiseQuestion").on("click", function(){
		var questionTitle = $("#questionTitle").val();
		var exam_ID = $("#exam_ID").val();
		var correctScore = $("#correctScore").val();
		var wrongScore = $("#wrongScore").val();
		var answer ="";

		for(var i=0; i<= x;i++){
			answer += $("#answer"+i).val();
			
			if(i != x)
				answer+=",";
		}
		
		var isCorrect = $('input[name=isCorrect]:checked', '#questionForm').val()
			
		
		console.log(exam_ID);
		console.log(correctScore);
		console.log(wrongScore);
		console.log(answer);
		console.log(isCorrect);
		
    	$.ajax({
    		url : "addQuestionAndAnswers",
    		type : "POST",
    		data : {
    			"questionTitle" : questionTitle,
    			"exam_ID" : exam_ID,
    			"correctScore" : correctScore,
    			"wrongScore" : wrongScore,
    			"answer" : answer,
    			"isCorrect" : isCorrect,
    			"questionType" : "SINGLE_CHOISE"
    		},
    		success : function(result){
    			$("#questionForm")[0].reset();
    			
    			for(var i=0; i<x; i++){
    				$("#moreAnswer").remove();
    			}
    			x=0;
    		},
    		
    		error : function(res){
    			console.log(res);
    		}
    	});
    	
    	
    });
    
    
    $("#moreMultipleChoiseQuestion").on("click", function(){
    	var questionTitle = $("#questionTitle").val();
		var exam_ID = $("#exam_ID").val();
		var correctScore = $("#correctScore").val();
		var wrongScore = $("#wrongScore").val();
		var answer ="";
		
		for(var i=0; i<= x;i++){
			answer += $("#answer"+i).val();
			
			if(i != x)
				answer+=",";
		}
		
		var isCorrect = "";
		
		$('input[name=isCorrect]:checked').each(function() {
			
			if(isCorrect != ""){
				isCorrect+=","+$(this).val();
			}
			else {
				isCorrect+=$(this).val();
			}

		});
    	
		console.log(exam_ID);
		console.log(correctScore);
		console.log(wrongScore);
		console.log(answer);
		
		console.log(isCorrect);
		
	 	$.ajax({
    		url : "addQuestionAndAnswers",
    		type : "POST",
    		data : {
    			"questionTitle" : questionTitle,
    			"exam_ID" : exam_ID,
    			"correctScore" : correctScore,
    			"wrongScore" : wrongScore,
    			"answer" : answer,
    			"isCorrect" : isCorrect,
    			"questionType" : "MULTIPLE_CHOISE"
    		},
    		success : function(result){
    			$("#questionForm")[0].reset();
    			
    			for(var i=0; i<x; i++){
    				$("#moreAnswer").remove();
    			}
    			x=0;
    		},
    		
    		error : function(res){
    			console.log(res);
    		}
    	});
    	
		
		
		
		
		
		
		
    });
    
    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    $("#moreOpenAnswerQuestion").on("click", function(){
    	var questionTitle = $("#questionTitle").val();
    	var maxScore = $("#maxScore").val();
    	var exam_ID = $("#exam_ID").val();
    	
    	console.log(questionTitle);
    	console.log(maxScore);
    	console.log(exam_ID);
    	
    	$.ajax({
    		url : "addQuestion",
    		type : "POST",
    		data : { 
    			"exam_ID" : exam_ID,
    			"questionTitle" : questionTitle,
    			"maxScore" : maxScore
    		},
    		
    		success : function(result){
    			$("#OpenQuestionForm")[0].reset();
    		},
    		
    		error : function(res){
    			alert(res);
    		}
    	});
    	
    });
    
    $("#submit").on("click", function(){
    	$.ajax({
    		url : "examCreated",
    		type : "GET",
    		success : function(result){
    			window.location.href="examCreated";
    		},
    		error : function(res){
    			
    		}
    	});
    	
    });
    
    $('#OpenQuestionForm').submit(function(event){
    	if( $("#questionTitle").val() ){
    		alert("You should submit your question before to review the exam !");
    		return false;
    	}
    	return true;
    });
    
});

