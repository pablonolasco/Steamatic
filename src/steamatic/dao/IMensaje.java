/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.dao;

/**
 *
 * @author pablonolasco
 */
public interface IMensaje {
    public abstract void error(String mensaje);
    public abstract void correcto(String mensaje);
    public abstract void warning(String mensaje);
    public abstract void info(String mensaje);
    
}
