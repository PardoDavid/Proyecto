
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;
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
 * @author Sena
 */
public class UsuarioDAO extends ConexionBd implements Crud 
{
    //1. Declarar

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String id_usuario="", nom_usu = "", clave = "", tipo_doc ="", num_doc="", telefono="", correo_electronico="", id_rol="", estado="";

    public UsuarioDAO() {
    }
    
    //2. Método principal para recibir datos del VO
    public UsuarioDAO(UsuarioVO usuVO) 
    {
        super();
        //2.1 Conectarse
        try 
        {
            conexion = this.obtenerConexion();
            
            //2.2 Traigo los datos del VO
            id_usuario = usuVO.getId_usuario();
            nom_usu = usuVO.getNom_usu();
            clave = usuVO.getClave();
            tipo_doc = usuVO.getTipo_doc();
            num_doc = usuVO.getNum_doc();
            telefono = usuVO.getTelefono();
            correo_electronico = usuVO.getCorreo_electronico();
            id_rol = usuVO.getId_rol();
            estado = usuVO.getEstado();
        } 
        catch (Exception e) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() 
    {
        try 
        {
            sql = "INSERT INTO USUARIO (NOM_USU, CLAVE, TIPO_DOC, NUM_DOC, TELEFONO, CORREO_ELECTRONICO, ID_ROL, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nom_usu);
            puente.setString(2, clave);
            puente.setString(3, tipo_doc);
            puente.setString(4, num_doc);
            puente.setString(5, telefono);
            puente.setString(6, correo_electronico);
            puente.setString(7, id_rol);
            puente.setString(8, estado);
            puente.executeUpdate();
            operacion = true;
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
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() 
    {
        try {
            sql = "update usuario set nom_usu=?,clave=?,tipo_doc=?,num_doc=?,telefono=?,correo_electronico=?,id_rol=?,estado=? where id_usuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nom_usu);
            puente.setString(2, clave);
            puente.setString(3, tipo_doc);
            puente.setString(4, num_doc);
            puente.setString(5, telefono);
            puente.setString(6, correo_electronico);
            puente.setString(7, id_rol);
            puente.setString(8, estado);
            puente.setString(9, id_usuario);
            puente.executeUpdate();
            operacion = true;
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
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() 
    {
        try 
        {
            sql = "update usuario set estado=? where estado=activo";
            puente = conexion.prepareStatement(sql);
            /*puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(3, usuId);*/
            puente.executeUpdate();
            operacion = true;

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
        return operacion;
    }

    public boolean inicioSesion(String nom_usu, String clave) 
    {
        try 
        {
            conexion = this.obtenerConexion();
            sql = "SELECT NOM_USU,CLAVE FROM usuario WHERE NOM_USU=? AND CLAVE=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nom_usu);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();
            if (mensajero.next()) 
            {
                operacion = true;
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
            catch (SQLException e) 
            {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    public UsuarioVO consultarID(String ID_USUARIO) {
        UsuarioVO usuVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario where ID_USUARIO = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ID_USUARIO);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4), mensajero.getString(5),
                        mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), mensajero.getString(9));
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return usuVO;
    }
    public ArrayList<UsuarioVO> listar() 
    {
        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                UsuarioVO usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4), mensajero.getString(5),
                        mensajero.getString(6), mensajero.getString(7),mensajero.getString(8),mensajero.getString(9));
                listaUsuarios.add(usuVO);
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaUsuarios;
    }
    
    public ArrayList<UsuarioVO> listar(String nom_usu) 
    {
        ArrayList<UsuarioVO> listarUsuario = new ArrayList<>();
        
        try 
        {
            conexion = this.obtenerConexion();
            sql = "SELECT USUARIO.ID_USUARIO, ROL.ID_ROL FROM USUARIO INNER JOIN ROL ON ROL.ID_ROL = USUARIO.ID_ROL WHERE USUARIO.NOM_USU = ?;";  
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nom_usu);
            mensajero = puente.executeQuery();
            while (mensajero.next()) 
            {
                UsuarioVO usuVO = new UsuarioVO(id_usuario, nom_usu);
                listarUsuario.add(usuVO);
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
