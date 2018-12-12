<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<link rel="stylesheet" type="text/css" href="resources/styles.css">
</head>
<body>
	<jsp:include page="_header.jsp" />
	<jsp:include page="_menu.jsp" />
	<div class="page-title">Course List</div>
	<c:forEach items="${courses}" var="course">
		<div class="product-preview-container">
			<ul>
				<!--li><img src="resources/AceQ.png" height="65" width="65" alt="${product.name}"></li!-->
				<li>Code: ${course.code}</li>
				<li>Name: ${course.name}</li>
				<li>Creation Date: ${course.creationDate}</li>
				<li>Type: ${course.examType}</li>
				<li><a href="${pageContext.request.contextPath}/joinCourse?courseName=${course.name}&courseCode=${course.code}&courseCredits=${course.code}">
					Join Now</a></li>
			</ul>
		</div>
	</c:forEach>
	<jsp:include page="_footer.jsp" />
</body>
</html>