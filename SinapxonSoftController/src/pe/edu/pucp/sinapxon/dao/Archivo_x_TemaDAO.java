/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Archivo_x_Tema;

/**
 *
 * @author ld_ra
 */
public interface Archivo_x_TemaDAO {
    public ArrayList<Archivo_x_Tema> listarArchivosXTemaXClassroom(int idTema, String idClassroom);
}
