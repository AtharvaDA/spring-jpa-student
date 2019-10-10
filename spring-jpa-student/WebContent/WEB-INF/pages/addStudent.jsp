<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="addStudent.do" method="post" modelAttribute="addStudentForm">
		<label>Student ID</label>
		<f:input path="studentId"/><br>
		<label>Student Name</label>
		<f:input path="studentName"/><br>
		<label>Student Score</label>
		<f:input path="studentScore"/>
		<input type="submit" value="ADMIT">
	</f:form>
		<jsp:include page="viewStudent.jsp"></jsp:include>
</body>
</html>