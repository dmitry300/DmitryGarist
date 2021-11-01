<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <c:forEach items="${requestScope.barbers}" var="barber" >
            <div class="align-middle d-flex w-100 flex-column">
                <div class="row">
                    <div class="col-md-6 card-body ps-lg-5 align-content-end">
                        <h5 class="card-title display-4">${barber.surname} ${barber.name} ${barber.patronymic}</h5>
                        <p class="card-text fs-5">
                                ${barber.age} <fmt:message key="barber.birthday" bundle="${ rb }"/><br>
                            <fmt:message key="barber.phone" bundle="${ rb }"/>: +${barber.phone}<br>
                            <a href="${barber.tiktokLink}" class="card-link m-1"><fmt:message key="barber.tiktok"
                                                                                          bundle="${ rb }"/></a><br>
                            <c:if test="${not empty sessionScope.user}">
                                <a class="btn btn-primary m-1"
                                   href="${pageContext.request.contextPath}/controller?command=go_to_review&barberId=${barber.id}"><fmt:message
                                        key="review.button"
                                        bundle="${ rb }"/></a>
                            </c:if>
                        </p>
                    </div>
                    <div class="col-md-6 card-body">
                        <img src="${pageContext.request.contextPath}/img?path=${barber.photo}"
                             class="card-img-top" alt="barber">
                    </div>
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
