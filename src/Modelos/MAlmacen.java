/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author victo
 */
public class MAlmacen {

    /*variables*/
    private float cant;
    private String des;
    private int cod;
    private float monto;
    private float minimo;

    public MAlmacen(int c, String d, float t,float m,float mi) {
        this.cod = c;
        this.des = d;
        this.cant = t;
        monto = m ;
        minimo = mi;
    }

    public MAlmacen() {
        this.cod = 0;
        this.des = null;
        this.cant = 0;
    }

    public void setalmacen(int cod, String des, int cant) {
        this.setCod(cod);
        this.setDes(des);
        this.setCant(cant);
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
     * @return the minimo
     */
    public float getMinimo() {
        return minimo;
    }

    /**
     * @param minimo the minimo to set
     */
    public void setMinimo(float minimo) {
        this.minimo = minimo;
    }

}
