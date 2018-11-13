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
import steamatic.model.dto.AdministradorDTO;

/**
 *
 * @author pablonolasco
 */
public class AdministradorDAO implements IAdministrador {

    private ResultSet resultSet;
    private PreparedStatement statement;
    private Connection connection;
    private final String SQL_READ = "select id_usuario, usuario, pwd from usuario where usuario=? and pwd=?";

    public AdministradorDAO() {
    }

    public AdministradorDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public AdministradorDTO login_admin(AdministradorDTO administradorDTO) throws SQLException {
        AdministradorDTO administradorDTO1 = new AdministradorDTO();;
        try {
            Connection connection;
            connection = (this.connection != null) ? this.connection : DBConexion.getConnection();
            statement = connection.prepareStatement(SQL_READ);
            statement.setString(1, administradorDTO.getmUsuario());
            statement.setString(2, administradorDTO.getmPassword());
            resultSet = (ResultSet) statement.executeQuery();
            if (resultSet.next()) {
                administradorDTO1.setmId_Usuario(resultSet.getInt(1));
                administradorDTO1.setmUsuario(resultSet.getString(2));
                administradorDTO1.setmPassword(resultSet.getString(3));
            }

        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("message:" + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConexion.close_resulset(resultSet);
            DBConexion.close_stament(statement);
            if (connection != null) {
                DBConexion.desconection(connection);
            }
        }
        return administradorDTO1;
    }

}
