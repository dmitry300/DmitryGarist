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
            <c:when test="${not empty sessionScope.user and not empty requestScope.barber}">
                <div class="col py-3">
                    <div class="align-middle d-flex w-100 align-items-center justify-content-center flex-column">
                        <form class="d-flex flex-column needs-validation w-50" novalidate name="registrationForm"
                              action="controller" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="command" value="edit_barber">
                            <input type="hidden" name="barberId" value="${requestScope.barber.id}">
                            <div class="form-outline mb-3">
                                <label for="name" class="form-label"><fmt:message key="user.name"
                                                                                  bundle="${rb}"/></label>
                                <input type="text" id="name" name="name" class="form-control"
                                       value="${requestScope.barber.name}">
                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                           bundle="${rb}"/></div>
                            </div>
                            <div class="form-outline mb-3">
                                <label for="surname" class="form-label"><fmt:message key="user.surname"
                                                                                     bundle="${rb}"/></label>
                                <input type="text" id="surname" name="surname" class="form-control"
                                       value="${requestScope.barber.surname}">
                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                           bundle="${rb}"/></div>
                            </div>
                            <div class="form-outline mb-3">
                                <label for="patronymic" class="form-label"><fmt:message key="signup.patronymic"
                                                                                        bundle="${rb}"/></label>
                                <input type="text" id="patronymic" name="patronymic"
                                       class="form-control"
                                       value="${requestScope.barber.patronymic}">
                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                           bundle="${rb}"/></div>
                            </div>
                            <div class="form-outline mb-3">
                                <label for="birthday" class="form-label"><fmt:message key="signup.birthday"
                                                                                      bundle="${rb}"/></label>
                                <input type="text" id="birthday" name="birthday" class="form-control"
                                       value="${requestScope.barber.birthday}"
                                       onfocus="(this.type='date')"
                                       onblur="(this.type='text')">
                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                           bundle="${rb}"/></div>
                            </div>
                            <div class="form-outline mb-3">
                                <label for="phone" class="form-label"><fmt:message key="barber.phone"
                                                                                   bundle="${rb}"/></label>
                                <input type="tel" class="form-control" id="phone" name="phone"
                                       value="${requestScope.barber.phone}"
                                       pattern="\+375\s?[\(]{0,1}\d{2}[\)]{0,1}\s?\d{3}[-]{0,1}\d{2}[-]{0,1}\d{2}"
                                       title="<fmt:message key="signup.hint.phone" bundle="${rb}"/>"/>
                                <div class="invalid-feedback"><fmt:message key="signup.hint.phone"
                                                                           bundle="${rb}"/></div>
                            </div>
                            <div class="form-outline mb-3">
                                <label for="tiktok" class="form-label"><fmt:message key="barber.tiktok"
                                                                                    bundle="${rb}"/></label>
                                <input type="text" id="tiktok" class="form-control" name="tiktok"
                                       value="${requestScope.barber.tiktokLink}"/>
                            </div>
                            <div class="form-outline mb-3">
                                <label for="startJob" class="form-label"><fmt:message key="barber.start_job"
                                                                                      bundle="${rb}"/></label>
                                <input type="text" id="startJob" name="startJob" class="form-control"
                                       value="${requestScope.barber.startJob}"
                                       onfocus="(this.type='date')"
                                       onblur="(this.type='text')">
                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                           bundle="${rb}"/></div>
                            </div>
                            <div class="form-outline mb-3">
                                <label for="endJob" class="form-label"><fmt:message key="barber.end_job"
                                                                                    bundle="${rb}"/></label>
                                <input type="text" id="endJob" name="endJob" class="form-control"
                                       value="${requestScope.barber.endJob}"
                                       onfocus="(this.type='date')"
                                       onblur="(this.type='text')">
                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                           bundle="${rb}"/></div>
                            </div>
                            <div class="form-outline mb-3">
                                <label for="fileInput" class="form-label"><fmt:message key="admin.barber.change_photo"
                                                                                       bundle="${rb}"/></label>
                                <input type="file" id="fileInput" name="photo" class="form-control"
                                       accept=".jpeg, .jpg">
                                <div class="invalid-feedback"><fmt:message key="field.is_important"
                                                                           bundle="${rb}"/></div>
                            </div>
                            <button type="submit" id="submit" class="btn-outline-success rounded-1">
                                <fmt:message key="button.submit" bundle="${ rb }"/></button>
                        </form>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>