<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="content" var="rb"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">
<head>
    <title>Barbershop</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>
<div id="home_carousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#home_carousel " data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#home_carousel" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#home_carousel" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="${pageContext.request.contextPath}/img/slide1.jpg" class="d-block w-100" alt="slide 1">
            <div class="carousel-caption d-none d-md-block">
                <h5 class="fs-1 mb-4"><fmt:message key="slide.first.label" bundle="${ rb }"/></h5>
                <p class="fs-5"><fmt:message key="slide.first.content" bundle="${ rb }"/></p>
            </div>
        </div>

        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/img/slide2.jpg" class="d-block w-100" alt="slide 2">
            <div class="carousel-caption d-none d-md-block">
                <h5 class="fs-1 mb-4"><fmt:message key="slide.second.label" bundle="${ rb }"/></h5>
                <p class="fs-5"><fmt:message key="slide.second.content" bundle="${ rb }"/></p>
            </div>
        </div>

        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/img/slide3.jpg" class="d-block w-100" alt="slide 2">
            <div class="carousel-caption d-none d-md-block">
                <h5 class="fs-1 mb-4"><fmt:message key="slide.third.label" bundle="${ rb }"/></h5>
                <p class="fs-5"><fmt:message key="slide.third.content" bundle="${ rb }"/></p>
            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#home_carousel"
            data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#home_carousel"
            data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<jsp:include page="footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
