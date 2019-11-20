/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Classroom;

/**
 *
 * @author Rick
 */
public interface ClassroomDAO {
    public void insertarClassroom(Classroom classroom);
    public ArrayList<Classroom> listarClassroomxProfesor(String codigo,String nombre);
    public ArrayList<Classroom> listarClassroomxAlumno(String codigo);
}
