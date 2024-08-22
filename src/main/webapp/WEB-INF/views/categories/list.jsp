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
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Category List</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="category" items="${categories}">
            <tr>
                <th scope="row">
                    <c:out value="${category.getId()}"/>
                </th>
                <td>
                    <c:out value="${category.getName()}"/>
                </td>
                <td>
                    <a href="<%=request.getContextPath()%>/categories_edit?id=<c:out value="${category.getId()}"/>"
                       class="btn btn-primary">Edit</a>
                    <a onclick="return confirm('Are you sure you want to delete?')"
                       href="<%=request.getContextPath()%>/categories_delete?id=<c:out value="${category.getId()}"/>"
                       class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
