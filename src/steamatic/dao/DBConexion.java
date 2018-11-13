/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pablonolasco
 */
public class DBConexion {

    private static final String DRIVER_BD = "com.mysql.jdbc.Driver";
    private static final String USER_BD = "root";
    private static final String PASS_BD = "root";
    private static final String URL_BD = "jdbc:mysql://localhost/Steamatic?useSSL=false";
    private static Driver driver;
    
    /**
     * TODO Constructor que inicializa la conexion a la Base de datos
     *
     * @return conn cadena de conexion
     */
    
    /**
     * TODO Metodo que retorna la conexion a la base de datos
     */
    
    public static synchronized Connection getConnection() throws SQLException {
        if (driver == null) {
            try {
                Class jdbClass = Class.forName(DRIVER_BD);
                driver = (Driver) jdbClass.newInstance();
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                System.err.println("message conexion:" + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.err.println("message driver:" + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error Conexion");
                e.printStackTrace();
            }
        }
        return DriverManager.getConnection(URL_BD, USER_BD, PASS_BD);
    }

    /**
     * TODO metodo que cierra el resulset
     * @param rs 
     */
    public static void close_resulset(ResultSet rs){
        try {
            if(rs!=null)rs.close();
        }catch(SQLException e){
            System.err.println("message:"+e.getMessage());
            
        }catch (Exception e) {
            System.err.println("message:"+e.getMessage());
            
        }
        
    }
    
    /**
     * TODO Metodo que cierra PreparedStatement 
     * @param ps 
     */
    public static void close_stament(PreparedStatement ps){
        try {
            if(ps!=null)ps.close();
            
        }catch(SQLException e){
            System.err.println("message:"+e.getMessage());
        } catch (Exception e) {
            System.err.println("message:"+e.getMessage());
        }
    }
    
    /**
     * TODO Metodo que desconecta a la base de datos
     */
    public static void desconection(Connection conn) {
        try {
            if (conn != null) conn.close();
           
        } catch (SQLException e) {
            System.err.println("message error conection" + e.getMessage());
        }
    }

}
