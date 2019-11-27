/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.sinapxon.config.DBManager;

/**
 *
 * @author Rick
 */
public class ServletReport extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nombre = request.getParameter("txtCodigoClassroom");
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(ServletReport.class.getResource("/pe/edu/pucp/sinapxon/reports/ReporteAlumnosConNotasXClassroom.jasper").getFile());
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            HashMap hm = new HashMap();
            hm.put("FID_CLASSROOM", nombre);
            OutputStream outStream = response.getOutputStream();
            JasperPrint jp = JasperFillManager.fillReport(reporte,hm,con);
            con.close();
            JasperExportManager.exportReportToPdfStream(jp, outStream);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
