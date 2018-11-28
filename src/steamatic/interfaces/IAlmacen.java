/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.interfaces;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import steamatic.model.dto.AlmacenDTO;

/**
 *
 */
public interface IAlmacen {
    public abstract int insertar_almacen(AlmacenDTO dTO)throws SQLException;
    public abstract int eliminar_almacen(AlmacenDTO dTO)throws SQLException;
    public abstract int update_almacen(AlmacenDTO dTO)throws SQLException;
    public DefaultTableModel get_almacen(AlmacenDTO dTO)throws SQLException;
    public DefaultTableModel get_almacenes()throws SQLException;
}
