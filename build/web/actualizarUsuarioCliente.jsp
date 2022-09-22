<%-- 
    Document   : actualizarVehiculo
    Created on : 9/05/2022, 10:31:58 AM
    Author     : Sena
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloVO.VehiculoVO"%>
<%@include file="Sesiones.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>ACTUALIZAR USUARIO</title>
    </head>
    <body>
    <center>
        <%
            UsuarioVO usuVO = (UsuarioVO) request.getAttribute("UsuarioConsultado");
            if (usuVO != null) {
        %>                          
        <h1>¡ACTUALIZAR USUARIO!</h1>
        <form method="POST" action="Usuario">   
            <table>
                <tr>
                 ID:<br> 
                <input type="text" name="textId" value="<%=usuVO.getId_usuario()%>" readonly><br>
                Nombre:<br>
                <input type="text" name="textUsuario" value="<%=usuVO.getNom_usu()%>" readonly><br>
                Clave:<br> 
                <input type="text" name="textClave" value="<%=usuVO.getClave()%>"><br>
                Tipo Documento:<br> 
                <input type="text" name="texTipoDocQ" value="<%=usuVO.getTipo_doc()%>" readonly><br>
                Numero Documento:<br> 
                <input type="text" name="textNumDoc" value="<%=usuVO.getNum_doc()%>" readonly><br>
                Telefono:<br> 
                <input type="text" name="textTelefono" value="<%=usuVO.getTelefono()%>"><br>
                Correo Electronico:<br> 
                <input type="text" name="textCorreo" value="<%=usuVO.getCorreo_electronico()%>"><br>
                 Rol:<br> 
                <input type="text" name="textIdRol" value="<%=usuVO.getId_rol()%>" readonly><br>
                 Estado:<br> 
                <input type="text" name="textEstado" value="<%=usuVO.getEstado()%>" readonly><br>
                </tr>
            </table><br>
            <button class="btn btn-success">Actualizar</button>
            <input type="hidden" value="3" name="opcion">
            <button class="btn btn-primary"><a href="consultarUsuario.jsp">Volver</a></button>             
        </form>  
        <% } else {
                request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
            }%>
    </center>
</body>
</html>

