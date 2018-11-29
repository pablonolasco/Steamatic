/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.interfaces;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import steamatic.model.dto.SalidaDTO;
/**
 *
 */
public interface ISalida {
  public abstract int insertar_salida(SalidaDTO dTO)throws SQLException;
  public abstract int eliminar_salida(SalidaDTO dTO)throws SQLException;
  public abstract int update_salida(SalidaDTO dTO)throws SQLException;
  public abstract DefaultTableModel get_salida()throws SQLException;
  public abstract DefaultTableModel get_salidas()throws SQLException;
  
}
