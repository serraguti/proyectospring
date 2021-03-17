<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Paginar departamentos</h1>
        <dl>
            <dt>Número: <c:out value="${DEPARTAMENTO.idDepartamento}"/></dt>
            <dd>Nombre: <c:out value="${DEPARTAMENTO.nombre}"/></dd>
            <dd>Localidad: <c:out value="${DEPARTAMENTO.localidad}"/> </dd>
        </dl>
        <hr/>
        <a href="web20paginardepartamentos.htm?posicion=1">Primero</a> |
        <a href="web20paginardepartamentos.htm?posicion=${ANTERIOR}">Anterior</a> |
        <a href="web20paginardepartamentos.htm?posicion=${SIGUIENTE}">Siguiente</a> |
        <a href="web20paginardepartamentos.htm?posicion=${ULTIMO}">Ultimo</a>
    </body>
</html>
