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
public class Administrador {
    private int id;
    private String noControl;
    private char[] contrasenia;

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
     * @return the noControl
     */
    public String getNoControl() {
        return noControl;
    }

    /**
     * @param noControl the noControl to set
     */
    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }

    /**
     * @return the contrasenia
     */
    public char[] getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(char[] contrasenia) {
        this.contrasenia = contrasenia;
    }
}
