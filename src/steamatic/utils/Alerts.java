/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.utils;

import steamatic.interfaces.IMensaje;
import alertas.AlertError;
import alertas.AlertSuccess;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import login.frmDashboard;

/**
 *
 * @author pablonolasco
 */
public class Alerts implements IMensaje {


    @Override
    public void warning(Component component, String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void success(String mensaje) {
       JFrame frame= new JFrame();
        AlertSuccess alertSuccess = new AlertSuccess(frame, true);
        alertSuccess.lbl_mensaje.setText(mensaje);
        alertSuccess.setVisible(true);
    }

    @Override
    public void error(String mensaje) {
        JFrame frame= new JFrame();
        AlertError alertError = new AlertError(frame, true);
        alertError.lbl_mensaje.setText(mensaje);
        alertError.setVisible(true);
    }

}
