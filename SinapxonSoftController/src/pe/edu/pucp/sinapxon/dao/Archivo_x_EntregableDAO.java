/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Archivo_x_Entregable;
import pe.edu.pucp.sinapxon.model.Entregable;

/**
 *
 * @author ld_ra
 */
public interface Archivo_x_EntregableDAO {
    public int insertarArchivo_x_Entregable(Archivo_x_Entregable archivo);
    public ArrayList<Archivo_x_Entregable> listarArchivosXEntregable(int idEvaluacion, String idAlumno, String idClassroom);
}
