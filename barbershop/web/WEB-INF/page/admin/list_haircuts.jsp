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
                <c:if test="${not empty requestScope.haircuts}">
                    <div class="col py-3">
                        <div class="table-responsive">
                            <TABLE class="table align-middle caption-top table-hover d-flex w-100 align-items-center justify-content-center flex-column table-sm">
                                <CAPTION class="display-6 text-center mt-4 mb-4 w-75"><fmt:message
                                        key="admin.caption.haircut"
                                        bundle="${ rb }"/></CAPTION>
                                <TR>
                                    <TH scope="col"><fmt:message key="service.th.name" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="service.th.time" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="service.th.price" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="admin.haircut.remove.th" bundle="${ rb }"/></TH>
                                    <TH scope="col"><fmt:message key="admin.haircut.edit.th" bundle="${ rb }"/></TH>
                                    <TH scope="col"></TH>
                                </TR>
                                <TR>
                                    <form action="controller" class="d-flex flex-column needs-validation" method="post">
                                        <input type="hidden" name="command" value="add_haircut">
                                        <TD>
                                            <div class="form-outline">
                                                <input type="text" name="name" class="form-control"
                                                       placeholder="<fmt:message key="service.th.name" bundle="${ rb }"/>">
                                            </div>
                                        </TD>
                                        <TD>
                                            <div class="form-outline">
                                                <input type="text" name="duration" class="form-control"
                                                       pattern="\d{2}[:]\d{2}[:]\d{2}"
                                                       title="<fmt:message
                                                            key="haircut.duration.format" bundle="${rb}"/>"
                                                       placeholder="<fmt:message key="service.th.time" bundle="${ rb }"/>">
                                                <div class="invalid-feedback"><fmt:message
                                                        key="haircut.duration.format" bundle="${rb}"/></div>
                                            </div>
                                        </TD>
                                        <TD>
                                            <div class="form-outline">
                                                <input type="text" name="price" class="form-control"
                                                       placeholder="<fmt:message key="service.th.price" bundle="${ rb }"/>">
                                            </div>
                                        </TD>
                                        <TD class="text-center" colspan="2">
                                            <button type="submit" class="btn-outline-success rounded-1">
                                                <fmt:message key="admin.haircut.add" bundle="${ rb }"/></button>
                                        </TD>
                                    </form>
                                </TR>
                                <c:forEach items="${requestScope.haircuts}" var="haircut">
                                    <TR>
                                        <TD>${haircut.name}</TD>
                                        <TD class="text-center">${haircut.time} <fmt:message key="service.time"
                                                                                             bundle="${ rb }"/></TD>
                                        <TD class="text-center">${haircut.price} <fmt:message key="service.price"
                                                                                              bundle="${ rb }"/></TD>
                                        <TD class="text-center">
                                            <form action="controller" method="post">
                                                <input type="hidden" name="command" value="remove_haircut">
                                                <input type="hidden" name="haircutId" value="${haircut.id}">
                                                <button class="btn-outline-danger rounded-1" type="submit" name="view">
                                                    <fmt:message
                                                            key="admin.haircut.remove.td"
                                                            bundle="${ rb }"/></button>
                                            </form>
                                        </TD>
                                        <TD class="text-center">
                                            <form action="controller" method="post">
                                                <input type="hidden" name="command" value="go_to_edit_haircut">
                                                <input type="hidden" name="haircutId" value="${haircut.id}">
                                                <button class="btn-outline-primary rounded-1" type="submit"
                                                        name="change">
                                                    <fmt:message
                                                            key="admin.haircut.edit.td"
                                                            bundle="${ rb }"/></button>
                                            </form>
                                        </TD>

                                    </TR>
                                </c:forEach>
                            </TABLE>
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