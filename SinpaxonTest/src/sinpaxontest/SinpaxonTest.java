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
        // Listar los classrooms de un profesor
//        ArrayList<Classroom> classrooms = DBController.listarClassroomxProfesor("198800");
//        Classroom classroom = classrooms.get(0);
//        System.out.println(classroom.getCodigo()+" "+classroom.getCurso().getNombre());
        
        // Listar los cursos
//        ArrayList<Curso> cursos = DBController.listarCursos("");
//        for (Curso curso : cursos) {
//            System.err.println(curso.getCodigo()+" "+curso.getNombre());
//        }
        
//        Listar los periodos
//        ArrayList<Periodo> periodos = DBController.listarPeriodos();
//        for (Periodo periodo : periodos) {
//            System.err.println(periodo.getNombre());
//        }
        
//        Tema tema = new Tema();
//        tema.setDescripcion("hmm");
//        tema.setNombre("hmm");
//        tema.setLink("hmm");
//        DBController.insertarTema(tema);
        
        ArrayList<Profesor> proefesores = DBController.listarProfesores("");
        for (Profesor proefesore : proefesores) {
            System.out.println(proefesore.getNombre());
        }
    }
    
}
