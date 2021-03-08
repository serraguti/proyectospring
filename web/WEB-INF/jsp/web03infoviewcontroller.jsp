<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sumar números</h1>
        <form method="post">
            <label>Número 1: </label>
            <input type="text" name="numero1" required/><br/>
            <label>Número 2: </label>
            <input type="text" name="numero2" required/><br/>
            <button type="submit">Mostrar suma</button>
        </form>
        <c:if test="${RESPUESTA != null}">
            <c:out value="${RESPUESTA}" escapeXml="false"/>
        </c:if>
    </body>
</html>
