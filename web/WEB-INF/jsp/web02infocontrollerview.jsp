<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Información Controller Vista</h1>
        <h2 style="color:blue">
            <c:out value="${mensaje}"/>
        </h2>
        <c:out value="${html}" escapeXml="false"/>
        <hr/>
        <dl>
            <dt>Nombre: <c:out value="${PERSONA.nombre}"/> </dt>
            <dd>Email: <c:out value="${PERSONA.email}"/> </dd>
            <dd>Edad: <c:out value="${PERSONA.edad}"/> </dd>
        </dl>
    </body>
</html>
