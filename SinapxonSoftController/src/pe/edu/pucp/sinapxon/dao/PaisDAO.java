/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Pais;

/**
 *
 * @author Emma Isabel Aragon Quenallata
 */
public interface PaisDAO {
    public ArrayList<Pais> listarPaises();
    public ArrayList<Pais> listarPais();
}