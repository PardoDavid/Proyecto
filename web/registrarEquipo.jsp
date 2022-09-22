<%-- 
    Document   : registrarEquipo
    Created on : 18/08/2022, 11:54:49 AM
    Author     : Usuario
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar equipo</title>
    </head>
    <body>
    <center><h1>Registrar un nuevo equipo</h1></center>
        <form method="POST" action="Equipo">
            <table>
                <tr>
                    Foto producto: <br>
                    <input type="file" name="textImgEquipo" accept="image/png,image/jpeg" required><br>
                    Nombre del Equipo:<br>
                    <input type="text" name="textNombreEquipo" required minlength="6" maxlength="10">
                    
                    <input type="hidden" name="textEstadoEquipo" value="1" required><br>
                    Cantidad:<br>
                    <input type="number" name="textCantEquipo" required><br>
                </tr>
            </table>
            <button class="btn btn-success">Registrar</button>
            <input type="hidden" value="1" name="opcion">
            <button class="btn btn-primary"><a href="registrarUsuarioAdministrador.jsp">Volver</a></button>
              <button class="btn btn-primary"><a href="consultarEquipoCliente.jsp">Consultar Equipos</a></button>        
        </form>
        <%
            if (request.getAttribute("mensajeError") != null) { %>
        ${mensajeError}

        <% } else {%>
        ${mensajeExito}
        <%}%>
    </body>
</html>
