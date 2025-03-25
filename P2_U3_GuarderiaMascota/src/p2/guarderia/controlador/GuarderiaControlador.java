/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import p2.guarderia.vista.GuarderiaVista;
import p2.guarderia.modelo.GuarderiaFachada;

/**
 *
 * @author Boris Perez
 */
public class GuarderiaControlador {

    private GuarderiaVista frame;
    private GuarderiaFachada negocio;

    public GuarderiaControlador(GuarderiaVista frame) {
        this.frame = frame;

        negocio = new GuarderiaFachada();
    }

    public void agregarMascota() {

        try {
            // Obtener datos de cajas de texto

            String id = frame.getTxtIdMascotaAgregar().getText();
            String nombre = frame.getTxtNombreMascota().getText();
            String edad = frame.getTxtEdadMascota().getText();
            String raza = frame.getTxtRazaMascota().getText();

            negocio.agregarMascota(id, nombre, edad, raza);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void buscarEliminar() throws Exception {
        try {
            String nombreMascota = negocio.buscarMascota(frame.getTxtIdMascotaEliminar().getText()).getNombre();
            System.out.println(nombreMascota);
            frame.getTxtNombreMascotaEliminar().setText(nombreMascota);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mascota no Encontrada", "Busqueda Fallida", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void setNombreEliminarTxt(String nombre) {
        frame.getTxtNombreMascotaEliminar().setText(nombre);
    }

//    public String[] buscarMascota(){
//        
//    }
}
