
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Giỏ hàng của bạn</h2>
<table border="1">
    <tr>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Thành tiền</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="c" items="${carts}">
        <tr>
            <td>${c.productName}</td>
            <td>${c.price}</td>
            <td>
                <form action="${pageContext.request.contextPath}/carts/update/${c.id}" method="post">
                    <input type="number" name="quantity" value="${c.quantity}" min="1"/>
                    <button type="submit">Cập nhật</button>
                </form>
            </td>
            <td>${c.price * c.quantity}</td>
            <td><a href="${pageContext.request.contextPath}/carts/delete/${c.id}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>
<h3>Tổng tiền: ${total}</h3>
<a href="${pageContext.request.contextPath}/home">Tiếp tục mua hàng</a>
</body>
</body>
</html>
