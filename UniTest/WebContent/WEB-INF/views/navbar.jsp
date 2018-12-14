<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="pull-right">
			<p id="demo"></p>
		</div>
		<div class="pull-left">
			<h2>${aUser.username}'s Exam</h2>
		</div>
	</div>
</nav>
 -->
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">UniTest v1.0 Beta</a>
		<a class="navbar-brand" href="#"><strong>${aUser.username}'sExam</strong></a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown">
			<h2 id="demo"></h2>
		</li>
	</ul>

	<!-- /.navbar-top-links -->
</nav>