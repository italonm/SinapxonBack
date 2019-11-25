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
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;

/**
 *
 * @author Italo
 */
@WebService(serviceName = "AlumnoServices")
public class AlumnoServices {

    @WebMethod(operationName = "listarClassroomxAlumno")
    public ArrayList<Classroom> listarClassroomxAlumno(@WebParam(name="codigo")String codigo){
        return DBController.listarClassroomxAlumno(codigo);
    }
    
//    @WebMethod(operationName = "listarCursos")
//    public ArrayList<Curso> listarCursos(@WebParam(name="nombre")String nombre) {
//        ArrayList<Curso> cursos = DBController.listarCursos(nombre);
//        return cursos;
//    }
    
    @WebMethod(operationName = "listarCursos")
    public ArrayList<Curso> listarCursos(String nombre) {
        ArrayList<Curso> cursos = DBController.listarCursos(nombre);
        return cursos;
    }
    
    @WebMethod(operationName = "listarClassroomsxCurso")
    public ArrayList<Classroom> listarClassroomXCurso(@WebParam(name = "curso") Curso curso){
        return DBController.listarClassroomxCurso(curso);
    }
    
    @WebMethod(operationName = "insertarAlumnoAlClassroom")
    public int insertarAlumnoAlClassroom(@WebParam(name = "codigALumno") String codAlumno, @WebParam(name = "codigoClassroom") String codClassroom){
        return DBController.insertarAlumno_classroom(codAlumno, codClassroom);
    }
    
    @WebMethod(operationName = "listarClassroomXAlumnoXPeriodo")
    public ArrayList<Classroom> listarClassroomXAlumnoXPeriodo(String codAlum, int id_periodo){
        return DBController.listarClassroomXAlumnoXPeriodo(codAlum, id_periodo);
    }
}
