
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm Sinh Viên</h2>
<form action="add" method="post">
    Tên: <input type="text" name="studentName"><br>
    Email: <input type="email" name="email"><br>
    Ngày sinh: <input type="date" name="birthday"><br>
    Điểm trung bình: <input type="text" name="avgMark"><br>
    <button type="submit">Thêm</button>
</form>
</body>
</html>
