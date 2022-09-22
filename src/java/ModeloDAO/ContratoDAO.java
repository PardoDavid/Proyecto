package ModeloDAO;

import ModeloVO.ContratoVO;
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
public class ContratoDAO extends ConexionBd implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    //Declarar Variables Para manejar datos del modulo    
    private String id_contrato = "",id_pedidoc="", fecha_contrato = "", desc_contrato = "", estado_contrato = "", fecha_instalacion = "", estado_instalacion = "", id_usuario = "";

    public ContratoDAO() {

    }

    //Metodo Principal para recibir datos del VO        
    public ContratoDAO(ContratoVO conVO) {
        super();
        //Conexion BD
        try {
            conexion = this.obtenerConexion();

            //Traer Datos del VO
            id_contrato = conVO.getId_contrato();
            id_pedidoc = conVO.getId_pedidoc();
            fecha_contrato = conVO.getFecha_contrato();
            desc_contrato = conVO.getDesc_contrato();
            estado_contrato = conVO.getEstado_contrato();
            fecha_instalacion = conVO.getFecha_instalacion();
            estado_instalacion = conVO.getEstado_instalacion();
            id_usuario = conVO.getId_usuario();

        } catch (Exception e) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into contrato (id_pedidoc,fecha_contrato,desc_contrato,estado_contrato,fecha_instalacion,estado_instalacion,id_usuario)values (?,NOW(),?,1,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_pedidoc);
            puente.setString(2, desc_contrato);
            puente.setString(3, fecha_instalacion);
            puente.setString(4, estado_instalacion);
            puente.setString(5, id_usuario);            
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update contrato set id_pedidoc=?, fecha_contrato=NOW(),desc_contrato=?,estado_contrato=1,fecha_instalacion=?,estado_instalacion=?,id_usuario=? where id_contrato=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_pedidoc);
            puente.setString(2, desc_contrato);
            puente.setString(3, fecha_instalacion);
            puente.setString(4, estado_instalacion);
            puente.setString(5, id_usuario);
            puente.setString(6, id_contrato);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public ContratoVO consultarContrato(String id_contrato) {
        ContratoVO conVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from contrato where id_contrato=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_contrato);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                conVO = new ContratoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5),
                        mensajero.getString(6), mensajero.getString(7),mensajero.getString(8));
            }
        } catch (SQLException e) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return conVO;
    }

    public ArrayList<ContratoVO> listar() {
        ArrayList<ContratoVO> listaContrato = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from contrato";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ContratoVO conVO = new ContratoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5),
                        mensajero.getString(6), mensajero.getString(7),mensajero.getString(8));
                listaContrato.add(conVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaContrato;
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
