<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.training.barbershop.bean.UserRole" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="content" var="rb"/>

<header class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold"
           href="${pageContext.request.contextPath}/controller?command=home"><fmt:message key="company.name"
                                                                                          bundle="${ rb }"/></a>
        <div class="d-flex justify-content-around">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page"
                   href="${pageContext.request.contextPath}/controller?command=home"><fmt:message key="header.home"
                                                                                                  bundle="${ rb }"/></a>
                <a class="nav-link " aria-current="page"
                   href="${pageContext.request.contextPath}/controller?command=go_to_about_us"><fmt:message key="header.about_us"
                                                                                                   bundle="${ rb }"/></a>
                <a class="nav-link " aria-current="page"
                   href="${pageContext.request.contextPath}/controller?command=services"><fmt:message
                        key="header.services"
                        bundle="${ rb }"/></a>
                <a class="nav-link " aria-current="page"
                   href="${pageContext.request.contextPath}/controller?command=barbers"><fmt:message
                        key="header.barbers"
                        bundle="${ rb }"/></a>
                <c:choose>
                    <c:when test="${sessionScope.user == null}">
                        <a href="${pageContext.request.contextPath}/controller?command=go_to_login"
                           type="button"
                           class="btn btn-outline-primary me-2"><fmt:message
                                key="header.login"
                                bundle="${ rb }"/></a>
                        <a class="btn btn-primary" aria-current="page" type="button"
                           href="${pageContext.request.contextPath}/controller?command=go_to_registration"><fmt:message
                                key="header.registration"
                                bundle="${ rb }"/></a>
                    </c:when>
                    <c:when test="${sessionScope.user.role eq UserRole.CLIENT}">
                        <a class="nav-link " aria-current="page"
                           href="${pageContext.request.contextPath}/controller?command=student_lesson_schedule">
                            <fmt:message key="header.profile" bundle="${ rb }"/></a>
                    </c:when>
                    <c:when test="${sessionScope.user.role eq UserRole.ADMIN}">
                        <a class="nav-link " aria-current="page"
                           href="${pageContext.request.contextPath}/controller?command=all_lessons_page">
                            <fmt:message key="header.profile" bundle="${ rb }"/>
                        </a>
                    </c:when>
                </c:choose>
                <c:if test="${sessionScope.user != null}">
                    <a href="${pageContext.request.contextPath}/controller?command=logout"
                       review="button"
                       class="btn btn-secondary"><fmt:message key="header.logout" bundle="${ rb }"/></a>
                </c:if>
            </div>
        </div>
    </div>
</header>
