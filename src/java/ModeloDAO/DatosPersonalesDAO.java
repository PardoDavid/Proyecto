/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;
import ModeloVO.DatosPersonalesVO;
import Util.ConexionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alrod
 */
public class DatosPersonalesDAO extends ConexionBd 
{
    //1. Declarar variables
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    private String sql;
    
    private String datId = "", usuId = "", datNombre = "", datApellido = "", datTipoId = "", datNumeroId = "", datTelefono = "", datCorreo = "";

    public DatosPersonalesDAO(DatosPersonalesVO datVO) 
    {
        super();
        try 
        {
            conexion = this.obtenerConexion();

            //2.2  Traigo los datos del VO
            datId = datVO.getDatId();
            usuId = datVO.getUsuId();
            datNombre = datVO.getDatNombre();
            datApellido = datVO.getDatApellido();
            datTipoId = datVO.getDatTipoId();
            datNumeroId = datVO.getDatNumeroId();
            datTelefono = datVO.getDatTelefono();
            datCorreo = datVO.getDatCorreo();
        } 
        catch (Exception e) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public DatosPersonalesDAO() 
    {
        
    }
    
    public DatosPersonalesVO consultarDatos(String datId) 
    {
        DatosPersonalesVO datVO = null;
        try 
        {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM datospersonales WHERE datospersonales.DATID=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datId);
            mensajero = puente.executeQuery();
            while (mensajero.next()) 
            {
                datVO = new DatosPersonalesVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
            }
        } 
        catch (SQLException e) 
        {
            Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        finally 
        {
            try 
            {
                this.cerrarConexion();
            } 
            catch (SQLException e) 
            {
                Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return datVO;
    }
}
