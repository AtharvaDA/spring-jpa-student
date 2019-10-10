<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>View Student</title>
</head>
<body>
<!-- <c:out value="${ requestScope.model }"/> -->
<table border="1">
<tr>
<th>Student Id</th>
<th>Student Name</th>
<th>Student Score</th>
</tr>
<c:forEach var="stud" items="${studentList}">
<tr>
<td>${stud.studentId}</td>
<td>${stud.studentName}</td>
<td>${stud.studentScore}</td>
</tr>
</c:forEach>
</table>
</body>
</html>