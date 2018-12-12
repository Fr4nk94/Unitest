<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<div class="header-container"> 
    <div class="site-name">Uniway</div> 
    <div class="header-bar">
     	<c:if test="${username == null}">	   
	         <a href="${pageContext.request.contextPath}/login">Login</a>
       </c:if>
	   <c:if test="${username != null}">
	 Hello ${username} (${user.role}) | <a href="${pageContext.request.contextPath}/logout">Logout</a>
	   </c:if>	            
    </div>
</div>