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
import javax.swing.table.DefaultTableModel;
import steamatic.interfaces.IOperacion;
import steamatic.model.dto.OperacionDTO;
import steamatic.utils.StematicConstants;

/**
 *
 */
public class OperacionDAO implements IOperacion {

    private String SQL_INSERT = StematicConstants.C_INSERT + "Operaciones (Empleado_Operaciones,"
            + "Apellidos,Puesto,Servicios_Programados,Servicios_Realizado,"
            + "Tiempo_Promedio,Costo_Servicio) Values (?,?,?,?,?,?,?);";
    private String SQL_UPDATE = StematicConstants.C_UPDATE + "Operaciones set Empleado_Operaciones=?,"
            + "Apellidos=?,Puesto=?,Servicios_Programados=?,Servicios_Realizado=? where Id_Operaciones=?";
    private String SQL_DELETE = StematicConstants.C_UPDATE + "Operaciones set estatus=0 where Id_Operaciones=?";
    private String SQL_READ = StematicConstants.C_SELECT + "* from Operaciones where (Empleado_Operaciones like ? and Puesto like ?) and estatus='1'";
    private String SQL_READ_ALL = StematicConstants.C_SELECT + "* from Operaciones where estatus='1'";
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    public OperacionDAO() {
    }

    public OperacionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insertar_operacion(OperacionDTO dTO) throws SQLException {
        int rows = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_INSERT);
            int indice = 1;
            statement.setString(indice++, dTO.getmEmpleado_Operaciones());
            statement.setString(indice++, dTO.getmApellidos());
            statement.setString(indice++, dTO.getmPuesto());
            statement.setString(indice++, dTO.getmServicios_Programados());
            statement.setInt(indice++, dTO.getmServicios_Realizado());
            statement.setInt(indice++, dTO.getmTiempo_Promedio());
            statement.setDouble(indice++, dTO.getmCosto_Servicio());
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
    public int eliminar_operacion(OperacionDTO dTO) throws SQLException {
        int rows = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_DELETE);
            int indice = 1;
            statement.setInt(indice, dTO.getmId_Operaciones());
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
    public int update_operacion(OperacionDTO dTO) throws SQLException {
        int rows = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_UPDATE);
            int indice = 1;
            statement.setString(indice++, dTO.getmEmpleado_Operaciones());
            statement.setString(indice++, dTO.getmApellidos());
            statement.setString(indice++, dTO.getmPuesto());
            statement.setString(indice++, dTO.getmServicios_Programados());
            statement.setInt(indice++, dTO.getmTiempo_Promedio());
            statement.setDouble(indice++, dTO.getmCosto_Servicio());
            statement.setInt(indice++, dTO.getmId_Operaciones());
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
    public DefaultTableModel get_operaciones() throws SQLException {
        DefaultTableModel opereacionDTOs = new DefaultTableModel();
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement=conn.prepareStatement(SQL_READ_ALL);
            resultSet = (ResultSet) statement.executeQuery();
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = resultSet.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                opereacionDTOs.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (resultSet.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = resultSet.getObject(i + 1);
                }
                opereacionDTOs.addRow(fila);
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
        return opereacionDTOs;
    }

    @Override
    public DefaultTableModel get_operacion(OperacionDTO dTO) throws SQLException {
        DefaultTableModel operacionDTOs = new DefaultTableModel();
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_READ);
            statement.setString(1, "%" + dTO.getmEmpleado_Operaciones() + "%");
            statement.setString(2, "%" + dTO.getmPuesto() + "%");
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
