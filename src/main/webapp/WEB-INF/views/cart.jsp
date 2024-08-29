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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
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
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cart}" var="cartItem">
            <tr>
                <td>${cartItem.getProduct().getName()}</td>
                <td><fmt:formatNumber value="${cartItem.getProduct().getPrice()}" type="currency"/></td>
                <td>
                    <a href="<c:url value="/update_quantity"/>?id=${cartItem.getProduct().getId()}&quantity=-1">-</a>
                        ${cartItem.getQuantity()}
                    <a href="<c:url value="/update_quantity"/>?id=${cartItem.getProduct().getId()}&quantity=1">+</a>
                </td>
                <td>
                    <fmt:formatNumber value="${cartItem.getQuantity() * cartItem.getProduct().getPrice()}"
                                      type="currency"/>
                </td>
                <td>
                    <a href="<c:url value="/remove_from_cart"/>?id=${cartItem.getProduct().getId()}">Remove</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <h3>SubTotal: <fmt:formatNumber value="${subTotal}" type="currency"/></h3>
    <h3>Tax: 10%</h3>
    <h3>Total: <fmt:formatNumber value="${total}" type="currency"/></h3>
    <a href="<c:url value="/checkout"/>">Checkout</a>
</div>
</body>
</html>
