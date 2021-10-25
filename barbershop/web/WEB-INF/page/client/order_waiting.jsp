<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="content" var="rb"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title><fmt:message key="company.name" bundle="${rb}"/></title>
</head>
<body>
<div class="align-middle d-flex w-100 align-items-center justify-content-center flex-column">
    <div class="alert alert-success" role="alert">
        <h4 class="alert-heading"><fmt:message key="order.waiting" bundle="${ rb }"/></h4>
    </div>
    <a type="submit" class="btn btn-success mt-2 mb-3" href="${pageContext.request.contextPath}/controller?command=home"
       class="btn btn-outline-success w-25 mb-4 display-1 fs-4"><fmt:message key="header.home" bundle="${rb}"/></a>
</div>

</body>
</html>
