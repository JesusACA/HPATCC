/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gentlepillar.hpatcc.persistencia.operaciones;

import mx.gentlepillar.hpatcc.nucleo.entidades.Cliente;
import mx.gentlepillar.hpatcc.persistencia.entidades.ClientePersistencia;

/**
 *
 * @author jesus
 */
public class ClienteOperaciones {
    ClientePersistencia  clientePers = new ClientePersistencia(); 
    public boolean verify(String numero, char[] contrasenia){
        Cliente cliente = clientePers.getByNumber(numero);
        if (cliente != null) {
            
        }else{
            
        }
        return false;
    }
}