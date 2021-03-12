<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Suma salarial Session</h1>
        <c:choose>
            <c:when test="${sessionScope.SUMASALARIAL != null}">
                <h1 style="color: chocolate">
                    La suma salarial es: <c:out value="${sessionScope.SUMASALARIAL}"/>
                </h1>
            </c:when>
            <c:otherwise>
                <h1 style="color:red">No existen salarios almacenados</h1>
            </c:otherwise>
        </c:choose>
    </body>
</html>
