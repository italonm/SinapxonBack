/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.config;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Pais;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.Persona;
import pe.edu.pucp.sinapxon.model.Profesor;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;
import pe.edu.pucp.sinapxon.model.Tema;

/**
 *
 * @author Italo
 */
public abstract class DBController {
    
    private static final DAOFactory daoFactory = DAOFactory.getDAOFactory();
    
    //Catálogo de métodos de acceso
    
    public static Persona validarLogin (String nickname,String password){
        return daoFactory.getPersonaDAO().validar(nickname, password);
    }
    
    public static ArrayList<Classroom> listarClassroomxProfesor(String codigo,String nombre){
        return daoFactory.getClassroomDAO().listarClassroomxProfesor(codigo,nombre);
    }
    
    public static ArrayList<Classroom> listarClassroomxAlumno(String codigo){
        return daoFactory.getClassroomDAO().listarClassroomxAlumno(codigo);
    }
    
    public static ArrayList<Curso> listarCursos(String nombre)
    {
        return daoFactory.getCursoDAO().listarCurso(nombre);
    }
    
    public static ArrayList<Periodo> listarPeriodos()
    {
        return daoFactory.getPeriodoDAO().listarPeriodo();
    }
    
    public static void insertarCurso(Curso curso){
        daoFactory.getCursoDAO().insertarCurso(curso);
    }
    
    public static int insertarAlumno(Alumno alumno){
        return daoFactory.getAlumnoDAO().insertarAlumno(alumno);
    }
    
    public static int actualizarAlumno(Alumno alumno){
        return daoFactory.getAlumnoDAO().actualizarAlumno(alumno);
    }
    
    public static int eliminarAlumno(String idAlumno){
        return daoFactory.getAlumnoDAO().eliminarAlumno(idAlumno);
    }
    
    public static int insertarProfesor(Profesor profesor){
        return daoFactory.getProfesorDAO().insertarProfesor(profesor);
    }
    
    public static int actualizarProfesor(Profesor profesor){
        return daoFactory.getProfesorDAO().actualizarProfesor(profesor);
    }
    
    public static int eliminarProfesor(String idProfesor){
        return daoFactory.getProfesorDAO().eliminarProfesor(idProfesor);
    }
   
    public static ArrayList<Idioma> listarIdiomas(){
        return daoFactory.getIdiomaDAO().listarIdiomas();
    }
    
    public static void insertarSolicitudClassroom(SolicitudClassroom solicitudclassroom){
        daoFactory.getSolicitudClassroomDAO().insertarSolicitudClassroom(solicitudclassroom);
    }
    
    public static void insertarTema(Tema tema){
        daoFactory.getTemaDAO().insertarTema(tema);
    }
    
    public static ArrayList<Profesor> listarProfesores(String nombre)
    {
        return daoFactory.getProfesorDAO().listarProfesores(nombre);
    }
    
    public static ArrayList<Alumno> listarAlumnos(String nombre)
    {
        return daoFactory.getAlumnoDAO().listarAlumnos(nombre);
    }
    
    public static ArrayList<Pais> listarPaises()
    {
        return daoFactory.getPaisDAO().listarPais();
    }
}
