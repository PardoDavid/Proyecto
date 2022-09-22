

<%@page import="ModeloVO.ContratoVO"%>
<%@page import="ModeloDAO.ContratoDAO"%>
<!doctype html>
<html lang="en">
 
  <body>
  <center>
        <h1>Registrar Contrato!</h1>
<form method="post" action="Contrato">
        <table>
            <tr>
            Contrato:<br>
            <input type="text" name="textPedido"><br>
            Fecha_Contrato:<br>
            <input type="date" name="textFechaContrato"><br>
            Descripción:<br>
            <input type="text" name="textDesContrato"><br>
            Estado_Contrato:<br>
            <input type="text" name="textEstadoContrato"><br>
            Fecha_Instalacion:<br>
            <input type="date" name="textFechaInstalacion"><br>
            Estado_Instalacion:<br>
            <input type="text" name="textEstadoInstalacion"><br>
            Usuario:<br>
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

