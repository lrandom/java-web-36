`
<%@ page import="java.util.ArrayList" %>
<%@ page import="luan.niit.com.javaweb36.models.Categories" %><%--
  Created by IntelliJ IDEA.
  User: luan_prep_vn
  Date: 20/08/2024
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-3">
                <div class="card" style="width: 18rem;">
                    <img src="${product.getPath()}" style="height: 280px" class="card-img-top"
                         alt="${product.getName()}">
                    <div class="card-body">
                        <h5 class="card-title">${product.getName()}</h5>
                        <p class="card-text"><fmt:formatNumber value="${product.getPrice()}"/></p>
                        <a href="<%=request.getContextPath()%>/add_to_cart?id=${product.getId()}" class="btn btn-primary">Add To Cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
