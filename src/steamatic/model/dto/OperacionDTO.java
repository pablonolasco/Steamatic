/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamatic.model.dto;

import java.io.Serializable;

/**
 *
 */
public class OperacionDTO implements Serializable {

    private int mId_Operaciones;
    private String mEmpleado_Operaciones;
    private String mApellidos;
    private String mPuesto;
    private String mServicios_Programados;
    private int mServicios_Realizado;
    private int mTiempo_Promedio;
    private Double mCosto_Servicio;

    public OperacionDTO() {
    }

    public OperacionDTO(int mId_Operaciones, String Empleado_Operaciones, 
            String Apellidos, String Puesto, String Servicios_Programados, 
            int Servicios_Realizado, int Tiempo_Promedio, Double Costo_Servicio) {
        this.mId_Operaciones = mId_Operaciones;
        this.mEmpleado_Operaciones = Empleado_Operaciones;
        this.mApellidos = Apellidos;
        this.mPuesto = Puesto;
        this.mServicios_Programados = Servicios_Programados;
        this.mServicios_Realizado = Servicios_Realizado;
        this.mTiempo_Promedio = Tiempo_Promedio;
        this.mCosto_Servicio = Costo_Servicio;
    }

    public int getmId_Operaciones() {
        return mId_Operaciones;
    }

    public void setmId_Operaciones(int mId_Operaciones) {
        this.mId_Operaciones = mId_Operaciones;
    }

    public String getmEmpleado_Operaciones() {
        return mEmpleado_Operaciones;
    }

    public void setmEmpleado_Operaciones(String mEmpleado_Operaciones) {
        this.mEmpleado_Operaciones = mEmpleado_Operaciones;
    }

    public String getmApellidos() {
        return mApellidos;
    }

    public void setmApellidos(String mApellidos) {
        this.mApellidos = mApellidos;
    }

    public String getmPuesto() {
        return mPuesto;
    }

    public void setmPuesto(String mPuesto) {
        this.mPuesto = mPuesto;
    }

    public String getmServicios_Programados() {
        return mServicios_Programados;
    }

    public void setmServicios_Programados(String mServicios_Programados) {
        this.mServicios_Programados = mServicios_Programados;
    }

    public int getmServicios_Realizado() {
        return mServicios_Realizado;
    }

    public void setmServicios_Realizado(int mServicios_Realizado) {
        this.mServicios_Realizado = mServicios_Realizado;
    }

    public int getmTiempo_Promedio() {
        return mTiempo_Promedio;
    }

    public void setmTiempo_Promedio(int mTiempo_Promedio) {
        this.mTiempo_Promedio = mTiempo_Promedio;
    }

    public Double getmCosto_Servicio() {
        return mCosto_Servicio;
    }

    public void setmCosto_Servicio(Double mCosto_Servicio) {
        this.mCosto_Servicio = mCosto_Servicio;
    }

    @Override
    public String toString() {
        return "OperacionDTO{" + "mId_Operaciones=" + mId_Operaciones + ", Empleado_Operaciones=" + mEmpleado_Operaciones + ", Apellidos=" + mApellidos + ", Puesto=" + mPuesto + ", Servicios_Programados=" + mServicios_Programados + ", Servicios_Realizado=" + mServicios_Realizado + ", Tiempo_Promedio=" + mTiempo_Promedio + ", Costo_Servicio=" + mCosto_Servicio + '}';
    }
    
    

}
