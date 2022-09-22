package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloVO.RolVO;
import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;

public final class registrarUsuarioAdministrador_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Sesiones.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"Sesiones.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <title>Sesiones</title>\n");
      out.write("    </head>\n");
      out.write("    ");

      response.setHeader("Pragma","No-cache");
      response.setHeader("Cache-control","no-cache,no-store,must-revalidate");
      response.setDateHeader("Expires",0);
    
      out.write("\n");
      out.write("    ");

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
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"contenedor\">\n");
      out.write("                <h1 style=\"color:red;\">Bienvenido: ");
      out.print(nom_usu);
      out.write("</h1>   \n");
      out.write("                <form method=\"post\" action=\"Sesiones\">\n");
      out.write("                    <button>Cerrar sesion</button>\n");
      out.write("                    <input type=\"hidden\" value=\"Cerrar sesion\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"registrarusuario.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <title>Registrar Usuario</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section>\n");
      out.write("            <h3 class=\"title is-3\">Registrar Usuario</h3>\n");
      out.write("            <form method=\"post\" action=\"Usuario\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        Usuario:<br>\n");
      out.write("                <input type=\"text\" name=\"textUsuario\" required><br>\n");
      out.write("                Contraseña:<br>\n");
      out.write("                <input type=\"password\" name=\"textClave\" required><br>\n");
      out.write("                Tipo Doc:<br>\n");
      out.write("                <input type=\"text\" name=\"texTipoDocQ\" required><br>\n");
      out.write("                Num Doc:<br>\n");
      out.write("                <input type=\"number\" name=\"textNumDoc\" required><br>\n");
      out.write("                Telefono:<br>\n");
      out.write("                <input type=\"number\" name=\"textTelefono\" required><br>\n");
      out.write("                Correo:<br>\n");
      out.write("                <input type=\"email\" name=\"textCorreo\" required><br>\n");
      out.write("                Rol:<br>\n");
      out.write("                <select name=\"txtCategoria\" >\n");
      out.write("                    <option>Seleccione...</option>\n");
      out.write("                    ");

                        RolDAO rolDAO = new RolDAO();
                        for (RolVO rolVO : rolDAO.listar()) {

                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(rolVO.getId_rol());
      out.write('"');
      out.write('>');
      out.print(rolVO.getNombre_rol());
      out.write("</option>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </select><br>\n");
      out.write("                Estado:<br>\n");
      out.write("                <input type=\"text\" name=\"textEstado\" required><br>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                <button>Registrar</button>\n");
      out.write("                <input type=\"hidden\" value=\"1\" name=\"opcion\">\n");
      out.write("                <h2><a href=\"inicioSesion.jsp\">¿Ya tienes cuenta? Inicia Sesion</a></h2>\n");
      out.write("                 <a href=\"consultarUsuario.jsp\">Consultar Usuarios</a>\n");
      out.write("                 <a href=\"registrarEquipo.jsp\">Registrar un Equipo</a>\n");
      out.write("                 <a href=\"actualizarUsuarioAdministrador.jsp\">Actualizar usuario</a>\n");
      out.write("            </form>\n");
      out.write("        <br>\n");
      out.write("        ");

            if (request.getAttribute("mensajeError") != null) { 
      out.write("\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("        ");
 } else {
      out.write("\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </section>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
