package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloVO.UsuarioVO;
import ModeloVO.VehiculoVO;
import ModeloVO.UsuarioVO;

public final class actualizarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <title>ACTUALIZAR USUARIO</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        ");

            UsuarioVO usuVO = (UsuarioVO) request.getAttribute(nom_usu);
            if (usuVO != null) {
        
      out.write("                          \n");
      out.write("        <h1>¡ACTUALIZAR USUARIO!</h1>\n");
      out.write("        <form method=\"POST\" action=\"Usuario\">   \n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                 ID:<br> \n");
      out.write("                <input type=\"text\" name=\"textId\" value=\"");
      out.print(usuVO.getId_usuario());
      out.write("\" readonly><br>\n");
      out.write("                Nombre:<br>\n");
      out.write("                <input type=\"text\" name=\"textUsuario\" value=\"");
      out.print(usuVO.getNom_usu());
      out.write("\" readonly><br>\n");
      out.write("                Clave:<br> \n");
      out.write("                <input type=\"text\" name=\"textClave\" value=\"");
      out.print(usuVO.getClave());
      out.write("\" readonly><br>\n");
      out.write("                Tipo Documento:<br> \n");
      out.write("                <input type=\"text\" name=\"texTipoDocQ\" value=\"");
      out.print(usuVO.getTipo_doc());
      out.write("\" readonly><br>\n");
      out.write("                Numero Documento:<br> \n");
      out.write("                <input type=\"text\" name=\"textNumDoc\" value=\"");
      out.print(usuVO.getNum_doc());
      out.write("\" readonly><br>\n");
      out.write("                Telefono:<br> \n");
      out.write("                <input type=\"text\" name=\"textTelefono\" value=\"");
      out.print(usuVO.getTelefono());
      out.write("\"><br>\n");
      out.write("                Correo Electronico:<br> \n");
      out.write("                <input type=\"text\" name=\"textCorreo\" value=\"");
      out.print(usuVO.getCorreo_electronico());
      out.write("\"><br>\n");
      out.write("                 Rol:<br> \n");
      out.write("                <input type=\"text\" name=\"textIdRol\" value=\"");
      out.print(usuVO.getId_rol());
      out.write("\" readonly><br>\n");
      out.write("                 Estado:<br> \n");
      out.write("                <input type=\"text\" name=\"textEstado\" value=\"");
      out.print(usuVO.getEstado());
      out.write("\" readonly><br>\n");
      out.write("                </tr>\n");
      out.write("            </table><br>\n");
      out.write("            <button class=\"btn btn-success\">Actualizar</button>\n");
      out.write("            <input type=\"hidden\" value=\"3\" name=\"opcion\">\n");
      out.write("            <button class=\"btn btn-primary\"><a href=\"consultarUsuario.jsp\">Volver</a></button>             \n");
      out.write("        </form>  \n");
      out.write("        ");
 } else {
                request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
            }
      out.write("\n");
      out.write("    </center>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
