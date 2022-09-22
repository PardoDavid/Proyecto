<%-- 
    Document   : registrarUsuario
    Created on : 9/05/2022, 09:20:54 AM
    Author     : Sena
--%>
<%@page import="ModeloVO.RolVO"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="registrarusuario.css" rel="stylesheet" type="text/css">
        <title>Registrar Usuario</title>
    </head>
    <body>
        <section>
            <h3 class="title is-3">Registrar Usuario</h3>
            <form method="post" action="Usuario">
                <table>
                    <tr>
                        Usuario:<br>
                <input type="text" name="textUsuario" required minlength="3"  maxlength="10"><br>
                Contraseña:<br>
                <input type="password" name="textClave" required required minlength="3"  maxlength="15"><br>
                Tipo Doc:<br>
                <input type="text" name="texTipoDocQ" required required minlength="2"  maxlength="2"><br>
                Num Doc:<br>
                <input type="number" name="textNumDoc" required><br>
                Telefono:<br>
                <input type="number" name="textTelefono" required ><br>
                Correo:<br>
                <input type="email" name="textCorreo" required><br>
                Rol:<br>
                <select name="textIdRol" >
                    <option>Seleccione...</option>
                    <%
                        RolDAO rolDAO = new RolDAO();
                        for (RolVO rolVO : rolDAO.listar()) {

                    %>
                    <option value="<%=rolVO.getId_rol()%>"><%=rolVO.getNombre_rol()%></option>
                    <%}%>
                </select><br>
                <input type="hidden" name="textEstado" value="1"><br>
                    </tr>
                </table>
                <button>Registrar</button>
                <input type="hidden" value="1" name="opcion">
                <h2><a href="inicioSesion.jsp">¿Ya tienes cuenta? Inicia Sesion</a></h2>
                 <a href="consultarUsuarioAdministrador.jsp">Consultar Usuarios</a>
                 <a href="registrarEquipo.jsp">Registrar un Equipo</a>
                 <a href="consultarContratoAdministrador.jsp">Consultar Contrato</a>
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