<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
 
<div class="menu-container">
  
   <a href="${pageContext.request.contextPath}/">Home</a>
   
   <c:if test="${user.role == 'Student'}"> 
   |
   <a href="${pageContext.request.contextPath}/courseList">
      Course List
   </a>
   |
   <a href="${pageContext.request.contextPath}/myCourses">
      My Courses
   </a>
   |
   </c:if>
   <c:if test="${user.role == 'Professor'}"> 
   |   
   <a href="${pageContext.request.contextPath}/myCourses">
      My Created Courses
   </a>
   |
   <a href="${pageContext.request.contextPath}/myCourses">
      Create a course
   </a>
   |
   </c:if>
     
</div>