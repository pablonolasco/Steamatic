/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.dao;

import java.sql.SQLException;
import java.util.List;
import steamatic.model.dto.ProveedorDTO;

/**
 *
 * @author pablonolasco
 */
public interface IProveedor {
    public abstract int insertar_proveedor(ProveedorDTO dTO)throws SQLException;
    public abstract int eliminar_proveedor(ProveedorDTO dTO)throws SQLException;
    public abstract int update_proveedor(ProveedorDTO dTO)throws SQLException;
    public abstract List<ProveedorDTO> get_proveedor(ProveedorDTO dTO)throws SQLException;
    public abstract List<ProveedorDTO> get_proveedores()throws SQLException;
    
}
