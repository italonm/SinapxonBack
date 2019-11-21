/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Idioma;

/**
 *
 * @author Rick
 */
public interface IdiomaDAO {
    public void insertarIdioma(Idioma idioma);
    public ArrayList<Idioma> listarIdiomas();
    public ArrayList<Idioma> listarIdiomasXNombre_codigo(String nombreCodigo);
}
