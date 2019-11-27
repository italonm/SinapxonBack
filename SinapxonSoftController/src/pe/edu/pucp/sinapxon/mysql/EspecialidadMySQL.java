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
import pe.edu.pucp.sinapxon.dao.EspecialidadDAO;
import pe.edu.pucp.sinapxon.model.Especialidad;

/**
 *
 * @author Rick
 */
public class EspecialidadMySQL implements EspecialidadDAO{
    
    Connection con = null;
    CallableStatement cs;
    
    @Override
    public int insertarEspecialidad(Especialidad especialidad) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_ESPECIALIDAD(?,?,?,?)}");
            cs.setString("_NOMBRE", especialidad.getNombre());
            cs.setString("_DESCRIPCION", especialidad.getDescripcion());
            cs.setString("_FID_ADMINISTRADOR", especialidad.getAdministrador().getCodigo());
            cs.registerOutParameter("_ID_ESPECIALIDAD", java.sql.Types.INTEGER);
            cs.executeUpdate();
            resultado = cs.getInt("_ID_ESPECIALIDAD");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            try{con.rollback();}catch(SQLException exe){System.out.println(exe.getMessage());}
        }finally{
            try{con.setAutoCommit(true);cs.close();con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int actualizarEspecialidad(Especialidad especialidad) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ACTUALIZAR_ESPECIALIDAD(?,?,?,?)}");
            cs.setString("_NOMBRE", especialidad.getNombre());
            cs.setString("_DESCRIPCION", especialidad.getDescripcion());
            cs.setString("_FID_ADMINISTRADOR", especialidad.getAdministrador().getCodigo());
            cs.setInt("_ID_ESPECIALIDAD", especialidad.getId_especialidad());
            cs.executeUpdate();
            resultado = cs.getInt("ID_ESPECIALIDAD");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            try{con.rollback();}catch(SQLException exe){System.out.println(exe.getMessage());}
        }finally{
            try{con.setAutoCommit(true);cs.close();con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminarEspecialidad(int idEspecialidad) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_ESPECIALIDAD(?)}");
            cs.setInt("_ID_ESPECIALIDAD", idEspecialidad);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @Override
    public ArrayList<Especialidad> listarEspecialidades(String nombre) {
        ArrayList<Especialidad> especialidades = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_ESPECIALIDADES(?)}");
            cs.setString("_NOMBRE_ESPECIALIDAD",nombre);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Especialidad esp = new Especialidad();
                esp.setNombre(rs.getString("NOMBRE"));
                esp.setId_especialidad(rs.getInt("ID_ESPECIALIDAD"));
                esp.setDescripcion(rs.getString("DESCRIPCION"));
                esp.getAdministrador().setCodigo(rs.getString("FID_ADMINISTRADOR"));
                especialidades.add(esp);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return especialidades;
    }
    
    @Override
    public ArrayList<Especialidad> listarEspecialidades() {
        ArrayList<Especialidad> especialidades = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_ESPECIALIDADES()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Especialidad e = new Especialidad();
                e.setId_especialidad(rs.getInt("ID_ESPECIALIDAD"));
                e.setNombre(rs.getString("NOMBRE"));
                e.setDescripcion(rs.getString("DESCRIPCION"));
                especialidades.add(e);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return especialidades;
    }
}