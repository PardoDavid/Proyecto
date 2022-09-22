

<%@page import="ModeloVO.ContratoVO"%>
<%@page import="ModeloDAO.ContratoDAO"%>
<%@include file="Sesiones.jsp"%>
<!doctype html>
<html lang="en">
 
  <body>
  <center>
        <h1>Registrar Contrato!</h1>
<form method="post" action="Contrato">
        <table>
            <tr>
            Pedido:<br>
            <input type="text" name="textPedido"><br>
            Descripción:<br>
            <input type="text" name="textDesContrato"><br>
            Fecha_Instalacion:<br>
            <input type="date" name="textFechaInstalacion"><br>
            <input type="hidden" name="textEstadoInstalacion" value="En espera"><br>
            Tecnico:<br>
            <input type="text" name="textUsuario"><br>
            </tr>
        </table><br>
        <button type="submit">Registrar</button>
        <input type="hidden" value="1" name="opcion">
    </form><br>
    <%
        if (request.getAttribute("mensajeError") != null) {%>
    ${mensajeError}
    <%} else {%>
    ${mensajeExito}
    <%}%>

</center>
</body>
</form>
</html>

