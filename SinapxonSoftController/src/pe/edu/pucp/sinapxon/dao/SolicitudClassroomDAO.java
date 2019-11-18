/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;

/**
 *
 * @author Rick
 */
public interface SolicitudClassroomDAO {
    public void insertarSolicitudClassroom(SolicitudClassroom solicitudclassroom);
    public ArrayList<SolicitudClassroom> listarSolicitudesClassroom(int estadoSolicitud);
}
