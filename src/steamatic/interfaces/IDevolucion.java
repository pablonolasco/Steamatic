/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.interfaces;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import steamatic.model.dto.DevolucionDTO;

/**
 *
 */
public interface IDevolucion {
  public abstract int insertar_devolucion(DevolucionDTO dTO)throws SQLException;
  public abstract int eliminar_devolucion(DevolucionDTO dTO)throws SQLException;
  public abstract int update_devolucion(DevolucionDTO dTO)throws SQLException;
  public abstract DefaultTableModel get_devolucion(DevolucionDTO dTO)throws SQLException;
  public abstract DefaultTableModel get_devolucions()throws SQLException;
    
}
