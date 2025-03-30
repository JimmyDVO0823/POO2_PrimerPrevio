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
            System.out.println("ESTAMOS EN ELLOOO");
            String idMascota = frame.getTxtIdMascotaEliminar().getText();
            //System.out.println("EL ID ESCRITO ES" + idMascota);
            String nombreMascota = negocio.buscarMascota(idMascota).getNombre();
            System.out.println("EL ID ESCRITO POR EL USUARIO ES: " + idMascota);
            negocio.buscarMascota(idMascota);
            System.out.println("Nombre Mascota: " );
            frame.getTxtNombreMascotaEliminar().setText(idMascota);
            
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
