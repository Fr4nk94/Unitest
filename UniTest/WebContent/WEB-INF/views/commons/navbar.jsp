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

		<li><a href="logout"><i class="fa fa-user fa-fw"></i>${aUser.fullName}</a></li>
		<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
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
					<li><a href="index.html"><i class="fa fa-dashboard fa-fw"></i>
							Dashboard</a></li>

					<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
							Portfolio</a> <!-- <ul class="nav nav-second-level">
						<li><a href="flot.html">Flot Charts</a></li>
						<li><a href="morris.html">Morris.js Charts</a></li>
					</ul> 
					 --> <!-- /.nav-second-level --></li>
				</c:if>
				<c:if test="${role == 'ROLE_Professor'}">
					<li><a href="index.html"><i class="fa fa-dashboard fa-fw"></i>
							Dashboard</a></li>
					<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
							Portfolio</a> <!-- <ul class="nav nav-second-level">
						<li><a href="flot.html">Flot Charts</a></li>
						<li><a href="morris.html">Morris.js Charts</a></li>
					</ul> 
					 --> <!-- /.nav-second-level --></li>
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