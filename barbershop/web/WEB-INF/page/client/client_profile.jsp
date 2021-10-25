<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="content" var="rb"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="company.name" bundle="${rb}"/> - <fmt:message key="page.name.signup"
                                                                           bundle="${rb}"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/client_profile.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../header.jsp" flush="true"/>
<div class="container-fluid">
    <div class="row flex-nowrap">
        <jsp:include page="client_navbar.jsp"/>
        <div class="col py-3">
            <div class="align-middle d-flex w-100 align-items-center justify-content-center flex-column">
                <h3><fmt:message key="client.profile" bundle="${ rb }"/></h3>
                <p class="lead w-75">
                    Hello, ${sessionScope.user.userInfo.name}!
                    Read the menu please, you can edit your data in the tab your personal data. You will also have access to the history of your orders, by going to this tab you can delete
                    order if you don't like something
                </p>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
