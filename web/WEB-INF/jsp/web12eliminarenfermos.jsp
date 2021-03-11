<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminar enfermos DI</h1>
        <form method="post">
            <label>Inscripción </label>
            <input type="text" name="inscripcion" required/>
            <button type="submit">Eliminar enfermo</button>
        </form>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Inscripción</th>
                    <th>Apellido</th>
                    <th>Dirección</th>
                    <th>Sexo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ENFERMOS}" var="enf">
                    <tr>
                        <td>
                            <c:out value="${enf.inscripcion}"/>
                        </td>
                        <td>
                            <c:out value="${enf.apellido}"/>
                        </td>
                        <td>
                            <c:out value="${enf.direccion}"/>
                        </td>
                        <td>
                            <c:out value="${enf.sexo}"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
