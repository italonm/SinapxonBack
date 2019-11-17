/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.config;

import pe.edu.pucp.sinapxon.dao.AlumnoDAO;
import pe.edu.pucp.sinapxon.dao.ClassroomDAO;
import pe.edu.pucp.sinapxon.dao.CursoDAO;
import pe.edu.pucp.sinapxon.dao.EspecialidadDAO;
import pe.edu.pucp.sinapxon.dao.IdiomaDAO;
import pe.edu.pucp.sinapxon.dao.PaisDAO;
import pe.edu.pucp.sinapxon.dao.PeriodoDAO;
import pe.edu.pucp.sinapxon.dao.PersonaDAO;
import pe.edu.pucp.sinapxon.dao.ProfesorDAO;
import pe.edu.pucp.sinapxon.dao.SolicitudClassroomDAO;
import pe.edu.pucp.sinapxon.dao.TemaDAO;
import pe.edu.pucp.sinapxon.mysql.AlumnoMySQL;
import pe.edu.pucp.sinapxon.mysql.ClassroomMySQL;
import pe.edu.pucp.sinapxon.mysql.CursoMySQL;
import pe.edu.pucp.sinapxon.mysql.EspecialidadMySQL;
import pe.edu.pucp.sinapxon.mysql.IdiomaMySQL;
import pe.edu.pucp.sinapxon.mysql.PaisMySQL;
import pe.edu.pucp.sinapxon.mysql.PeriodoMySQL;
import pe.edu.pucp.sinapxon.mysql.PersonaMySQL;
import pe.edu.pucp.sinapxon.mysql.ProfesorMySQL;
import pe.edu.pucp.sinapxon.mysql.SolicitudClassroomMySQL;
import pe.edu.pucp.sinapxon.mysql.TemaMySQL;

/**
 *
 * @author Italo
 */
public class MySQLDAOFactory extends DAOFactory{
    
    public MySQLDAOFactory(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public PersonaDAO getPersonaDAO(){
        return new PersonaMySQL();
    }

    @Override
    public ClassroomDAO getClassroomDAO() {
        return new ClassroomMySQL();
    }

    @Override
    public CursoDAO getCursoDAO() {
        return new CursoMySQL();
    }

    @Override
    public AlumnoDAO getAlumnoDAO() {
        return new AlumnoMySQL();
    }

    @Override
    public ProfesorDAO getProfesorDAO() {
        return new ProfesorMySQL();
    }

    @Override
    public PeriodoDAO getPeriodoDAO() {
        return new PeriodoMySQL();
    }

    @Override
    public IdiomaDAO getIdiomaDAO() {
        return new IdiomaMySQL();
    }
    
    @Override
    public SolicitudClassroomDAO getSolicitudClassroomDAO() {
        return new SolicitudClassroomMySQL();
    }
    
    @Override
    public TemaDAO getTemaDAO() {
        return new TemaMySQL();
    }

    @Override
    public EspecialidadDAO getEspecialidadDAO() {
        return new EspecialidadMySQL();
    }

    @Override
    public PaisDAO getPaisDAO() {
        return new PaisMySQL();
    }
}
