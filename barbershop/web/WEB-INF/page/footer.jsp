<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="content" var="rb"/>

<footer class="navbar navbar-expand-lg navbar-light bg-light ">
    <div class="container-fluid d-flex justify-content-between">
        <div class="navbar-nav">
            <form method="post" action="controller">
                <input type="hidden" name="command" value="language">
                <input type="hidden" name="language" value="en">
                <button class="btn nav-link fw-bold" type="submit">En</button>
            </form>
            <span class="nav-link disabled"> | </span>
            <form method="post" action="controller">
                <input type="hidden" name="command" value="language">
                <input type="hidden" name="language" value="ru">
                <button class="btn nav-link fw-bold" type="submit">Рус</button>
            </form>
        </div>
        <div>
            <span class="copyright"> &copy; 2021 Copyright: Barbershop, "Magnifique" </span>
        </div>
    </div>
</footer>
