<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>UniTest Index</title>
<link href="resources/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="resources/css/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="resources/css/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="resources/css/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">


<!-- Custom Fonts -->
<link href="resources/css/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/professor.js"></script>

<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}"
</script>
</head>
<body>
	<h1>UniTest</h1>
	<div class="panel-body">
		<table width="100%"
			class="table table-striped table-bordered table-hover"
			id="dataTables-example">
			<thead>
				<tr>
					<th>Exam Name</th>
					<th>Student Name</th>
					<th>Score</th>
					<th>Exam Date</th>
					<th>Button check</th>

				</tr>
			</thead>
			<tbody id="exam-container">

			</tbody>
		</table>
	</div>
	<button type="button" id="list_test_button" class="btn btn-primary">List
		Test</button>
</body>
</html>