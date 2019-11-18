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
 * @author Monica
 */
public class EspecialidadMySQL implements EspecialidadDAO {
    
    Connection con;
    Statement st = null;
    CallableStatement cs;
    
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
                esp.getAdministrador().setCodigo("FID_ADMINISTRADOR");
                especialidades.add(esp);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return especialidades;
    }
}
