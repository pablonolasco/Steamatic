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
import steamatic.interfaces.ISalida;
import steamatic.model.dto.SalidaDTO;
import steamatic.utils.StematicConstants;

/**
 *
 */
public class SalidaDAO implements ISalida {

    private String SQL_INSERT = StematicConstants.C_INSERT + "Salidas (Id_Operaciones,"
            + "Id_Articulo,Fecha_Salida,Fecha_Servicio,Empleado_Operaciones,Servicio,"
            + "Articulos_Entregados,Total_Entregados)"
            + "VALUES(?,?,?,?,?,?,?,?)";
    private String SQL_DELETE = StematicConstants.C_UPDATE + " Salidas SET estatus=0 where Id_Salida=?";
    private String SQL_UPDATE = StematicConstants.C_UPDATE + " Salidas SET Articulos_Entregados=? where Id_dev=?";
    private String SQL_READ = StematicConstants.C_SELECT + " * from Salidas where Articulos_Entregados like ? and estatus='1'";
    private String SQL_READ_ALL = StematicConstants.C_SELECT + " * from Salidas where estatus='1'";
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public SalidaDAO() {
    }

    public SalidaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insertar_salida(SalidaDTO dTO) throws SQLException {
        int row = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_INSERT);
            int indice = 1;
            statement.setInt(indice++, dTO.getmId_Operaciones());
            statement.setInt(indice++, dTO.getmId_Articulo());
            statement.setString(indice++, (dTO.getmFecha_Salida()));
            statement.setString(indice++, (dTO.getmFecha_Servicio()));
            statement.setString(indice++, dTO.getmEmpleado_Operaciones());
            statement.setString(indice++, dTO.getmServicio());
            statement.setString(indice++, dTO.getmArticulos_Entregados());
            statement.setInt(indice++, dTO.getmTotal_Entregados());
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
                DBConexion.desconection(connection);
            }
        }
        return row;
    }

    @Override
    public int eliminar_salida(SalidaDTO dTO) throws SQLException {
        int row = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_DELETE);
            int indice = 1;
            statement.setInt(indice, dTO.getmId_Salida());
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
                DBConexion.desconection(connection);
            }
        }
        return row;
    }

    @Override
    public int update_salida(SalidaDTO dTO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel get_salida(SalidaDTO dTO) throws SQLException {
         DefaultTableModel operacionDTOs = new DefaultTableModel();
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_READ);
            statement.setString(1, "%" + dTO.getmArticulos_Entregados()+ "%");
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
    public DefaultTableModel get_salidas() throws SQLException {  DefaultTableModel operacionDTOs = new DefaultTableModel();
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
