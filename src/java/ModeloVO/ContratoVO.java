/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Joretof
 */
public class ContratoVO {
    
private String id_contrato,id_pedidoc, fecha_contrato, desc_contrato,estado_contrato,fecha_instalacion,estado_instalacion,id_usuario;   

    public ContratoVO(String id_contrato, String id_pedidoc, String fecha_contrato, String desc_contrato, String estado_contrato, String fecha_instalacion, String estado_instalacion, String id_usuario) {
        this.id_contrato = id_contrato;
        this.id_pedidoc = id_pedidoc;
        this.fecha_contrato = fecha_contrato;
        this.desc_contrato = desc_contrato;
        this.estado_contrato = estado_contrato;
        this.fecha_instalacion = fecha_instalacion;
        this.estado_instalacion = estado_instalacion;
        this.id_usuario = id_usuario;
    }

    public ContratoVO() {
    }

    public String getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(String id_contrato) {
        this.id_contrato = id_contrato;
    }

    public String getId_pedidoc() {
        return id_pedidoc;
    }

    public void setId_pedidoc(String id_pedidoc) {
        this.id_pedidoc = id_pedidoc;
    }

    public String getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(String fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public String getDesc_contrato() {
        return desc_contrato;
    }

    public void setDesc_contrato(String desc_contrato) {
        this.desc_contrato = desc_contrato;
    }

    public String getEstado_contrato() {
        return estado_contrato;
    }

    public void setEstado_contrato(String estado_contrato) {
        this.estado_contrato = estado_contrato;
    }

    public String getFecha_instalacion() {
        return fecha_instalacion;
    }

    public void setFecha_instalacion(String fecha_instalacion) {
        this.fecha_instalacion = fecha_instalacion;
    }

    public String getEstado_instalacion() {
        return estado_instalacion;
    }

    public void setEstado_instalacion(String estado_instalacion) {
        this.estado_instalacion = estado_instalacion;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

   
    
    

   
   
    
    
}

