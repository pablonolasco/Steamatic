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
 * @author Ricardo
 */
public class Empleado implements Serializable {

    private int mId_Empleado;
    private String mNombre;
    private String mApellido_Paterno;
    private String mApellido_Materno;
    private String mOrganismo;
    private String mSexo;
    private String mEstado_Civil;
    private Date mFecha_Nacimiento;
    private String mDireccion;
    private String mPuesto;

    public Empleado() {
    }

    public Empleado(int mId_Empleado, String mNombre, String mApellido_Paterno, String mApellido_Materno, String mOrganismo, String mSexo, String mEstado_Civil, Date mFecha_Nacimiento, String mDireccion, String mPuesto) {
        this.mId_Empleado = mId_Empleado;
        this.mNombre = mNombre;
        this.mApellido_Paterno = mApellido_Paterno;
        this.mApellido_Materno = mApellido_Materno;
        this.mOrganismo = mOrganismo;
        this.mSexo = mSexo;
        this.mEstado_Civil = mEstado_Civil;
        this.mFecha_Nacimiento = mFecha_Nacimiento;
        this.mDireccion = mDireccion;
        this.mPuesto = mPuesto;
    }

    public int getmId_Empleado() {
        return mId_Empleado;
    }

    public void setmId_Empleado(int mId_Empleado) {
        this.mId_Empleado = mId_Empleado;
    }

    public String getmNombre() {
        return mNombre;
    }

    public void setmNombre(String mNombre) {
        this.mNombre = mNombre;
    }

    public String getmApellido_Paterno() {
        return mApellido_Paterno;
    }

    public void setmApellido_Paterno(String mApellido_Paterno) {
        this.mApellido_Paterno = mApellido_Paterno;
    }

    public String getmApellido_Materno() {
        return mApellido_Materno;
    }

    public void setmApellido_Materno(String mApellido_Materno) {
        this.mApellido_Materno = mApellido_Materno;
    }

    public String getmOrganismo() {
        return mOrganismo;
    }

    public void setmOrganismo(String mOrganismo) {
        this.mOrganismo = mOrganismo;
    }

    public String getmSexo() {
        return mSexo;
    }

    public void setmSexo(String mSexo) {
        this.mSexo = mSexo;
    }

    public String getmEstado_Civil() {
        return mEstado_Civil;
    }

    public void setmEstado_Civil(String mEstado_Civil) {
        this.mEstado_Civil = mEstado_Civil;
    }

    public Date getmFecha_Nacimiento() {
        return mFecha_Nacimiento;
    }

    public void setmFecha_Nacimiento(Date mFecha_Nacimiento) {
        this.mFecha_Nacimiento = mFecha_Nacimiento;
    }

    public String getmDireccion() {
        return mDireccion;
    }

    public void setmDireccion(String mDireccion) {
        this.mDireccion = mDireccion;
    }

    public String getmPuesto() {
        return mPuesto;
    }

    public void setmPuesto(String mPuesto) {
        this.mPuesto = mPuesto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "mId_Empleado=" + mId_Empleado + ", mNombre=" + mNombre + ", mApellido_Paterno=" + mApellido_Paterno + ", mApellido_Materno=" + mApellido_Materno + ", mOrganismo=" + mOrganismo + ", mSexo=" + mSexo + ", mEstado_Civil=" + mEstado_Civil + ", mFecha_Nacimiento=" + mFecha_Nacimiento + ", mDireccion=" + mDireccion + ", mPuesto=" + mPuesto + '}';
    }
    
    

}
