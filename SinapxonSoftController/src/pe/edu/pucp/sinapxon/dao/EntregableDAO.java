/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Entregable;

/**
 *
 * @author ld_ra
 */
public interface EntregableDAO {
    public void insertarEntregable(int idEvaluacion, String idAlumno, String idClassroom, String descripcion, int idArchivoXEntregable);
    public void eliminarEntregable(int idEvaluacion, String idAlumno, String idClassroom);
    public ArrayList<Entregable> listarEntregables(int idEvaluacion, String idAlumno, String idClassroom);
}
