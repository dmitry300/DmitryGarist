<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Table</title>
</head>
<body>
<table>
    <caption>XML Data</caption>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Pharm</th>
        <th scope="col">Group</th>
        <th scope="col">Analogs</th>
        <th scope="col">Version</th>
        <th scope="col">Certificate</th>
        <th scope="col">Package</th>
        <th scope="col">Dosage</th>
    </tr>
    <c:forEach var="med" items="${requestScope.setMedicines}">
        <tr>
            <td><c:out value="${med.name}"/></td>
            <td><c:out value="${med.pharm}"/></td>
            <td><c:out value="${med.group}"/></td>
            <td><c:out value="${med.analogs}"/></td>
            <td><c:out value="${med.version}"/></td>
            <td><c:out value="${med.certificate}"/></td>
            <td><c:out value="${med.packageMedicine}"/></td>
            <td><c:out value="${med.dosage}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
