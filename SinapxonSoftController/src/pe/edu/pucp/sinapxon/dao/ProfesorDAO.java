/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Profesor;

/**
 *
 * @author Rick
 */
public interface ProfesorDAO {
    public int insertarProfesor(Profesor profesor);
    public int actualizarProfesor(Profesor profesor);
    public int eliminarProfesor(String idProfesor);
    public ArrayList<Profesor> listarProfesores(String nombre);
    public ArrayList<Profesor> listarProfesoresXCurso(String codigoCurso);
}
