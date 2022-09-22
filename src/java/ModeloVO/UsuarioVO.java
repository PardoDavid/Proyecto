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
public class UsuarioVO 
{
    private String id_usuario, nom_usu, clave, tipo_doc, num_doc, telefono, correo_electronico, id_rol, estado;

    public UsuarioVO(String id_usuario, String nom_usu, String clave, String tipo_doc, String num_doc, String telefono, String correo_electronico, String id_rol, String estado) 
    {
        this.id_usuario = id_usuario;
        this.nom_usu = nom_usu;
        this.clave = clave;
        this.tipo_doc = tipo_doc;
        this.num_doc = num_doc;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.id_rol = id_rol;
        this.estado = estado;
    }

    public UsuarioVO(String id_usuario) 
    {
        this.id_usuario = id_usuario;
    }

    public UsuarioVO(String id_usuario, String nom_usu) {
        this.id_usuario = id_usuario;
        this.nom_usu = nom_usu;
    }
    
    

    public UsuarioVO() {
    }
    

    public UsuarioVO(String id_usuario, String nom_usu, String clave) {
        this.id_usuario = id_usuario;
        this.nom_usu = nom_usu;
        this.clave = clave;
    }
    
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}