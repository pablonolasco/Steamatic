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
import steamatic.interfaces.ICompra;
import steamatic.model.dto.CompraDTO;
import steamatic.utils.StematicConstants;

/**
 *
 */
public class CompraDAO implements ICompra {

    private String SQL_INSERT = StematicConstants.C_INSERT + "Compras(Id_Empleado, "
            + "Codigo, Nombre_Producto,RFC,Tipo_Producto,Descripcion,Stock,Cantidad,"
            + "Concepto,Fecha_Compra,Costo_Real)"
            + " VALUES(?,?,?,?,?,?,?,?,?,?,?);";
    private String SQL_DELETE = StematicConstants.C_UPDATE + "Compras set estatus=0 where Id_compras=? ";
    private String SQL_UPDATE = StematicConstants.C_UPDATE + "Compras set Codigo=?,"
            + "Nombre_Producto=?,RFC=?,Tipo_Producto=?,Descripcion=?,"
            + "Stock=?,Cantidad=?,Concepto=?,Costo_Real=? where Id_compras=? ";
    private String SQL_READ = StematicConstants.C_SELECT + "* from Compras where Nombre_Producto like ? and estatus='1'";
    private String SQL_READ_ALL = StematicConstants.C_SELECT + "* from Compras where estatus='1'";
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    public CompraDAO() {
    }

    public CompraDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insertar_compra(CompraDTO cdto) throws SQLException {
        int row = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_INSERT);
            int indice = 1;
            statement.setInt(indice++, cdto.getmId_Empleado());
            statement.setString(indice++, cdto.getmCodigo());
            statement.setString(indice++, cdto.getmNombre_Producto());
            statement.setString(indice++, cdto.getmRFC());
            statement.setString(indice++, cdto.getmTipo_Producto());
            statement.setString(indice++, cdto.getmDescripcion());
            statement.setInt(indice++, cdto.getmStock());
            statement.setDouble(indice++, cdto.getmCantidad());
            statement.setString(indice++, cdto.getmConcepto());
            statement.setString(indice++, dateFormat.format(cdto.getMdatetime()));
            statement.setDouble(indice++, cdto.getmCosto_Real());
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
    public int eliminar_compra(CompraDTO cdto) throws SQLException {
        int row = 0;

        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_DELETE);
            int indice = 1;
            statement.setInt(indice, cdto.getmId_compras());
            row = statement.executeUpdate();

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
        return row;
    }

    @Override
    public int update_compra(CompraDTO cdto) throws SQLException {
        int row = 0;
        
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_UPDATE);
            int indice = 1;
            statement.setString(indice++, cdto.getmCodigo());
            statement.setString(indice++, cdto.getmNombre_Producto());
            statement.setString(indice++, cdto.getmRFC());
            statement.setString(indice++, cdto.getmTipo_Producto());
            statement.setString(indice++, cdto.getmDescripcion());
            statement.setInt(indice++, cdto.getmStock());
            statement.setDouble(indice++, cdto.getmCantidad());
            statement.setString(indice++, cdto.getmConcepto());
            statement.setDouble(indice++, cdto.getmCosto_Real());
            statement.setInt(indice++, cdto.getmId_compras());
        
            row = statement.executeUpdate();

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
        return row;
    }

    @Override
    public DefaultTableModel get_compra(CompraDTO cdto) throws SQLException {
        DefaultTableModel operacionDTOs = new DefaultTableModel();
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_READ);
            statement.setString(1, "%" + cdto.getmNombre_Producto() + "%");
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
    public DefaultTableModel get_compras() throws SQLException {
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
