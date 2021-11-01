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
    <title><fmt:message key="company.name" bundle="${rb}"/></title>
</head>
<body>
<jsp:include page="../header.jsp" flush="true"/>
<div class="d-flex align-middle  p-4 w-50 justify-content-center align-items-center flex-column">
    <c:if test="${sessionScope.is_not_dateTime_valid != null}">
        <div id="" class="alert alert-danger d-flex align-items-center" role="alert">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                 class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img"
                 aria-label="Warning:">
                <path
                        d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path>
            </svg>
            <div>
                <fmt:message key="${sessionScope.error_key}" bundle="${rb}"/>
            </div>
        </div>
    </c:if>
    <form class="needs-validation" novalidate name="registrationForm" action="controller"
          method="post">
        <input type="hidden" name="command" value="order_waiting">
        <div class="mb-3">
            <div class="form-outline">
                <label for="service_select" class="form-label"><fmt:message key="order.service" bundle="${rb}"/></label>
                <select class="form-select" id="service_select" name="haircut" required>
                    <c:forEach items="${requestScope.services}" var="haircut">
                        <option value="${haircut.id}">${haircut.name} - ${haircut.price} <fmt:message
                                key="service.price"
                                bundle="${ rb }"/></option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback"><fmt:message key="order.service" bundle="${rb}"/></div>
            </div>
        </div>
        <div class="mb-3">
            <div class="form-outline">
                <label for="barber_select" class="form-label"><fmt:message key="order.barber" bundle="${rb}"/></label>
                <select class="form-select" id="barber_select" name="barber" required>
                    <option selected disabled value=""><fmt:message key="order.barber.option" bundle="${rb}"/></option>
                    <c:forEach items="${requestScope.barbers}" var="barber">
                        <option value="${barber.id}">${barber.name} ${barber.surname} </option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback"><fmt:message key="order.barber" bundle="${rb}"/></div>
            </div>
        </div>
        <div class="mb-3">
            <div class="form-outline">
                <label for="data_select" class="form-label"><fmt:message key="order.data" bundle="${rb}"/></label>
                <input type="date" class="form-control" name="data" id="data_select" required/><br>
                <div class="invalid-feedback"><fmt:message key="order.data" bundle="${rb}"/></div>
            </div>
        </div>
        <div class="mb-3">
            <div class="form-outline">
                <label for="time_select" class="form-label"><fmt:message key="order.time" bundle="${rb}"/></label>
                <datalist id="time">
                    <option value="08:00" label="Начало рабочего дня">08:00</option>
                    <option value="12:00" label="Обед">12:00</option>
                    <option value="17:00" label="Конец рабочего дня">17:00</option>
                </datalist>
                <input type="time" min="08:00" max="20:00" class="form-control" name="time"
                       id="time_select" required/><br>
                <div class="invalid-feedback"><fmt:message key="order.time" bundle="${rb}"/></div>

            </div>
        </div>
        <button id="order_button"
                type="submit" class="btn btn-success mt-2 mb-3" value="Order">
            <fmt:message key="order.button" bundle="${rb}"/>
        </button>
    </form>
</div>
<jsp:include page="../footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/order.js"></script>
</body>
</html>
