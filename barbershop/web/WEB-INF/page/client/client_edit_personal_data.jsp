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
                <div class="col py-3">
                    <div class="align-middle d-flex w-100 align-items-center justify-content-center flex-column">
                        <form class="d-flex flex-column needs-validation w-50 mb-5" novalidate name="registrationForm"
                              action="controller" method="post">
                            <input type="hidden" name="command" value="client_edit_personal_data">
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="login" class="form-label"><fmt:message key="signup.login"
                                                                                       bundle="${rb}"/></label>
                                    <input type="text" placeholder="${sessionScope.user.login}" class="form-control"
                                           id="login"
                                           pattern="[A-Za-z][0-9a-zA-Z]{3,20}"
                                           title="<fmt:message key="signup.hint.login" bundle="${rb}"/>" name="login">
                                    <div class="invalid-feedback"><fmt:message key="signup.hint.login"
                                                                               bundle="${rb}"/></div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="password" class="form-label"><fmt:message key="signup.password"
                                                                                          bundle="${rb}"/></label>
                                    <input type="password" class="form-control" name="password" id="password"
                                           pattern="[A-Za-z0-9]{8,20}"
                                           title="<fmt:message key="signup.hint.password" bundle="${rb}"/>"/><br>
                                    <div class="invalid-feedback"><fmt:message key="signup.hint.password"
                                                                               bundle="${rb}"/></div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="repeatPassword" class="form-label"><fmt:message
                                            key="signup.password_repeated"
                                            bundle="${rb}"/></label>
                                    <input type="password" class="form-control" name="repeatPassword"
                                           id="repeatPassword"
                                           pattern="[A-Za-z0-9]{8,20}"
                                           title="<fmt:message key="signup.hint.password" bundle="${rb}"/>"/><br>
                                    <div class="invalid-feedback"><fmt:message key="signup.hint.password"
                                                                               bundle="${rb}"/></div>
                                </div>
                            </div>

                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="name" class="form-label"><fmt:message key="signup.name"
                                                                                      bundle="${rb}"/></label>
                                    <input type="text" placeholder="${sessionScope.user.userInfo.name}"
                                           class="form-control"
                                           name="name" id="name"
                                           pattern="([ЁА-Я][ёа-я]{1,20})|([A-Z][a-z]{1,20})"
                                           title="<fmt:message key="signup.hint.name" bundle="${rb}"/>"/><br>
                                    <div class="invalid-feedback"><fmt:message key="signup.hint.name"
                                                                               bundle="${rb}"/></div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="surname" class="form-label"><fmt:message key="signup.surname"
                                                                                         bundle="${rb}"/></label>
                                    <input type="text" placeholder="${sessionScope.user.userInfo.surname}"
                                           class="form-control"
                                           name="surname" id="surname"
                                           pattern="([ЁА-Я][ёа-я]{1,20})|([A-Z][a-z]{1,20})"
                                           title="<fmt:message key="signup.hint.name" bundle="${rb}"/>"/><br>
                                    <div class="invalid-feedback"><fmt:message key="signup.hint.name"
                                                                               bundle="${rb}"/></div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="patronymic" class="form-label"><fmt:message key="signup.patronymic"
                                                                                            bundle="${rb}"/></label>
                                    <input type="text" placeholder="${sessionScope.user.userInfo.patronymic}"
                                           class="form-control"
                                           name="patronymic" id="patronymic"
                                           pattern="([ЁА-Я][ёа-я]{1,20})|([A-Z][a-z]{1,20})"
                                           title="<fmt:message key="signup.hint.name" bundle="${rb}"/>"/><br>
                                    <div class="invalid-feedback"><fmt:message key="signup.hint.name"
                                                                               bundle="${rb}"/></div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="phone" class="form-label"><fmt:message key="signup.phone"
                                                                                       bundle="${rb}"/></label>
                                    <input type="tel" class="form-control" name="phone" id="phone"
                                           placeholder="${sessionScope.user.userInfo.phone}"
                                           pattern="\+375\s?[\(]{0,1}\d{2}[\)]{0,1}\s?\d{3}[-]{0,1}\d{2}[-]{0,1}\d{2}"
                                           title="<fmt:message key="signup.hint.phone" bundle="${rb}"/>"/><br>
                                    <div class="invalid-feedback"><fmt:message key="signup.hint.phone"
                                                                               bundle="${rb}"/></div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="birthday" class="form-label"><fmt:message key="signup.birthday"
                                                                                      bundle="${rb}"/></label>
                                <input type="text" placeholder="${sessionScope.user.userInfo.birthday}"
                                       onfocus="(this.type='datetime-local')"
                                       onblur="(this.type='text')"
                                       class="form-control"
                                       name="birthday" id="birthday"/><br>
                            </div>
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="email" class="form-label"><fmt:message key="signup.email"
                                                                                       bundle="${rb}"/></label>
                                    <input type="email" placeholder="${sessionScope.user.userInfo.email}"
                                           class="form-control"
                                           name="email" id="email"/><br>
                                </div>
                            </div>
                            <button id="signup_btn" type="submit" class="btn btn-success mt-2 mb-3" value="Edit"
                                    onClick="if (password.value !== repeatPassword.value) alert('Пароли не совпадают');">
                                <fmt:message key="client.edit_profile" bundle="${rb}"/>
                            </button>
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
</body>
</html>

