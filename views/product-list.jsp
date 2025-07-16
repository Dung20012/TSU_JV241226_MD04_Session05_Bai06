
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="p" items="${products}">
  <div>
    <h3>${p.productName}</h3>
    <p>${p.description}</p>
    <p>Giá: ${p.price}</p>
    <a href="${pageContext.request.contextPath}/home/addToCart/${p.id}">Thêm vào giỏ</a>
  </div>
</c:forEach>

<c:forEach var="i" begin="1" end="${totalPages}">
  <a href="${pageContext.request.contextPath}/home?page=${i}">${i}</a>
</c:forEach>
</body>
</html>
