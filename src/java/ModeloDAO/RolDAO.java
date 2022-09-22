/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.RolVO;
import Util.ConexionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sena
 */
public class RolDAO extends ConexionBd 
{
    //1. Declarar variables
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    private String id_rol = "", nombre_rol = "", estado_rol="";
    
    public RolDAO()
    {
    
    }

    public RolDAO(RolVO rolVO) 
    {
        super();

        try 
        {
            conexion = this.obtenerConexion();

            id_rol = rolVO.getId_rol();
            nombre_rol = rolVO.getNombre_rol();
            estado_rol = rolVO.getEstado_rol();
        } 
        catch (Exception e) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<RolVO> listar(String nom_usu) 
    {
        ArrayList<RolVO> listarRol = new ArrayList<>();
        try 
        {
            conexion = this.obtenerConexion();
             sql = "SELECT USUARIO.ID_USUARIO, ROL.NOMBRE_ROL FROM ROL INNER JOIN USUARIO ON ROL.ID_ROL = USUARIO.ID_ROL WHERE USUARIO.NOM_USU=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nom_usu);
            mensajero = puente.executeQuery();

            while (mensajero.next()) 
            {
                RolVO rolVO = new RolVO(mensajero.getString(1), mensajero.getString(2));
                
                listarRol.add(rolVO);
            }
        } 
        catch (Exception e) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        finally 
        {
            try 
            {
                this.cerrarConexion();
            } 
            catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarRol;
    }
    public ArrayList<RolVO> listar() {
        ArrayList<RolVO> listaRoles = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from rol";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                RolVO rolVO = new RolVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3));
                listaRoles.add(rolVO);
            }
        } catch (Exception e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaRoles;
    }
    /*public ArrayList<RolVO> listar(String nom_usu) 
    {
        ArrayList<RolVO> listaRol = new ArrayList<>();
        try 
        {
            conexion = this.obtenerConexion();
            sql = "SELECT ROL.NOMBRE_ROL FROM ROL INNER JOIN USUARIO ON ROL.ID_ROL = USUARIO.ID_ROL WHERE usuario.NOM_USU=?";  
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nom_usu);
            mensajero = puente.executeQuery();
            while (mensajero.next()) 
            {
                RolVO rolVO = new RolVO(mensajero.getString(id_rol), mensajero.getString(nombre_rol), mensajero.getString(estado_rol));
                listaRol.add(rolVO);
            }
        } 
        catch (SQLException e) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        finally 
        {
            try 
            {
                this.cerrarConexion();
            } 
            catch (SQLException e) 
            {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaRol;
    }*/
public ArrayList<RolVO> listarQ(String nom_usu) 
    {
        ArrayList<RolVO> listarUsuario = new ArrayList<>();
        
        try 
        {
            conexion = this.obtenerConexion();
            sql = "SELECT USUARIO.ID_USUARIO, ROL.ID_ROL FROM USUARIO INNER JOIN ROL ON ROL.ID_ROL = USUARIO.ID_ROL WHERE USUARIO.NOM_USU = ?;";  
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nom_usu);
            mensajero = puente.executeQuery();
            while (mensajero.next()) 
            {
                RolVO rolVO = new RolVO(id_rol, nombre_rol);
                listarUsuario.add(rolVO);
            }
        } 
        catch (SQLException e) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        finally 
        {
            try 
            {
                this.cerrarConexion();
            } 
            catch (SQLException e) 
            {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarUsuario;
    }
}
