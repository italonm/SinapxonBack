/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinpaxontest;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.config.DBController;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Especialidad;
import pe.edu.pucp.sinapxon.model.Evaluacion;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.Profesor;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;
import pe.edu.pucp.sinapxon.model.Tema;

/**
 *
 * @author ld_ra
 */
public class SinpaxonTest {

    public static void main(String[] args) {        
        ArrayList<Evaluacion> evs = DBController.listarEvaluacionesXClassroom("H-0222");
        for(Evaluacion e : evs)
            System.out.println(e.getNombre());
    }
}
