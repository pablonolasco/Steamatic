/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import steamatic.interfaces.IVenta;
import steamatic.model.dto.VentasDTO;
import steamatic.utils.StematicConstants;

/**
 *
 */
public class VentaDAO implements IVenta {

    private String SQL_INSERT = StematicConstants.C_INSERT + "Control_Ventas(Id_Empleado, "
            + "Nombre_Vendedor, Tipo_Servicio,Empleado_Operaciones,Observaciones,Impuesto,Costo_Total)"
            + " VALUES(?,?,?,?,?,?,?);";
    private String SQL_DELETE = StematicConstants.C_UPDATE + "Control_Ventas set estatus=0 where Id_Venta=? ";
    private String SQL_UPDATE = StematicConstants.C_UPDATE + "Control_Ventas set Nombre_Vendedor=?,"
            + "Tipo_Servicio=?,Empleado_Operaciones=?,Observaciones=?,Impuesto=?,"
            + "Costo_Total=? where Id_Venta=? ";
    private String SQL_READ = StematicConstants.C_SELECT + "* from Control_Ventas where Nombre_Vendedor like ? and estatus='1'";
    private String SQL_READ_ALL = StematicConstants.C_SELECT + "* from Control_Ventas where estatus='1'";
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    public VentaDAO() {
    }

    public VentaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insertar_venta(VentasDTO cdto) throws SQLException {
        int row = 0;
        
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_INSERT);
            int indice = 1;
            statement.setInt(indice++, cdto.getmId_Empleado());
            statement.setString(indice++, cdto.getmNombre_Vendedor());
            statement.setString(indice++, cdto.getmTipo_Servicio());
            statement.setString(indice++, cdto.getmEmpleado_Operaciones());
            statement.setString(indice++, cdto.getmObservaciones());
            statement.setDouble(indice++, cdto.getmImpuesto());
            statement.setDouble(indice++, cdto.getmCosto_Total());
            row = statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int eliminar_venta(VentasDTO cdto) throws SQLException {
    int row = 0;
        
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_DELETE);
            int indice = 1;
            statement.setInt(indice++, cdto.getmId_Venta());
            row = statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int update_venta(VentasDTO cdto) throws SQLException {
        int row = 0;
        
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_UPDATE);
            int indice = 1;
            statement.setString(indice++, cdto.getmNombre_Vendedor());
            statement.setString(indice++, cdto.getmTipo_Servicio());
            statement.setString(indice++, cdto.getmEmpleado_Operaciones());
            statement.setString(indice++, cdto.getmObservaciones());
            statement.setDouble(indice++, cdto.getmImpuesto());
            statement.setDouble(indice++, cdto.getmCosto_Total());
            statement.setInt(indice++, cdto.getmId_Venta());
            
            row = statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public DefaultTableModel get_venta(VentasDTO cdto) throws SQLException {
        DefaultTableModel operacionDTOs = new DefaultTableModel();
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_READ);
            statement.setString(1, "%" + cdto.getmNombre_Vendedor()+ "%");
            resultSet = (ResultSet) statement.executeQuery();
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = resultSet.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                operacionDTOs.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (resultSet.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = resultSet.getObject(i + 1);
                }
                operacionDTOs.addRow(fila);
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
        return operacionDTOs;
    }

    @Override
    public DefaultTableModel get_ventas() throws SQLException {
        DefaultTableModel operacionDTOs = new DefaultTableModel();
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_READ_ALL);
            resultSet = (ResultSet) statement.executeQuery();
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = resultSet.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                operacionDTOs.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (resultSet.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = resultSet.getObject(i + 1);
                }
                operacionDTOs.addRow(fila);
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
        return operacionDTOs;
    }

}
