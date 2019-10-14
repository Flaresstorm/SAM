package Controlador;

import Modelo.Consultas;
import Modelo.Usuario;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Funciones implements ActionListener {

    private Usuario mod;
    private Consultas modC;
    private Formulario frm;

    public Funciones(Usuario mod, Consultas modC, Formulario frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btnGuardar) {
            mod.setCedula(frm.txtCedula.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setCargo(frm.txtCargo.getText());
            mod.setDescripcion(frm.txtDescripcion.getText());
            
            if(modC.registrar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCedula(frm.txtCedula.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setCargo(frm.txtCargo.getText());
            mod.setDescripcion(frm.txtDescripcion.getText());
            
            if(modC.modificar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            
            if(modC.eliminar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) {
            mod.setCedula(frm.txtCedula.getText());
            
            if(modC.buscar(mod))
            {
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtCedula.setText(mod.getCedula());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtCargo.setText(String.valueOf(mod.getCargo()));
                frm.txtDescripcion.setText(String.valueOf(mod.getDescripcion()));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }

    }
    
    public void limpiar()
    {
        frm.txtId.setText(null);
        frm.txtCedula.setText(null);
        frm.txtNombre.setText(null);
        frm.txtCargo.setText(null);
        frm.txtDescripcion.setText(null);
    }

}
