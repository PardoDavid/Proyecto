/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.EquipoVO;
import ModeloVO.UsuarioVO;
import Util.ConexionBd;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class EquipoDAO extends ConexionBd implements Crud
{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    
    private String id_equipo = "", img_equipo = "", nombre_equipo = "", estado_equipo = "", cantidad_equipo = ""; 
    
    
    public EquipoDAO()
    {
        
    }
    
    public EquipoDAO(EquipoVO equVO)
    {
        super();
        
        try 
        {
            conexion = this.obtenerConexion();

            id_equipo = equVO.getId_equipo();
            img_equipo = equVO.getImg_equipo();
            nombre_equipo = equVO.getNombre_equipo();
            estado_equipo = equVO.getEstado_equipo();
            cantidad_equipo = equVO.getCantidad_equipo();
        } 
        catch (Exception e) 
        {
            Logger.getLogger(EquipoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() 
    {
        try 
        {
            sql = "INSERT INTO EQUIPO(IMG_EQUIPO, NOMBRE_EQUIPO, ESTADO_EQUIPO, CANTIDAD_EQUIPO) VALUES (?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, img_equipo);
            puente.setString(2, nombre_equipo);
            puente.setString(3, estado_equipo);
            puente.setString(4, cantidad_equipo);
            puente.executeUpdate();
            operacion = true;
        } 
        catch (SQLException e) 
        {
            Logger.getLogger(EquipoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        finally
        {
            try 
            {
                this.cerrarConexion();
            } 
            catch (SQLException e) 
            {
                Logger.getLogger(EquipoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() 
    {
        try 
        {
            sql = "update equipo set IMG_EQUIPO=?, NOMBRE_EQUIPO=?, ESTADO_EQUIPO=?, CANTIDAD_EQUIPO=? where ID_EQUIPO=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, img_equipo);
            puente.setString(2, nombre_equipo);
            puente.setString(3, estado_equipo);
            puente.setString(4, cantidad_equipo);
            puente.setString(5, id_equipo);
                
            puente.executeUpdate();
            operacion = true;
            
        } 
         catch (Exception e) 
        {
            Logger.getLogger(EquipoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        finally
        {
            try 
            {
                this.cerrarConexion();
            }
            catch (Exception e) 
            {
                Logger.getLogger(EquipoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public EquipoVO consultarID(String id_equipo) 
    {
        EquipoVO equVO = null;
        try 
        {
            conexion = this.obtenerConexion();
            sql = "select * from equipo where ID_EQUIPO = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_equipo);
            mensajero = puente.executeQuery();
            while (mensajero.next()) 
            {
                equVO = new EquipoVO(
                        mensajero.getString(1), 
                        mensajero.getString(2),
                        mensajero.getString(3), 
                        mensajero.getString(4), 
                        mensajero.getString(5));
            }
        } 
        catch (Exception e) 
        {
            Logger.getLogger(EquipoDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        finally 
        {
            try 
            {
                this.cerrarConexion();
            } catch (Exception e) 
            {
                Logger.getLogger(EquipoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return equVO;
    }
    
    public ArrayList<EquipoVO> listar()
    {
        ArrayList<EquipoVO> listaEquipos = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from equipo";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next())
            {
                EquipoVO equVO = new EquipoVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));
                listaEquipos.add(equVO);
            }
        } catch (Exception e) {
            Logger.getLogger(EquipoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(EquipoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaEquipos;
    }
}
