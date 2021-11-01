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
                <c:if test="${not empty requestScope.haircut}">
                    <div class="col py-3">
                        <form action="controller" method="post" class="d-flex flex-column needs-validation">
                            <input type="hidden" name="command" value="edit_haircut">
                            <input type="hidden" name="haircutId" value="${requestScope.haircut.id}">
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="name" class="form-label"><fmt:message key="haircut.name"
                                                                                      bundle="${rb}"/></label>
                                    <input type="text" class="form-control" id="name" name="name"
                                           value="${requestScope.haircut.name}">
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="price" class="form-label"><fmt:message key="haircut.price"
                                                                                       bundle="${rb}"/></label>
                                    <input type="text" class="form-control" id="price" name="price"
                                           value="${requestScope.haircut.price}">
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="form-outline">
                                    <label for="duration" class="form-label"><fmt:message key="haircut.duration"
                                                                                          bundle="${rb}"/></label>
                                    <input type="text" value="${requestScope.haircut.time}"
                                           class="form-control" name="duration" id="duration"
                                           pattern="\d{2}[:]\d{2}[:]\d{2}"/><br>
                                    <div class="invalid-feedback"><fmt:message
                                            key="haircut.duration.format" bundle="${rb}"/></div>

                                </div>
                            </div>
                            <button id="order_button"
                                    type="submit" class="btn btn-success mt-2 mb-3" value="Order">
                                <fmt:message key="order.button" bundle="${rb}"/>
                            </button>
                        </form>
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
</body>
</html>
