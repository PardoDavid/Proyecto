/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.PedidoEquipoCVO;
import Util.ConexionBd;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macbookair
 */
public class PedidoEquipoCDAO extends ConexionBd implements Crud
{
    //1. Declarar

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    private String sql;
    
    private String id_pedidoC = "",id_usuario = "", fecha_pedido = "", id_equipo = "", cantidad_equipo = "";
    
    //2. Método principal para recibir datos del VO
    public PedidoEquipoCDAO(PedidoEquipoCVO pedCVO) 
    {
        super();
        /*this.fecha_pedido = new Date();*/
        //2.1 Conectarse
        try 
        {
            conexion = this.obtenerConexion();
            
            //2.2 Traigo los datos del VO
            id_pedidoC = pedCVO.getId_pedidoC();
            id_usuario = pedCVO.getId_usuario();
            fecha_pedido = pedCVO.getFecha_pedido();
            id_equipo = pedCVO.getId_equipo();
            cantidad_equipo = pedCVO.getCantidad_equipo();
        } 
        catch (Exception e) 
        {
            Logger.getLogger(PedidoEquipoCDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() 
    {
        try 
        {
            sql = "INSERT INTO PEDIDO_EQUIPO_CABECERO(ID_USUARIO,FECHA_PEDIDO,ID_EQUIPO,CANTIDAD_EQUIPO) VALUES (?,NOW(),?,?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_usuario);
            puente.setString(2, id_equipo);
            puente.setString(3, cantidad_equipo);
            puente.executeUpdate();
            operacion = true;
        } 
        catch (SQLException e) 
        {
            Logger.getLogger(PedidoEquipoCDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        finally 
        {
            try 
            {
                this.cerrarConexion();
            } 
            catch (SQLException e) 
            {
                Logger.getLogger(PedidoEquipoCDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
