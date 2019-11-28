/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinpaxontest;

import java.util.ArrayList;
import java.util.Random;
import pe.edu.pucp.sinapxon.config.DBController;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Archivo_x_Tema;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Entregable;
import pe.edu.pucp.sinapxon.model.Especialidad;
import pe.edu.pucp.sinapxon.model.Evaluacion;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.Profesor;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;
import pe.edu.pucp.sinapxon.model.Tema;
import pe.edu.pucp.sinapxon.model.Tema_x_Classroom;

/**
 *
 * @author ld_ra
 */
public class SinpaxonTest {

    public static void main(String[] args) {
        System.out.println("Soy un mapa");
        
//        ArrayList<Classroom> clasrrums = DBController.listarClassroomXAlumnoXPeriodo("20190", 2);
//        for (Classroom clasrrum : clasrrums) {
//            System.out.println(clasrrum.getCurso().getNombre());
//        }
        
//        ArrayList<SolicitudClassroom> solicitudes = DBController.listarSolicitudesClassroom(2);
//        for (SolicitudClassroom solicitude : solicitudes) {
//            System.out.println(solicitude.getProfesor().getNombre());
//        }
        
//        ArrayList<Idioma> idiomas = DBController.listarIdiomasXNombre_codigo("4");
//        for (Idioma idioma : idiomas) {
//            System.out.println(idioma.getNombre());
//        }      
//        ArrayList<Evaluacion> evs = DBController.listarEvaluacionesXClassroom("H-0222");
//        for(Evaluacion e : evs)
//            System.out.println(e.getNombre());
        
//        Curso curso = new Curso();
//        curso.setCodigo("IND231");
//        ArrayList<Classroom> classrooms = DBController.listarClassroomxCurso(curso);
//        for (Classroom classroom : classrooms) {
//            System.out.println(classroom.getProfesor().getNombre());
//        }
//        int salida = -1;
//        salida = DBController.insertarAlumno_classroom("203383", "H-6506");
        //System.out.println(salida);
        
//        ArrayList<Tema_x_Classroom> temasXclasroom = null;
//        temasXclasroom = DBController.listarTemaxClassroom("H-0222");
//        if(temasXclasroom != null)
//        {
//            for (Tema_x_Classroom tema_x_Classroom : temasXclasroom) {
//                System.out.println(tema_x_Classroom.getNombre());
//            }
//        }
        
//        ArrayList<Evaluacion> evaluaciones = null;
//        evaluaciones = DBController.listarEvaluacionesXClassroom("H-0222");
//        if(evaluaciones != null)
//        {
//            for (Evaluacion evaluacione : evaluaciones) {
//                System.out.println(evaluacione.getNombre());
//            }
//        }
        ArrayList<Entregable> aux = new ArrayList<Entregable>();
        aux=DBController.listarEntregables(14, "H-0222");
        for (Entregable e : aux) {
            System.out.println(e.getArchivo().getNombre());
            System.out.println(e.getAlumno().getAlumno().getCodigo());
        }
    }
}
