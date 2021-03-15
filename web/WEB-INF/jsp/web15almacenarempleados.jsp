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
        <h2 style="color:blue">
            <c:out value="${MENSAJE}"/>
        </h2>
        <a href="web15mostrarempleados.htm">Mostrar empleados session</a>
        <c:if test="${ALMACENADOS != null}">
            <h1 style="color:red">
                Empleados almacenados: <c:out value="${ALMACENADOS}"/>
            </h1>                
        </c:if>
        <ul>
            <!--DECLARAR UNA VARIABLE PARA GUARDAR SESSION-->
            <c:set var="seleccionados" value="${sessionScope.LISTAIDS}"/>
            <c:forEach items="${EMPLEADOS}" var="empleado">
                <li>
                    <c:out value="${empleado.apellido}"/>
                    <!--DEBEMOS PREGUNTAR SI EXISTE EL EMPLEADO QUE -->
                    <!--ESTAMOS DIBUJANDO EN LOS SELECCIONADOS (SESSION)-->
                    <c:choose>
                        <c:when test="${seleccionados.contains(empleado.idEmpleado.toString())}">
                            <img src="images/check.jpg" style="width:20px; height:20px"/>
                        </c:when>
                        <c:otherwise>
                            <a href="web15almacenarempleados.htm?id=${empleado.idEmpleado}">
                                Almacenar empleado
                            </a>                            
                        </c:otherwise>
                    </c:choose>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
