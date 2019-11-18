/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinpaxontest;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.config.DBController;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Especialidad;
import pe.edu.pucp.sinapxon.model.Evaluacion;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.Profesor;
import pe.edu.pucp.sinapxon.model.Tema;

/**
 *
 * @author ld_ra
 */
public class SinpaxonTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Classroom> classrooms = DBController.listarClassroomxAlumno("201521");
        for (Classroom classroom : classrooms) {
            System.out.println(classroom.getProfesor().getNombre());
        }
//        ArrayList<Especialidad> es = DBController.listarEspecialidades();
//        for(Especialidad e : es)
//            System.out.println(e.getId_especialidad() + " - " + e.getNombre() + " - " + e.getDescripcion());
        
        Evaluacion e= new Evaluacion();
        e.setNombre("z");
        e.setDescripcion("d");
        e.setPeso_porcentual(3);
        DBController.insertarEvaluacion(e, "H-0222", 10);
    }
}
