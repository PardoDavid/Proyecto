<%-- 
    Document   : ActualizarContrato
    Created on : 4/08/2022, 12:36:47 AM
    Author     : Joretof
--%>

<%@page import="ModeloVO.ContratoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Actualizar Vehiculo</h1>
        <%
            ContratoVO conVO = (ContratoVO) request.getAttribute("datosConsultados");
            if (conVO != null) {
        %>
        <form method="post" action="Contrato">
            <table>
                <tr>
                <input type="hidden" name="textContrato" value="<%=conVO.getId_contrato()%>"><br>
                 Pedido Cab.:<br>
                <input type="text" name="textPedido" value="<%=conVO.getId_pedidoc()%>"><br>
                Desc Contrato:<br>
                <input type="text" name="textDesContrato" value="<%=conVO.getDesc_contrato()%>"><br>
                Fecha Instalacion:<br>
                <input type="text" name="textFechaInstalacion" value="<%=conVO.getFecha_instalacion()%>"><br>
                Estado Instalacion:<br>
                <input type="text" name="textEstadoInstalacion" value="<%=conVO.getEstado_instalacion()%>"><br>
                Usuario:<br>
                <input type="number" name="textUsuario" value="<%=conVO.getId_usuario()%>"><br>
                </tr>
            </table><br>
            <button class="w-10 btn btn-lg btn-primary" type="submit">Actualizar</button>
            <input type="hidden" value="2" name="opcion">
        </form><br>
        <%}%>
        <%
            if (request.getAttribute("mensajeError") != null) {%>
        ${mensajeError}
        <%} else {%>
        ${mensajeExito}
        <br>
        <a href="consultarContratoAdministrador.jsp" class="w-10 btn btn-lg btn-primary">Volver</a>
        <%}%>
    </body>
</html>
