/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gentlepillar.hpatcc.nucleo.interfaces;

import mx.gentlepillar.hpatcc.nucleo.entidades.Configuracion;
import mx.gentlepillar.hpatcc.nucleo.entidades.Factura;
import mx.gentlepillar.hpatcc.nucleo.entidades.Paquete;

/**
 *
 * @author jesus
 */
public interface IFactura {
    public double[] totales(Factura factura, Paquete paquete, Configuracion configuracion);
}
