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
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.Archivo_x_TemaDAO;
import pe.edu.pucp.sinapxon.model.Archivo_x_Tema;
import pe.edu.pucp.sinapxon.model.Tema_x_Classroom;

/**
 *
 * @author ld_ra
 */
public class Archivo_x_TemaMySQL implements Archivo_x_TemaDAO{

    Connection con;
    Statement st = null;
    CallableStatement cs;
    
    @Override
    public ArrayList<Archivo_x_Tema> listarArchivosXTemaXClassroom(int idTema, String idClassroom) {
        ArrayList<Archivo_x_Tema> archivos = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_ARCHIVOS_X_TEMA_CLASSROOM(?,?)}");
            cs.setInt("_FID_TEMA", idTema);
            cs.setString("_FID_CLASSROOM", idClassroom);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Archivo_x_Tema arch = new Archivo_x_Tema();
                arch.setId_archivo_x_tema(rs.getInt("ID_ARCHIVO_X_TEMA"));
                arch.setNombre(rs.getString("NOMBRE"));
                Tema_x_Classroom tema = new Tema_x_Classroom();
                tema.setId_tema(rs.getInt("FID_TEMA"));
                arch.setTema(tema);
                archivos.add(arch);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return archivos;
    }
    
}
