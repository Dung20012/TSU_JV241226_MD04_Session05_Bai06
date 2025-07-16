
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sửa sinh viên</h2>
<form action="${pageContext.request.contextPath}/students/edit/${student.id}" method="post">
    Tên: <input type="text" name="studentName" value="${student.studentName}"/><br>
    Email: <input type="text" name="email" value="${student.email}"/><br>
    Ngày sinh: <input type="text" name="birthday" value="${student.birthday}"/><br>
    Điểm TB: <input type="text" name="avgMark" value="${student.avgMark}"/><br>
    <input type="hidden" name="id" value="${student.id}"/>
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
