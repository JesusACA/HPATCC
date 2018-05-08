/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gentlepillar.hpatcc.nucleo.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author jesus
 */
@Entity
public class Factura {
    private int id;
    private Date fecha;
    private int anio;
    private int mes;
    private Cliente cliente;
    private double total;
    private String noControl;
    private List<Llamada> llamadas;

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
     * @return the fecha
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
        this.setAnio(fecha.getYear() + 1900);
        this.setMes(fecha.getMonth() + 1);
    }
    
    /**
     * @return the cliente
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idCliente")
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
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
     * @return the llamadas
     */
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
        name = "rel_factura_llamada", 
        joinColumns = { @JoinColumn(name = "idFactura") }, 
        inverseJoinColumns = { @JoinColumn(name = "idLlamada") }
    )
    public List<Llamada> getLlamadas() {
        return llamadas;
    }

    /**
     * @param llamadas the llamadas to set
     */
    public void setLlamadas(List<Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }
    
}
