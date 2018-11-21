/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.interfaces;

import java.awt.Component;

/**
 *
 * @author pablonolasco
 */
public interface IMensaje {
    public abstract void error(String mensaje);
    public abstract void warning(Component component, String mensaje);
    public abstract void success(String mensaje);
    
}
