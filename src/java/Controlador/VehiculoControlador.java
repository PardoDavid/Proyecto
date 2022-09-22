/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
/**
 *
 * @author Sena
 */
import ModeloDAO.DatosPersonalesDAO;
import ModeloDAO.VehiculoDAO;
import ModeloVO.DatosPersonalesVO;
import ModeloVO.VehiculoVO;
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
@WebServlet(name = "VehiculoControlador", urlPatterns = {"/Vehiculo"})
public class VehiculoControlador extends HttpServlet 
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
        response.setContentType("text/html;charset=UTF-8");
         //1. datos de la vista
         String vehPlaca = request.getParameter("textPlaca");
         String datId = request.getParameter("textDat");
         String catId = request.getParameter("textCat");
         String vehModelo = request.getParameter("textModelo");
         String vehMarca = request.getParameter("textMarca");
         String vehEstado = request.getParameter("textEstado");
         String vehPrecio = request.getParameter("textPrecio");
         String datos = request.getParameter("datos");
         int opcion2 = Integer.parseInt(request.getParameter("opcion2"));
         
         //2.instanciar VO // infromacion
         VehiculoVO vehVO = new VehiculoVO(vehPlaca, datId, catId,  vehModelo, vehMarca, vehEstado, vehPrecio);
         
         //3. instanciar Dao //opereaciones
         VehiculoDAO vehDAO = new VehiculoDAO(vehVO);
       
         //4. administrar operaciones
         switch (opcion2) 
         {
            case 1:  //agregar registro
                if (vehDAO.agregarRegistro()) 
                {
                    request.setAttribute("MensajeExito", "El vehiculo se registro");
                } 
                else 
                {
                    request.setAttribute("MensajeError", "El vehiculo no se pudo registrar");
                }
                request.getRequestDispatcher("registrarVehiculo.jsp").forward(request, response);
                break;

            case 2:  //actualizar registro
                if (vehDAO.actualizarRegistro()) 
                {
                    request.setAttribute("MensajeExito", "El vehiculo se actualizo");
                } 
                else 
                {
                    request.setAttribute("MensajeError", "El vehiculo no se pudo actualizar");
                }
                request.getRequestDispatcher("actualizarVehiculo.jsp").forward(request, response);
                break;
                
            case 3:  //eliminar registro
                if (vehDAO.eliminarRegistro()) 
                {
                    request.setAttribute("MensajeExito", "El vehiculo se elimino");

                } 
                else 
                {
                    request.setAttribute("MensajeError", "El vehiculo no se pudo eliminar");
                }
                request.getRequestDispatcher("eliminarVehiculo.jsp").forward(request, response);
                break;
                
            case 4:  //Consultar por placa comprador
               
                vehVO = vehDAO.consultarPlaca(vehPlaca);
                if (vehVO != null) 
                {
                    request.setAttribute("datosConsultados", vehVO);
                    request.getRequestDispatcher("consultarVehiculoComprador.jsp").forward(request, response);
                } 
                else 
                {
                    request.setAttribute("MensajeError", "EL VEHICULO NO EXISTE");

                    request.getRequestDispatcher("consultarVehiculo.jsp").forward(request, response);
                }
                break;
                
            case 5:  //Consultar por placa vendedor
               
                vehVO = vehDAO.consultarPlaca(vehPlaca);
                if (vehVO != null) 
                {
                    request.setAttribute("datosConsultados", vehVO);
                    request.getRequestDispatcher("actualizarVehiculo.jsp").forward(request, response);
                } 
                else 
                {
                    request.setAttribute("MensajeError", "EL VEHICULO NO EXISTE");

                    request.getRequestDispatcher("consultarVehiculo.jsp").forward(request, response);
                }
                break;  
            
            case 6:  //Datos Personales vendedor
               
                DatosPersonalesVO datVO = new DatosPersonalesVO();
                DatosPersonalesDAO datDAO = new DatosPersonalesDAO();
                
                datVO = datDAO.consultarDatos(datos);
                
                if(datVO != null)
                {
                    request.setAttribute("datosPersonales", datVO);
                    request.getRequestDispatcher("datosPersonalesVendedor.jsp").forward(request, response);
                } 
                else 
                {
                    request.setAttribute("mensajeError", "Datos No se encontraron");
                    request.getRequestDispatcher("consultarVehiculo.jsp").forward(request, response);
                }
                break;
                
            case 7:  //Datos Personales comprador
               
                DatosPersonalesVO DatVO = new DatosPersonalesVO();
                DatosPersonalesDAO DatDAO = new DatosPersonalesDAO();
                
                DatVO = DatDAO.consultarDatos(datos);
                
                if(DatVO != null)
                {
                    request.setAttribute("datosPersonales", DatVO);
                    request.getRequestDispatcher("datosPersonales.jsp").forward(request, response);
                } 
                else 
                {
                    request.setAttribute("mensajeError", "Datos No se encontraron");
                    request.getRequestDispatcher("consultarVehiculo.jsp").forward(request, response);
                }
                break; 
        }
    }
    @Override
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
   
