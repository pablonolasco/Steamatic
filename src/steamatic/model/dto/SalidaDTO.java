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
public class SalidaDTO implements Serializable {

    private int mId_Salida;
    private int mId_Operaciones;
    private int mId_Articulo;
    private String mFecha_Salida;
    private String mFecha_Servicio;
    private String mEmpleado_Operaciones;
    private String mServicio;
    private String mArticulos_Entregados;
    private int mTotal_Entregados;

    public SalidaDTO() {
    }

    public SalidaDTO(int mId_Salida,int mId_Operaciones, int mId_Articulo,String mEmpleado_Operaciones, String mServicio, String mArticulos_Entregados, int mTotal_Entregados) {
        this.mId_Salida = mId_Salida;
        this.mId_Operaciones = mId_Operaciones;
        this.mId_Articulo = mId_Articulo;
        this.mFecha_Salida = mFecha_Salida;
        this.mFecha_Servicio = mFecha_Servicio;
        this.mEmpleado_Operaciones = mEmpleado_Operaciones;
        this.mServicio = mServicio;
        this.mArticulos_Entregados = mArticulos_Entregados;
        this.mTotal_Entregados = mTotal_Entregados;
    }

    public int getmId_Salida() {
        return mId_Salida;
    }

    public void setmId_Salida(int mId_Salida) {
        this.mId_Salida = mId_Salida;
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

    public String getmFecha_Salida() {
        return mFecha_Salida;
    }

    public void setmFecha_Salida(String mFecha_Salida) {
        this.mFecha_Salida = mFecha_Salida;
    }

    public String getmFecha_Servicio() {
        return mFecha_Servicio;
    }

    public void setmFecha_Servicio(String mFecha_Servicio) {
        this.mFecha_Servicio = mFecha_Servicio;
    }

    public String getmEmpleado_Operaciones() {
        return mEmpleado_Operaciones;
    }

    public void setmEmpleado_Operaciones(String mEmpleado_Operaciones) {
        this.mEmpleado_Operaciones = mEmpleado_Operaciones;
    }

    public String getmServicio() {
        return mServicio;
    }

    public void setmServicio(String mServicio) {
        this.mServicio = mServicio;
    }

    public String getmArticulos_Entregados() {
        return mArticulos_Entregados;
    }

    public void setmArticulos_Entregados(String mArticulos_Entregados) {
        this.mArticulos_Entregados = mArticulos_Entregados;
    }

    public int getmTotal_Entregados() {
        return mTotal_Entregados;
    }

    public void setmTotal_Entregados(int mTotal_Entregados) {
        this.mTotal_Entregados = mTotal_Entregados;
    }

    @Override
    public String toString() {
        return "SalidaDTO{" + "mId_Operaciones=" + mId_Operaciones + ", mId_Articulo=" + mId_Articulo + ", mFecha_Salida=" + mFecha_Salida + ", mFecha_Servicio=" + mFecha_Servicio + ", mEmpleado_Operaciones=" + mEmpleado_Operaciones + ", mServicio=" + mServicio + ", mArticulos_Entregados=" + mArticulos_Entregados + ", mTotal_Entregados=" + mTotal_Entregados + '}';
    }
    
    
    
}
