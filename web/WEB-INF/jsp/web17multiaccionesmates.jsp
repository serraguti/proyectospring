<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MultiAction Controller Mates</h1>
        <form method="post" action="web17multiaccionesmates.htm">
            <label>Introduzca un número </label>
            <input type="text" name="numero" required/><br/>
            <button type="submit" name="operacion" value="tablamultiplicar">
                Tabla multiplicar                
            </button>
            <button type="submit" name="operacion" value="numerospares">
                Número pares
            </button>
        </form>
        <hr/>
        <c:if test="${NUMEROS != null}">
            <table border="1">
                <c:forEach items="${NUMEROS}" var="num">
                    <tr>
                        <td>
                            <c:out value="${num}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
