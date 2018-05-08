/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gentlepillar.hpatcc.persistencia.operaciones;

import mx.gentlepillar.hpatcc.persistencia.entidades.PaquetePersistencia;

/**
 *
 * @author osmar
 */
public class PaqueteOperaciones {
    PaquetePersistencia paquetePers = new PaquetePersistencia();
    public boolean exists(String nombre){
        return paquetePers.getByName(nombre) == null;
    }
}
