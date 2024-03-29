/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Archivo_x_Tema;
import pe.edu.pucp.sinapxon.model.Tema_x_Classroom;

/**
 *
 * @author Italo
 */
public interface TemaxClassroomDAO {
    public void insertarTemaxClassroom(Tema_x_Classroom tema);
    public int insertarArchivos(Archivo_x_Tema archivo, int idTema, String idClassroom);
    public void guardarArchivo(byte[] archivo,int idArchivo);
    public ArrayList<Tema_x_Classroom> listarTemaxClassroom(String id);
    public void eliminarTemaxClassroom(int codTema,String codClassroom);
}
