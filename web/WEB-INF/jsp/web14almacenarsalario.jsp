<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Almacenar salarios Session</h1>
        <a href="web14mostrarsumasalarial.htm">Mostrar suma salarial</a>
        
        <c:if test="${SALARIO != null}">
        <h1 style="color:blue">
            Salario almacenado: <c:out value="${SALARIO}"/>
        </h1>            
        </c:if>

        <ul>
            <c:forEach items="${EMPLEADOS}" var="empleado">
                <li>
                    <c:out value="${empleado.apellido}"/>
                    <a href="web14almacenarsalario.htm?salario=${empleado.salario}">
                        Almacenar salario
                    </a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
