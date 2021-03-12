<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color:blue">Almacenar Empleados Session</h1>
        <a href="web15mostrarempleados.htm">Mostrar empleados session</a>
        <c:if test="${ALMACENADOS != null}">
            <h1 style="color:red">
                Empleados almacenados: <c:out value="${ALMACENADOS}"/>
            </h1>                
        </c:if>
        <ul>
            <c:forEach items="${EMPLEADOS}" var="empleado">
                <li>
                    <c:out value="${empleado.apellido}"/>
                    <a href="web15almacenarempleados.htm?id=${empleado.idEmpleado}">
                        Almacenar empleado
                    </a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
