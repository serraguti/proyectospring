<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tenista</h1>
        <hr/>
        <h1 style="color:fuchsia">
            <c:out value="${GRANDSLAM.descripcion}"/>
        </h1>
        <h1 style="color:blue">
            <c:out value="${GRANDSLAM.tenista.nombre}"/>
        </h1>
        <h1 style="color:red">
            <c:out value="${GRANDSLAM.tenista.palmares}"/>
        </h1>
        <img src="${GRANDSLAM.tenista.imagen}" style="width: 400px; height: 400px"/>        
        <h1 style="color:blue">
            <c:out value="${TENISTA.nombre}"/>
        </h1>
        <h1 style="color:red">
            <c:out value="${TENISTA.palmares}"/>
        </h1>
        <img src="${TENISTA.imagen}" style="width: 400px; height: 400px"/>
    </body>
</html>
