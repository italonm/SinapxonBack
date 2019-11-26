/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Classroom_x_Alumno;

/**
 *
 * @author Rick Fuyo
 */
public interface ClassroomxAlumnoDAO {
    public ArrayList<Classroom_x_Alumno> listarClassroomXAlumno();
    public ArrayList<Classroom> listarClassroomXAlumnoXPeriodo(String codAlumno,int id_periodo);
}


