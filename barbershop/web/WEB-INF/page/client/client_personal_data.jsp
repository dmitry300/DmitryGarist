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
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/client_profile.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../header.jsp" flush="true"/>
<div class="container-fluid">
    <div class="row flex-nowrap">
        <jsp:include page="client_navbar.jsp"/>
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <div class="col py-3">
                    <div class="align-middle d-flex w-100 align-items-center justify-content-center flex-column">
                        <div class="profile-img row">
                            <div class="col-md-6 card-body">
                                <h5 class="card-title display-4">${sessionScope.user.userInfo.surname} ${sessionScope.user.userInfo.name} ${sessionScope.user.userInfo.patronymic}</h5>
                                <p class="card-text fs-5">
                                    <fmt:message key="barber.phone" bundle="${ rb }"/>: +${sessionScope.user.userInfo.phone}<br>
                                    <fmt:message key="user.birthday"
                                                 bundle="${ rb }"/>: ${sessionScope.user.userInfo.birthday}<br>
                                    <fmt:message key="user.email" bundle="${ rb }"/>: ${sessionScope.user.userInfo.email}<br>
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 card-body">
                                <a href="${pageContext.request.contextPath}/controller?command=go_to_client_edit_profile"
                                   class="btn btn-outline-success w-100 mb-4 display-1 fs-4 align-items-center"><fmt:message
                                        key="client.edit_profile" bundle="${rb}"/></a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <P><fmt:message key="service.list_empty" bundle="${ rb }"/></P>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
