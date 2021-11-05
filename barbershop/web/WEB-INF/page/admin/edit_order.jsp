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
    <link href="${pageContext.request.contextPath}/css/profile.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../header.jsp" flush="true"/>
<div class="container-fluid">
    <div class="row flex-nowrap">
        <jsp:include page="../navbar.jsp"/>
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <c:if test="${not empty requestScope.order
                 and not empty requestScope.haircuts
                  and not empty requestScope.barbers}">
                    <div class="col py-5 d-flex flex-column align-items-center">
                        <c:if test="${sessionScope.is_not_dateTime_valid != null}">
                            <div id="" class="alert alert-danger d-flex align-items-center" role="alert">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                                     class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16"
                                     role="img"
                                     aria-label="Warning:">
                                    <path
                                            d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path>
                                </svg>
                                <div>
                                    <fmt:message key="${sessionScope.error_key}" bundle="${rb}"/>
                                </div>
                            </div>
                        </c:if>
                        <form action="controller" method="post" class="w-50">
                            <input type="hidden" name="command" value="edit_order">
                            <input type="hidden" name="orderId" value="${requestScope.order.id}">
<%--                            <input type="hidden" name="userId" value="${requestScope.order.user.id}">--%>
                            <c:if test="${not empty requestScope.toActive}">
                                <input type="hidden" name="toActive" value="${requestScope.toActive}">
                            </c:if>
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="service_select" class="form-label"><fmt:message key="order.service"
                                                                                                bundle="${rb}"/></label>
                                    <select class="form-select" id="service_select" name="haircut">
                                        <option selected value="">${requestScope.order.haircut.name}
                                            - ${requestScope.order.haircut.price} <fmt:message
                                                    key="service.price"
                                                    bundle="${ rb }"/></option>
                                        <c:forEach items="${requestScope.haircuts}" var="haircut">
                                            <option value="${haircut.id}">${haircut.name} - ${haircut.price}
                                                <fmt:message
                                                        key="service.price"
                                                        bundle="${ rb }"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="barber_select" class="form-label"><fmt:message key="order.barber"
                                                                                               bundle="${rb}"/></label>
                                    <select class="form-select" id="barber_select" name="barber">
                                        <option selected
                                                value="">${requestScope.order.barber.name} ${requestScope.order.barber.surname}</option>
                                        <c:forEach items="${requestScope.barbers}" var="user">
                                            <option value="${user.id}">${user.name} ${user.surname} </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="data_select" class="form-label"><fmt:message key="order.data"
                                                                                             bundle="${rb}"/></label>
                                    <input type="text" value="${requestScope.order.dateTimePlane}"
                                           onfocus="(this.type='datetime-local')"
                                           onblur="(this.type='text')"
                                           class="form-control" name="data-time" id="data_select"/><br>
                                </div>
                            </div>
                            <div class="container-fluid d-flex flex-column align-items-center">
                                <button id="order_button"
                                        type="submit" class="btn btn-success mt-2 mb-3 w-50" value="Order">
                                    <fmt:message key="order.button" bundle="${rb}"/>
                                </button>
                            </div>
                        </form>
                    </div>
                </c:if>
            </c:when>
            <c:otherwise>
                <P><fmt:message key="service.list_empty" bundle="${ rb }"/></P>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
