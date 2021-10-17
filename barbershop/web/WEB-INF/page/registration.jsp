<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <link href="${pageContext.request.contextPath}/css/registration.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>
<div class="signup-outer pt-3 pb-3">
    <div class="signup-inner d-flex flex-column p-4">
        <h1 class="fs-3 mb-3"><fmt:message key="signup.message" bundle="${rb}"/></h1>

        <c:if test="${sessionScope.is_signup_error != null}">
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
        <div id="passwords_mismatch" class="alert alert-danger align-items-center" role="alert">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                 class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img"
                 aria-label="Warning:">
                <path
                        d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path>
            </svg>
            <div>
                <fmt:message key="signup.passwords_mismatch" bundle="${rb}"/>
            </div>
        </div>
        <form class="d-flex flex-column needs-validation" novalidate name="registrationForm" action="controller"
              method="post">
            <input type="hidden" name="command" value="registration" required>
            <div class="mb-3">
                <div class="form-outline">
                    <label for="role_select" class="form-label"><fmt:message key="signup.role" bundle="${rb}"/></label>
                    <select class="form-select" id="role_select" name="role">
                        <option selected value="CLIENT"><fmt:message key="signup.role.client" bundle="${rb}"/></option>
                        <option value="ADMIN"><fmt:message key="signup.role.admin" bundle="${rb}"/></option>
                    </select>
                    <div class="invalid-feedback"><fmt:message key="signup.role" bundle="${rb}"/></div>
                </div>
            </div>
            <div class="mb-3">
                <div class="form-outline">
                    <label for="login" class="form-label"><fmt:message key="signup.login" bundle="${rb}"/></label>
                    <input type="text" class="form-control" id="login" pattern="[A-Za-z][0-9a-zA-Z]{3,20}"
                           title="<fmt:message key="signup.hint.login" bundle="${rb}"/>" name="login" required>
                    <div class="invalid-feedback"><fmt:message key="signup.hint.login" bundle="${rb}"/></div>
                </div>
            </div>
            <div class="mb-3">
                <div class="form-outline">
                    <label for="password" class="form-label"><fmt:message key="signup.password" bundle="${rb}"/></label>
                    <input type="password" class="form-control" name="password" id="password"
                           pattern="[A-Za-z0-9]{8,20}"
                           title="<fmt:message key="signup.hint.password" bundle="${rb}"/>" required/><br>
                    <div class="invalid-feedback"><fmt:message key="signup.hint.password" bundle="${rb}"/></div>
                </div>
            </div>
            <div class="mb-3">
                <div class="form-outline">
                    <label for="repeatPassword" class="form-label"><fmt:message key="signup.password_repeated"
                                                                                bundle="${rb}"/></label>
                    <input type="password" class="form-control" name="repeatPassword" id="repeatPassword"
                           pattern="[A-Za-z0-9]{8,20}"
                           title="<fmt:message key="signup.hint.password" bundle="${rb}"/>" required/><br>
                    <div class="invalid-feedback"><fmt:message key="signup.hint.password" bundle="${rb}"/></div>
                </div>
            </div>

            <div class="mb-3">
                <div class="form-outline">
                    <label for="name" class="form-label"><fmt:message key="signup.name" bundle="${rb}"/></label>
                    <input type="text" class="form-control" name="name" id="name"
                           pattern="([ЁА-Я][ёа-я]{1,20})|([A-Z][a-z]{1,20})"
                           title="<fmt:message key="signup.hint.name" bundle="${rb}"/>" required/><br>
                    <div class="invalid-feedback"><fmt:message key="signup.hint.name" bundle="${rb}"/></div>
                </div>
            </div>
            <div class="mb-3">
                <div class="form-outline">
                    <label for="surname" class="form-label"><fmt:message key="signup.surname" bundle="${rb}"/></label>
                    <input type="text" class="form-control" name="surname" id="surname"
                           pattern="([ЁА-Я][ёа-я]{1,20})|([A-Z][a-z]{1,20})"
                           title="<fmt:message key="signup.hint.name" bundle="${rb}"/>" required/><br>
                    <div class="invalid-feedback"><fmt:message key="signup.hint.name" bundle="${rb}"/></div>
                </div>
            </div>
            <div class="mb-3">
                <div class="form-outline">
                    <label for="patronymic" class="form-label"><fmt:message key="signup.patronymic"
                                                                            bundle="${rb}"/></label>
                    <input type="text" class="form-control" name="patronymic" id="patronymic"
                           pattern="([ЁА-Я][ёа-я]{1,20})|([A-Z][a-z]{1,20})"
                           title="<fmt:message key="signup.hint.name" bundle="${rb}"/>"/><br>
                    <div class="invalid-feedback"><fmt:message key="signup.hint.name" bundle="${rb}"/></div>
                </div>
            </div>
            <div class="mb-3">
                <div class="form-outline">
                    <label for="phone" class="form-label"><fmt:message key="signup.phone" bundle="${rb}"/></label>
                    <input type="tel" class="form-control" name="phone" id="phone" placeholder="+375(XX) XXX-XX-XX"
                           pattern="\+375\s?[\(]{0,1}\d{2}[\)]{0,1}\s?\d{3}[-]{0,1}\d{2}[-]{0,1}\d{2}"
                           title="<fmt:message key="signup.hint.phone" bundle="${rb}"/>" required/><br>
                    <div class="invalid-feedback"><fmt:message key="signup.hint.phone" bundle="${rb}"/></div>
                </div>
            </div>
            <div class="mb-3">
                <label for="birthday" class="form-label"><fmt:message key="signup.birthday" bundle="${rb}"/></label>
                <input type="date" class="form-control" name="birthday" id="birthday"/><br>
            </div>
            <div class="mb-3">
                <div class="form-outline">
                    <label for="email" class="form-label"><fmt:message key="signup.email" bundle="${rb}"/></label>
                    <input type="email" class="form-control" name="email" id="email" required/><br>
                </div>
            </div>
            <button id="signup_btn" type="submit" class="btn btn-success mt-2 mb-3" value="Registration"
                    onClick="if (password1.value !== password2.value) alert('Пароли не совпадают');" >
                <fmt:message key="signup.button"
                             bundle="${rb}"/></button>
            <p class=" fs-6
            "><fmt:message key="signup.have_account" bundle="${rb}"/>
            <a class="login_link"
               href="${pageContext.request.contextPath}/controller?command=go_to_login"><fmt:message
                    key="login_page.login_button" bundle="${rb}"/></a>
            </p>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/registration.js"></script>
</body>
</html>
