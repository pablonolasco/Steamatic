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
import steamatic.interfaces.IAlmacen;
import steamatic.model.dto.AlmacenDTO;
import steamatic.utils.StematicConstants;

/**
 *
 */
public class AlmacenDAO implements IAlmacen {

    private String SQL_INSERT="Insert into Almacen(Id_Empleado,Articulo,Fecha_Registro, "
            + "Unidad_Medida,Stock_minimo,Stock_Actual,Costo_Promedio,Existencia) "
            + "Values(?,?,?,?,?,?,?,?);";
    private String SQL_DELETE=StematicConstants.C_UPDATE+" Almacen set estatus=0 WHERE Id_Articulo=?;";
    private String SQL_UPDATE=StematicConstants.C_UPDATE+"Almacen set Articulo=?, Unidad_Medida=?,"
            + "Stock_minimo=?,Stock_Actual=?,Costo_Promedio=?,Existencia=? WHERE Id_Articulo=?;";
    private String SQL_READ=StematicConstants.C_SELECT+" * from Almacen where Articulo like ? and estatus='1';";;
    private String SQL_READ_ALL=StematicConstants.C_SELECT+" * from Almacen WHERE estatus='1';";
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    public AlmacenDAO() {
    }

    public AlmacenDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insertar_almacen(AlmacenDTO dTO) throws SQLException {
        int rows = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_INSERT);
            int indice = 1;
            statement.setInt(indice++, dTO.getmId_Empleado());
            statement.setString(indice++, dTO.getmArticulo());
            statement.setString(indice++, dateFormat.format(dTO.getmFecha_Registro()));
        statement.setDouble(indice++, dTO.getmUnidad_Medida());
            statement.setInt(indice++, dTO.getmStock_minimo());
            statement.setInt(indice++, dTO.getmStock_Actual());
            statement.setDouble(indice++, dTO.getmCosto_Promedio());
            statement.setString(indice++, dTO.getmExistencia());
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
    public int eliminar_almacen(AlmacenDTO dTO) throws SQLException {
        int rows = 0;

        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_DELETE);
            int indice = 1;
            statement.setInt(indice, dTO.getmId_Articulo());
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
    public int update_almacen(AlmacenDTO dTO) throws SQLException {
        int rows = 0;

        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_UPDATE);
            int indice = 1;
            statement.setString(indice++, dTO.getmArticulo());
            statement.setDouble(indice++, dTO.getmUnidad_Medida());
            statement.setInt(indice++, dTO.getmStock_minimo());
            statement.setInt(indice++, dTO.getmStock_Actual());
            statement.setDouble(indice++, dTO.getmCosto_Promedio());
            statement.setString(indice++, dTO.getmExistencia());
            statement.setInt(indice++, dTO.getmId_Articulo());
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
    public DefaultTableModel get_almacen(AlmacenDTO dTO) throws SQLException {
       DefaultTableModel operacionDTOs = new DefaultTableModel();
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_READ);
            statement.setString(1, "%" + dTO.getmArticulo()+ "%");
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
    public DefaultTableModel get_almacenes() throws SQLException {
        DefaultTableModel opereacionDTOs = new DefaultTableModel();
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

}
