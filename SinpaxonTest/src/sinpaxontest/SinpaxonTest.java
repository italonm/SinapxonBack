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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<SolicitudClassroom> scs = DBController.listarSolicitudesClassroom(2);
        for(SolicitudClassroom sc : scs)
            System.out.println(sc.getCurso().getNombre() + " - " + sc.getPeriodo().getNombre());
    }
}
