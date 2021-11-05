<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link href="${pageContext.request.contextPath}/css/barber.css" rel="stylesheet">
    <title><fmt:message key="company.name" bundle="${rb}"/> - <fmt:message key="page.name.error"
                                                                           bundle="${rb}"/></title>
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>
<c:choose>
    <c:when test="${not empty requestScope.barbers}">
        <c:forEach items="${requestScope.barbers}" var="user">
            <div class="container-fluid d-flex justify-content-between w-50 my-5 ">
                <div class="mb-5 pe-5 ps-0 d-flex flex-column">
                    <div class="card my-auto w-auto">
                        <div class="card-body">
                            <h5 class="card-title fs-5">${user.surname} ${user.name} ${user.patronymic}</h5>
                        </div>

                        <ul class="list-group list-group-flush ">
                            <li class="list-group-item">${user.age} <fmt:message key="barber.birthday"
                                                                                 bundle="${ rb }"/></li>
                            <li class="list-group-item"><fmt:message key="barber.phone" bundle="${ rb }"/>:
                                +${user.phone}</li>
                        </ul>
                        <div class="card-body container-fluid d-flex justify-content-between">
                            <a href="${user.tiktokLink}" class="card-link my-auto"><fmt:message key="barber.tiktok"
                                                                                                bundle="${ rb }"/></a>
                            <c:if test="${not empty sessionScope.user}">
                                <a class="btn btn-primary m-1 w-75"
                                   href="${pageContext.request.contextPath}/controller?command=go_to_review&barberId=${user.id}"><fmt:message
                                        key="review.button"
                                        bundle="${ rb }"/></a>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="mb-5 ps-5">
                    <img src="${pageContext.request.contextPath}/img?path=${user.photo}"
                         class="card-img-top" alt="...">
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <P><fmt:message key="service.list_empty" bundle="${ rb }"/></P>
    </c:otherwise>
</c:choose>
<jsp:include page="footer.jsp"/>
</body>
</html>
