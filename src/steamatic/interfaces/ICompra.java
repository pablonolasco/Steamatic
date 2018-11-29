/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.interfaces;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import steamatic.model.dto.CompraDTO;

/**
 *
 */
public interface ICompra {
    public abstract int insertar_compra(CompraDTO cdto)throws SQLException;
    public abstract int eliminar_compra(CompraDTO cdto)throws SQLException;
    public abstract int update_compra(CompraDTO cdto)throws SQLException;
    public abstract DefaultTableModel get_compra(CompraDTO cdto)throws SQLException;
    public abstract DefaultTableModel get_compras()throws SQLException;
    
}
