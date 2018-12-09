<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
   <div class="page-title">Enter ${role} Information </div>
	<form method="POST" action="edit">
           <table>
               <tr>
               <td>Name</td>
                   <td><input name="name" /></td>
               </tr> 
               <tr>
                   <td>Surname</td>
                   <td><input name="surname" /></td>
               </tr>
               <tr>
                   <td>E-Mail</td>
                   <td><input type="email" name="email" /></td>
               </tr>
               <tr>
                   <td>Address</td>
                   <td><input name="address" /></td>
               </tr>
               <tr>
                   <td>Phone</td>
                   <td><input type="number" name="phone" /></td>
               </tr>
 
               <tr>
                   <td>&nbsp;</td>
                   <td><input type="submit" value="Submit" /> 
               </tr>
           </table>
       </form> 
</body>
</html>