/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author victo
 */
public class Operacion {
    private int id;
    private int factura;
    private String ente;
    private String Descripcion;
    private float monto;
    private Date fecha;

    public Operacion() {
    }

    public Operacion(int i,int f,String e, String d,float m,  Date fe) {
        ente = e;
        factura = f;
        fecha = fe;
        Descripcion = d;
        monto=m;
        id = i;
    }

    /**
     * @return the factura
     */
    public int getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(int factura) {
        this.factura = factura;
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
     * @return the ente
     */
    public String getEnte() {
        return ente;
    }

    /**
     * @param ente the ente to set
     */
    public void setEnte(String ente) {
        this.ente = ente;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
