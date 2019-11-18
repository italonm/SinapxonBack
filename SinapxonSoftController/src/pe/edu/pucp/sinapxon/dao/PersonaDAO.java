/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import pe.edu.pucp.sinapxon.model.Persona;

/**
 *
 * @author Italo
 */
public interface PersonaDAO {
    public Persona validar(String nickname,String password);
    public Persona validarCorreo(String correo);
    public void actualizarPasswordAlumno(String codigo, String password);
}
