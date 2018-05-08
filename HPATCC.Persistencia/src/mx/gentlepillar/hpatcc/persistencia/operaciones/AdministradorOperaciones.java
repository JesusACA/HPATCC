/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gentlepillar.hpatcc.persistencia.operaciones;

import mx.gentlepillar.chuyptionpane.vistas.ChuyptionPane;
import mx.gentlepillar.hpatcc.nucleo.entidades.Administrador;
import mx.gentlepillar.hpatcc.persistencia.entidades.AdministradorPersistencia;

/**
 *
 * @author jesus
 */
public class AdministradorOperaciones {
    AdministradorPersistencia adminsPers = new AdministradorPersistencia();
    Administrador administrador = null;
    ChuyptionPane chuyPane = new ChuyptionPane();
    public boolean verify(String noControl, String contrasenia){
        boolean validacion = false;
        administrador = adminsPers.getByNumControl(noControl);
        if (administrador != null) {
            if (contrasenia.equals(administrador.getContrasenia())) {
                validacion = true;
            }else{
                chuyPane.showMessage(null, "La contraseña es incorrecta", "Error");
            }
        }else{
            chuyPane.showMessage(null, "Administrador no encontrado", "Error");
        }
        return validacion;
    }
    
    public boolean exists(String noControl){
        administrador = adminsPers.getByNumControl(noControl);
        return administrador == null;
    }
}
