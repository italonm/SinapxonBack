/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.config;

import pe.edu.pucp.sinapxon.dao.AlumnoDAO;
import pe.edu.pucp.sinapxon.dao.ClassroomDAO;
import pe.edu.pucp.sinapxon.dao.CursoDAO;
import pe.edu.pucp.sinapxon.dao.IdiomaDAO;
import pe.edu.pucp.sinapxon.dao.PeriodoDAO;
import pe.edu.pucp.sinapxon.dao.PersonaDAO;
import pe.edu.pucp.sinapxon.dao.ProfesorDAO;
import pe.edu.pucp.sinapxon.dao.SolicitudClassroomDAO;
import pe.edu.pucp.sinapxon.dao.TemaDAO;

/**
 *
 * @author Italo
 */
public abstract class DAOFactory {
    
    public abstract PersonaDAO getPersonaDAO();
    public abstract ClassroomDAO getClassroomDAO();
    public abstract CursoDAO getCursoDAO();
    public abstract AlumnoDAO getAlumnoDAO();
    public abstract ProfesorDAO getProfesorDAO();
    public abstract PeriodoDAO getPeriodoDAO();
    public abstract IdiomaDAO getIdiomaDAO();
    public abstract SolicitudClassroomDAO getSolicitudClassroomDAO();
    public abstract TemaDAO getTemaDAO();
    
    public static DAOFactory getDAOFactory(){
        return new MySQLDAOFactory();
    }
}
