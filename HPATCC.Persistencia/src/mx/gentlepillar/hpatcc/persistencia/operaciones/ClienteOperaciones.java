/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gentlepillar.hpatcc.persistencia.operaciones;

import mx.gentlepillar.chuyptionpane.vistas.ChuyptionPane;
import mx.gentlepillar.hpatcc.nucleo.entidades.Cliente;
import mx.gentlepillar.hpatcc.persistencia.entidades.ClientePersistencia;

/**
 *
 * @author jesus
 */
public class ClienteOperaciones {
    ClientePersistencia  clientePers = new ClientePersistencia(); 
    ChuyptionPane pane = new ChuyptionPane();
    public boolean verify(String numero, String contrasenia){
        boolean respuesta = false;
        Cliente cliente = clientePers.getByNumber(numero);
        if (cliente != null) {
            if (contrasenia.equals(cliente.getContrasenia())) {
                respuesta = true;
            }else{
                pane.showMessage(null, "La contraseña es incorrecta", "Error");
            }
        }else{
            pane.showMessage(null, "Usuario no encontrado", "Error");
        }
        return respuesta;
    }
    
    public boolean exists(String numero){
        return clientePers.getByNumber(numero) == null;
    }
}
