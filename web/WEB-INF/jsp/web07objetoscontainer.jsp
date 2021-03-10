<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Objetos Container</h1>
        <h1>Tenista</h1>
        <h1 style="color:blue">
            <c:out value="${TENISTA.nombre}"/>
        </h1>
        <h1 style="color:red">
            <c:out value="${TENISTA.palmares}"/>
        </h1>
        <img src="${TENISTA.imagen}" style="width: 400px; height: 400px"/>        
        <h2 style="color:blue">
            <c:out value="${CAR.marca}"/> 
            <c:out value="${CAR.modelo}"/>
        </h2>
        <h2 style="color:red">
            Velocidad máxima: <c:out value="${CAR.velocidadMaxima}"/>
        </h2>
        <hr/>
        <h1 style="color:fuchsia">
            Conductor: 
            <c:out value="${DRIVER.nombre}"/>
        </h1>
        <h2 style="color:white; background-color: blue">
            <c:out value="${DRIVER.coche.marca}"/>
            <c:out value="${DRIVER.coche.modelo}"/>
        </h2>
    </body>
</html>
