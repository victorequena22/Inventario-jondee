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
public class factura {

    private int id;
    private int factura;
    private String descriccion;
    private float monto;
    private Date fecha;

    public factura(int i, int f, String d, float m, Date feha) {
        id = i;
        factura = f;
        descriccion = d;
        monto = m;
        fecha = feha;

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
     * @return the descriccion
     */
    public String getDescriccion() {
        return descriccion;
    }

    /**
     * @param descriccion the descriccion to set
     */
    public void setDescriccion(String descriccion) {
        this.descriccion = descriccion;
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
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void setFecha(String fecha) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
        try {
            Date date = formatter.parse(fecha);
            this.setFecha(date);
        } catch (ParseException e) {
        }
    }
}
