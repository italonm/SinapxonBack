/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Especialidad;

/**
 *
 * @author Monica
 */
public interface EspecialidadDAO {
    int insertarEspecialidad(Especialidad especialidad);
    int actualizarEspecialidad(Especialidad especialidad);
    int eliminarEspecialidad(int idEspecialidad);
    public ArrayList<Especialidad> listarEspecialidades(String nombre);
}
