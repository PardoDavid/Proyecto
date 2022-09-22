<%-- 
    Document   : ConsultarContrato
    Created on : 4/08/2022, 12:44:57 AM
    Author     : Joretof
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.ContratoDAO"%>
<%@page import="ModeloVO.ContratoVO"%>
<%@include file="Sesiones.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>

        <h1>Contratos!</h1>
        <form method="post" action="Contrato">
            <table>
                <tr>
                    <th>
                <center>Contrato</center>
                <br>

                <input type="text" name="textContrato">
                <br>
                <br>
                <center>
                    <button class="w-10 btn btn-lg btn-primary" type="submit">Consultar</button>
                </center>

            </table><br><br>
            <input type="hidden" value="3" name="opcion">
        </form><br><br>
        <%
            if (request.getAttribute("mensajeError") != null) {%>
        ${mensajeError}
        <%} else {%>
        ${mensajeExito}
        <%}%>

        <form>
            <div>
                <table>
                    <tr>
                        <td scope="col">Contrato</td>
                        <th scope="col">Pedido Cab.</th>
                        <th scope="col">Fecha Contrato</th>
                        <th scope="col">Desc Contrato</th>
                        <th scope="col">Estado Contrato</th>
                        <th scope="col">Fecha Instalacion</th>
                        <th scope="col">Estado Instalacion</th>
                        <th scope="col">Usuario</th>                    
                    </tr>
                    <%
                        ContratoVO conVO = new ContratoVO();
                        ContratoDAO conDAO = new ContratoDAO();
                        ArrayList<ContratoVO> listaContrato = conDAO.listar();
                        for (int i = 0; i < listaContrato.size(); i++) {
                            conVO = listaContrato.get(i);
                    %>

                    <tr>
                        <td><%=conVO.getId_contrato()%></td>
                        <td><%=conVO.getId_pedidoc()%></td>
                        <td><%=conVO.getFecha_contrato()%></td>
                        <td><%=conVO.getDesc_contrato()%></td>
                        <td><%=conVO.getEstado_contrato()%></td>
                        <td><%=conVO.getFecha_instalacion()%></td>
                        <td><%=conVO.getEstado_instalacion()%></td>
                        <td><%=conVO.getId_usuario()%></td>
                    </tr>
                    <%}%>
                </table>
                <a href="registroContratoAdministrador.jsp">Registrar Contrato</a>
        </form>
    </body>
</center>
</html>
