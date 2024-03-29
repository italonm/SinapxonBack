/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.services;

import java.util.TimeZone;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.sinapxon.config.DBController;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Persona;

/**
 *
 * @author Rick
 */
@WebService(serviceName = "LoginServices")
public class LoginServices {
    
    public LoginServices(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    
    @WebMethod(operationName = "validarLogin")
    public Persona validarLogin(@WebParam(name="nickname")String nickname, @WebParam(name="password")String password){
        return DBController.validarLogin(nickname, password);
    }
    @WebMethod(operationName = "validarCorreo")
    public Persona validarCorreo(@WebParam(name="correo")String correo){
        return DBController.validarCorreo(correo);
    }
    @WebMethod(operationName = "actualizarPassword")
    public void actualizarPassword(@WebParam(name="codigo")String codigo, @WebParam(name="password")String password){
        DBController.actualizarPassword(codigo, password);
    }
    
    @WebMethod(operationName = "validarNickname")
    public Alumno validarNickname(@WebParam(name="nickname")String nickname){
        return DBController.validarNickname(nickname);
    }
}
