<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Departamentos Container Repository</h1>
        <form method="post">
            <label>Id departamento </label>
            <input type="text" name="id" required/>
            <button type="submit">Buscar departamento</button>
        </form>
        <hr/>
        <c:if test="${DEPARTAMENTO != null}">
            <hr/>
            <h1 style="color:blue">
                <c:out value="${DEPARTAMENTO.nombre}"/>, 
                <c:out value="${DEPARTAMENTO.localidad}"/>
            </h1>
        </c:if>
    </body>
</html>