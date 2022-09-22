package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloDAO.EquipoDAO;
import ModeloDAO.RolDAO;
import ModeloVO.RolVO;
import java.util.ArrayList;
import ModeloVO.EquipoVO;
import ModeloVO.UsuarioVO;

public final class consultarEquipoCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/consultarEquipoCliente.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("        <h1>¡CONSULTAR EQUIPO CLIENTE!</h1>\n");
      out.write("        <form method=\"POST\" action=\"Equipo\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    ID:<br>\n");
      out.write("                <input type=\"text\" name=\"textIdEquipo\"><br>\n");
      out.write("                </tr>\n");
      out.write("            </table><br><br>\n");
      out.write("            <button class=\"btn btn-success\">Consultar</button>\n");
      out.write("            <input type=\"hidden\" value=\"2\" name=\"opcion\">\n");
      out.write("        </form><br><br>\n");
      out.write("        ");

            if (request.getAttribute("mensajeError") != null) {
      out.write("\n");
      out.write("        <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
 }
            else
            { 
      out.write("\n");
      out.write("        <div class=\"alert alert-success\" role=\"alert\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
 }
        
      out.write("\n");
      out.write("        <form>\n");
      out.write("            <table class=\"table table-dark\">\n");
      out.write("                <tr>\n");
      out.write("                    <th class=\"bg-warning\">IMG</th>\n");
      out.write("                    <th class=\"bg-warning\">NOMBRE</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                   
                    EquipoVO equVO = new EquipoVO();
                    EquipoDAO equDAO = new EquipoDAO();
                    ArrayList<EquipoVO> listaEquipos = equDAO.listar();
                    for (int i = 0; i < listaEquipos.size(); i++) {

                        equVO = listaEquipos.get(i);

                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( equVO.getImg_equipo());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( equVO.getNombre_equipo());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("            <button id=\"botonmodel\" class=\"btn btn-success botonmodel\">Hacer pedido</button>\n");
      out.write("            <section id=\"model\" class=\"model\">\n");
      out.write("                <form method=\"POST\" action=\"PedidoEquipoCControlador\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            ");
 
                                RolVO rolVO = new RolVO();
                                RolDAO rolDAO = new RolDAO();
                                ArrayList<RolVO> listarUsuario = rolDAO.listar(nom_usu);

                                for (int i = 0; i < listarUsuario.size(); i++) 
                                {
                                    rolVO = listarUsuario.get(i);
                                }
                            
      out.write(" \n");
      out.write("                            <input type=\"hidden\" name=\"textId_usuario\" value=\"");
      out.print(rolVO.getId_rol());
      out.write("\">\n");
      out.write("                            <select name=\"textId_equipo\">\n");
      out.write("                                <option>Lista de equipos..</option>\n");
      out.write("                                ");

                                    for (int i = 0; i < listaEquipos.size(); i++) 
                                    {

                                        equVO = listaEquipos.get(i);
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(equVO.getId_equipo());
      out.write('"');
      out.write('>');
      out.print( equVO.getNombre_equipo());
      out.write("</option>\n");
      out.write("                                  ");
}
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <br>\n");
      out.write("                            CANTIDAD DE EQUIPOS:<br>\n");
      out.write("                            <input type=\"number\" name=\"textCantidad_equipo\" required><br>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                <button>ACEPTAR</button>\n");
      out.write("                <input type=\"hidden\" value=\"1\" name=\"opcion\">\n");
      out.write("                </form>\n");
      out.write("            </section>\n");
      out.write("    </center>   \n");
      out.write("            <script src=\"js/modalBotonHacerPedidoCliente.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
