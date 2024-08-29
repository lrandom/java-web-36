<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="message"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP - Hello World</title>
</head>
<body>
<c:out value="${sessionScope.lang}"/>

<a href="${pageContext.request.contextPath}/test?lang=vi_VN">Vietnamese</a>
<a href="${pageContext.request.contextPath}/test?lang=en_US">English</a>
<a href="${pageContext.request.contextPath}/test?lang=ja_JP">Japanese</a>

<fmt:message key="hello"/>
<fmt:message key="welcome_to"/>
</body>
</html>
