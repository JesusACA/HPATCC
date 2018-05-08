/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gentlepillar.hpatcc.nucleo.implementaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mx.gentlepillar.hpatcc.nucleo.entidades.Configuracion;
import mx.gentlepillar.hpatcc.nucleo.entidades.Factura;
import mx.gentlepillar.hpatcc.nucleo.entidades.Llamada;
import mx.gentlepillar.hpatcc.nucleo.entidades.Paquete;
import mx.gentlepillar.hpatcc.nucleo.interfaces.IFactura;

/**
 *
 * @author jesus
 */
public class FacturaImplementacion implements IFactura{

    @Override
    /**
     * Calcula los valores totales en cada una de las secciones
     * @param factura
     * @param paquete
     * @param configuracion
     * @return totales
     */
    public double[] totales(Factura factura, Paquete paquete, Configuracion configuracion) {
        double[] totales = new double[3];
        int sobranteLocales;
        int sobranteCelular;
        int minutos = 0;
        List<Llamada> llamadasLocales = new ArrayList<Llamada>();
        List<Llamada> llamadasCelular = new ArrayList<Llamada>();
        for (Llamada llamada:factura.getLlamadas()) {
            Pattern pat = Pattern.compile("[^62222] + [/d{10}]$");
            Matcher mat = pat.matcher(llamada.getNumero());
            if (mat.find()) {
                llamadasLocales.add(llamada);
            }else{
                llamadasCelular.add(llamada);
            }
        }
        for (Llamada llamada:llamadasCelular) {
            minutos += llamada.getDuracion();
        }
        sobranteLocales = llamadasLocales.size() - paquete.getLlamadasLocales();
        sobranteCelular = minutos - paquete.getLlamadasCelular();
        if (sobranteLocales > 0) {
            totales[1] = sobranteLocales * configuracion.getPrecioLocales();
        }else{
            totales[1] = 0;
        }
        if (sobranteCelular > 0) {
            totales[2] = sobranteCelular * configuracion.getPrecioCelular();
        }else{
            totales[2] = 0;
        }
        totales[0] = paquete.getPrecio() + totales[1] + totales[2];
        return totales;
    }
    
}
