/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.interfaces;

import java.sql.SQLException;
import steamatic.model.dto.AdministradorDTO;

/**
 *
 * @author pablonolasco
 */
public interface IAdministrador {
    public abstract AdministradorDTO login_admin(AdministradorDTO administradorDTO) throws SQLException;
    
}
