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
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet">
    <title><fmt:message key="company.name" bundle="${rb}"/></title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="row align-items-center">
    <div class="col-md-6 mx-auto my-md-5 w-50 px-0 align-items-center d-flex flex-column">
        <div class="alert alert-success" role="alert">
            <h4 class="alert-heading"><fmt:message key="order.waiting" bundle="${ rb }"/></h4>
        </div>
        <a type="submit" class="btn btn-success w-25 mt-2 mb-3"
           href="${pageContext.request.contextPath}/controller?command=home">
            <fmt:message key="header.home" bundle="${rb}"/></a>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
