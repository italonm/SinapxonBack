/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.config;

import pe.edu.pucp.sinapxon.dao.AlumnoDAO;
import pe.edu.pucp.sinapxon.dao.Archivo_x_EntregableDAO;
import pe.edu.pucp.sinapxon.dao.Archivo_x_TemaDAO;
import pe.edu.pucp.sinapxon.dao.ClassroomDAO;
import pe.edu.pucp.sinapxon.dao.ClassroomxAlumnoDAO;
import pe.edu.pucp.sinapxon.dao.CursoDAO;
import pe.edu.pucp.sinapxon.dao.EntregableDAO;
import pe.edu.pucp.sinapxon.dao.EspecialidadDAO;
import pe.edu.pucp.sinapxon.dao.EvaluacionDAO;
import pe.edu.pucp.sinapxon.dao.IdiomaDAO;
import pe.edu.pucp.sinapxon.dao.PaisDAO;
import pe.edu.pucp.sinapxon.dao.PeriodoDAO;
import pe.edu.pucp.sinapxon.dao.PersonaDAO;
import pe.edu.pucp.sinapxon.dao.ProfesorDAO;
import pe.edu.pucp.sinapxon.dao.SolicitudClassroomDAO;
import pe.edu.pucp.sinapxon.dao.TemaDAO;
import pe.edu.pucp.sinapxon.dao.TemaxClassroomDAO;

/**
 *
 * @author Italo
 */
public abstract class DAOFactory {
    
    public abstract PersonaDAO getPersonaDAO();
    public abstract ClassroomDAO getClassroomDAO();
    public abstract CursoDAO getCursoDAO();
    public abstract AlumnoDAO getAlumnoDAO();
    public abstract EspecialidadDAO getEspecialidadDAO();
    public abstract ProfesorDAO getProfesorDAO();
    public abstract PeriodoDAO getPeriodoDAO();
    public abstract IdiomaDAO getIdiomaDAO();
    public abstract SolicitudClassroomDAO getSolicitudClassroomDAO();
    public abstract TemaDAO getTemaDAO();
    public abstract PaisDAO getPaisDAO();
    public abstract TemaxClassroomDAO getTemaxClassroomDAO();
    public abstract EvaluacionDAO getEvaluacionDAO();
    public abstract ClassroomxAlumnoDAO getClassroomXAlumnoDAO();
    public abstract Archivo_x_TemaDAO getArchivoXTemaDAO();
    public abstract Archivo_x_EntregableDAO getArchivoXEntregableDAO();
    public abstract EntregableDAO getEntregableDAO();
    
    public static DAOFactory getDAOFactory(){
        return new MySQLDAOFactory();
    }
}
