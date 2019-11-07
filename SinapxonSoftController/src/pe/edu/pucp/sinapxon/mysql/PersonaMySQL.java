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
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.PersonaDAO;
import pe.edu.pucp.sinapxon.model.Persona;

/**
 *
 * @author Italo
 */
public class PersonaMySQL implements PersonaDAO{

    Connection con;
    CallableStatement cs;
    
    @Override
    public Persona validar(String nickname, String password) {
        Persona persona= new Persona();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call VALIDAR_ALUMNO(?,?)}");
            cs.setString("_NICKNAME",nickname);
            cs.setString("_PASSWORD",password);
            ResultSet rs = cs.executeQuery();
            if(rs.next()){persona.setCodigo(rs.getString("CODIGO"));persona.setNombre(rs.getString("NOMBRE_COMPLETO"));persona.setTipo("A");}
            else{
                cs = con.prepareCall("{call VALIDAR_PROFESOR(?,?)}");
                cs.setString("_NICKNAME",nickname);
                cs.setString("_PASSWORD",password);
                rs = cs.executeQuery();
                if(rs.next()){persona.setCodigo(rs.getString("CODIGO"));persona.setNombre(rs.getString("NOMBRE_COMPLETO"));persona.setTipo("P");}
                else{
                    cs = con.prepareCall("{call VALIDAR_ADMINISTRADOR(?,?)}");
                    cs.setString("_NICKNAME",nickname);
                    cs.setString("_PASSWORD",password);
                    rs = cs.executeQuery();
                    if(rs.next()){persona.setCodigo(rs.getString("CODIGO"));persona.setNombre(rs.getString("NOMBRE_COMPLETO"));persona.setTipo("D");}
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return persona;
    }
    
}
