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
 * @author Italo
 */
public interface ProfesorDAO {
    public void insertarProfesor(Profesor profesor);
    public ArrayList<Profesor> listarProfesores(String nombre);
}
