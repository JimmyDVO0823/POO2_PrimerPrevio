/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
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
    DefaultComboBoxModel<String> modelo1;
    DefaultComboBoxModel<String> modelo2;

    

    public GuarderiaControlador(GuarderiaVista frame) {
        this.frame = frame;
        modelo1 = new DefaultComboBoxModel<>();
        modelo2 = new DefaultComboBoxModel<>();
        //modelo.addElement("ID - NOMBRE");
        negocio = new GuarderiaFachada();
        asignarModeloMascotas(getListaMascotas());
        frame.setModeloMascotas(modelo1);
        asignarModeloPersonas(getListaPersonas());
        frame.setModeloDuenos(modelo2);
    }

    public void asignarModeloMascotas(String[] lista){
        ArrayList<String> listaModelo = new ArrayList<>(Arrays.asList(lista));
        modelo1.removeAllElements();
        modelo1.addAll(listaModelo);
    }

    public void asignarModeloPersonas(String[] lista){
        ArrayList<String> listaModelo = new ArrayList<>(Arrays.asList(lista));
        modelo2.removeAllElements();
        modelo2.addAll(listaModelo);
    }
    
    public void agregarMascota() {

        try {
            // Obtener datos de cajas de texto

            String id = frame.getTxtIdMascotaAgregar().getText();
            String nombre = frame.getTxtNombreMascota().getText();
            String edad = frame.getTxtEdadMascota().getText();
            String raza = frame.getTxtRazaMascota().getText();

            negocio.agregarMascota(id, nombre, edad, raza);
            aniadirMascotaModelo(id, nombre);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void buscarEliminar() throws Exception {
        try {
            String idMascota = frame.getTxtIdMascotaEliminar().getText();
            //System.out.println("EL ID ESCRITO ES" + idMascota);
            String nombreMascota = negocio.buscarMascota(idMascota).getNombre();
            //System.out.println("EL ID ESCRITO POR EL USUARIO ES: " + idMascota);
            negocio.buscarMascota(idMascota);
            //System.out.println("Nombre Mascota: " + nombreMascota);
            frame.getTxtNombreMascotaEliminar().setText(nombreMascota);

            String[] lista = getListaMascotas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mascota no Encontrada", "Busqueda Fallida", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void eliminar() {
        String id = frame.getTxtIdMascotaEliminar().getText();
        negocio.eliminarMascota(id);
    }

    public void setNombreEliminarTxt(String nombre) {
        frame.getTxtNombreMascotaEliminar().setText(nombre);
    }

    public void actualizarMascota() {
        String id = frame.getTxtIdMascotaActualizar().getText();
        String edad = frame.getTxtEdadAct().getText();
        String raza = frame.getTxtRazaAct().getText();
        String nombre = frame.getTxtNombreAct().getText();
        negocio.actualizarMascota(id, nombre, raza, edad);
    }

    public String[] getListaMascotas() {
        String[] listaMascotas;
        listaMascotas = negocio.listarMascotas();

        

        return listaMascotas;
    }

    public String[] getListaPersonas() {
        String[] listaPersonas;
        listaPersonas = negocio.listarPersonas();
        return listaPersonas;
    }
    
    public void asignarPropietarioMascota(){
        try {
            
        String[] mascota = frame.getCmbMascotaAsignar().getModel().getSelectedItem().toString().split(" ");
        String[] persona = frame.getCmbDuenoAsignar().getModel().getSelectedItem().toString().split(" ");
        String idMascota = mascota[0];
        String idPersona = persona[0];
        
            System.out.println("id de mascota: " + idMascota
            + "\nid Dueño: " + idPersona);
        
        negocio.asignarPropietarioMascota(idMascota, idPersona);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    
    public void retirarDueno(){
        String mascota = frame.getCmbMascotaRetirar().getModel().getSelectedItem().toString();
        String[] mascotaArray = mascota.split(" ");
        String mascotaId = mascotaArray[0];
        negocio.retirarPropietrioMascota(mascotaId);
    }

    public void aniadirMascotaModelo(String id, String nombre) {
        modelo1.addElement(id + " - " + nombre);
    }

    public void aniadirPersonaModelo(String id, String nombre) {
        modelo2.addElement(id + " - " + nombre);
    }
    
    public void limpiarEliminar(){
        frame.getTxtNombreMascotaEliminar().setText("");
        frame.getTxtIdMascotaEliminar().setText("");
    }
}
