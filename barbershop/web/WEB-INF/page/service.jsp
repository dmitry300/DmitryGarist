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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
    </script>
    <link href="${pageContext.request.contextPath}/css/service.css" rel="stylesheet">
    <title><fmt:message key="company.name" bundle="${rb}"/></title>
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>
<c:choose>
    <c:when test="${not empty requestScope.services}">
        <div class="table-responsive mb-5">
            <TABLE class="table align-middle caption-top table-hover d-flex w-100 align-items-center justify-content-center flex-column">
                <CAPTION class="display-6 text-center mt-4 mb-4 w-75"><fmt:message key="service.caption"
                                                                                   bundle="${ rb }"/></CAPTION>
                <TR class="table-primary">
                    <TH scope="col"><fmt:message key="service.th.name" bundle="${ rb }"/></TH>
                    <TH scope="col"><fmt:message key="service.th.time" bundle="${ rb }"/></TH>
                    <TH scope="col"><fmt:message key="service.th.price" bundle="${ rb }"/></TH>
                </TR>
                <c:forEach items="${requestScope.services}" var="haircut">
                    <TR>
                        <TD>${haircut.name}</TD>
                        <TD>${haircut.time} <fmt:message key="service.time" bundle="${ rb }"/></TD>
                        <TD>${haircut.price} <fmt:message key="service.price" bundle="${ rb }"/></TD>
                    </TR>
                </c:forEach>
            </TABLE>
        </div>
    </c:when>
    <c:otherwise>
        <p><fmt:message key="service.list_empty" bundle="${ rb }"/></p>
    </c:otherwise>
</c:choose>

<jsp:include page="footer.jsp"/>
</body>
</html>
