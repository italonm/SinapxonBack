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
import java.util.Date;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.PeriodoDAO;
import pe.edu.pucp.sinapxon.model.Periodo;

/**
 *
 * @author ld_ra
 */
public class PeriodoMySQL implements PeriodoDAO{
    
    Connection con;
    Statement st = null;
    CallableStatement cs;

    @Override
    public ArrayList<Periodo> listarPeriodo() {
        ArrayList<Periodo> periodos = new ArrayList<>();
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_PERIODOS()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
                Periodo periodo = new Periodo();
                periodo.setId_periodo(rs.getInt("ID_PERIODO"));
                periodo.setNombre(rs.getString("NOMBRE"));
                //periodo.getAdministrador().setCodigo(String.valueOf(rs.getInt("FID_ADMINISTRADOR")));
                periodo.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                periodo.setFecha_fin(rs.getDate("FECHA_FIN"));
                periodos.add(periodo);
            }
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return periodos;
    }
    
    @Override
    public ArrayList<Periodo> listarPeriodosDisponibles() {
        ArrayList<Periodo> periodos = new ArrayList<>();
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_PERIODOS_DISPONIBLES()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
                Periodo periodo = new Periodo();
                periodo.setId_periodo(rs.getInt("ID_PERIODO"));
                periodo.setNombre(rs.getString("NOMBRE"));
                //periodo.getAdministrador().setCodigo(String.valueOf(rs.getInt("FID_ADMINISTRADOR")));
                periodo.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                periodo.setFecha_fin(rs.getDate("FECHA_FIN"));
                periodos.add(periodo);
            }
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return periodos;
    }

    @Override
    public ArrayList<Periodo> listarRangoPeriodos(Date fechaIni, Date fechaFin) {
        ArrayList<Periodo> periodos = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_RANGO_PERIODOS(?,?)}");
            cs.setDate("_FECHA_INI", new java.sql.Date(fechaIni.getTime()));
            cs.setDate("_FECHA_FIN", new java.sql.Date(fechaFin.getTime()));

            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Periodo periodo = new Periodo();
                periodo.setId_periodo(rs.getInt("ID_PERIODO"));
                periodo.setNombre(rs.getString("NOMBRE"));
                //periodo.getAdministrador().setCodigo(String.valueOf(rs.getInt("FID_ADMINISTRADOR")));
                periodo.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                periodo.setFecha_fin(rs.getDate("FECHA_FIN"));
                periodos.add(periodo);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return periodos;
    }

    @Override
    public void insertarPeriodo(Periodo periodo) {
        try {
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_PERIODO(?,?,?,?,?)}");
            cs.setString("_NOMBRE", periodo.getNombre());
            cs.setString("_FID_ADMINISTRADOR", periodo.getAdministrador().getCodigo());
            cs.setDate("_FECHA_INICIO", new java.sql.Date(periodo.getFecha_inicio().getTime()));
            cs.setDate("_FECHA_FIN", new java.sql.Date(periodo.getFecha_fin().getTime()));
            cs.registerOutParameter("_ID_PERIODO", java.sql.Types.INTEGER);
            cs.executeUpdate();
            periodo.setId_periodo(cs.getInt("_ID_PERIODO"));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {con.close();} catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
    }

    @Override
    public Periodo obtenerPeriodo_X_Codigo(int codigo) {
        Periodo periodo = new Periodo();
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_PERIODOS_x_CODIGO(?)}");
            cs.setInt("_NOMBRE_CODIGO", codigo);
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
                periodo.setId_periodo(rs.getInt("ID_PERIODO"));
                periodo.setNombre(rs.getString("NOMBRE"));
                //periodo.getAdministrador().setCodigo(String.valueOf(rs.getInt("FID_ADMINISTRADOR")));
                periodo.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                periodo.setFecha_fin(rs.getDate("FECHA_FIN"));
            }
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return periodo;
    }
    
}
