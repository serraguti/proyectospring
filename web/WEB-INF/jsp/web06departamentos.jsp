<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Departamentos Spring</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Localidad</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${DEPARTAMENTOS}" var="dept">
                    <tr>
                        <td>
                            <c:out value="${dept.idDepartamento}"/>
                        </td>
                        <td>
                            <c:out value="${dept.nombre}"/>
                        </td>
                        <td>
                            <c:out value="${dept.localidad}"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
