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
public class CompraDTO implements Serializable {

    private int mId_Empleado;
    private int mId_compras;
    private String mCodigo;
    private String mNombre_Producto;
    private String mRFC;
    private String mTipo_Producto;
    private String mDescripcion;
    private int mStock;
    private double mCantidad;
    private String mConcepto;
    private Date mdatetime;
    private double mCosto_Real;

    public CompraDTO() {
    }

    public CompraDTO(int Id_Empleado,int mId_compras, String Codigo, 
            String Nombre_Producto, String RFC, String Tipo_Producto, 
            String Descripcion, int Stock, double Cantidad, String Concepto, 
            double Costo_Real) {
        this.mId_Empleado = Id_Empleado;
        this.mId_compras=mId_compras;
        this.mCodigo = Codigo;
        this.mNombre_Producto = Nombre_Producto;
        this.mRFC = RFC;
        this.mTipo_Producto = Tipo_Producto;
        this.mDescripcion = Descripcion;
        this.mStock = Stock;
        this.mCantidad = Cantidad;
        this.mConcepto = Concepto;
        this.mdatetime = new Date();
        this.mCosto_Real = Costo_Real;
    }

    public int getmId_Empleado() {
        return mId_Empleado;
    }

    public void setmId_Empleado(int mId_Empleado) {
        this.mId_Empleado = mId_Empleado;
    }

    public int getmId_compras() {
        return mId_compras;
    }

    public void setmId_compras(int mId_compras) {
        this.mId_compras = mId_compras;
    }
    
    

    public String getmCodigo() {
        return mCodigo;
    }

    public void setmCodigo(String mCodigo) {
        this.mCodigo = mCodigo;
    }

    public String getmNombre_Producto() {
        return mNombre_Producto;
    }

    public void setmNombre_Producto(String mNombre_Producto) {
        this.mNombre_Producto = mNombre_Producto;
    }

    public String getmRFC() {
        return mRFC;
    }

    public void setmRFC(String mRFC) {
        this.mRFC = mRFC;
    }

    public String getmTipo_Producto() {
        return mTipo_Producto;
    }

    public void setmTipo_Producto(String mTipo_Producto) {
        this.mTipo_Producto = mTipo_Producto;
    }

    public String getmDescripcion() {
        return mDescripcion;
    }

    public void setmDescripcion(String mDescripcion) {
        this.mDescripcion = mDescripcion;
    }

    public int getmStock() {
        return mStock;
    }

    public void setmStock(int mStock) {
        this.mStock = mStock;
    }

    public double getmCantidad() {
        return mCantidad;
    }

    public void setmCantidad(double mCantidad) {
        this.mCantidad = mCantidad;
    }

    public String getmConcepto() {
        return mConcepto;
    }

    public void setmConcepto(String mConcepto) {
        this.mConcepto = mConcepto;
    }

    public Date getMdatetime() {
        return mdatetime;
    }

    public void setMdatetime(Date mdatetime) {
        this.mdatetime = mdatetime;
    }

    public double getmCosto_Real() {
        return mCosto_Real;
    }

    public void setmCosto_Real(double mCosto_Real) {
        this.mCosto_Real = mCosto_Real;
    }

    @Override
    public String toString() {
        return "CompraDTO{" + "Id_Empleado=" + mId_Empleado + ", Codigo=" + mCodigo + ", Nombre_Producto=" + mNombre_Producto + ", RFC=" + mRFC + ", Tipo_Producto=" + mTipo_Producto + ", Descripcion=" + mDescripcion + ", Stock=" + mStock + ", Cantidad=" + mCantidad + ", Concepto=" + mConcepto + ", datetime=" + mdatetime + ", Costo_Real=" + mCosto_Real + '}';
    }
    
}
