package Controlador;

import ModeloDAO.ContratoDAO;
import ModeloVO.ContratoVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sena
 */
@WebServlet(name = "ContratoControlador", urlPatterns = {"/Contrato"})
public class ContratoControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String IdContrato = request.getParameter("textContrato");
        String IdPedidoC = request.getParameter("textPedido");
        String FechaContrato = request.getParameter("textFechaContrato");
        String DesContrato = request.getParameter("textDesContrato");
        String EstadoContrato = request.getParameter("textEstadoContrato");
        String FechaInstalacion = request.getParameter("textFechaInstalacion");
        String EstadoInstalacion = request.getParameter("textEstadoInstalacion");
        String IdUsuario = request.getParameter("textUsuario");
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //Instanciar el VO
        ContratoVO conVO = new ContratoVO(IdContrato,IdPedidoC,FechaContrato,DesContrato,EstadoContrato,FechaInstalacion,EstadoInstalacion,IdUsuario);

        //Instanciar DAO
        ContratoDAO conDAO = new ContratoDAO(conVO);

        switch (opcion) {
            case 1://Agregar Registro
                if (conDAO.agregarRegistro()) {
                      request.setAttribute("mensajeExito", "El Contrrato se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "El Contrato NO se registro correctamente");
                }
                request.getRequestDispatcher("registroContratoAdministrador.jsp").forward(request, response);
                break;
        

            case 2://Actualizar Registro
                if (conDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El Contrato se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "El Contrato NO se actualizo correctamente");
                }
                request.getRequestDispatcher("actualizarContratoAdministrador.jsp").forward(request, response);
                break;
    

            case 3://Consultar por idContrato
                conVO = conDAO.consultarContrato(IdContrato);
                if (conVO != null) {
                    request.setAttribute("datosConsultados", conVO);
                    request.getRequestDispatcher("actualizarContratoAdministrador.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "El Contrato NO existe");
                    request.getRequestDispatcher("consultarContratoAdministrador.jsp").forward(request, response);
                break;
                }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}