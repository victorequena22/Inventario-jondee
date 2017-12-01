/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author victo
 */
public class OpAux {

    private int cod;
    private String des;
    private float monto;
    private float cant;

    public OpAux() {
        cod = 0;
        monto = 0;
        cant = 0;
    }

    public OpAux(int c,String d, float m, float t) {
        cod = c;
        des = d;
        monto = m;
        cant = t;
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
     * @return the orden
     */
    public float getTotal() {
        return cant + monto;
    }
}
