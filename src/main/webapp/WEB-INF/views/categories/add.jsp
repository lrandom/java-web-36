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
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1>Category Add</h1>
    <form method="POST">
        <div class="mb-3">
            <label for="inputName" class="form-label">Categories Name</label>
            <input type="text" name="name" class="form-control" id="inputName" placeholder="name@example.com">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
