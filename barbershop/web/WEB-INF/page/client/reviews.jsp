<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="content" var="rb"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/barber.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/review.css" rel="stylesheet">
    <title><fmt:message key="company.name" bundle="${rb}"/> - <fmt:message key="page.name.error"
                                                                           bundle="${rb}"/></title>
</head>
<body>
<jsp:include page="../header.jsp" flush="true"/>
<c:choose>
    <c:when test="${not empty sessionScope.user
     and not empty requestScope.barber}">
        <c:set var="barber" value="${requestScope.barber}"/>
        <div class="align-middle d-flex w-100 align-items-center justify-content-center flex-column">
            <div class="row">
                <div class="col-md-6 card-body">
                    <h5 class="card-title display-4">${barber.surname} ${barber.name} ${barber.patronymic}</h5>
                    <p class="card-text fs-5">
                            ${barber.birthday} <fmt:message key="barber.birthday" bundle="${ rb }"/><br>
                        <fmt:message key="barber.phone" bundle="${ rb }"/>: +${barber.phone}<br>
                        <a href="${barber.tiktokLink}" class="card-link"><fmt:message key="barber.tiktok"
                                                                                      bundle="${ rb }"/></a>
                    </p>
                </div>
                <div class="col-md-6 card-body">
                    <img src="${pageContext.request.contextPath}/img?path=${barber.photo}"
                         class="card-img-top" alt="barber">
                </div>

            </div>
        </div>
        <div class="d-flex flex-column justify-content-center align-items-center">
            <c:if test="${empty requestScope.reviews}">
                <p><fmt:message key="review.barber_id" bundle="${ rb }"/></p>
            </c:if>
            <form action="controller" method="post" class="w-75 mb-4 mt-4">
                <input type="hidden" name="command" value="add_review">
                <input type="hidden" name="barberId" value="${barber.id}">
                <div class="mb-3">
                    <label>
                            <textarea placeholder="Enter your comment" class="form-control" name="content"
                                      rows="5" required></textarea>
                    </label>
                </div>
                <button type="submit" class="btn btn-outline-success w-25"><fmt:message key="review.button.send"
                                                                                        bundle="${rb}"/></button>
            </form>
            <h2 class="display-4 mt-4"><fmt:message key="review" bundle="${rb}"/></h2>
            <c:if test="${not empty requestScope.reviews}">
                <c:forEach items="${requestScope.reviews}" var="review">
                    <div class="review d-flex w-75 flex-column mt-4 mb-4 p-4">
                        <div class="d-flex justify-content-between align-items-center">
                            <p class="fs-4">${review.user.userInfo.name} ${review.user.userInfo.surname}</p>
                            <p class="fs-6">${review.commentData}</p>
                        </div>
                        <div class="d-flex justify-content-between">
                            <p class="review-text display-1 fs-2">${review.comment}</p>
                            <c:if test="${sessionScope.user.id == review.user.id and sessionScope.user.role == 'CLIENT'}">
                                <form action="controller" method="post">
                                    <input type="hidden" name="command" value="remove_review">
                                    <input type="hidden" name="reviewId" value="${review.id}">
                                    <div class="buttons">
                                        <button class="btn btn-outline-danger" data-target="#block_1">
                                            <fmt:message key="admin.review.remove" bundle="${ rb }"/></button>
                                    </div>
                                </form>
                                <form action="controller" method="post">
                                    <input type="hidden" name="command" value="go_to_edit_review">
                                    <input type="hidden" name="reviewId" value="${review.id}">
                                    <button class="btn  btn-outline-success">
                                        <fmt:message key="admin.review.edit" bundle="${ rb }"/></button>
                                </form>
                            </c:if>
                            <c:if test="${sessionScope.user.role == 'ADMIN'}">
                                <form action="controller" method="post">
                                    <input type="hidden" name="command" value="remove_review">
                                    <input type="hidden" name="reviewId" value="${review.id}">
                                    <button class="btn  btn-outline-danger">
                                        <fmt:message key="admin.review.remove" bundle="${ rb }"/></button>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </c:when>
    <c:otherwise>
        <P><fmt:message key="service.list_empty" bundle="${ rb }"/></P>
    </c:otherwise>
</c:choose>
<jsp:include page="../footer.jsp"/>
</body>
</html>
