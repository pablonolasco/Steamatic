/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import steamatic.model.dto.ProveedorDTO;

/**
 *
 * @author pablonolasco
 */
public class ProveedorDAO implements IProveedor{
    private String SQL_INSERT="insert into Proveedores(Nombre_Proveedor,Codigo,RFC,Direccion,Telefono,E_Mail) "
            + "Values(?,?,?,?,?,?);";
    private String SQL_DELETE;
    private String SQL_UPDATE;
    private String SQL_READ;
    private String SQL_READ_ALL;
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
        int rows=0;
        try {
            Connection conn;
            conn=(this.connection != null)?this.connection:DBConexion.getConnection();
            statement=conn.prepareStatement(SQL_INSERT);
            int indice=1;
            statement.setString(indice++, dTO.getmNombre_Proveedor());
            statement.setInt(indice++, dTO.getmCodigo());
            statement.setString(indice++, dTO.getmRFC());
            statement.setString(indice++, dTO.getmDireccion());
            statement.setInt(indice++, dTO.getmTelefono());
            statement.setString(indice++, dTO.getmE_Mail());
            rows=statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBConexion.close_stament(statement);
            if(this.connection !=null)DBConexion.desconection(this.connection);
        }
        return rows;
    }

    @Override
    public int eliminar_proveedor(ProveedorDTO dTO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update_proveedor(ProveedorDTO dTO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProveedorDTO> get_proveedor(ProveedorDTO dTO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProveedorDTO> get_proveedores() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
