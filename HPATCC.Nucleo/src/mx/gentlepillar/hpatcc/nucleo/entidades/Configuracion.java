/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gentlepillar.hpatcc.nucleo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author jesus
 */
@Entity
public class Configuracion {
    private int id;
    private double precioLocales;
    private double precioCelular;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue
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
     * @return the precioLocales
     */
    public double getPrecioLocales() {
        return precioLocales;
    }

    /**
     * @param precioLocales the precioLocales to set
     */
    public void setPrecioLocales(double precioLocales) {
        this.precioLocales = precioLocales;
    }

    /**
     * @return the precioCelular
     */
    public double getPrecioCelular() {
        return precioCelular;
    }

    /**
     * @param precioCelular the precioCelular to set
     */
    public void setPrecioCelular(double precioCelular) {
        this.precioCelular = precioCelular;
    }
}
