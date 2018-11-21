/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.interfaces;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import steamatic.model.dto.OperacionDTO;

/**
 *
 * @author pablonolasco
 */
public interface IOperacion {
    public abstract int insertar_operacion(OperacionDTO dTO)throws SQLException;
    public abstract int eliminar_operacion(OperacionDTO dTO)throws SQLException;
    public abstract int update_operacion(OperacionDTO dTO)throws SQLException;
    public abstract DefaultTableModel get_operaciones()throws SQLException;
    public abstract DefaultTableModel get_operacion(OperacionDTO dTO)throws SQLException;
    
}
