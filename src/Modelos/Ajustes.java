/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author victo
 */
public class Ajustes {
    private int registro;
    private String des;
    private float monto;
    private float cant;
    private Date fecha;

    public Ajustes(int r,String d,float m, float c, Date f) {
        registro = r;
        des = d;
        monto = m;
        cant = c;
        fecha = f;
    }

    /**
     * @return the cant
     */
    public float getCant() {
        return cant;
    }

    /**
     * @param cant the cant to set
     */
    public void setCant(float cant) {
        this.cant = cant;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
        try {
            Date date = formatter.parse(fecha);
        } catch (ParseException e) {
        }
    }

    /**
     * @return the registro
     */
    public int getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(int registro) {
        this.registro = registro;
    }

    /**
     * @return the des
     */
    public String getDes() {
        return des;
    }

    /**
     * @param des the des to set
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * @return the monto
     */
    public float getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
