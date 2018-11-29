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
public class VentasDTO implements Serializable {

    private int mId_Venta;
    private int mId_Empleado;
    private String mNombre_Vendedor;
    private String mTipo_Servicio;
    private String mEmpleado_Operaciones;
    private String mObservaciones;
    private double mImpuesto;
    private double mCosto_Total;

    public VentasDTO() {
    }

    public VentasDTO(int Id_Venta, int Id_Empleado, String Nombre_Vendedor, String Tipo_Servicio, String Empleado_Operaciones, String Observaciones, double Impuesto, double Costo_Total) {
        this.mId_Venta = Id_Venta;
        this.mId_Empleado = Id_Empleado;
        this.mNombre_Vendedor = Nombre_Vendedor;
        this.mTipo_Servicio = Tipo_Servicio;
        this.mEmpleado_Operaciones = Empleado_Operaciones;
        this.mObservaciones = Observaciones;
        this.mImpuesto = Impuesto;
        this.mCosto_Total = Costo_Total;
    }

    public int getmId_Venta() {
        return mId_Venta;
    }

    public void setmId_Venta(int mId_Venta) {
        this.mId_Venta = mId_Venta;
    }

    public int getmId_Empleado() {
        return mId_Empleado;
    }

    public void setmId_Empleado(int mId_Empleado) {
        this.mId_Empleado = mId_Empleado;
    }

    public String getmNombre_Vendedor() {
        return mNombre_Vendedor;
    }

    public void setmNombre_Vendedor(String mNombre_Vendedor) {
        this.mNombre_Vendedor = mNombre_Vendedor;
    }

    public String getmTipo_Servicio() {
        return mTipo_Servicio;
    }

    public void setmTipo_Servicio(String mTipo_Servicio) {
        this.mTipo_Servicio = mTipo_Servicio;
    }

    public String getmEmpleado_Operaciones() {
        return mEmpleado_Operaciones;
    }

    public void setmEmpleado_Operaciones(String mEmpleado_Operaciones) {
        this.mEmpleado_Operaciones = mEmpleado_Operaciones;
    }

    public String getmObservaciones() {
        return mObservaciones;
    }

    public void setmObservaciones(String mObservaciones) {
        this.mObservaciones = mObservaciones;
    }

    public double getmImpuesto() {
        return mImpuesto;
    }

    public void setmImpuesto(double mImpuesto) {
        this.mImpuesto = mImpuesto;
    }

    public double getmCosto_Total() {
        return mCosto_Total;
    }

    public void setmCosto_Total(double mCosto_Total) {
        this.mCosto_Total = mCosto_Total;
    }

    @Override
    public String toString() {
        return "VentasDTO{" + "Id_Venta=" + mId_Venta + ", Id_Empleado=" + mId_Empleado + ", Nombre_Vendedor=" + mNombre_Vendedor + ", Tipo_Servicio=" + mTipo_Servicio + ", Empleado_Operaciones=" + mEmpleado_Operaciones + ", Observaciones=" + mObservaciones + ", Impuesto=" + mImpuesto + ", Costo_Total=" + mCosto_Total + '}';
    }
        
}
