/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.model.dto;

import java.io.Serializable;

/**
 *
 * @author pablonolasco
 */
public class AdministradorDTO implements Serializable{
    private int mId_Usuario;
    private String mUsuario;
    private String mPassword;

    public AdministradorDTO() {
    }

    public AdministradorDTO(int mId_Usuario, String mUsuario, String mPassword) {
        this.mId_Usuario = mId_Usuario;
        this.mUsuario = mUsuario;
        this.mPassword = mPassword;
    }

    public int getmId_Usuario() {
        return mId_Usuario;
    }

    public void setmId_Usuario(int mId_Usuario) {
        this.mId_Usuario = mId_Usuario;
    }

    public String getmUsuario() {
        return mUsuario;
    }

    public void setmUsuario(String mUsuario) {
        this.mUsuario = mUsuario;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    @Override
    public String toString() {
        return "AdministradorDTO{" + "mId_Usuario=" + mId_Usuario + ", mUsuario=" + mUsuario + ", mPassword=" + mPassword + '}';
    }
    
    
    
    
    
}
