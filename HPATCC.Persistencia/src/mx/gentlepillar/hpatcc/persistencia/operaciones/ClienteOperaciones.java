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
    /**
     * Verifica que el numero del usuario sea existente y verifica si su contraseña es correcta
     * @param numero
     * @param contrasenia
     * @return respuesta
     */
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
    /**
     * Verifica que el numero no este ya registrado
     * @param numero
     * @return estado;
     */
    public boolean exists(String numero){
        return clientePers.getByNumber(numero) == null;
    }
}
