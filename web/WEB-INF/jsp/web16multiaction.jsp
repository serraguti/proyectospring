<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MultiAction Controller</h1>
        <form method="POST" action="web16multiaction.htm">
            <input type="hidden" name="accion" value="operar"/>
            <label>Número 1: </label>
            <input type="text" name="numero1" required/><br/>
            <label>Número 2: </label>
            <input type="text" name="numero2" required/><br/>
            <button type="submit" name="tipooperacion" value="sumar">
                Sumar números
            </button>
            <button type="submit" name="tipooperacion" value="multiplicar">
                Multiplicar números
            </button>            
        </form>
        
        <ul>
            <li>
                <a href="web16multiaction.htm?accion=alta">Action ALTA</a>
            </li>
            <li>
                <a href="web16multiaction.htm?accion=baja">Action BAJA</a>
            </li>
        </ul>
        <h1 style="color:blue">
            <c:out value="${MENSAJE}"/>
        </h1>
    </body>
</html>
