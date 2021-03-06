<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.training.barbershop.bean.UserStatus" %>
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
                <c:if test="${not empty requestScope.users}">
                    <div class="col py-3">
                        <div class="table-responsive">
                            <TABLE class="table align-middle caption-top table-hover d-flex w-100 align-items-center justify-content-center flex-column">
                                <CAPTION class="display-6 text-center mt-4 mb-4 w-75"><fmt:message
                                        key="admin.list.caption"
                                        bundle="${ rb }"/></CAPTION>
                                <TR>
                                    <TH scope="col"><fmt:message key="client.status" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="client.fio" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="signup.birthday" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="signup.email" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="signup.phone" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="client.view.orders" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="client.status.change" bundle="${ rb }"/></TH>
                                </TR>
                                <c:forEach items="${requestScope.users}" var="user">
                                    <TR>
                                        <c:if test="${user.userStatus eq UserStatus.PERMITTED}">
                                            <TD class="table-success">${user.userStatus.name()}</TD>
                                        </c:if>
                                        <c:if test="${user.userStatus eq UserStatus.BLOCKED}">
                                            <TD class="table-danger">${user.userStatus.name()}</TD>
                                        </c:if>
                                        <TD>${user.userInfo.surname} ${user.userInfo.name} ${user.userInfo.patronymic}</TD>
                                        <TD>${user.userInfo.birthday}</TD>
                                        <TD>${user.userInfo.email}</TD>
                                        <TD>+${user.userInfo.phone}</TD>
                                        <TD>
                                            <form action="controller" method="post">
                                                <input type="hidden" name="command" value="view_orders">
                                                <input type="hidden" name="userId" value="${user.id}">
                                                <button type="submit" name="view" class="btn-outline-primary rounded-1">
                                                    <fmt:message key="view.orders"
                                                                 bundle="${ rb }"/></button>
                                            </form>
                                        </TD>
                                        <TD>
                                            <form action="controller" method="post">
                                                <input type="hidden" name="command" value="change_user_status">
                                                <input type="hidden" name="userId" value="${user.id}">
                                                <c:choose>
                                                    <c:when test="${user.userStatus eq UserStatus.BLOCKED}">
                                                        <button type="submit" name="change"
                                                                class="btn-outline-success rounded-1">
                                                            <fmt:message key="client.status.unblock"
                                                                         bundle="${ rb }"/>
                                                        </button>
                                                    </c:when>
                                                    <c:when test="${user.userStatus eq UserStatus.PERMITTED}">
                                                        <button type="submit" name="change"
                                                                class="btn-outline-danger rounded-1">
                                                            <fmt:message key="client.status.block"
                                                                         bundle="${ rb }"/>
                                                        </button>
                                                    </c:when>
                                                </c:choose>
                                            </form>
                                        </TD>
                                    </TR>
                                </c:forEach>
                            </TABLE>
                        </div>
                        <ctg:pagestag pagesCountAttribute="${requestScope.pages_count}"
                                      command="${requestScope.command}"/>
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
<script src="${pageContext.request.contextPath}/js/pagination.js"></script>
</body>
</html>