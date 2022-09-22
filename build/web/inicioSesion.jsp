<%-- 
    Document   : inicioSesion
    Created on : 16/05/2022, 07:51:37 AM
    Author     : Sena
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="sesion.css" rel="stylesheet" type="text/css"/>
        <title>Iniciar Sesion</title>
    </head>
<body>
    <section>
        <form method="post" action="Usuario">
            <h3>Iniciar Sesion</h3>
            <table>
                <tr>
                    <label>Usuario:</label>
                    <input type="text" placeholder="Usuario" name="textUsuario" requerid="requerid">
                    <label >Contraseña:</label>
                    <input type="password" placeholder="Contraseña" name="textClave" requerid="requerid">
                </tr>
            </table>
                <button>Iniciar Sesion</button>
                <input type="hidden" value="2" name="opcion">
                <h2><a href="registrarUsuarioCliente.jsp">¿No tienes cuenta? Registrate!</a></h2>
            <br>
        <center>
            <%if (request.getAttribute("mensajeError") != null) { %>
            ${mensajeError}

            <% } else {%>
            ${mensajeExito}
            <%}%>
        </center>
    </section>
</body>
</html>
