/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.interfaces;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import steamatic.model.dto.VentasDTO;

/**
 *
 */
public interface IVenta {
    public abstract int insertar_venta(VentasDTO cdto)throws SQLException;
    public abstract int eliminar_venta(VentasDTO cdto)throws SQLException;
    public abstract int update_venta(VentasDTO cdto)throws SQLException;
    public abstract DefaultTableModel get_venta(VentasDTO cdto)throws SQLException;
    public abstract DefaultTableModel get_ventas()throws SQLException;
   
}
