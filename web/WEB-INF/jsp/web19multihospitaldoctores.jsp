<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hospital Doctores</h1>
        <form method="post" action="web19multihospitaldoctores.htm">
            <input type="hidden" name="accion" value="incrementarSalarios"/>
            <table border="1">
                <thead>
                    <tr>
                        <td></td>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Camas</th>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${HOSPITALES}" var="hospital">
                        <tr>
                            <td>
                                <input type="radio" name="idhospital"
                                       value="${hospital.idHospital}"/>
                            </td>
                            <td>
                                <c:out value="${hospital.nombre}"/>
                            </td>
                            <td>
                                <c:out value="${hospital.direccion}"/>
                            </td>
                            <td>
                                <c:out value="${hospital.telefono}"/>
                            </td>
                            <td>
                                <c:out value="${hospital.camas}"/>
                            </td>
                            <td>
                                <a href="web19multihospitaldoctores.htm?idhospital=${hospital.idHospital}&accion=mostrarDoctores">
                                    Mostrar doctores
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>            
            <label>Incremento salarial: </label>
            <input type="text" name="incremento" required/>
            <button type="submit">
                Incrementar salarios doctores
            </button>
        </form>
        <c:if test="${DOCTORES != null}">
            <hr/>
            <table border="1">
                <thead>
                    <tr>
                        <th>Apellido</th>
                        <th>Especialidad</th>
                        <th>Salario</th>
                        <th>Hospital</th>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${DOCTORES}" var="doctor">
                        <tr>
                            <td>
                                <c:out value="${doctor.apellido}"/>
                            </td>
                            <td>
                                <c:out value="${doctor.especialidad}"/>
                            </td>
                            <td>
                                <c:out value="${doctor.salario}"/>
                            </td>
                            <td>
                                <c:out value="${doctor.hospital}"/>
                            </td>
                            <td>
<a href="web19multihospitaldoctores.htm?accion=eliminarDoctor&iddoctor=${doctor.idDoctor}&idhospital=${doctor.hospital}">
                                    Eliminar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
