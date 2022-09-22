/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.PedidoEquipoCDAO;
import ModeloVO.PedidoEquipoCVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author macbookair
 */
@WebServlet(name = "PedidoEquipoCControlador", urlPatterns = {"/PedidoEquipoCControlador"})
public class PedidoEquipoCControlador extends HttpServlet 
{
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
        String id_pedidoC = request.getParameter("textId_pedidoC");
        String id_usuario = request.getParameter("textId_usuario");
        String fecha_pedido = request.getParameter("textFecha_pedido");
        String id_equipo = request.getParameter("textId_equipo");
        String cantidad_equipo = request.getParameter("textCantidad_equipo");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        PedidoEquipoCVO pedCVO = new PedidoEquipoCVO(id_pedidoC, id_usuario, fecha_pedido, id_equipo, cantidad_equipo);

        PedidoEquipoCDAO pedCDAO = new PedidoEquipoCDAO(pedCVO);
         
        switch (opcion) 
        {
            case 1: // Agregar Registro en Pedido Cabecero automaticamente
            {
                if (pedCDAO.agregarRegistro()) 
                {
                    request.setAttribute("mensajeExito", "Se hizo el registro correctamente");
                } 
                else 
                {
                    request.setAttribute("mensajeError", "NO se hizo el registró correctamente");
                }
                request.getRequestDispatcher("consultarEquipoCliente.jsp").forward(request, response);
                break;
            }
            
            case 2:
                break;
            case 3:
            {
                if (pedCDAO.actualizarRegistro()) 
                {
                    request.setAttribute("mensajeExito", "EL USUARIO SE ACTULIZO CORRECTAMENTE");
                    request.getRequestDispatcher("actualizarEquipo.jsp").forward(request, response);
                } else 
                {
                    request.setAttribute("mensajeError", "EL USUARIO NO SE ACTULIZO CORRECTAMENTE");
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