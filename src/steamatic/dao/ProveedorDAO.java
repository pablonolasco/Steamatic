/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.dao;

import steamatic.interfaces.IProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import steamatic.model.dto.ProveedorDTO;
import steamatic.utils.StematicConstants;

/**
 *
 * 
 */
public class ProveedorDAO implements IProveedor {

    private String SQL_INSERT = StematicConstants.C_INSERT+"Proveedores(Nombre_Proveedor,Codigo,RFC,Direccion,Telefono,E_Mail) "
            + "Values(?,?,?,?,?,?);";
    private String SQL_DELETE=StematicConstants.C_DELETE+"Proveedores where Id_Proveedores=?";
    private String SQL_UPDATE = StematicConstants.C_UPDATE+"Proveedores set Nombre_Proveedor=?,Codigo=?,Direccion=?,Telefono=?,E_Mail=?";
    private String SQL_READ = StematicConstants.C_SELECT+" * from Proveedores where ( Nombre_Proveedor like ? and estatus='1');";
    private String SQL_READ_ALL =StematicConstants.C_SELECT +"* from Proveedores where estatus='1';";
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    public ProveedorDAO() {
    }

    public ProveedorDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insertar_proveedor(ProveedorDTO dTO) throws SQLException {
        int rows = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_INSERT);
            int indice = 1;
            statement.setString(indice++, dTO.getmNombre_Proveedor());
            statement.setInt(indice++, dTO.getmCodigo());
            statement.setString(indice++, dTO.getmRFC());
            statement.setString(indice++, dTO.getmDireccion());
            statement.setInt(indice++, dTO.getmTelefono());
            statement.setString(indice++, dTO.getmE_Mail());
            rows = statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConexion.close_stament(statement);
            if (this.connection != null) {
                DBConexion.desconection(this.connection);
            }
        }
        return rows;
    }

    @Override
    public int eliminar_proveedor(ProveedorDTO dTO) throws SQLException {
        int rows = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_DELETE);
            int indice = 1;
            statement.setInt(indice, dTO.getmId_Proveedores());
            rows = statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConexion.close_stament(statement);
            if (this.connection != null) {
                DBConexion.desconection(this.connection);
            }
        }
        return rows;
    }

    @Override
    public int update_proveedor(ProveedorDTO dTO) throws SQLException {
        int rows = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_UPDATE);
            int indice = 1;
            statement.setString(indice++, dTO.getmNombre_Proveedor());
            statement.setInt(indice++, dTO.getmCodigo());
            statement.setString(indice++, dTO.getmRFC());
            statement.setString(indice++, dTO.getmDireccion());
            statement.setInt(indice++, dTO.getmTelefono());
            statement.setString(indice++, dTO.getmE_Mail());
            statement.setInt(indice++, dTO.getmId_Proveedores());
            rows = statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConexion.close_stament(statement);
            if (this.connection != null) {
                DBConexion.desconection(this.connection);
            }
        }
        return rows;
    }

    @Override
    public DefaultTableModel get_proveedor(ProveedorDTO dTO) throws SQLException {
        DefaultTableModel proveedorDTOs = new DefaultTableModel();
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_READ);
            statement.setString(1,"%"+ dTO.getmNombre_Proveedor()+"%");
            resultSet=(ResultSet)statement.executeQuery();
                        //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = resultSet.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                proveedorDTOs.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (resultSet.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = resultSet.getObject(i + 1);
                }
                proveedorDTOs.addRow(fila);
            }

        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConexion.close_resulset(resultSet);
            DBConexion.close_stament(statement);
            if (this.connection != null) {
                DBConexion.desconection(this.connection);
            }
        }
        return proveedorDTOs;
    }

    @Override
    public DefaultTableModel get_proveedores() throws SQLException {
        DefaultTableModel proveedorDTOs = new DefaultTableModel();
        try {
            Connection conn;
            conn=(this.connection != null)?this.connection:DBConexion.getConnection();
            statement=conn.prepareStatement(SQL_READ_ALL);
            resultSet=(ResultSet)statement.executeQuery();
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = resultSet.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                proveedorDTOs.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (resultSet.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = resultSet.getObject(i + 1);
                }
                proveedorDTOs.addRow(fila);
            }

        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        }finally{
            DBConexion.close_resulset(resultSet);
            DBConexion.close_stament(statement);
            if (this.connection != null) DBConexion.desconection(this.connection);
        }
        
        return proveedorDTOs;
    }

}
