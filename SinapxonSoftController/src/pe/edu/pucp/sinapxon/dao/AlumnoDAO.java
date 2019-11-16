/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Alumno;

/**
 *
 * @author Italo
 */
public interface AlumnoDAO {
    public int insertarAlumno(Alumno alumno);
    public int actualizarAlumno(Alumno alumno);
    public int eliminarAlumno(String idAlumno);
    public ArrayList<Alumno> listarAlumnos(String nombre);
}
