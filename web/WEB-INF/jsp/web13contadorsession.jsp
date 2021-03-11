<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ejemplo Session Contador</h1>
        <form method="post">
            <button type="submit" name="incremento" value="1">
                Incrementar contador
            </button>
        </form>
        <h1 style="color:red">
            Contador: <c:out value="${CONTADOR}"/>
        </h1>
    </body>
</html>
