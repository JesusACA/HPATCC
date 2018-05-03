/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gentlepillar.hpatcc.nucleo.implementaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mx.gentlepillar.hpatcc.nucleo.interfaces.ILlamada;

/**
 *
 * @author jesus
 */
public class LlamadaImplementacion implements ILlamada{

    @Override
    public boolean verificar(String numero) {
        Pattern pat = Pattern.compile("[^62222] + [/d{10}]$");
        Matcher mat = pat.matcher(numero);
        return mat.find();
    }
    
}
