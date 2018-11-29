/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class DevolucionDTO implements Serializable {

    private int mId_Operaciones;
    private int mId_Articulo;
    private Date mFecha_Salida;
    private Date mFecha_Entrada;
    private String mArticulo_Devuelto;
    private int mTotal_Devuelto;

    public DevolucionDTO() {
    }

    public DevolucionDTO(int mId_Operaciones, int mId_Articulo, Date mFecha_Salida, Date mFecha_Entrada, String mArticulo_Devuelto, int mTotal_Devuelto) {
        this.mId_Operaciones = mId_Operaciones;
        this.mId_Articulo = mId_Articulo;
        this.mFecha_Salida = mFecha_Salida;
        this.mFecha_Entrada = mFecha_Entrada;
        this.mArticulo_Devuelto = mArticulo_Devuelto;
        this.mTotal_Devuelto = mTotal_Devuelto;
    }

    public int getmId_Operaciones() {
        return mId_Operaciones;
    }

    public void setmId_Operaciones(int mId_Operaciones) {
        this.mId_Operaciones = mId_Operaciones;
    }

    public int getmId_Articulo() {
        return mId_Articulo;
    }

    public void setmId_Articulo(int mId_Articulo) {
        this.mId_Articulo = mId_Articulo;
    }

    public Date getmFecha_Salida() {
        return mFecha_Salida;
    }

    public void setmFecha_Salida(Date mFecha_Salida) {
        this.mFecha_Salida = mFecha_Salida;
    }

    public Date getmFecha_Entrada() {
        return mFecha_Entrada;
    }

    public void setmFecha_Entrada(Date mFecha_Entrada) {
        this.mFecha_Entrada = mFecha_Entrada;
    }

    public String getmArticulo_Devuelto() {
        return mArticulo_Devuelto;
    }

    public void setmArticulo_Devuelto(String mArticulo_Devuelto) {
        this.mArticulo_Devuelto = mArticulo_Devuelto;
    }

    public int getmTotal_Devuelto() {
        return mTotal_Devuelto;
    }

    public void setmTotal_Devuelto(int mTotal_Devuelto) {
        this.mTotal_Devuelto = mTotal_Devuelto;
    }

    @Override
    public String toString() {
        return "DevolucionDTO{" + "mId_Operaciones=" + mId_Operaciones + ", mId_Articulo=" + mId_Articulo + ", mFecha_Salida=" + mFecha_Salida + ", mFecha_Entrada=" + mFecha_Entrada + ", mArticulo_Devuelto=" + mArticulo_Devuelto + ", mTotal_Devuelto=" + mTotal_Devuelto + '}';
    }
    
    

}
