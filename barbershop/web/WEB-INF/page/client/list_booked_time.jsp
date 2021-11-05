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
</head>
<body>
<jsp:include page="../header.jsp" flush="true"/>
<c:choose>
    <c:when test="${not empty sessionScope.user}">
        <TABLE class="table align-middle caption-top table-hover d-flex align-items-center justify-content-center flex-column">
            <CAPTION class="display-6 text-center mt-4 mb-4 w-75"><fmt:message
                    key="order.time_booked"
                    bundle="${ rb }"/></CAPTION>
            <TR>
                <TH scope="col"><fmt:message key="client.fio" bundle="${ rb }"/></TH>
                <TH scope="col"><fmt:message key="order.slots.booked" bundle="${ rb }"/></TH>
                <TH scope="col"><fmt:message key="haircut.duration.th" bundle="${ rb }"/></TH>
            </TR>
            <c:forEach items="${requestScope.bookedTimeOrder}" var="booked">
                <TR>
                    <TD>${booked.barber.name} ${booked.barber.surname} ${booked.barber.patronymic}</TD>
                    <TD class="text-center">${booked.dateTimePlane}</TD>
                    <TD class="text-center">${booked.haircut.time}</TD>
                </TR>
            </c:forEach>
        </TABLE>

    </c:when>
    <c:otherwise>
        <div class="text-center">
            <h3><fmt:message
                    key="service.list_empty" bundle="${ rb }"/></h3>
        </div>
    </c:otherwise>

</c:choose>
<jsp:include page="../footer.jsp"/>
</body>
</html>

