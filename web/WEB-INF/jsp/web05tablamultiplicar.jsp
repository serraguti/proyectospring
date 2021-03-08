<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla multiplicar</h1>
        <form method="post">
            <label>Introduzca número: </label>
            <input type="text" name="numero" required/><br/>
            <button type="submit">Mostrar tabla multiplicar</button>
        </form>
        <c:if test="${TABLA != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Operación</th>
                        <th>Resultado</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${TABLA}" var="fila">
                        <tr>
                            <td>
                                <c:out value="${fila.operacion}"/>
                            </td>
                            <td>
                                <c:out value="${fila.resultado}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
