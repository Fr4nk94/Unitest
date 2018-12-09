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
      		<li>Role: ${role}</li>
	        <li>Name: ${name}</li>
	        <li>Surname: ${surname}</li>
	        <li>E-mail: ${email}</li>
	        <li>Address: ${address}</li>
	        <li>Phone: ${phone}</li>
	        <li>UserName: ${username}</li>
       </ul>
   </div>
 	<!-- Edit Customer Info -->
  	<a class="navi-item"
      href="${pageContext.request.contextPath}/editInfo">Edit Customer Info</a>
   <jsp:include page="_footer.jsp" />
</body>
</html>