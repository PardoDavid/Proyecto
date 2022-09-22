<%-- 
    Document   : registrarUsuarioCliente
    Created on : 8/09/2022, 06:49:13 AM
    Author     : uSER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="registrarusuario.css" rel="stylesheet" type="text/css">
        <title>Registrarse</title>
    </head>
    <body>
        <section>
            <h3 class="title is-3">Registrate</h3>
            <form method="post" action="Usuario">
                <table>
                    <tr>
                        Usuario:<br>
                <input type="text" name="textUsuario" required required minlength="3"  maxlength="10"><br>
                Contraseña:<br>
                <input type="password" name="textClave" required minlength="3"  maxlength="15"><br>
                Tipo Doc:<br>
                <input type="text" name="texTipoDocQ" required minlength="2"  maxlength="2"><br>
                Num Doc:<br>
                <input type="number" name="textNumDoc" required><br>
                Telefono:<br>
                <input type="number" name="textTelefono" required minlength="6"  maxlength="10"><br>
                Correo:<br>
                <input type="email" name="textCorreo" required><br>   
                
                <input type="hidden" name="textIdRol" value="1"><br>
                
                <input type="hidden" name="textEstado" value="1"><br>
                
                    </tr>
                </table>
                <button>Registrar</button>
                <input type="hidden" value="1" name="opcion">
                <h2><a href="inicioSesion.jsp">¿Ya tienes cuenta? Inicia Sesion</a></h2>                 
            </form>
        <br>
        <%
            if (request.getAttribute("mensajeError") != null) { %>
        ${mensajeError}

        <% } else {%>
        ${mensajeExito}
        <%}%>
    </section>
</body>
</html>
