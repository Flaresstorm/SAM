/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import Controlador.Funciones;
import Modelo.Consultas;
import Modelo.Usuario;
import Vista.Formulario;

/**
 *
 * @author Marko
 */
public class CRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Usuario mod = new Usuario();
        Consultas modC = new Consultas();
        Formulario frm = new Formulario();
        
        Funciones ctrl = new Funciones(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
    }
    
}
