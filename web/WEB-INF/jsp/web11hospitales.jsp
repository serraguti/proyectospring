<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>DI Hospitales</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Teléfono</th>
                    <th>Camas</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${HOSPITALES}" var="hospital">
                    <tr>
                        <td>
                            <c:out value="${hospital.idHospital}"/>
                        </td>
                        <td>
                            <c:out value="${hospital.nombre}"/>
                        </td>
                        <td>
                            <c:out value="${hospital.direccion}"/>
                        </td>
                        <td>
                            <c:out value="${hospital.telefono}"/>
                        </td>
                        <td>
                            <c:out value="${hospital.camas}"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
