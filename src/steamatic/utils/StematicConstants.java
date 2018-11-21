/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.utils;

/**
 *
 */
public class StematicConstants {
    //*DBConexion 
    public static final String DB_DRIVER_BD = "com.mysql.jdbc.Driver";
    public static final String DB_USER_BD = "root";
    public static final String DB_PASS_BD = "root";
    public static final String DB_URL_BD = "jdbc:mysql://localhost/Steamatic?useSSL=false";
    //*Messages Aplication
    public static final String M_INSERT_SUCCESS="Registro Correcto.";
    public static final String M_UPDATE_SUCCESS="Modificacion Correcta.";
    public static final String M_DELETE_SUCCESS="Registro eliminado.";
    public static final String M_ERROR="Ocurrio un error.";
    public static final String M_OBLIGATE="Campos obligatorios";
    public static final String M_OBLIGATE_ID="Selecciona un registro.";
    public static final String M_OBLIGATE_SEARCH="Campo de busqueda obligatorio.";
    //*SQL
    public static final String C_INSERT="insert into ";
    public static final String C_UPDATE="UPDATE ";
    public static final String C_SELECT="select ";
    
   
    
}
