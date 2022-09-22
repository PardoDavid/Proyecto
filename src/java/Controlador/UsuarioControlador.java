package Controlador;
import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
import ModeloVO.RolVO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Sena
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet 
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

        // 1. Recibir datos de las vistas
        String id_usuario = request.getParameter("textId");
        String nom_usu = request.getParameter("textUsuario");
        String clave = request.getParameter("textClave");
        String tipo_doc = request.getParameter("texTipoDocQ");
        String num_doc = request.getParameter("textNumDoc");
        String telefono = request.getParameter("textTelefono");
        String correo_electronico = request.getParameter("textCorreo");
        String id_rol = request.getParameter("textIdRol");
        String estado = request.getParameter("textEstado");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        

        //2. Instanciar datos de forma segura con el VO
        UsuarioVO usuVO = new UsuarioVO(id_usuario, nom_usu, clave, tipo_doc, num_doc, telefono, correo_electronico, id_rol, estado);

        //3. Instanciar el DAO
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
        
        //4. Administrar Operaciones
        switch (opcion) 
        {
            case 1: // Agregar Registro como Administrador
            {
                if (usuDAO.agregarRegistro()) 
                {
                    request.setAttribute("mensajeExito", "El usuario se registró correctamente");
                } 
                else 
                {
                    request.setAttribute("mensajeError", "El usuario NO se registró correctamente");
                }
                request.getRequestDispatcher("registrarUsuarioAdministrador.jsp").forward(request, response);
                break;
            }
            
            case 2: //Iniciar sesion
            {
                if (usuDAO.inicioSesion(nom_usu, clave)) 
                {
                    HttpSession misesion = request.getSession(true);
                    usuVO = new UsuarioVO(id_usuario, nom_usu, clave);
                    misesion.setAttribute("datosUsuario", usuVO);
               
                    RolDAO rolDAO = new RolDAO();
                    RolVO rolVO = new RolVO();
               
                    ArrayList<RolVO>listarRol = rolDAO.listar(nom_usu);
                    for (int i = 0; i < listarRol.size(); i++) 
                    {
                        rolVO = listarRol.get(i);
                    }
                    String nombre_rol = rolVO.getNombre_rol();
               
                    if (listarRol.size() > 1) 
                    {
                        request.getRequestDispatcher("menu.jsp").forward(request, response);
                    }
               
                    if(nombre_rol.equals("Cliente"))
                    {
                        request.getRequestDispatcher("consultarEquipoCliente.jsp").forward(request, response);
                    }
                    else if(nombre_rol.equals("Administrador"))
                    {
                        request.getRequestDispatcher("registrarUsuarioAdministrador.jsp").forward(request, response);
                    }
                    else if(nombre_rol.equals("Tecnico"))
                    {
                        request.getRequestDispatcher("dashboardTecnico.jsp").forward(request, response);
                    }
                }
                else
                {
                    request.setAttribute("mensajeError", "¡Por favor, verifique sus datos de acceso!");
                    request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
                }
            }
            break;
        
        case 3:
            {
                if (usuDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "EL USUARIO SE ACTULIZO CORRECTAMENTE");
                } else {
                    request.setAttribute("mensajeError", "EL USUARIO NO SE ACTULIZO CORRECTAMENTE");
                }
                request.getRequestDispatcher("consultarUsuarioAdministrador.jsp").forward(request, response);
                break;
            }
            case 4:
                usuVO = usuDAO.consultarID(id_usuario);
                if (usuVO != null) {
                    request.setAttribute("UsuarioConsultado", usuVO);
                    request.getRequestDispatcher("actualizarUsuarioAdministrador.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "EL USUARIO NO EXISTE");
                    request.getRequestDispatcher("consultarUsuarioAdministrador.jsp").forward(request, response);
                }
                break;
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

