package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloVO.ContratoVO;
import ModeloDAO.ContratoDAO;

public final class registroContratoAdministrador_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html");
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
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write(" \n");
      out.write("  <body>\n");
      out.write("  <center>\n");
      out.write("        <h1>Registrar Contrato!</h1>\n");
      out.write("<form method=\"post\" action=\"Contrato\">\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("            Contrato:<br>\n");
      out.write("            <input type=\"text\" name=\"textPedido\"><br>\n");
      out.write("            Fecha_Contrato:<br>\n");
      out.write("            <input type=\"date\" name=\"textFechaContrato\"><br>\n");
      out.write("            Descripción:<br>\n");
      out.write("            <input type=\"text\" name=\"textDesContrato\"><br>\n");
      out.write("            Estado_Contrato:<br>\n");
      out.write("            <input type=\"text\" name=\"textEstadoContrato\"><br>\n");
      out.write("            Fecha_Instalacion:<br>\n");
      out.write("            <input type=\"date\" name=\"textFechaInstalacion\"><br>\n");
      out.write("            Estado_Instalacion:<br>\n");
      out.write("            <input type=\"text\" name=\"textEstadoInstalacion\"><br>\n");
      out.write("            Usuario:<br>\n");
      out.write("            <input type=\"text\" name=\"textUsuario\"><br>\n");
      out.write("            </tr>\n");
      out.write("        </table><br>\n");
      out.write("        <button type=\"submit\">Registrar</button>\n");
      out.write("        <input type=\"hidden\" value=\"1\" name=\"opcion\">\n");
      out.write("    </form><br>\n");
      out.write("    ");

        if (request.getAttribute("mensajeError") != null) {
      out.write("\n");
      out.write("    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    ");
} else {
      out.write("\n");
      out.write("    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    ");
}
      out.write("\n");
      out.write("\n");
      out.write("</center>\n");
      out.write("</body>\n");
      out.write("</form>\n");
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
