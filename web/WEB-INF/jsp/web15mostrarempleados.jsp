<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Empleados Almacenados</h1>
        <a href="web15almacenarempleados.htm">Mostrar almacenar empleados session</a>
        <c:choose>
            <c:when test="${sessionScope.LISTAIDS != null}">
                <table border="1">
                    <c:forEach items="${EMPLEADOSSESSION}" var="emp">
                        <tr>
                            <td>
                                <c:out value="${emp.apellido}"/>    
                            </td>
                            <td>
                                <c:out value="${emp.oficio}"/>
                            </td>
                            <td>
                                <c:out value="${emp.salario}"/>
                            </td>
                            <td>
                                <a href="web15mostrarempleados.htm?eliminar=${emp.idEmpleado}">
                                    Quitar de Session
                                </a>                                
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h1 style="color:red">No existen empleados almacenados</h1>
            </c:otherwise>
        </c:choose>
    </body>
</html>
