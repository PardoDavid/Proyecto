<%--
    Document   : ConsultarEquipoCliente
    Created on : 4/09/2022, 08:23:50 PM
    Author     : Usuario
--%>

<%@page import="ModeloDAO.EquipoDAO"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page import="ModeloVO.RolVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.EquipoVO"%>
<%@include file="Sesiones.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/consultarEquipoCliente.css">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <h1>¡CONSULTAR EQUIPO CLIENTE!</h1>
        <form method="POST" action="Equipo">
            <table>
                <tr>
                    ID:<br>
                <input type="text" name="textIdEquipo"><br>
                </tr>
            </table><br><br>
            <button class="btn btn-success">Consultar</button>
            <input type="hidden" value="2" name="opcion">
        </form><br><br>
        <%
            if (request.getAttribute("mensajeError") != null) {%>
        <div class="alert alert-danger" role="alert">
            ${mensajeError}
        </div>
        <% }
            else
            { %>
        <div class="alert alert-success" role="alert">
            ${mensajeExito}
        </div>
        <% }
        %>
        <form>
            <table class="table table-dark">
                <tr>
                    <th class="bg-warning">IMG</th>
                    <th class="bg-warning">NOMBRE</th>
                </tr>
                <%
                   
                    EquipoVO equVO = new EquipoVO();
                    EquipoDAO equDAO = new EquipoDAO();
                    ArrayList<EquipoVO> listaEquipos = equDAO.listar();
                    for (int i = 0; i < listaEquipos.size(); i++) {

                        equVO = listaEquipos.get(i);

                %>
                <tr>
                    <td><%= equVO.getImg_equipo()%></td>
                    <td><%= equVO.getNombre_equipo()%></td>
                </tr>
                <%}%>
            </table>
        </form>
            <button id="botonmodel" class="btn btn-success botonmodel">Hacer pedido</button>
            <section id="model" class="model">
                <form method="POST" action="PedidoEquipoCControlador">
                    <table>
                        <tr>
                            <% 
                                RolVO rolVO = new RolVO();
                                RolDAO rolDAO = new RolDAO();
                                ArrayList<RolVO> listarUsuario = rolDAO.listar(nom_usu);

                                for (int i = 0; i < listarUsuario.size(); i++) 
                                {
                                    rolVO = listarUsuario.get(i);
                                }
                            %> 
                            <input type="hidden" name="textId_usuario" value="<%=rolVO.getId_rol()%>">
                            <select name="textId_equipo">
                                <option>Lista de equipos..</option>
                                <%
                                    for (int i = 0; i < listaEquipos.size(); i++) 
                                    {

                                        equVO = listaEquipos.get(i);
                                %>
                                <option value="<%=equVO.getId_equipo()%>"><%= equVO.getNombre_equipo()%></option>
                                  <%}%>
                            </select>
                            <br>
                            CANTIDAD DE EQUIPOS:<br>
                            <input type="number" name="textCantidad_equipo" required><br>
                        </tr>
                    </table>
                <button>ACEPTAR</button>
                <input type="hidden" value="1" name="opcion">
                </form>
            </section>
    </center>   
            <script src="js/modalBotonHacerPedidoCliente.js"></script>
    </body>
</html>
