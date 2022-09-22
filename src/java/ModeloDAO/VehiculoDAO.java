/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;
import ModeloVO.DatosPersonalesVO;
import ModeloVO.VehiculoVO;
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
public class VehiculoDAO extends ConexionBd implements Crud
{
    //1. Declarar
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String vehPlaca = "", datId = "", catId = "", vehModelo = "", vehMarca = "", vehEstado = "", vehPrecio = "";
    
    
    public VehiculoDAO(VehiculoVO vehVO)
    {
        super();
        try 
        {
            conexion = this.obtenerConexion();
            vehPlaca = vehVO.getVehPlaca();
            datId = vehVO.getDatId();
            catId = vehVO.getCatId();
            vehModelo = vehVO.getVehModelo();
            vehMarca = vehVO.getVehMarca();
            vehEstado = vehVO.getVehEstado();
            vehPrecio = vehVO.getVehPrecio();
        } catch (Exception e) 
        {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public VehiculoDAO() 
    {
        
    }

    
    @Override
    public boolean agregarRegistro() 
    {
        try 
        {
            sql = "insert into vehiculo values (?,?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, vehPlaca);
            puente.setString(2, datId);
            puente.setString(3, catId);
            puente.setString(4, vehModelo);
            puente.setString(5, vehMarca);
            puente.setString(6, vehEstado);
            puente.setString(7, vehPrecio);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) 
        {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally
        {
            try 
            {
                this.cerrarConexion();
            } catch (SQLException e) 
            {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() 
    {
        try 
        {
            sql = "update vehiculo set datId=?, catId=?, vehModelo=?, vehMarca=?, vehEstado=?, vehPrecio=? where vehPlaca=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datId);
            puente.setString(2, catId);
            puente.setString(3, vehModelo);
            puente.setString(4, vehMarca);
            puente.setString(5, vehEstado);
            puente.setString(6, vehPrecio);
            puente.setString(7, vehPlaca);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) 
        {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally 
        {
            try 
            {
                this.cerrarConexion();
            } catch (SQLException e) 
            {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
    @Override
    public boolean eliminarRegistro() 
    {
        try {
            sql = "delete from vehiculo";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datId);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) 
        {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally 
        {
            try 
            {
                this.cerrarConexion();
            } catch (SQLException e) 
            {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    public VehiculoVO consultarPlaca(String vehPlaca)
    {
        VehiculoVO vehVO = null;
        try 
        {
           sql = "SELECT vehiculo.VEHPLACA, vehiculo.DATID, categoria.CATIPO, vehiculo.VEHMODELO, vehiculo.VEHMARCA, vehiculo.VEHESTADO, vehiculo.VEHPRECIO from vehiculo INNER JOIN categoria ON vehiculo.CATID = categoria.CATID WHERE vehPlaca=?";
           puente = conexion.prepareStatement(sql);
           puente.setString(1, vehPlaca);
           mensajero = puente.executeQuery();
           while (mensajero.next())
           {
               vehVO = new VehiculoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));
           }
        } catch (SQLException e) 
        {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        finally 
        {
            try 
            {
                this.cerrarConexion();
            } catch (SQLException e) 
            {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return vehVO;
    }
    
    public ArrayList <VehiculoVO>listar()
    {
        ArrayList<VehiculoVO>listaVehiculo = new ArrayList<>();
        
        try 
        {
           conexion = this.obtenerConexion();
           sql = "SELECT vehiculo.VEHPLACA, vehiculo.DATID,categoria.CATIPO, vehiculo.VEHMODELO, vehiculo.VEHMARCA, vehiculo.VEHESTADO, vehiculo.VEHPRECIO FROM vehiculo INNER JOIN categoria ON vehiculo.CATID = categoria.CATID";
           puente = conexion.prepareStatement(sql);
           mensajero = puente.executeQuery();
           while(mensajero.next())
           {
               VehiculoVO vehVO = new VehiculoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));
               listaVehiculo.add(vehVO);
           }
        } catch (SQLException e) 
        {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        finally
        {
            try 
            {
                this.cerrarConexion();
            } 
            catch (SQLException e) 
            {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaVehiculo;
    }
}
