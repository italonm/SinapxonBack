/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Persona;

/**
 *
 * @author Rick
 */
public interface AlumnoDAO {
    public int insertarAlumno(Alumno alumno);
    public int actualizarAlumno(Alumno alumno);
    public int eliminarAlumno(String idAlumno);
    public ArrayList<Alumno> listarAlumnos(String nombre);
    public ArrayList<Alumno> listarAlumnosXClassroom(String codigoClassroom);
    public Alumno validarNickname(String nickname);
    public int insertarAlumno_a_un_classroom(String codAlumno, String codClassroom);
}
