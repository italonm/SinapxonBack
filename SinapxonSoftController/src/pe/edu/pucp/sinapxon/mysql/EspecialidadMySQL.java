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
    public void insertarEspecialidad(Especialidad especialidad, String idAdministrador) {
        // OUT _ID_ESPECIALIDAD, _FID_ADMINISTRADOR, _NOMBRE, _DESCRIPCION
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_ESPECIALIDAD(?,?,?,?)}");
            cs.setString("_FID_ADMINISTRADOR", idAdministrador);
            cs.setString("_NOMBRE", especialidad.getNombre());
            cs.setString("_DESCRIPCION", especialidad.getDescripcion());
            cs.registerOutParameter("_ID_ESPECIALIDAD", java.sql.Types.INTEGER);
            cs.executeUpdate();
            especialidad.setId_especialidad(cs.getInt("_ID_ESPECIALIDAD"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex){System.out.println();}
        }
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
