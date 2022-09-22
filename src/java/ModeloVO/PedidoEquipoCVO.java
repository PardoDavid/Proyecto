/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author macbookair
 */
public class PedidoEquipoCVO 
{
    private String id_pedidoC,id_usuario, fecha_pedido, id_equipo, cantidad_equipo;

    public PedidoEquipoCVO(String id_pedidoC, String id_usuario, String fecha_pedido, String id_equipo, String cantidad_equipo) 
    {
        this.id_pedidoC = id_pedidoC;
        this.id_usuario = id_usuario;
        this.fecha_pedido = fecha_pedido;
        this.id_equipo = id_equipo;
        this.cantidad_equipo = cantidad_equipo;
    }

    public String getId_pedidoC() 
    {
        return id_pedidoC;
    }

    public void setId_pedidoC(String id_pedidoC) 
    {
        this.id_pedidoC = id_pedidoC;
    }

    public String getId_usuario() 
    {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) 
    {
        this.id_usuario = id_usuario;
    }

    public String getFecha_pedido() 
    {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) 
    {
        this.fecha_pedido = fecha_pedido;
    }

    public String getId_equipo() 
    {
        return id_equipo;
    }

    public void setId_equipo(String id_equipo) 
    {
        this.id_equipo = id_equipo;
    }

    public String getCantidad_equipo() 
    {
        return cantidad_equipo;
    }

    public void setCantidad_equipo(String cantidad_equipo) 
    {
        this.cantidad_equipo = cantidad_equipo;
    }
}
