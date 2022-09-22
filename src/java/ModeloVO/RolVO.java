/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Sena
 */
public class RolVO  
{
    private String id_rol, nombre_rol, estado_rol;

    public RolVO(String id_rol, String nombre_rol, String estado_rol) 
    {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.estado_rol = estado_rol;
    }
    

    public RolVO(String id_rol, String nombre_rol) 
    {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
    }

    public RolVO() 
    {
        
    }
    
    public String getId_rol() 
    {
        return id_rol;
    }

    public void setId_rol(String id_rol) 
    {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() 
    {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) 
    {
        this.nombre_rol = nombre_rol;
    }

    public String getEstado_rol() 
    {
        return estado_rol;
    }

    public void setEstado_rol(String estado_rol) 
    {
        this.estado_rol = estado_rol;
    }
}
