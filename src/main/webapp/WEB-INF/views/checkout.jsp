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
    <title>Checkout</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row">
        <form method="POST">
            <div class="mb-3">
                <label for="inputName" class="form-label">Name</label>
                <input type="text" name="name" class="form-control" id="inputName">
            </div>
            <div class="mb-3">
                <label for="inputPhone" class="form-label">Phone</label>
                <input type="text" name="phone" class="form-control" id="inputPhone">
            </div>
            <div class="mb-3">
                <label for="inputAddress" class="form-label">Address</label>
                <input type="text" name="address" class="form-control" id="inputAddress">
            </div>
            <div class="mb-3">
                <label for="inputNote" class="form-label">Note</label>
                <textarea placeholder="Note" class="form-control" name="note" id="inputNote"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>

</body>
</html>
