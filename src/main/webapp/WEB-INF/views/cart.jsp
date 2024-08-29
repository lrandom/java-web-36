<%--
  Created by IntelliJ IDEA.
  User: luan_prep_vn
  Date: 27/08/2024
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<div class="container">
    <h1>Cart</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cart}" var="cartItem">
            <tr>
                <td>${cartItem.getProduct().getName()}</td>
                <td><fmt:formatNumber value="${cartItem.getProduct().getPrice()}" type="currency"/></td>
                <td>
                   ${cartItem.getQuantity()}
                </td>
                <td>
                    <fmt:formatNumber value="${cartItem.getQuantity() * cartItem.getProduct().getPrice()}" type="currency"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h3></h3>
    <a href="<c:url value="/checkout"/>">Checkout</a>
</div>
</body>
</html>
