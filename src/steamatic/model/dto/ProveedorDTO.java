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
public class ProveedorDTO implements Serializable {

    private int mId_Proveedores;
    private String mNombre_Proveedor;
    private int mCodigo;
    private String mRFC;
    private String mDireccion;
    private int mTelefono;
    private String mE_Mail;
    private int mEstatus;

    public ProveedorDTO() {
    }

    
    public ProveedorDTO(int mId_Proveedores, String mNombre_Proveedor, int mCodigo, String mRFC, String mDireccion, int mTelefono, String mE_Mail,int mEstatus) {
        this.mId_Proveedores = mId_Proveedores;
        this.mNombre_Proveedor = mNombre_Proveedor;
        this.mCodigo = mCodigo;
        this.mRFC = mRFC;
        this.mDireccion = mDireccion;
        this.mTelefono = mTelefono;
        this.mE_Mail = mE_Mail;
        this.mEstatus = mEstatus;
    }

    
    public int getmId_Proveedores() {
        return mId_Proveedores;
    }

    public void setmId_Proveedores(int mId_Proveedores) {
        this.mId_Proveedores = mId_Proveedores;
    }

    public String getmNombre_Proveedor() {
        return mNombre_Proveedor;
    }

    public void setmNombre_Proveedor(String mNombre_Proveedor) {
        this.mNombre_Proveedor = mNombre_Proveedor;
    }

    public int getmCodigo() {
        return mCodigo;
    }

    public void setmCodigo(int mCodigo) {
        this.mCodigo = mCodigo;
    }

    public String getmRFC() {
        return mRFC;
    }

    public void setmRFC(String mRFC) {
        this.mRFC = mRFC;
    }

    public String getmDireccion() {
        return mDireccion;
    }

    public void setmDireccion(String mDireccion) {
        this.mDireccion = mDireccion;
    }

    public int getmTelefono() {
        return mTelefono;
    }

    public void setmTelefono(int mTelefono) {
        this.mTelefono = mTelefono;
    }

    public String getmE_Mail() {
        return mE_Mail;
    }

    public void setmE_Mail(String mE_Mail) {
        this.mE_Mail = mE_Mail;
    }

    public int getmEstatus() {
        return mEstatus;
    }

    public void setmEstatus(int mEstatus) {
        this.mEstatus = mEstatus;
    }

    
    @Override
    public String toString() {
        return "ProveedorDTO{" + "mId_Proveedores=" + mId_Proveedores + ", mNombre_Proveedor=" + mNombre_Proveedor + ", mCodigo=" + mCodigo + ", mRFC=" + mRFC + ", mDireccion=" + mDireccion + ", mTelefono=" + mTelefono + ", mE_Mail=" + mE_Mail + '}';
    }
    
    

}
