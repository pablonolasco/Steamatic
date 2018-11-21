/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.interfaces;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import steamatic.model.dto.ProveedorDTO;

/**
 *
 * @author pablonolasco
 */
public interface IProveedor {
    public abstract int insertar_proveedor(ProveedorDTO dTO)throws SQLException;
    public abstract int eliminar_proveedor(ProveedorDTO dTO)throws SQLException;
    public abstract int update_proveedor(ProveedorDTO dTO)throws SQLException;
    public abstract DefaultTableModel get_proveedor(ProveedorDTO dTO)throws SQLException;
    public abstract DefaultTableModel get_proveedores()throws SQLException;
    
}
