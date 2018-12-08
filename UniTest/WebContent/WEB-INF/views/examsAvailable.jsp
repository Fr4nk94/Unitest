<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>UniTest</title>
<!--  bootstrap -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!--  bootstrap -->




<!--  script -->
<script src="resources/js/availableExams.js"></script>
<!--  script -->

</head>
<body>
<div class="container">
	<div class="row">
		
        
        <div class="col-md-12">
        <h4>Professor's Exams</h4>
        <div class="table-responsive">

                
              <table id="mytable" class="table table-bordred table-striped">
                   
                   <thead>
                   

                   <th>First Name</th>
                    <th>Last Name</th>
                     <th>Email</th>
                     <th>Exam Name</th>
                     <th>Start Date</th>
                  		
                  		<th>Go to Exam</th>
              
                   </thead>
    <tbody>
    
    <tr>
     
    <td>Mohsin</td>
    <td>Irshad</td>
    <td>isometric.mohsin@gmail.com</td>
    <td>Exam 1</td>
    <td>2018-11-12</td>
		<td><input type="button" class="btn btn-success" value="Start" /></td>
		<td></td>
    </tr>
    
<tr>
  
    <td>Mohsin</td>
    <td>Irshad</td>
    <td>isometric.mohsin@gmail.com</td>
    <td>Exam 1</td>
    <td>2018-11-12</td>
   
		<td><input type="button" class="btn btn-success" value="Start" /></td>
    </tr>
    
    
<tr>
  
    <td>Mohsin</td>
    <td>Irshad</td>
    <td>isometric.mohsin@gmail.com</td>
    <td>Exam 1</td>
    <td>2018-11-12</td>
   
		<td><input type="button" class="btn btn-success" value="Start" /></td>
    </tr>
    
    
    
<tr>
  
    <td>Mohsin</td>
    <td>Irshad</td>
    <td>isometric.mohsin@gmail.com</td>
    <td>Exam 1</td>
    <td>2018-11-12</td>
   
		<td><input type="button" class="btn btn-success" value="Start" /></td>
    </tr>
    
    
<tr>
  
    <td>Mohsin</td>
    <td>Irshad</td>
    <td>isometric.mohsin@gmail.com</td>
    <td>Exam 1</td>
    <td>2018-11-12</td>
    
		<td><input type="button" class="btn btn-success" value="Start" /></td>
    </tr>
    
   
    
   
    
    </tbody>
        
</table>

<div class="clearfix"></div>
<ul class="pagination pull-right">
  <li id="goLeft"><a href="#"><span class="glyphicon glyphicon-chevron-left" ></span></a></li>
  <li class="active" id="page1"><a href="#"> 1</a></li>
  <li id="page2"><a href="#">2</a></li>
  <li id="page3"><a href="#">3</a></li>
  <li id="page4"><a href="#">4</a></li>
  <li id="page5"><a href="#">5</a></li>
  <li id="goRight"><a href="#" ><span class="glyphicon glyphicon-chevron-right"></span></a></li>
</ul>
                
            </div>
            
        </div>
	</div>
</div>

<!--  modal information -->
<div class="modal fade" id="informationModal" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
      <div class="modal-dialog">
    <div class="modal-content">
          <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
        <h4 class="modal-title custom_align" id="Heading">Delete this entry</h4>
      </div>
          <div class="modal-body">
       
       <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Record?</div>
       
      </div>
        <div class="modal-footer ">
        <button type="button" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Yes</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> No</button>
      </div>
        </div>
    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
    </div>
<!--  end modal information -->

</body>
</html>