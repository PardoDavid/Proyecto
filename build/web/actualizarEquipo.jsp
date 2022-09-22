<%-- 
    Document   : actualizarEquipo
    Created on : 4/09/2022, 10:03:14 PM
    Author     : Usuario
--%>

<%@page import="ModeloVO.EquipoVO"%>
<%@include file="Sesiones.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>ACTUALIZAR USUARIO</title>
    </head>
    <body>
    <center>
        <%
            EquipoVO equVO = (EquipoVO) request.getAttribute("EquipoConsultado");
            if (equVO != null) {
        %>                          
        <h1>¡ACTUALIZAR EQUIPO!</h1>
        <form method="POST" action="Equipo">   
            <table>
                <tr>
                 ID:<br> 
                <input type="text" name="textIdequipo" value="<%=equVO.getId_equipo()%>" readonly><br>
                Descripcion:<br>
                <input type="text" name="textImgEquipo" value="<%=equVO.getImg_equipo()%>" readonly><br>
                Nombre:<br>
                <input type="text" name="textNombreEquipo" value="<%=equVO.getNombre_equipo()%>" readonly><br>
                Cantidad:<br> 
                <input type="text" name="textCantEquipo" value="<%=equVO.getCantidad_equipo()%>" readonly><br>
                </tr>
            </table><br>
            <button class="btn btn-success">Actualizar</button>
            <input type="hidden" value="3" name="opcion">
            <button class="btn btn-primary"><a href="consultarEquipoCliente.jsp">Volver</a></button>             
        </form>  
        <% } else {
                request.getRequestDispatcher("consultarEquipoCliente.jsp").forward(request, response);
            }%>
    </center>
</body>
</html>


