/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.sinapxon.config.DBController;
import pe.edu.pucp.sinapxon.model.Archivo_x_Tema;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Evaluacion;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.Tema_x_Classroom;

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
    
    @WebMethod(operationName = "listarClassroomsXAlumno_X_Periodo")
    public ArrayList<Classroom> listarClassroomsXAlumno_X_Periodo(@WebParam(name = "codigoAlumno")String codAlum,@WebParam(name = "id_perido") int id_periodo){
        ArrayList<Classroom> clasrrums = DBController.listarClassroomXAlumnoXPeriodo(codAlum,id_periodo);
        return clasrrums;
    }
    
    @WebMethod(operationName = "listarClassrooms_Alumno_Periodo")
    public ArrayList<Classroom> listarClassrooms_Alumno_Periodo(@WebParam (name = "CodAl") String codAl, @WebParam(name = "idPer")int idPer)
    {
        ArrayList<Classroom> classrooms = DBController.listarClassroomXAlumnoXPeriodo(codAl, idPer);
        return classrooms;
    }
    
    
    @WebMethod(operationName = "listarPeriodos")
    public ArrayList<Periodo> listarPeriodos(){
        return DBController.listarPeriodos();
    }
    
    @WebMethod(operationName = "listarTemaxClassroom")
    public ArrayList<Tema_x_Classroom> listarTemaxClassroom(String id){
        return DBController.listarTemaxClassroom(id);
    }
    
    @WebMethod(operationName = "listarEvaluacionesXClassroom")
    public ArrayList<Evaluacion> listarEvaluacionesXClassroom(@WebParam(name="codigo")String codClassroom){
        return DBController.listarEvaluacionesXClassroom(codClassroom);
    }
    
    @WebMethod(operationName = "listarArchivosXTemaXClassroom")
    public ArrayList<Archivo_x_Tema> listarArchivos_x_Tema_x_Classroom(@WebParam(name = "idTema")int idTema, @WebParam(name = "idClassroom")String idClassroom)
    {
        return DBController.listarArchivosXTemasXClassroom(idTema, idClassroom);
    }
    
    @WebMethod(operationName = "obtenerArchivo")
    public byte[] obtenerArchivo(@WebParam(name = "nombreArchivo") int idArchivo) throws IOException {
        byte[] bytesArchivo;
        File arch = new File("D:\\Pruebas\\ARCHIVOS\\"+idArchivo);
        return Files.readAllBytes(arch.toPath());
    }
}
