/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import steamatic.model.dto.EmpleadoDTO;

/**
 *
 * @author pablonolasco
 */
public class EmpleadoDAO implements IEmpleado {

    private ResultSet resultSet;
    private PreparedStatement statement;
    private Connection connection;
    private String SQL_INSERT = "Insert Into Empleado(Nombre,Apellido_Paterno,Apellido_Materno,Organismo,Sexo,Estado_Civil,Fecha_Nacimiento,Direccion,Puesto)"
            + "        Values(?,?,?,?,?,?,?,"
            + "               ?,?);";
    private String SQL_DELET = "update Empleado set estatus=0 where id_Empleado=?";
    private String SQL_UPDATE = "update Empleado set Nombre=?,  Apellido_Paterno=?,  Apellido_Materno=?, Organismo=?,  Direccion=?, Puesto=? where id_Empleado=?";
    private String SQL_READ = "Select * from Empleado where ( Nombre like ? or Apellido_Paterno like ?) and estatus='1';";
    private String SQL_READ_ALL = "Select * from Empleado where estatus=1;";

    public EmpleadoDAO() {
    }

    public EmpleadoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insertar_empleado(EmpleadoDTO edao) throws SQLException {
        int rows = 0;
        try {
            Connection conn;
            int indice = 1;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_INSERT);
            statement.setString(1, edao.getmNombre());
            statement.setString(2, edao.getmApellido_Paterno());
            statement.setString(3, edao.getmApellido_Materno());
            statement.setString(4, edao.getmOrganismo());
            statement.setString(5, edao.getmSexo());
            statement.setString(6, edao.getmEstado_Civil());
            statement.setDate(7, Date.valueOf(edao.getmFecha_Nacimiento()));
            statement.setString(8, edao.getmDireccion());
            statement.setString(9, edao.getmPuesto());
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
                DBConexion.desconection(connection);
            }
        }

        return rows;
    }

    @Override
    public int modificar_empleado(EmpleadoDTO edto) throws SQLException {
        int rows = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_UPDATE);
            statement.setString(1, edto.getmNombre());
            statement.setString(2, edto.getmApellido_Paterno());
            statement.setString(3, edto.getmApellido_Materno());
            statement.setString(4, edto.getmOrganismo());
            statement.setString(5, edto.getmDireccion());
            statement.setString(6, edto.getmPuesto());
            statement.setInt(7, edto.getmId_Empleado());
            rows = statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int eliminar_empleado(EmpleadoDTO edto) throws SQLException {
        int rows = 0;
        try {
            Connection conn;
            conn = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = conn.prepareStatement(SQL_DELET);
            statement.setInt(1, edto.getmId_Empleado());
            rows = statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public DefaultTableModel consultar_empleado(EmpleadoDTO edto) throws SQLException {
        DefaultTableModel empleadoDTOs = new DefaultTableModel();
        try {
            Connection c;
            c = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = c.prepareStatement(SQL_READ);
            statement.setString(1, "%" + edto.getmNombre() + "%");
            statement.setString(2, "%" + edto.getmApellido_Paterno() + "%");
            resultSet = (ResultSet) statement.executeQuery();
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = resultSet.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                empleadoDTOs.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (resultSet.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = resultSet.getObject(i + 1);
                }
                empleadoDTOs.addRow(fila);
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
                DBConexion.desconection(connection);
            }
        }
        return empleadoDTOs;
    }

    @Override
    public DefaultTableModel consultar_empleados() throws SQLException {
        DefaultTableModel empleadoDTOs = new DefaultTableModel();
        try {
            Connection c;
            c = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = c.prepareStatement(SQL_READ_ALL);
            resultSet = (ResultSet) statement.executeQuery();
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = resultSet.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                empleadoDTOs.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (resultSet.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = resultSet.getObject(i + 1);
                }
                empleadoDTOs.addRow(fila);
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
                DBConexion.desconection(connection);
            }
        }
        return empleadoDTOs;
    }

}
