<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="<c:url value='/'></c:url>">UniTest
			v1.0 Beta</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">

		<li><a href="#"><i class="fa fa-user fa-fw"></i>${aUser.fullName}</a></li>
		<li><a href="#" id="logout"><i class="fa fa-sign-out fa-fw"></i>
				Logout</a></li>
		<!-- 	<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="#"><i class="fa fa-user fa-fw"></i> User
						Profile</a></li>
				<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a></li>
				<li class="divider"></li>

			</ul></li> -->
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<!--<li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                             /input-group
                        </li> -->
				<c:if test="${role == 'ROLE_Student'}">			

					<li class="active"><a><i class="fa fa-bar-chart-o fa-fw"></i>
							Portfolio</a>
						<ul class="nav nav-second-level">

							<!--  MODIFICATO DA DENNIS -->
							<!-- <li><a href="getUserExams">Available Exams</a></li>  -->
							<li><a href="examList">Available Exams</a></li>
							<!--  MODIFICATO DA DENNIS -->

							<li><a href="morris.html">Taken Exams</a></li>
						</ul> <!-- /.nav-second-level --></li>
				</c:if>
				<c:if test="${role == 'ROLE_Professor'}">
					<li class="active"><a><i class="fa fa-bar-chart-o fa-fw"></i> Portfolio<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">

							<!--  MODIFICATO DA DENNIS -->
							<li><a href="getUserExams">Created Exams</a></li>
							<!--  MODIFICATO DA DENNIS -->

							<li><a href="evaluatedExam">Evaluated Exams</a></li>
							<li><a href="evalExam">Non evaluated exams</a></li>
						</ul> <!-- /.nav-second-level --></li>
					<li><a href="createExam"><i class="fa fa-table fa-fw"></i>
							Create Exam</a></li>
					<!-- <li><a href="#"><i class="fa fa-edit fa-fw"></i> Forms</a></li> -->
				</c:if>
				<!-- <li><a href="#"><i class="fa fa-wrench fa-fw"></i> UI
						Elements<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="panels-wells.html">Panels and Wells</a></li>
						<li><a href="buttons.html">Buttons</a></li>
						<li><a href="notifications.html">Notifications</a></li>
						<li><a href="typography.html">Typography</a></li>
						<li><a href="icons.html"> Icons</a></li>
						<li><a href="grid.html">Grid</a></li>
					</ul> </li>
				<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
						Multi-Level Dropdown<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#">Second Level Item</a></li>
						<li><a href="#">Second Level Item</a></li>
						<li><a href="#">Third Level <span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li><a href="#">Third Level Item</a></li>
								<li><a href="#">Third Level Item</a></li>
								<li><a href="#">Third Level Item</a></li>
								<li><a href="#">Third Level Item</a></li>
							</ul> </li>
					</ul> </li>
				<li class="active"><a href="#"><i
						class="fa fa-files-o fa-fw"></i> Sample Pages<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a class="active" href="blank.html">Blank Page</a></li>
						<li><a href="login.html">Login Page</a></li>
					</ul>  -->
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>

<!-- Modal -->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">UniTest</h4>
			</div>
			<div class="modal-body">Are you sure that you want to leave the system?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
				<button type="button" class="btn btn-primary" id="yesButtonLog">Yes</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>