/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.sinapxon.config.DBController;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Profesor;

/**
 *
 * @author Italo
 */
@WebService(serviceName = "AdministradorServices")
public class AdministradorServices {

    @WebMethod(operationName = "insertarCurso")
    public void insertarCurso(Curso curso){
        DBController.insertarCurso(curso);
    }
    
    @WebMethod(operationName = "insertarProfesor")
    public void insertarProfesor(Profesor profesor){
        DBController.insertarProfesor(profesor);
    }
    
    @WebMethod(operationName = "insertarAlumno")
    public void insertarAlumno(Alumno alumno){
        DBController.insertarAlumno(alumno);
    }

    @WebMethod(operationName = "listarCursos")
    public ArrayList<Curso> listarCursos(String nombre) {
        ArrayList<Curso> cursos = DBController.listarCursos(nombre);
        return cursos;
    }
    
    @WebMethod(operationName = "listarProfesores")
    public ArrayList<Profesor> listarProfes(String nombre) {
        ArrayList<Profesor> profesores = DBController.listarProfesores(nombre);
        return profesores;
    }
}
