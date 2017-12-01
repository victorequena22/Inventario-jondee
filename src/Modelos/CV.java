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
public class CV {

    private int registro;
    private int cod;
    private String nombre;
    private String des;
    private float monto;
    private float cant;
    private Date fecha;

    public CV() {
        cod = 0;
        monto = 0;
        cant = 0;
    }

    public CV(int r,int c,String n, String d, float m, float t, Date f) {
        registro = r;
        cod = c;
        nombre = n;
        des = d;
        monto = m;
        cant = t;
        fecha = f;
    }

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
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
            this.setFecha(date);
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
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
