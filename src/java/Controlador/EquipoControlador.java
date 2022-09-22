/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.EquipoDAO;
import ModeloDAO.RolDAO;
import ModeloVO.EquipoVO;
import ModeloVO.RolVO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "EquipoControlador", urlPatterns = {"/Equipo"})
public class EquipoControlador extends HttpServlet {

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
            throws ServletException, IOException 
    {
        String id_equipo = request.getParameter("textIdEquipo");
        String img_equipo = request.getParameter("textImgEquipo");
        String nombre_equipo = request.getParameter("textNombreEquipo");
        String estado_equipo = request.getParameter("textEstadoEquipo");
        String cantidad_equipo = request.getParameter("textCantEquipo");
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        EquipoVO equVO = new EquipoVO(id_equipo, img_equipo, nombre_equipo, estado_equipo, cantidad_equipo);

        EquipoDAO equDAO = new EquipoDAO(equVO);
         
        switch (opcion) 
        {
            case 1: // Agregar Registro como Administrador
            {
                if (equDAO.agregarRegistro()) 
                {
                    request.setAttribute("mensajeExito", "El equipo se registró correctamente");
                } 
                else 
                {
                    request.setAttribute("mensajeError", "El equipo NO se registró correctamente");
                }
                request.getRequestDispatcher("registrarEquipo.jsp").forward(request, response);
                break;
            }
            case 2: //Consultar por id de equipos
                equVO = equDAO.consultarID(id_equipo);
                if (equVO != null) 
                {
                    request.setAttribute("EquipoConsultado", equVO);
                    request.getRequestDispatcher("actualizarEquipo.jsp").forward(request, response);
                } else 
                {
                    request.setAttribute("mensajeError", "EL EQUIPO NO EXISTE");
                    request.getRequestDispatcher("consultarEquipoCliente.jsp").forward(request, response);
                }
                break;
            case 3:
            {
                if (equDAO.actualizarRegistro()) 
                {
                    request.setAttribute("mensajeExito", "EL EQUIPO SE ACTULIZO CORRECTAMENTE");
                    request.getRequestDispatcher("actualizarEquipo.jsp").forward(request, response);
                } else 
                {
                    request.setAttribute("mensajeError", "EL EQUIPO NO SE ACTULIZO CORRECTAMENTE");
                }
                request.getRequestDispatcher("ConsultarEquipoCliente.jsp").forward(request, response);
                break;
            }
           
        }     
    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
        {
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
            throws ServletException, IOException 
        {
            processRequest(request, response);
        }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() 
        {
            return "Short description";
        }// </editor-fold>
}