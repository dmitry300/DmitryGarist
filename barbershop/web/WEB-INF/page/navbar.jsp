<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.training.barbershop.bean.UserRole" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="content" var="rb"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="company.name" bundle="${rb}"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/profile_navbar.css" rel="stylesheet">
</head>
<body>
<div class="col-auto col-md-1 col-lg-2 " id="navbar">
    <div class="d-flex flex-column align-items-center px-3 pt-2 text-white min-vh-100">
        <span class="fs-5 d-none d-sm-inline p-4"><fmt:message key="profile.menu" bundle="${ rb }"/></span>
        <div id="navbarSupportedContent align-items-center">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
                <c:choose>
                    <c:when test="${sessionScope.user.role eq UserRole.CLIENT}">
                        <li class="nav-item rounded-1">
                            <a class="nav-link active mx-4" aria-current="page"
                               href="${pageContext.request.contextPath}/controller?command=client_personal_data"><fmt:message
                                    key="client.data"
                                    bundle="${ rb }"/></a>
                        </li>
                        <li class="dropdown-divider"></li>
                        <li class="nav-item rounded-1">
                            <a class="nav-link mx-4"
                               href="${pageContext.request.contextPath}/controller?command=client_orders">
                                <fmt:message key="order.list" bundle="${ rb }"/></a>
                        </li>
                    </c:when>
                    <c:when test="${sessionScope.user.role eq UserRole.ADMIN}">
                        <li class="nav-item rounded-1">
                            <a class="nav-link active mx-4" aria-current="page"
                               href="${pageContext.request.contextPath}/controller?command=clients_list"><fmt:message
                                    key="admin.client.list"
                                    bundle="${ rb }"/></a>
                        </li>
                        <li class="dropdown-divider"></li>
                        <li class="nav-item rounded-1">
                            <a class="nav-link mx-4" aria-current="page"
                               href="${pageContext.request.contextPath}/controller?command=active_orders">
                                <fmt:message key="admin.order.active" bundle="${ rb }"/></a>
                        </li>
                        <li class="dropdown-divider"></li>
                        <li class="nav-item rounded-1">
                            <a class="nav-link mx-4" aria-current="page"
                               href="${pageContext.request.contextPath}/controller?command=inactive_orders">
                                <fmt:message key="admin.order.inactive" bundle="${ rb }"/></a>
                        </li>
                        <li class="dropdown-divider"></li>
                        <li class="nav-item rounded-1">
                            <a class="nav-link mx-3" aria-current="page"
                               href="${pageContext.request.contextPath}/controller?command=list_haircuts">
                                <fmt:message key="admin.edit.haircut" bundle="${ rb }"/></a>
                        </li>
                        <li class="dropdown-divider"></li>
                        <li class="nav-item rounded-1">
                            <a class="nav-link mx-3" aria-current="page"
                               href="${pageContext.request.contextPath}/controller?command=active_barbers">
                                <fmt:message key="admin.barbers.active" bundle="${ rb }"/></a>
                        </li>
                        <li class="dropdown-divider"></li>
                        <li class="nav-item rounded-1">
                            <a class="nav-link mx-3" aria-current="page"
                               href="${pageContext.request.contextPath}/controller?command=dismissed_barbers">
                                <fmt:message key="admin.barbers.dismissed" bundle="${ rb }"/></a>
                        </li>
                    </c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
