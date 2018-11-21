/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.interfaces;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import steamatic.model.dto.EmpleadoDTO;

/**
 *
 * @author pablonolasco
 */
public interface IEmpleado {
    public abstract int insertar_empleado(EmpleadoDTO edao)throws SQLException;
    public abstract int modificar_empleado(EmpleadoDTO edao)throws SQLException;
    public abstract int eliminar_empleado(EmpleadoDTO edao)throws SQLException;
    public abstract DefaultTableModel consultar_empleado(EmpleadoDTO edao)throws SQLException;
    public abstract DefaultTableModel consultar_empleados()throws SQLException;
    
}
