<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtag" %>

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
                <c:if test="${not empty requestScope.orders}">
                    <div class="col py-3">
                        <div class="table-responsive">
                            <TABLE class="table align-middle caption-top table-hover d-flex w-100 align-items-center justify-content-center flex-column">
                                <CAPTION class="display-6 text-center mt-4 mb-4 w-75"><fmt:message
                                        key="client.orders.caption"
                                        bundle="${ rb }"/></CAPTION>
                                <TR>
                                    <TH scope="col"><fmt:message key="client.order.status" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="client.order.data_time" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="client.order.data_time_plane"
                                                                 bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="client.order.service" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="client.order.barber" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="client.remove.order" bundle="${ rb }"/></TH>
                                </TR>
                                <c:forEach items="${requestScope.orders}" var="order">
                                    <TR>
                                        <c:if test="${order.status.name()=='APPROVED'}">
                                            <TD class="table-success">
                                                    ${order.status.name()}
                                            </TD>
                                        </c:if>
                                        <c:if test="${order.status.name()=='REJECTED'}">
                                            <TD class="table-danger">
                                                    ${order.status.name()}
                                            </TD>
                                        </c:if>
                                        <c:if test="${order.status.name()=='WAITING'}">
                                            <TD class="table-warning">
                                                    ${order.status.name()}
                                            </TD>
                                        </c:if>
                                        <TD>${order.dateTime} <fmt:message key="service.time"
                                                                           bundle="${ rb }"/></TD>
                                        <TD>${order.dateTimePlane} <fmt:message key="service.time"
                                                                                bundle="${ rb }"/></TD>
                                        <TD>${order.haircut.name}</TD>
                                        <TD>${order.barber.name}</TD>
                                        <TD>
                                            <form action="controller" method="post">
                                                <input type="hidden" name="command" value="client_remove_order">
                                                <input type="hidden" name="orderId" value="${order.id}">
                                                <button type="submit" name="remove"
                                                        class="btn-outline-danger rounded-1"><fmt:message
                                                        key="client.remove.td"
                                                        bundle="${ rb }"/></button>
                                            </form>
                                        </TD>
                                    </TR>
                                </c:forEach>
                            </TABLE>
                            <ctg:pagestag pagesCountAttribute="${requestScope.pages_count}"
                                          command="${requestScope.command}"/>
                            <p><fmt:message key="barbershop.email"
                                            bundle="${ rb }"/>
                                <a href="mailto:magnifique@gmail.com"> magnifique@gmail.com</a>
                            </p>
                        </div>
                    </div>
                </c:if>
                <c:if test="${empty requestScope.orders}">
                    <div class="col py-3">
                        <div class="text-center">
                            <h3><fmt:message
                                    key="client.no_orders" bundle="${ rb }"/></h3>
                        </div>
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
</body>
</html>
