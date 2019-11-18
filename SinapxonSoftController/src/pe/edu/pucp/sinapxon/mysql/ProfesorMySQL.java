/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.ProfesorDAO;
import pe.edu.pucp.sinapxon.model.Pais;
import pe.edu.pucp.sinapxon.model.Profesor;

/**
 *
 * @author Italo
 */
public class ProfesorMySQL implements ProfesorDAO{

    Connection con;
    Statement st = null;
    CallableStatement cs;
    
    @Override
    public int insertarProfesor(Profesor profesor) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_PROFESOR(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("_ID_PROFESOR", profesor.getCodigo());
            cs.setInt("_FID_PAIS", profesor.getPais().getId_pais());
            cs.setString("_NICKNAME", profesor.getNickname());
            cs.setString("_PASSWORD",profesor.getPassword());
            cs.setString("_NOMBRE",profesor.getNombre());
            cs.setString("_AP_PATERNO",profesor.getApellidoPaterno());
            cs.setString("_AP_MATERNO",profesor.getApellidoMaterno());
            cs.setDate("_FECHA_NACIMIENTO", new java.sql.Date(profesor.getFecha().getTime()));
            cs.setString("_DNI",profesor.getDni());
            cs.setString("_CORREO",profesor.getCorreo());
            cs.setString("_TELEFONO", profesor.getTelefono());
            cs.setString("_AREA_INTERES",profesor.getAreaInteres());
            cs.setString("_GRADO_INSTRUCCION",profesor.getGradoInstruccion());
            cs.executeUpdate();
            resultado = 1;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.setAutoCommit(true);cs.close();con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Profesor> listarProfesores(String nombre) {
        ArrayList<Profesor> profesores = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_PROFESORES(?)}");
            cs.setString("_NOMBRE_PROFESOR", nombre);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Profesor prof = new Profesor();
                prof.setApellidoMaterno(rs.getString("AP_MATERNO"));
                prof.setApellidoPaterno(rs.getString("AP_PATERNO"));
                prof.setCodigo(rs.getString("CODIGO"));
                prof.setCorreo(rs.getString("CORREO"));
                prof.setDni(rs.getString("DNI"));
                prof.setFecha(new java.sql.Date(rs.getDate("FECHA_NACIMIENTO").getTime()));
                prof.setNickname(rs.getString("NICKNAME"));
                prof.setNombre(rs.getString("NOMBRE"));
                Pais pais = new Pais();
                pais.setId_pais(rs.getInt("FID_PAIS"));
                pais.setNombre(rs.getString("PAIS"));
                prof.setPais(pais);
                prof.setPassword(rs.getString("PASSWORD"));
                prof.setTelefono(rs.getString("TELEFONO"));
                prof.setAreaInteres(rs.getString("AREA_INTERES"));
                prof.setGradoInstruccion(rs.getString("GRADO_INSTRUCCION"));
                profesores.add(prof);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return profesores;
    }

    @Override
    public int actualizarProfesor(Profesor profesor) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            con.setAutoCommit(false);
            cs = con.prepareCall("{call ACTUALIZAR_PROFESOR(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("_ID_PROFESOR", profesor.getCodigo());
            cs.setInt("_FID_PAIS", profesor.getPais().getId_pais());
            cs.setString("_NICKNAME", profesor.getNickname());
            cs.setString("_PASSWORD",profesor.getPassword());
            cs.setString("_NOMBRE",profesor.getNombre());
            cs.setString("_AP_PATERNO",profesor.getApellidoPaterno());
            cs.setString("_AP_MATERNO",profesor.getApellidoMaterno());
            cs.setDate("_FECHA_NACIMIENTO", new java.sql.Date(profesor.getFecha().getTime()));
            cs.setString("_DNI",profesor.getDni());
            cs.setString("_CORREO",profesor.getCorreo());
            cs.setString("_TELEFONO", profesor.getTelefono());
            cs.setString("_AREA_INTERES",profesor.getAreaInteres());
            cs.setString("_GRADO_INSTRUCCION",profesor.getGradoInstruccion());
            cs.setInt("_ESTADO",profesor.getEstado());
            cs.executeUpdate();
            resultado = 1;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            try{con.rollback();}catch(SQLException exe){System.out.println(exe.getMessage());}
        }finally{
            try{con.setAutoCommit(true);cs.close();con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminarProfesor(String idProfesor) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_PROFESOR(?)}");
            cs.setString("_ID_PROFESOR", idProfesor);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
}
