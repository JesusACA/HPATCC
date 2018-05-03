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
public class Paquete {
    private int id;
    private String nombre;
    private double precio;
    private int llamadasLocales;
    private int llamadasCelular;

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

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the llamadasLocales
     */
    public int getLlamadasLocales() {
        return llamadasLocales;
    }

    /**
     * @param llamadasLocales the llamadasLocales to set
     */
    public void setLlamadasLocales(int llamadasLocales) {
        this.llamadasLocales = llamadasLocales;
    }

    /**
     * @return the llamadasCelular
     */
    public int getLlamadasCelular() {
        return llamadasCelular;
    }

    /**
     * @param llamadasCelular the llamadasCelular to set
     */
    public void setLlamadasCelular(int llamadasCelular) {
        this.llamadasCelular = llamadasCelular;
    }

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
}
