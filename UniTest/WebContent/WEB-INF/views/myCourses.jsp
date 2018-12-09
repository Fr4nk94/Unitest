<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Courses</title> 
<link rel="stylesheet" type="text/css" href="resources/styles.css"> 
 
</head>
<body>
 
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
  
   <fmt:setLocale value="en_US" scope="session"/>
 
   <div class="page-title">My Courses</div>

    <c:if test="${myCourses == null}">
       <h2>You don't have any joined courses</h2> 
   </c:if>
   <c:if test="${myCourses != null}"> 
   <c:forEach items="${myCourses}" var="course">
		<div class="product-preview-container">
			<ul>
				<!--li><img src="resources/AceQ.png" height="65" width="65" alt="${product.name}"></li!-->
				<li>Name: ${course.name}</li>
				<li>Code: ${course.code}</li>
				<li>Credits:  ${course.code}</li>
				<li><a href="${pageContext.request.contextPath}/joinCourse?courseCode=${course}">
					Join Now</a></li>
			</ul>
		</div>
	</c:forEach>
	<%-- 
    <div class="product-preview-container">
       <ul>
    	   <li><img src="resources/${courseName}.png" height="65" width="65" alt="${courseName}"></li>
           <li>Code: ${courseCode}</li>
           <li>Name: ${courseName}</li>
           <li>Credits: ${courseCredits}</li>
           <li><a href="${pageContext.request.contextPath}/leaveCourse?code=${courseCode}">
            Leave course</a></li>
            
       </ul>
     </div>   --%>
       
   </c:if>
   <div style="clear: both"></div>
   <!-- input class="button-update-sc" type="submit" value="Update Quantity" /-->
   <a class="navi-item" href="${pageContext.request.contextPath}/courseList">
   Join a course</a>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>