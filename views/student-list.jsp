
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sinh viên</h2>
<form method="get" action="${pageContext.request.contextPath}/students">
  <input type="text" name="keyword" value="${keyword}" placeholder="Tìm theo tên hoặc email" />
  <select name="sort">
    <option value="asc" ${sort == 'asc' ? 'selected' : ''}>Tăng dần</option>
    <option value="desc" ${sort == 'desc' ? 'selected' : ''}>Giảm dần</option>
  </select>
  <button type="submit">Lọc</button>
</form>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Email</th>
    <th>Ngày sinh</th>
    <th>Điểm trung bình</th>
    <th>Hành động</th>
  </tr>
  <c:forEach var="s" items="${students}">
    <tr>
      <td>${s.id}</td>
      <td>${s.studentName}</td>
      <td>${s.email}</td>
      <td>${s.birthday}</td>
      <td>${s.avgMark}</td>
      <td>
        <a href="${pageContext.request.contextPath}/students/edit/${s.id}">Sửa</a> |
        <a href="${pageContext.request.contextPath}/students/delete/${s.id}"
           onclick="return confirm('Bạn có chắc chắn muốn xóa sinh viên này?');">Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/students/add">
  <button>Thêm sinh viên</button>
</a>

</body>
</html>
