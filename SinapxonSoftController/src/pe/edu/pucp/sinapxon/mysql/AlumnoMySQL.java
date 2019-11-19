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
import pe.edu.pucp.sinapxon.dao.AlumnoDAO;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Pais;

/**
 *
 * @author Rick
 */
public class AlumnoMySQL implements AlumnoDAO{

    Connection con;
    Statement st = null;
    CallableStatement cs;
    
    @Override
    public int insertarAlumno(Alumno alumno) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_ALUMNO(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("_ID_ALUMNO", alumno.getCodigo());
            cs.setInt("_FID_PAIS", alumno.getPais().getId_pais());
            cs.setString("_NICKNAME", alumno.getNickname());
            cs.setString("_PASSWORD",alumno.getPassword());
            cs.setString("_NOMBRE", alumno.getNombre());
            cs.setString("_AP_PATERNO",alumno.getApellidoPaterno());
            cs.setString("_AP_MATERNO", alumno.getApellidoMaterno());
            cs.setDate("_FECHA_NACIMIENTO", new java.sql.Date(alumno.getFecha().getTime()));
            cs.setString("_DNI", alumno.getDni());
            cs.setString("_CORREO", alumno.getCorreo());
            cs.setString("_TELEFONO", alumno.getTelefono());
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
    public int actualizarAlumno(Alumno alumno) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            con.setAutoCommit(false);
            cs = con.prepareCall("{call ACTUALIZAR_ALUMNO(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("_ID_ALUMNO", alumno.getCodigo());
            cs.setInt("_FID_PAIS", alumno.getPais().getId_pais());
            cs.setString("_NICKNAME", alumno.getNickname());
            cs.setString("_PASSWORD",alumno.getPassword());
            cs.setString("_NOMBRE",alumno.getNombre());
            cs.setString("_AP_PATERNO",alumno.getApellidoPaterno());
            cs.setString("_AP_MATERNO",alumno.getApellidoMaterno());
            cs.setDate("_FECHA_NACIMIENTO", new java.sql.Date(alumno.getFecha().getTime()));
            cs.setString("_DNI",alumno.getDni());
            cs.setString("_CORREO",alumno.getCorreo());
            cs.setString("_TELEFONO", alumno.getTelefono());
            cs.setInt("_ESTADO",alumno.getEstado());
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
    public int eliminarAlumno(String idAlumno) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_ALUMNO(?)}");
            cs.setString("_ID_ALUMNO", idAlumno);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Alumno> listarAlumnos(String nombre) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_ALUMNOS(?)}");
            cs.setString("_NOMBRE_ALUMNO", nombre);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Alumno alum = new Alumno();
                alum.setApellidoMaterno(rs.getString("AP_MATERNO"));
                alum.setApellidoPaterno(rs.getString("AP_PATERNO"));
                alum.setCodigo(rs.getString("CODIGO"));
                alum.setCorreo(rs.getString("CORREO"));
                alum.setDni(rs.getString("DNI"));
                alum.setFecha(new java.sql.Date(rs.getDate("FECHA_NACIMIENTO").getTime()));
                alum.setNickname(rs.getString("NICKNAME"));
                alum.setNombre(rs.getString("NOMBRE"));
                Pais pais = new Pais();
                pais.setId_pais(rs.getInt("FID_PAIS"));
                pais.setNombre(rs.getString("PAIS"));
                alum.setPais(pais);
                alum.setPassword(rs.getString("PASSWORD"));
                alum.setTelefono(rs.getString("TELEFONO"));
                alumnos.add(alum);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return alumnos;
    }    

    @Override
    public ArrayList<Alumno> listarAlumnosXClassroom(String codigoClassroom) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_ALUMNO_X_CLASSROOM(?)}");
            cs.setString("_CODIGO_CLASSROOM", codigoClassroom);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Alumno alum = new Alumno();
                alum.setApellidoMaterno(rs.getString("AP_MATERNO"));
                alum.setApellidoPaterno(rs.getString("AP_PATERNO"));
                alum.setCodigo(rs.getString("CODIGO"));
                alum.setCorreo(rs.getString("CORREO"));
                alum.setDni(rs.getString("DNI"));
                alum.setFecha(new java.sql.Date(rs.getDate("FECHA_NACIMIENTO").getTime()));
                alum.setNickname(rs.getString("NICKNAME"));
                alum.setNombre(rs.getString("NOMBRE"));
                Pais pais = new Pais();
                pais.setId_pais(rs.getInt("FID_PAIS"));
                pais.setNombre(rs.getString("PAIS"));
                alum.setPais(pais);
                alum.setPassword(rs.getString("PASSWORD"));
                alum.setTelefono(rs.getString("TELEFONO"));
                alumnos.add(alum);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return alumnos;
    }
}
