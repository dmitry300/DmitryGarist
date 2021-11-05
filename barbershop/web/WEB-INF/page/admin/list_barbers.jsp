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
            <c:when test="${not empty sessionScope.user and not empty requestScope.barbers}">
                <div class="col py-3">
                    <div class="table-responsive">
                        <TABLE class="table align-middle caption-top table-hover d-flex align-items-center justify-content-center flex-column table-sm">
                            <CAPTION class="display-6 text-center mt-4 mb-4 w-75"><fmt:message
                                    key="header.barbers"
                                    bundle="${ rb }"/></CAPTION>
                            <TR>
                                <TH scope="col"><fmt:message key="user.name" bundle="${ rb }"/></TH>
                                <TH scope="col"><fmt:message key="user.surname" bundle="${ rb }"/></TH>
                                <TH scope="col"><fmt:message key="signup.patronymic" bundle="${ rb }"/></TH>
                                <TH scope="col"><fmt:message key="signup.birthday" bundle="${ rb }"/></TH>
                                <TH scope="col"><fmt:message key="barber.phone" bundle="${ rb }"/></TH>
                                <TH scope="col"><fmt:message key="barber.start_job" bundle="${ rb }"/></TH>
                                <TH scope="col"><fmt:message key="barber.photo.th" bundle="${ rb }"/></TH>
                                <TH scope="col"><fmt:message key="admin.remove.barber.th" bundle="${ rb }"/></TH>
                                <TH scope="col"><fmt:message key="admin.edit.barber.th" bundle="${ rb }"/></TH>
                            </TR>
                            <c:if test="${not empty requestScope.active_barbers}">
                                <TR>
                                    <form action="controller" class="d-flex flex-column needs-validation"
                                          method="post" enctype="multipart/form-data">
                                        <input type="hidden" name="command" value="add_barber">
                                        <TD>
                                            <div class="form-outline">
                                                <input type="text" id="name" name="name" class="form-control" required
                                                       placeholder="<fmt:message key="user.name" bundle="${ rb }"/>">
                                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                                           bundle="${rb}"/></div>
                                            </div>
                                        </TD>
                                        <TD>
                                            <div class="form-outline">
                                                <input type="text" id="surname" name="surname" class="form-control"
                                                       required
                                                       placeholder="<fmt:message key="user.surname" bundle="${ rb }"/>">
                                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                                           bundle="${rb}"/></div>
                                            </div>
                                        </TD>
                                        <TD>
                                            <div class="form-outline">
                                                <input type="text" id="patronymic" name="patronymic"
                                                       class="form-control" required
                                                       placeholder="<fmt:message key="signup.patronymic" bundle="${ rb }"/>">
                                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                                           bundle="${rb}"/></div>
                                            </div>
                                        </TD>
                                        <TD class="text-center">
                                            <div class="form-outline">
                                                <input type="date" id="birthday" name="birthday" class="form-control"
                                                       required
                                                       placeholder="<fmt:message key="signup.birthday" bundle="${ rb }"/>">
                                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                                           bundle="${rb}"/></div>
                                            </div>
                                        </TD>
                                        <TD>
                                            <div class="form-outline">
                                                <input type="tel" class="form-control" id="phone" name="phone"
                                                       placeholder="+375(XX) XXX-XX-XX"
                                                       pattern="\+375\s?[\(]{0,1}\d{2}[\)]{0,1}\s?\d{3}[-]{0,1}\d{2}[-]{0,1}\d{2}"
                                                       title="<fmt:message key="signup.hint.phone" bundle="${rb}"/>"
                                                       required/>
                                                <div class="invalid-feedback"><fmt:message key="signup.hint.phone"
                                                                                           bundle="${rb}"/></div>
                                            </div>
                                        </TD>
                                        <TD class="text-center">
                                            <div class="form-outline">
                                                <input type="date" id="startJob" name="startJob" class="form-control"
                                                       required
                                                       placeholder="<fmt:message key="barber.start_job" bundle="${ rb }"/>">
                                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                                           bundle="${rb}"/></div>
                                            </div>
                                        </TD>
                                        <TD>
                                            <div class="form-outline">
                                                <input type="file" id="fileInput" name="photo" class="form-control"
                                                       required
                                                       accept=".jpeg, .jpg">
                                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                                           bundle="${rb}"/></div>
                                            </div>
                                        </TD>
                                        <TD class="text-center" colspan="2">
                                            <button type="submit" id="submit" class="btn-outline-success rounded-1">
                                                <fmt:message key="admin.barber.add" bundle="${ rb }"/></button>
                                        </TD>
                                    </form>
                                </TR>
                            </c:if>
                            <c:forEach items="${requestScope.barbers}" var="user">
                                <TR>
                                    <TD>${user.name}</TD>
                                    <TD>${user.surname}</TD>
                                    <TD>${user.patronymic}</TD>
                                    <TD>${user.birthday}</TD>
                                    <TD>+${user.phone}</TD>
                                    <TD>${user.startJob}</TD>
                                    <TD>
                                        <img src="${pageContext.request.contextPath}/img?path=${user.photo}"
                                             height="70px" width="60px" alt="barber">
                                    </TD>
                                    <TD class="text-center">
                                        <form action="controller" method="post">
                                            <input type="hidden" name="command" value="remove_barber">
                                            <input type="hidden" name="barberId" value="${user.id}">
                                            <button class="btn-outline-danger rounded-1" type="submit" name="view">
                                                <fmt:message
                                                        key="admin.remove.barber.td"
                                                        bundle="${ rb }"/></button>
                                        </form>
                                    </TD>
                                    <TD class="text-center">
                                        <form action="controller" method="post">
                                            <input type="hidden" name="command" value="go_to_edit_barber">
                                            <input type="hidden" name="barberId" value="${user.id}">
                                            <button class="btn-outline-primary rounded-1" type="submit"
                                                    name="change">
                                                <fmt:message
                                                        key="admin.edit.barber.td"
                                                        bundle="${ rb }"/></button>
                                        </form>
                                    </TD>
                                </TR>
                            </c:forEach>
                        </TABLE>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="col py-3">
                    <div class="text-center">
                        <h3><fmt:message
                                key="service.list_empty" bundle="${ rb }"/></h3>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/list_barber.js"></script>
</body>
</html>
