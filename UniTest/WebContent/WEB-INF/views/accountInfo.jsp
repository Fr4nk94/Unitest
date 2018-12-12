<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Account Info</title>
<link rel="stylesheet" type="text/css" href="resources/styles.css"> 
</head>
<body>
    <jsp:include page="_header.jsp" />
	<jsp:include page="_menu.jsp" />
	<div class="page-title">Account Info</div>
	<div class="account-container">
		<ul>
			<li>Role: ${user.role}</li>
			<li>Name: ${user.firstName}</li>
			<li>Surname: ${user.lastName}</li>
			<li>E-mail: ${user.email}</li>
			<li>UserName: ${user.username}</li>
			<li>Password: ${user.password}</li>
		</ul>
	</div>
	
<%-- 	<c:forEach items="${users}" var="user">
		<div class="product-preview-container">
			<ul>
				<!--li><img src="resources/AceQ.png" height="65" width="65" alt="${product.name}"></li!-->
						
				<li>Role: ${user.role}</li>
				<li>Name: ${user.firstName}</li>
				<li>Surname: ${user.lastName}</li>
				<li>E-mail: ${user.email}</li>
				<li>UserName: ${user.username}</li>
				<li>Password: ${user.password}</li>
				
			</ul>
		</div>
	</c:forEach> --%>
	
 	<!-- Edit Customer Info -->
  	<a class="navi-item"
      href="${pageContext.request.contextPath}/editInfo">Edit Customer Info</a>
   <jsp:include page="_footer.jsp" />
</body>
</html>