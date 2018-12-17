$(document).ready(function() {
	
	$("#wrong").hide();
	$(".input_fields_wrap").hide();
	
	
	
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    var type = "";				// The type of the box (radio button or checkbox)
    var questionType = "OPEN_ANSWER";		//The type of the question (Open, Multiple, Single)..Set to default value
    
    var x = 0; //initial text box count
    $(add_button).on("click",function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            
            $(wrapper).append('<div id="moreAnswer">'+
            '<input class="answerInput" id="answer'+x+'" type="text" name="answer" />'+
            '<a href="#" class="remove_field">'+
            '<span  id="trash" class="fa-stack"><i class="fa fa-trash" aria-hidden="true"></i> </span></a>'+
            '<input id="isCorrect" type="'+type+'" name="isCorrect" value="true-'+x+'"> Correct<br>'+
            '</div>'); //add input box
        }
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
      
    
    
    
     $('#questionType').on('change', function() {
      
    	 questionType = this.value;
    	 
    	 if(this.value == "OPEN_ANSWER" || this.value == "ATTACH_FILE"){
    		 
    		 for(var i=0;i<x;i++){
    			 $("#moreAnswer").remove();
    		 }
    		 
    		 x = 0;
    		 
    		 $("#wrong").hide();
    		 $(".input_fields_wrap").hide();
    	 }
    	 else if(this.value == "SINGLE_CHOICE"){
    		
    		 for(var i=0;i<x;i++){
    			 $("#moreAnswer").remove();
    		 }
    		
    		 x=0;
    		 $("#isCorrect").prop("type", "radio");
    		 type = "radio";
    		 $("#wrong").show();
    		 $(".input_fields_wrap").show();
    	 }
    	 else if (this.value == "MULTIPLE_CHOICE"){
    		 
    		 for(var i=0;i<x;i++){
    			 $("#moreAnswer").remove();
    		 }
    		 
    		 x=0;
    		 $("#isCorrect").prop("type", "checkbox");
    		 type = "checkbox";
    		 $("#wrong").show();
    		 $(".input_fields_wrap").show();
    	 }
    
    });
    
    
    
    $("#oneMoreQuestion").on("click", function() {
    	
    	
    	var questionTitle = $("#questionTitle").val();
    	var exam_ID = $("#exam_ID").val();
    	var correctScore = $("#correctScore").val();
    	var wrongScore = $("#wrongScore").val();
		var answer = "";
    	var isCorrect = "";
    	
    	

        // Check if empty of not
        if (questionTitle === '') {
            alert('Insert the question');
            return false;
        }
        
        // Check if empty of not
        if (correctScore === '') {
            alert('Insert the score of the correct answer');
            return false;
        }
    	
    	
    	
    	
    	if(questionType == "OPEN_ANSWER" || questionType == "ATTACH_FILE"){
    		console.log("you are submitting a OPEN question");
    		
        	$.ajax({
        		url : "insertQuestions",
        		type : "POST",
        		data : { 
        			"exam_ID" : exam_ID,
        			"questionTitle" : questionTitle,
        			"correctScore" : correctScore,
        			"wrongScore" : 0,
        			"answers" : "",
        			"questionType" : "OPEN_ANSWER",
        			"isCorrect" : ""
        		},
        		
        		success : function(result){
        			$("#questionForm")[0].reset();
        			$("#questionType").val(questionType);
        		},
        		
        		error : function(res){
        			alert(res);
        		}
        	});
    		
    		
    	}
    	else if (questionType == "MULTIPLE_CHOICE"){
    		console.log("you are submitting a MULTIPLE question");
    		
    		isCorrect = "";
    		
    		for(var i=0; i<= x;i++){
    			answer += $("#answer"+i).val();
    			
    			if(i != x)
    				answer+=",";
    		}
    		
    		$('input[name=isCorrect]:checked').each(function() {
    			
    			if(isCorrect != ""){
    				isCorrect+=","+$(this).val();
    			}
    			else {
    				isCorrect+=$(this).val();
    			}

    		});
    		
    		// Check if empty of not
            if (wrongScore === '') {
                alert('Insert the wrong score');
                return false;
            }
            
            // Check if empty of not
            if (answer === '') {
                alert('Insert the answer');
                return false;
            }
    		
            // Check if empty of not
            if (isCorrect === '') {
                alert('Choose at least one correct answer');
                return false;
            }
    		
    		
    		$.ajax({
        		url : "insertQuestions",
        		type : "POST",
        		data : {
        			"questionTitle" : questionTitle,
        			"exam_ID" : exam_ID,
        			"correctScore" : correctScore,
        			"wrongScore" : wrongScore,
        			"answers" : answer,
        			"isCorrect" : isCorrect,
        			"questionType" : "MULTIPLE_CHOICE"
        		},
        		success : function(result){
        			$("#questionForm")[0].reset();
        			$("#questionType").val("MULTIPLE_CHOICE");
        			
        			for(var i=0; i<x; i++){
        				$("#moreAnswer").remove();
        			}
        			x=0;
        		},
        		
        		error : function(res){
        			console.log(res);
        		}
        	});
        	
    		
    		
    	}
    	else if (questionType == "SINGLE_CHOICE"){
    		console.log("you are submitting a SINGLE question");
    	
    		for(var i=0; i<= x;i++){
    			answer += $("#answer"+i).val();
    			
    			if(i != x)
    				answer+=",";
    		}
    		
    		isCorrect = $('input[name=isCorrect]:checked', '#questionForm').val();
    		
    		// Check if empty of not
            if (wrongScore === '') {
            	alert('Insert the wrong score');
                return false;
            }
            
            // Check if empty of not
            if (answer === '') {
            	alert('Insert the answer');
                return false;
            }
    		
            // Check if empty of not
            if (isCorrect === '') {
                alert('Choose at least one correct answer');
                return false;
            }
            
    		$.ajax({
        		url : "insertQuestions",
        		type : "POST",
        		data : {
        			"questionTitle" : questionTitle,
        			"exam_ID" : exam_ID,
        			"correctScore" : correctScore,
        			"wrongScore" : wrongScore,
        			"answers" : answer,
        			"isCorrect" : isCorrect,
        			"questionType" : "SINGLE_CHOICE"
        		},
        		success : function(result){
        			$("#questionForm")[0].reset();
        			$("#questionType").val("SINGLE_CHOICE");
        			
        			for(var i=0; i<x; i++){
        				$("#moreAnswer").remove();
        			}
        			x=0;
        		},
        		
        		error : function(res){
        			console.log(res);
        		}
        	});
    		
    		
    		
    		
    	}
    	
    	
    });
    
    
    
    
    // CREATE EXAM
    
    
    $("#createExam").on("click", function(){
    	var examName = $("#examName").val();
    	var isAvailable = $('input[name=isAvailable]:checked').val();
    	var timeAvailable = $("#availableTime").val();
    	
    	alert(isAvailable);
    	
    	if(examName == '' || isAvailable == ''){
    		alert("Compilare tutti i campi");
    		return false;
    	}
    	
    	console.log("is available = "+isAvailable);
    	console.log("examName= "+  examName);
    	
    	$.ajax({
    		url : "createExam",
    		type : "POST",
    		data : {
    				"examName" : examName,
    				"isAvailable" : isAvailable,
    				"timeAvailable" : timeAvailable
    		},
    		success : function(res) {
    			
    				window.location.href="./addQuestions";
    			
    		},
    		
    		error : function(r){
    			alert(r);
    		}
    	});
    });
    
    
    
    
    
    /////////////////////////////////////////////////////////
    
    $("#done").on("click", function(){
        
        
        var examID=$("#exam_ID").val();
        
        
        $.ajax({
         url : 'examCreated',
         type : 'POST',
         data : {
          "exam_ID" : examID
         },
         success : function(result){
          
          
          alert("SAVED ON THE DB");
          
         },
         error : function(res){
          
         }
        });
        
       });
    
});


