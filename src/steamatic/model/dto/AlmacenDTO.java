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
public class AlmacenDTO implements Serializable {

    private int mId_Empleado;
    private int mId_Articulo;
    private String mArticulo;
    private Date mFecha_Registro;
    private Double mUnidad_Medida;
    private int mStock_minimo;
    private int mStock_Actual;
    private Double mCosto_Promedio;
    private String mExistencia;

    public AlmacenDTO() {
    }

    public AlmacenDTO(int mId_Empleado, int mId_Articulo, String mArticulo, 
            Double mUnidad_Medida, int mStock_minimo, int mStock_Actual, 
            Double mCosto_Promedio, String mExistencia) {
        this.mId_Empleado = mId_Empleado;
        this.mId_Articulo = mId_Articulo;
        this.mArticulo = mArticulo;
        this.mFecha_Registro=new Date();
        this.mUnidad_Medida = mUnidad_Medida;
        this.mStock_minimo = mStock_minimo;
        this.mStock_Actual = mStock_Actual;
        this.mCosto_Promedio = mCosto_Promedio;
        this.mExistencia = mExistencia;
    }

    public int getmId_Empleado() {
        return mId_Empleado;
    }

    public void setmId_Empleado(int mId_Empleado) {
        this.mId_Empleado = mId_Empleado;
    }

    public int getmId_Articulo() {
        return mId_Articulo;
    }

    public void setmId_Articulo(int mId_Articulo) {
        this.mId_Articulo = mId_Articulo;
    }

    public String getmArticulo() {
        return mArticulo;
    }

    public void setmArticulo(String mArticulo) {
        this.mArticulo = mArticulo;
    }

    public Date getmFecha_Registro() {
        return mFecha_Registro;
    }

    public void setmFecha_Registro(Date mFecha_Registro) {
        this.mFecha_Registro = mFecha_Registro;
    }

    
    public Double getmUnidad_Medida() {
        return mUnidad_Medida;
    }

    public void setmUnidad_Medida(Double mUnidad_Medida) {
        this.mUnidad_Medida = mUnidad_Medida;
    }

    public int getmStock_minimo() {
        return mStock_minimo;
    }

    public void setmStock_minimo(int mStock_minimo) {
        this.mStock_minimo = mStock_minimo;
    }

    public int getmStock_Actual() {
        return mStock_Actual;
    }

    public void setmStock_Actual(int mStock_Actual) {
        this.mStock_Actual = mStock_Actual;
    }

    public Double getmCosto_Promedio() {
        return mCosto_Promedio;
    }

    public void setmCosto_Promedio(Double mCosto_Promedio) {
        this.mCosto_Promedio = mCosto_Promedio;
    }

    public String getmExistencia() {
        return mExistencia;
    }

    public void setmExistencia(String mExistencia) {
        this.mExistencia = mExistencia;
    }

    @Override
    public String toString() {
        return "AlmacenDTO{" + "mId_Empleado=" + mId_Empleado + ", mId_Articulo=" + mId_Articulo + ", mArticulo=" + mArticulo + ", mFecha_Registro=" + mFecha_Registro + ", mUnidad_Medida=" + mUnidad_Medida + ", mStock_minimo=" + mStock_minimo + ", mStock_Actual=" + mStock_Actual + ", mCosto_Promedio=" + mCosto_Promedio + ", mExistencia=" + mExistencia + '}';
    }
    
    
    
    

}
