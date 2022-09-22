<%-- 
    Document   : newjspc
    Created on : 24/08/2022, 10:20:05 AM
    Author     : uSER
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
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
        <h1>¡CONSULTAR USUARIO!</h1>
        <form method="POST" action="Usuario">
            <table>
                <tr>
                    ID:<br>
                <input type="text" name="textId"><br>
                </tr>
            </table><br><br>
            <button class="btn btn-success">Consultar</button>
            <input type="hidden" value="4" name="opcion">
        </form><br><br>
        <%
            if (request.getAttribute("mensajeError") != null) {%>
        <div class="alert alert-danger" role="alert">
            ${mensajeError}
        </div>
        <% } else { %>
        <div class="alert alert-success" role="alert">
            ${mensajeExito}
        </div>
        <% }
        %>
        <form>
            <table class="table table-dark">
                <tr>
                    <th class="bg-warning">ID</th>
                    <th class="bg-warning">NOMBRE</th>
                    <th class="bg-warning">CLAVE</th>
                    <th class="bg-warning">TIPO_DOC</th>
                    <th class="bg-warning">NUM_DOC</th>
                    <th class="bg-warning">TELEFONO</th>
                    <th class="bg-warning">CORREO ELECTRONICO</th>
                    <th class="bg-warning">ID ROL</th>
                    <th class="bg-warning">ESTADO</th>
                </tr>
                <%
                   UsuarioVO usuVO= new UsuarioVO();
                    UsuarioDAO usuDAO = new UsuarioDAO();
                    ArrayList<UsuarioVO> ListaUsuarios = usuDAO.listar();
                    for (int i = 0; i < ListaUsuarios.size(); i++) {

                        usuVO = ListaUsuarios.get(i);

                %>
                <tr>
                    <td><%= usuVO.getId_usuario()%></td>
                    <td><%= usuVO.getNom_usu()%></td>
                    <td><%= usuVO.getClave()%></td>
                    <td><%= usuVO.getTipo_doc()%></td>
                    <td><%= usuVO.getNum_doc()%></td>
                    <td><%= usuVO.getTelefono()%></td>
                    <td><%= usuVO.getCorreo_electronico()%></td>
                    <td><%= usuVO.getId_rol()%></td>
                    <td><%= usuVO.getEstado()%></td>
                </tr>
                <%}%>
            </table>
        </form>
    </center>
                                
                    
    </body>
</html>

