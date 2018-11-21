/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.interfaces;

import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author pablonolasco
 */
public interface IMetodosFormulario {
    public abstract void limpiar();
    public abstract void llenarTabla(Vector vector);
    public abstract void ocultar_boton(boolean status );
    public abstract void ocultar_columnas();
    public abstract void pasar_columna_caja(JTextField field, String valor);
}
