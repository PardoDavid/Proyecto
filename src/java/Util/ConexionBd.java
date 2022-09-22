/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Sena
 */
public class ConexionBd 
{
    //1. Declarar variables y/u objetos
    private String driver, user, password, dataBase, urlBd;
    private Connection conexion;

    public ConexionBd() 
    {
        //2. Asignar valores
        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "";
        dataBase = "la_securite";
        urlBd = "jdbc:mysql://localhost:3306/" + dataBase;
        //3. Conectarse
        try 
        {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlBd, user, password);
            System.out.println("¡Conexión exitosa!");
        } 
        catch (Exception e) 
        {
            System.out.println("Error al conectarse" + e.toString());
        }
    }
    public Connection obtenerConexion() 
    {
        return conexion;
    }
    public Connection cerrarConexion() throws SQLException
    {
        conexion.close();
        conexion=null;
        return conexion;
    }
    public static void main(String[] args)
    {
        new ConexionBd();
    }
}
