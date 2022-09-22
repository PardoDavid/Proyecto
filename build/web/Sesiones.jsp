<%-- 
    Document   : Sesiones
    Created on : 23/05/2022, 10:28:35 a. m.
    Author     : uSER
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Sesiones.css" rel="stylesheet" type="text/css">
        <title>Sesiones</title>
    </head>
    <%
      response.setHeader("Pragma","No-cache");
      response.setHeader("Cache-control","no-cache,no-store,must-revalidate");
      response.setDateHeader("Expires",0);
    %>
    <%
        HttpSession miSesion = (HttpSession) request.getSession();
        String nom_usu = "";
        if (miSesion.getAttribute("datosUsuario") == null) 
        {
            request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
        } 
        else 
        {
            UsuarioVO usuVO = (UsuarioVO) miSesion.getAttribute("datosUsuario");
            nom_usu = usuVO.getNom_usu();
        }
    %>
    <body>
        <header>
            <div class="contenedor">
                <h1 style="color:red;">Bienvenido: <%=nom_usu%></h1>   
                <form method="post" action="Sesiones">
                    <button>Cerrar sesion</button>
                    <input type="hidden" value="Cerrar sesion">
                </form>
            </div>
        </header>
    </body>
</html>
