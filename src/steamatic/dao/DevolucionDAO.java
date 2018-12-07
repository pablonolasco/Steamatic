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
import steamatic.interfaces.IDevolucion;
import steamatic.model.dto.DevolucionDTO;
import steamatic.utils.StematicConstants;

/**
 *
 */
public class DevolucionDAO implements IDevolucion {

    private String SQL_INSERT = StematicConstants.C_INSERT + "Devolucion(Id_Operaciones,"
            + "Id_Articulo,Fecha_Salida,Fecha_Entrada,Articulo_Devuelto,Total_Devuelto) "
            + "VALUES(?,?,?,?,?,?)";
    private String SQL_DELETE = StematicConstants.C_UPDATE + " Devolucion SET estatus=0 where Id_dev=?";
    private String SQL_UPDATE = StematicConstants.C_UPDATE + " Devolucion SET Articulo_Devuelto=?,Total_Devuelto=? where Id_dev=?";
    private String SQL_READ = StematicConstants.C_SELECT + " * from Devolucion where Articulo_Devuelto like ? and estatus='1'";
    private String SQL_READ_ALL = StematicConstants.C_SELECT + " * from Devolucion where estatus='1'";
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public DevolucionDAO() {
    }

    public DevolucionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insertar_devolucion(DevolucionDTO dTO) throws SQLException {
        int row = 0;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat();
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_INSERT);
            int indice = 1;
            statement.setInt(indice++, dTO.getmId_Operaciones());
            statement.setInt(indice++, dTO.getmId_Articulo());
            statement.setString(indice++, (dTO.getmFecha_Salida()));
            statement.setString(indice++, (dTO.getmFecha_Entrada()));
            statement.setString(indice++, dTO.getmArticulo_Devuelto());
            statement.setInt(indice++, dTO.getmTotal_Devuelto());
            row = statement.executeUpdate();
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
        return row;

    }

    @Override
    public int eliminar_devolucion(DevolucionDTO dTO) throws SQLException {
        int row = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_DELETE);
            int indice = 1;
            statement.setInt(indice, dTO.getmId_dev());
            row = statement.executeUpdate();
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
        return row;

    }

    @Override
    public int update_devolucion(DevolucionDTO dTO) throws SQLException {
        int row = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_UPDATE);
            int indice = 1;
            statement.setString(indice++, dTO.getmArticulo_Devuelto());
            statement.setInt(indice++, dTO.getmTotal_Devuelto());
            statement.setInt(indice++, dTO.getmId_dev());

            row = statement.executeUpdate();
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
        return row;

    }

    @Override
    public DefaultTableModel get_devolucion(DevolucionDTO dTO) throws SQLException {
        DefaultTableModel operacionDTOs = new DefaultTableModel();
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_READ);
            statement.setString(1, "%" + dTO.getmArticulo_Devuelto() + "%");
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
    public DefaultTableModel get_devolucions() throws SQLException {
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
